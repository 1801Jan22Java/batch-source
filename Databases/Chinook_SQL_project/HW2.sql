-- 2.0 SQL Queries

-- 2.1 SELECT

-- Task – Select all records from the Employee table.
SELECT * FROM Employee;

-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';

-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL;

-- 2.2 ORDER BY

-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

-- 2.3 INSERT INTO

-- Task – Insert two new records into Genre table 
INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Sport');
INSERT INTO GENRE (GENREID, NAME)
VALUES (27, 'Kpop');

-- Task – Insert two new records into Employee table
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (9, 'Awwad', 'Ahmed', 'Associate', 1, '09-SEP-95', '22-JAN-18', '123 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 456-7890', '+1 (234) 567-8901', 'totallyreal@chinookcorp.com');
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (10, 'Frisk', 'Fox', 'Associate', 1, '10-SEP-95', '22-JAN-18', '124 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 456-7894', '+1 (234) 563-8901', 'totallyrealistic@chinookcorp.com');

-- Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (60, 'Halle', 'Berry', 'WorldWideWidgets', '125 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 426-7894', '+1 (234) 563-8401', 'totalrealistic@chinookcorp.com', 5);
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES (61, 'Jim', 'Bob', 'WorldWideWidgets', '126 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 426-7394', '+1 (234) 163-8401', 'totalreal@chinookcorp.com', 4);

-- 2.4 UPDATE

-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME='Robert', LASTNAME='Walter'
WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';

-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”x
UPDATE ARTIST
SET NAME='CCR'
WHERE NAME='Creedence Clearwater Revival';

-- 2.5 LIKE

-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN

-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE

