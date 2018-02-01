SET SERVEROUTPUT ON;
--============ Section 2.0 ==================

--2.1
-- Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

-- Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

-- 2.2

-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

-- 2.3

-- Insert two new records into Genre table 
INSERT INTO Genre (GenreId, Name) VALUES (26, 'Techno');
INSERT INTO Genre (GenreId, Name) VALUES (27, 'MyGenre');

-- Insert two new records into Employee table
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (9, 'Jacob', 'Boyles', 'Softeware Engineer', TO_DATE('2018-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2020-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11730 Plaza America Drive', 'Reston', 'VA', 'US', 'T5K 2N1', 
'+1 (780) 428-9482', '+1 (780) 428-3457', 'jacob@chinookcorp.com');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) 
VALUES (10, 'Joe', 'Schmoe', 'Some Job', TO_DATE('2018-2-18 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
TO_DATE('2020-8-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11730 Plaza America Drive', 'Reston', 'VA', 'US', 'T5K 2N1', 
'+1 (780) 428-9482', '+1 (780) 428-3457', 'schmoe@chinookcorp.com');

-- Insert two new records into Customer table
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (60, 'Kim', 'Possible', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 
'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (61, 'George', 'Tim', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 'São José dos Campos', 
'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);

-- 2.4

-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';

-- 2.5

-- Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 

--Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL >= 15 AND TOTAL <=  50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE >= '01-JUN-2003' AND HIREDATE <= '01-Mar-2004';

-- 2.7

-- Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY (CUSTOMERID) REFERENCES CUSTOMER(CUSTOMERID) ON DELETE CASCADE;
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY (INVOICEID) REFERENCES INVOICE(INVOICEID) ON DELETE CASCADE;
DELETE FROM CUSTOMER CASCADE WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--============ Section 3.0 ==================

-- 3.1

-- Create a function that returns the current time.
--SELECT SYSTIMESTAMP FROM DUAL; 

--CREATE OR REPLACE FUNCTION CURRENT_TIME RETURN TIMESTAMP IS CTIME TIMESTAMP;
--BEGIN
--    RETURN SYSTIMESTAMP;
--END CURRENT_TIME;

SELECT CURRENT_TIME FROM DUAL;    

-- Create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;

--CREATE OR REPLACE FUNCTION MEDIATYPE_NAME_LENGTH(NAME IN VARCHAR2) RETURN NUMBER AS LEN NUMBER;
--BEGIN
--    RETURN LENGTH(NAME);
--END MEDIATYPE_NAME_LENGTH;

SELECT MEDIATYPE_NAME_LENGTH(NAME) FROM MEDIATYPE;


-- 3.2

-- Create a function that returns the average total of all invoices 
SELECT AVG(TOTAL) FROM INVOICE;


--CREATE OR REPLACE FUNCTION AVERAGE_TOTAL RETURN NUMBER AS AVERAGE NUMBER;
--CURSOR C1 IS
--SELECT AVG(TOTAL) FROM INVOICE;
--BEGIN
--    OPEN C1;
--    FETCH C1 INTO AVERAGE;
--    CLOSE C1;
--    RETURN AVERAGE;
--END AVERAGE_TOTAL;

SELECT AVERAGE_TOTAL FROM DUAL;

-- Create a function that returns the most expensive track
SELECT TRACKID FROM TRACK WHERE UNITPRICE IN (SELECT MAX(UNITPRICE) FROM TRACK) AND ROWNUM = 1;

--CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK RETURN NUMBER AS TRACK_ID NUMBER;
--CURSOR C1 IS
--SELECT TRACKID FROM TRACK WHERE UNITPRICE IN (SELECT MAX(UNITPRICE) FROM TRACK) AND ROWNUM = 1;
--BEGIN
--    OPEN C1;
--    FETCH C1 INTO TRACK_ID;
--    CLOSE C1;
--    RETURN TRACK_ID;
--END MOST_EXPENSIVE_TRACK;

SELECT MOST_EXPENSIVE_TRACK FROM DUAL;

-- 3.3

-- Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT AVG(UNITPRICE) FROM INVOICELINE;

--CREATE OR REPLACE FUNCTION AVERAGE_PRICE RETURN NUMBER AS AVERAGE NUMBER;
--CURSOR C1 IS
--SELECT AVG(UNITPRICE) FROM INVOICELINE;
--BEGIN
--    OPEN C1;
--    FETCH C1 INTO AVERAGE;
--    CLOSE C1;
--    RETURN AVERAGE;
--END AVERAGE_PRICE;

SELECT AVERAGE_PRICE FROM DUAL;

-- 3.4

-- Create a function that returns all employees who are born after 1968.
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';

--CREATE OR REPLACE FUNCTION YOUNG_EMPLOYEE RETURN SYS_REFCURSOR IS C1 SYS_REFCURSOR;
--BEGIN
--    OPEN C1 FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';
--    RETURN C1;
--END YOUNG_EMPLOYEE;

SELECT YOUNG_EMPLOYEE FROM DUAL;

--============ Section 4.0 ==================

-- 4.1

-- Create a stored procedure that selects the first and last names of all the employees.

SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;

--CREATE OR REPLACE PROCEDURE GET_FIRST_LAST_NAME_EMPLOYEES (
--    C1 OUT SYS_REFCURSOR)
--AS
--BEGIN
--    OPEN C1 FOR
--        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
--    DBMS_SQL.RETURN_RESULT(C1);
--END GET_FIRST_LAST_NAME_EMPLOYEES;
DECLARE 
MY_CURSOR SYS_REFCURSOR;
BEGIN
GET_FIRST_LAST_NAME_EMPLOYEES(c1=>MY_CURSOR/*REF CURSOR*/);
END;

-- 4.2

-- Create a stored procedure that updates the personal information of an employee.

--CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_EMAIL(
--EMPL_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
--NEW_EMAIL IN EMPLOYEE.EMAIL%TYPE)
--AS
--BEGIN
--    UPDATE EMPLOYEE SET EMAIL = NEW_EMAIL WHERE EMPLOYEEID = EMPL_ID;
--END;

BEGIN
    UPDATE_EMPLOYEE_EMAIL(1, 'NEWEMAIL@MAIL.COM');
END;

-- Create a stored procedure that returns the managers of an employee.

--CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_MANAGERS (
--    EMPL_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
--    C1 OUT SYS_REFCURSOR)
--AS
--BEGIN
--    OPEN C1 FOR
--        SELECT * FROM EMPLOYEE WHERE EMPLOYEEID IN (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPL_ID);
--    DBMS_SQL.RETURN_RESULT(C1);
--END GET_EMPLOYEE_MANAGERS;

DECLARE 
MY_CURSOR SYS_REFCURSOR;
BEGIN
GET_EMPLOYEE_MANAGERS(2, c1=>MY_CURSOR/*REF CURSOR*/);
END;

-- 4.3

-- Create a stored procedure that returns the name and company of a customer.

--CREATE OR REPLACE PROCEDURE GET_CUSTOMER_FLNAME_COMPANY (
--    C_ID IN CUSTOMER.CUSTOMERID%TYPE,
--    FNAME OUT CUSTOMER.FIRSTNAME%TYPE,
--    LNAME OUT CUSTOMER.LASTNAME%TYPE,
--    OUT_COMPANY OUT CUSTOMER.COMPANY%TYPE)
--AS
--BEGIN
--    SELECT FIRSTNAME, LASTNAME, COMPANY INTO FNAME, LNAME, OUT_COMPANY FROM CUSTOMER WHERE CUSTOMERID = C_ID;
--END GET_CUSTOMER_FLNAME_COMPANY;

DECLARE
FN CUSTOMER.FIRSTNAME%TYPE;
LN CUSTOMER.LASTNAME%TYPE;
O_COMP CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_CUSTOMER_FLNAME_COMPANY(1,FNAME=>FN/*VARCHAR2*/,LNAME=>LN/*VARCHAR2*/,OUT_COMPANY=>O_COMP/*VARCHAR2*/);
    DBMS_OUTPUT.PUT_LINE(FN || ' ' || LN || ' ' || O_COMP);
END;


--============ Section 5.0 ==================


-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

--CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INV_ID INVOICE.INVOICEID%TYPE)
--AS
--BEGIN 
--    DELETE FROM INVOICE CASCADE WHERE INVOICEID = INV_ID;
--    COMMIT;
--END DELETE_INVOICE;

BEGIN
    DELETE_INVOICE(1);
END;

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table

--CREATE OR REPLACE PROCEDURE ADD_CUSTOMER(
--CUST_ID CUSTOMER.CUSTOMERID%TYPE, 
--FNAME CUSTOMER.FIRSTNAME%TYPE,
--LNAME CUSTOMER.LASTNAME%TYPE,
--NEW_EMAIL CUSTOMER.EMAIL%TYPE)
--AS
--BEGIN 
--    INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (CUST_ID, FNAME, LNAME, NEW_EMAIL);
--    COMMIT;
--END ADD_CUSTOMER;

BEGIN
    ADD_CUSTOMER(200, 'LEWIS', 'BOB', 'EMAIL@EMAIL.COM');
END;

--============ Section 6.0 ==================


--6.1

-- Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER EMPL_TRIGGER AFTER INSERT ON EMPLOYEE
BEGIN 
    CASE
        WHEN INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Something was inserted into employee. So spooky.');
    END CASE;
END;

-- Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER ALBUM_TRIGGER AFTER UPDATE ON ALBUM
BEGIN 
    CASE
        WHEN INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Something was updated in album. Not spooky.');
    END CASE;
END;

-- Create an after delete trigger on the customer table that fires after a row is deleted from the table.

CREATE OR REPLACE TRIGGER CUSTOMER_TRIGGER AFTER DELETE ON CUSTOMER
BEGIN 
    CASE
        WHEN DELETING THEN
        DBMS_OUTPUT.PUT_LINE('Something was deleted from customer. Hopefully not too spoopy.');
    END CASE;
END;

--============ Section 7.0 ==================

--7.1

-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT DISTINCT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 7.2

-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.

SELECT DISTINCT C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL FROM CUSTOMER C FULL OUTER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

-- 7.3

--  Create a right join that joins album and artist specifying artist name and title.
SELECT DISTINCT ART.NAME, AL.TITLE FROM ARTIST ART RIGHT JOIN ALBUM AL ON art.artistid = AL.ARTISTID;

-- 7.4

-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT DISTINCT * FROM ALBUM CROSS JOIN ARTIST ORDER BY NAME;

-- 7.5

-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME, A.LASTNAME, B.FIRSTNAME, B.LASTNAME FROM EMPLOYEE A JOIN EMPLOYEE B ON A.EMPLOYEEID = B.REPORTSTO;