-- Task – Delete a record in Customer table where the name is Robert Walter 
-- (There may be constraints that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE IL
WHERE IL.INVOICEID IN
(SELECT I.INVOICEID FROM INVOICE I
WHERE I.CUSTOMERID IN 
(SELECT C.CUSTOMERID FROM CUSTOMER C
WHERE C.FIRSTNAME='Robert' AND C.LASTNAME='Walter'));

DELETE FROM INVOICE I
WHERE I.CUSTOMERID IN 
(SELECT C.CUSTOMERID FROM CUSTOMER C
WHERE C.FIRSTNAME='Robert' AND C.LASTNAME='Walter');

DELETE FROM CUSTOMER
WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

-- 3.0 SQL Functions

-- 3.1 System Defined Functions

-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION CURR_TIME
    RETURN VARCHAR AS CURRTIME VARCHAR(20);
    BEGIN
        SELECT EXTRACT(HOUR FROM CURRENT_TIMESTAMP) ||
        ':' || EXTRACT(MINUTE FROM CURRENT_TIMESTAMP) ||
        ':' || EXTRACT(SECOND FROM CURRENT_TIMESTAMP)
        INTO CURRTIME
        FROM DUAL;
        RETURN CURRTIME;
    END CURR_TIME;
/

SELECT CURR_TIME FROM DUAL;

-- Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION NAME_LENGTH (STR IN VARCHAR)
    RETURN NUMBER AS LEN NUMBER;
    BEGIN
        SELECT LENGTH(STR)
        INTO LEN
        FROM DUAL;
        RETURN LEN;
    END;
/

SELECT NAME_LENGTH(NAME) FROM MEDIATYPE;

-- 3.2 System Defined Aggregate Functions

-- Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AVERAGE_INVOICE_TOTAL
    RETURN NUMBER AS AV_TOT NUMBER;
    BEGIN
        SELECT AVG(TOTAL)
        INTO AV_TOT
        FROM INVOICE;
        RETURN AV_TOT;
    END;
/

SELECT AVERAGE_INVOICE_TOTAL FROM DUAL;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
    RETURN VARCHAR AS M_E_T VARCHAR(50);
    BEGIN
        SELECT NAME
        INTO M_E_T
        FROM TRACK
        WHERE UNITPRICE IN
        (SELECT MAX(UNITPRICE)
        FROM TRACK)
        AND ROWNUM=1;
        RETURN M_E_T;
    END;
/

SELECT MOST_EXPENSIVE_TRACK FROM DUAL;

-- 3.3 User Defined Scalar Functions

-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE_PRICE
    RETURN NUMBER AS A_I_P NUMBER;
    BEGIN
        SELECT AVG(UNITPRICE)
        INTO A_I_P
        FROM INVOICELINE;
        RETURN A_I_P;
    END;
/

SELECT AVERAGE_INVOICELINE_PRICE FROM DUAL;

-- 3.4 User Defined Table Valued Functions
-- Task – Create a function that returns all employees who are born after 1968.
CREATE TYPE EMP_NAMES_TYPE AS OBJECT
(
    FIRSTNAME VARCHAR2(100),
    LASTNAME VARCHAR2(100)
);
    
CREATE TYPE EMP_NAMES AS TABLE OF EMP_NAMES_TYPE;

CREATE OR REPLACE FUNCTION GEN_X_GENERATOR
    RETURN EMP_NAMES PIPELINED IS
    BEGIN
        FOR I IN (
                SELECT FIRSTNAME, LASTNAME
                FROM EMPLOYEE
                WHERE BIRTHDATE > '31-DEC-1968') LOOP
            PIPE ROW(EMP_NAMES_TYPE(I.FIRSTNAME, I.LASTNAME));
        END LOOP;
        RETURN;
    END;
/

SELECT * FROM TABLE(GEN_X_GENERATOR);

-- 4.0 Stored Procedures

-- 4.1 Basic Stored Procedure

-- Task – Create a stored procedure that selects the first and last names of all the employees.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES AS
BEGIN
    FOR REC IN
    (
    SELECT FIRSTNAME, LASTNAME 
    FROM EMPLOYEE
    )
    LOOP
        DBMS_OUTPUT.PUT_LINE(REC.FIRSTNAME || ' ' || REC.LASTNAME);
    END LOOP;
END EMPLOYEE_NAMES;
/

BEGIN
    EMPLOYEE_NAMES;
END;

-- 4.2 Stored Procedure Input Parameters

-- Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EDIT_EMP_EMAIL
(GIVEN_ID IN EMPLOYEE.EMPLOYEEID%TYPE, NEW_EMAIL IN EMPLOYEE.EMAIL%TYPE) AS
BEGIN
    UPDATE EMPLOYEE
    SET EMAIL=NEW_EMAIL
    WHERE EMPLOYEEID=GIVEN_ID;
END;
/

BEGIN
    EDIT_EMP_EMAIL(10, 'new_email@chinookcorp.com');
END;

-- Task – Create a stored procedure that returns the managers of an employee.
SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE GET_MANAGERS
(
GIVEN_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
F_NAME OUT EMPLOYEE.FIRSTNAME%TYPE,
L_NAME OUT EMPLOYEE.LASTNAME%TYPE
) AS
BEGIN
    SELECT E2.FIRSTNAME, E2.LASTNAME
    INTO F_NAME, L_NAME
    FROM EMPLOYEE E1, EMPLOYEE E2
    WHERE E1.EMPLOYEEID=GIVEN_ID AND
    E1.REPORTSTO=E2.EMPLOYEEID;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE('Nonexistent ID or no manager found!');
END;
/

DECLARE
    F_NAME EMPLOYEE.FIRSTNAME%TYPE;
    L_NAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_MANAGERS(5, F_NAME, L_NAME);
    DBMS_OUTPUT.PUT_LINE(F_NAME|| ' ' || L_NAME);
END;

-- 4.3 Stored Procedure Output Parameters

-- Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY
(
GIVEN_ID IN CUSTOMER.CUSTOMERID%TYPE,
F_NAME OUT CUSTOMER.FIRSTNAME%TYPE,
L_NAME OUT CUSTOMER.LASTNAME%TYPE,
COMPANY_NAME OUT CUSTOMER.COMPANY%TYPE
) AS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY
    INTO F_NAME, L_NAME, COMPANY_NAME
    FROM CUSTOMER
    WHERE CUSTOMERID=GIVEN_ID;
END;
/

DECLARE
    F_NAME CUSTOMER.FIRSTNAME%TYPE;
    L_NAME CUSTOMER.LASTNAME%TYPE;
    COMPANY_NAME CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_NAME_COMPANY(4, F_NAME, L_NAME, COMPANY_NAME);
    DBMS_OUTPUT.PUT_LINE('Name of customer: ' || F_NAME|| ' ' || L_NAME);
    IF COMPANY_NAME IS NULL THEN
        DBMS_OUTPUT.PUT_LINE(F_NAME|| ' ' || L_NAME || ' has no company');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Company of customer: ' || COMPANY_NAME);
    END IF;
END;

-- 5.0 Transactions

-- Task – Create a transaction that given a invoiceId will delete that invoice 
-- (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
(GIVEN_ID IN INVOICE.INVOICEID%TYPE) AS
BEGIN
    SET TRANSACTION READ WRITE;
    
    DELETE FROM INVOICELINE IL
    WHERE IL.INVOICEID IN
    (SELECT I.INVOICEID FROM INVOICE I
    WHERE I.INVOICEID=GIVEN_ID);

    DELETE FROM INVOICE I
    WHERE I.INVOICEID=GIVEN_ID;
    
    COMMIT;
END;
/

BEGIN
    DELETE_INVOICE(409);
END;

-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE CREATE_CUSTOMER
(
GIVEN_ID IN CUSTOMER.CUSTOMERID%TYPE,
F_NAME IN CUSTOMER.FIRSTNAME%TYPE,
L_NAME IN CUSTOMER.LASTNAME%TYPE,
COMPANY_NAME IN CUSTOMER.COMPANY%TYPE,
ADDRESS_VAL IN CUSTOMER.ADDRESS%TYPE,
CITY_VAL IN CUSTOMER.CITY%TYPE,
STATE_VAL IN CUSTOMER.STATE%TYPE,
COUNTRY_VAL IN CUSTOMER.COUNTRY%TYPE,
POSTALCODE_VAL IN CUSTOMER.POSTALCODE%TYPE,
PHONE_VAL IN CUSTOMER.PHONE%TYPE,
FAX_VAL IN CUSTOMER.FAX%TYPE,
EMAIL_VAL IN CUSTOMER.EMAIL%TYPE,
SUPPORTREPID_VAL IN CUSTOMER.SUPPORTREPID%TYPE
) AS
BEGIN
    SET TRANSACTION READ WRITE;
    
    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
    VALUES (GIVEN_ID, F_NAME, L_NAME, COMPANY_NAME, ADDRESS_VAL, CITY_VAL, STATE_VAL, COUNTRY_VAL, POSTALCODE_VAL, PHONE_VAL, FAX_VAL, EMAIL_VAL, SUPPORTREPID_VAL);
    
    COMMIT;
END;
/

BEGIN
    CREATE_CUSTOMER(62, 'Real', 'Original', 'WorldWideWidgets', '129 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 426-1894', '+1 (234) 513-8401', 'totalrealistical@chinookcorp.com', 5);
END;

-- 6.0 Triggers

-- 6.1 AFTER/FOR

-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER EMPLOYEE_AFTER_INSERT
AFTER INSERT
   ON EMPLOYEE
BEGIN
    DELETE FROM EMPLOYEE WHERE EMPLOYEEID=11;
END;
/

-- Trigger only deletes this entry as an example! Do not try with others!
INSERT INTO EMPLOYEE (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (11, 'Frisk', 'Fox', 'Associate', 1, '10-SEP-95', '22-JAN-18', '124 Real St. NE', 'Reston', 'VA', 'USA', '20170', '+1 (123) 456-7894', '+1 (234) 563-8901', 'totallyrealistic@chinookcorp.com');

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER ALBUM_AFTER_UPDATE
AFTER UPDATE
   ON ALBUM
BEGIN
    INSERT INTO ALBUM (ALBUMID, TITLE, ARTISTID)
    VALUES (348, 'Nothing!', 1);
END;
/

-- Updating any entry, introduces 1 hard coded entry. Only try once or uncomment below, execute, and try again!
UPDATE ALBUM
SET TITLE='Rasputin'
WHERE ALBUMID=346;

-- DELETE FROM ALBUM WHERE ALBUMID=348;

-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER CUSTOMER_AFTER_DELETE
AFTER DELETE
   ON CUSTOMER
BEGIN
    UPDATE CUSTOMER
    SET COMPANY='JC Penney'
    WHERE CUSTOMERID=59;
END;
/

-- Deleting Halle Berry from earlier. Will still work if 60th customer does not exist!
DELETE FROM CUSTOMER WHERE CUSTOMERID=60;

-- 7.0 JOINS

-- 7.1 INNER

-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT C.FIRSTNAME, C.LASTNAME, I.INVOICEID FROM CUSTOMER C
INNER JOIN INVOICE I
ON C.CUSTOMERID=I.CUSTOMERID;

-- 7.2 OUTER

-- Task – Create an outer join that joins the customer and invoice table, 
-- specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CUSTOMER C
LEFT JOIN INVOICE I
ON C.CUSTOMERID=I.CUSTOMERID;

-- 7.3 RIGHT

-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT A.NAME, L.TITLE FROM ARTIST A
RIGHT JOIN ALBUM L
ON A.ARTISTID=L.ARTISTID;

--7.4 CROSS

-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ARTIST A
CROSS JOIN ALBUM L
ORDER BY A.NAME;

-- 7.5 SELF

-- Task – Perform a self-join on the employee table, joining on the reportsto column.
-- This matches employees that report to the same boss.
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME
FROM EMPLOYEE A INNER JOIN EMPLOYEE B
ON A.EMPLOYEEID <> B.EMPLOYEEID AND A.REPORTSTO=B.REPORTSTO;