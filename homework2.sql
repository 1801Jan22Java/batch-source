-- 2.0 SQL Queries

-- 2.1 SELECT

-- Select all records from the Employee table
    -- basic select all statement
SELECT * FROM EMPLOYEE;
-- Select all records from the Employee table where last name is King
    -- basic select statement with condition
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
    -- basic select statement with two conditions
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO = NULL;

-- 2.2 ORDER BY

-- Select all albums in Album table and sort result set in descending order by title
    -- basic select statement testing descending order functionality
SELECT * FROM ALBUM ORDER BY TITLE DESC;
-- Select first name from Customer and sort result set in ascending order by city
    -- basic select statement testing ascending order functionality
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

-- 2.3 INSERT INTO

--Insert two new records into Genre table
INSERT INTO GENRE (GENREID, NAME) VALUES (26,'Dubstep');
INSERT INTO GENRE (GENREID, NAME) VALUES (27,'Trap');
-- Insert two new records into Employee table
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FISRTNAME) VALUES (9,'Smith','John');
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FISRTNAME) VALUES (10,'Camp','Evan');
-- Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME) VALUES (60,'Matt','Stone');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME) VALUES (61,'Trey','Parker');

-- 2.4 UPDATE

-- Update Aaron Mitchell in Customer table to Robert Walter
    -- basic update statement for specified row
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
    -- basic update statement for specified row
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

-- 2.5 LIKE

-- Select all invoices with a billing address like “T%”
    -- basic select statement testing "LIKE" functionality with regular expressions
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN

-- Select all invoices that have a total between 15 and 50
    -- basic select statement testing "BETWEEN" functionality with two numbers
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
-- Select all employees hired between 1st of June 2003 and 1st of March 2004
    -- basic select statement testing "BETWEEN" functionality with two DATE values
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '1-MAR-04';

-- 2.7 DELETE

-- Delete a record in Customer table where the name is Robert Walter
    -- basic delete statement which, due to foreign key constraints, requires cascading deletion
DELETE FROM INVOICELINE WHERE INVOICEID IN(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));
DELETE FROM INVOICE WHERE CUSTOMERID IN(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'); 
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--------------------------------------------------------------------------------------------------------------------------------
-- 3.0 SQL Functions

-- 3.1 System Defined Functions

-- Create a function that returns the current time.
    -- basic function that returns a TO_CHAR formatted version of CURRENT_TIMESTAMP
CREATE OR REPLACE FUNCTION CURRTIME 
    RETURN VARCHAR2
    IS
    BEGIN 
        RETURN TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS');
    END;
/
SELECT CURRTIME FROM DUAL;

-- create a function that returns the length of name in MEDIATYPE table
    -- basic function demonstrating function variable and USER_TAB_COLUMNS functionality
CREATE OR REPLACE FUNCTION MEDIATYPE_NAME_SIZE
    RETURN NUMBER
    IS 
    NAMESIZE NUMBER;
    BEGIN
        SELECT DATA_LENGTH INTO NAMESIZE FROM USER_TAB_COLUMNS WHERE TABLE_NAME='MEDIATYPE' AND COLUMN_NAME='NAME';
        RETURN NAMESIZE;
    END;
/
SELECT MEDIATYPE_NAME_SIZE FROM DUAL;

-- 3.2 System Defined Aggregate Functions

-- Create a function that returns the average total of all invoices 
    -- basic function demonstrating functionality of AVG()
CREATE OR REPLACE FUNCTION AVG_INVOICE_TOTAL
    RETURN NUMBER
    IS 
    IT_AVG NUMBER;
    BEGIN
        SELECT AVG(TOTAL)
        INTO IT_AVG
        FROM INVOICE;
        RETURN IT_AVG;
    END;
/
SELECT AVG_INVOICE_TOTAL FROM DUAL;

-- Create a function that returns the most expensive track
    -- basic function demonstrating functionality of MAX()
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
    RETURN NUMBER
    IS 
    MAXPRICE NUMBER;
    BEGIN
        SELECT MAX(UNITPRICE)
        INTO MAXPRICE
        FROM TRACK;
        RETURN MAXPRICE;
    END;
/
SELECT MOST_EXPENSIVE_TRACK FROM DUAL;

-- 3.3 User Defined Scalar Functions 

-- Create a function that returns the average price of invoiceline items in the invoiceline table
    -- another basic function demonstrating functionality of AVG()
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_PRICE
    RETURN NUMBER
    IS 
    AVGPRICE NUMBER;
    BEGIN
        SELECT AVG(UNITPRICE)
        INTO AVGPRICE
        FROM INVOICELINE;
        RETURN AVGPRICE;
    END;
/
SELECT AVG_INVOICELINE_PRICE FROM DUAL;

-- 3.4 User Defined Table Valued Functions

-- Create a function that returns all employees who are born after 1968.
    -- due to not knowing about cursors at the time of writing this, I used a nested table to return resultset
    -- this part creates an employee type
CREATE OR REPLACE TYPE EMPLOYEE_TYPE AS OBJECT
    (EMPLOYEEID	NUMBER,
    LASTNAME	VARCHAR2(20 BYTE),
    FIRSTNAME	VARCHAR2(20 BYTE));
/
    -- this part creates a table of employee type
CREATE OR REPLACE TYPE EMPLOYEE_NESTED_TABLE AS TABLE OF EMPLOYEE_TYPE;
/
    -- this function retreives the required table and returns it through the nested table
CREATE OR REPLACE FUNCTION MODERN_EMPLOYEE
    RETURN EMPLOYEE_NESTED_TABLE
    IS 
    TEMP_TABLE EMPLOYEE_NESTED_TABLE;
    BEGIN
        SELECT EMPLOYEE_TYPE(A.EMPLOYEEID, A.LASTNAME, A.FIRSTNAME)
        BULK COLLECT INTO TEMP_TABLE
        FROM (SELECT EMPLOYEEID, LASTNAME, FIRSTNAME
        FROM EMPLOYEE
        WHERE BIRTHDATE > '31-DEC-1968') A;
        RETURN TEMP_TABLE;
    END;
/
SELECT * FROM TABLE(MODERN_EMPLOYEE);

--------------------------------------------------------------------------------------------------------------------------------
-- 4.0 Stored Procedures

-- 4.1 Basic Stored Procedure

-- Create a stored procedure that selects the first and last names of all the employees
    -- basic proceedure using a cursor to return multiple results from a stored proceedure
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE GET_EMP_NAMES (CURS OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN CURS FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE 
CURS SYS_REFCURSOR;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_EMP_NAMES(CURS);
    LOOP
        FETCH CURS INTO FNAME, LNAME;
        EXIT WHEN CURS%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FNAME||' '||LNAME);
    END LOOP;
    CLOSE CURS;
END;

-- 4.2 Stored Procedure Input Parameters

-- Create a stored procedure that updates the personal information of an employee
    -- basic proceedure testing the usage of input parameters in order to direct an update
CREATE OR REPLACE PROCEDURE UPDATE_EMP_NAME 
    (EMP_ID IN NUMBER,
    NEW_FNAME IN EMPLOYEE.FIRSTNAME%TYPE,
    NEW_LNAME IN EMPLOYEE.LASTNAME%TYPE)
    IS
    BEGIN
        UPDATE EMPLOYEE SET FIRSTNAME = NEW_FNAME, LASTNAME = NEW_LNAME
        WHERE EMPLOYEEID = EMP_ID;
    END;
/
DECLARE 
EMP_ID NUMBER := 1;
FNAME EMPLOYEE.FIRSTNAME%TYPE := 'Andy';
LNAME EMPLOYEE.LASTNAME%TYPE := 'Anderson';
BEGIN
    UPDATE_EMP_NAME(EMP_ID, FNAME, LNAME);
END;
/
-- Create a stored procedure that returns the managers of an employee.
    -- basic proceedure testing the usage of output parameters to return results from a stored proceedure
CREATE OR REPLACE PROCEDURE GET_EMP_MANAGER 
    (EMP_ID IN NUMBER,
    MANAGER_FNAME OUT EMPLOYEE.FIRSTNAME%TYPE,
    MANAGER_LNAME OUT EMPLOYEE.LASTNAME%TYPE)
    IS
    MANAGER_ID NUMBER;
    BEGIN
        SELECT REPORTSTO
        INTO MANAGER_ID 
        FROM EMPLOYEE 
        WHERE EMPLOYEEID = EMP_ID;
        SELECT FIRSTNAME, LASTNAME
        INTO MANAGER_FNAME, MANAGER_LNAME
        FROM EMPLOYEE
        WHERE EMPLOYEEID = MANAGER_ID;
    END;
/
DECLARE
EMP_ID NUMBER := 3;
FNAME EMPLOYEE.FIRSTNAME%TYPE;
LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    GET_EMP_MANAGER(EMP_ID, FNAME, LNAME);
    DBMS_OUTPUT.PUT_LINE(FNAME||' '||LNAME);
END;
/

-- 4.3 Stored Procedure Output Parameters

-- Create a stored procedure that returns the name and company of a customer
    -- basic proceedure demonstrating the combined usage of input/output parameters for result retreival
CREATE OR REPLACE PROCEDURE GET_CUST_DETAILS 
    (CUST_ID IN NUMBER,
    CUST_FNAME OUT CUSTOMER.FIRSTNAME%TYPE,
    CUST_LNAME OUT CUSTOMER.LASTNAME%TYPE,
    CUST_COMPANY OUT CUSTOMER.COMPANY%TYPE)
    IS
    BEGIN
        SELECT FIRSTNAME, LASTNAME, COMPANY
        INTO CUST_FNAME, CUST_LNAME, CUST_COMPANY 
        FROM CUSTOMER 
        WHERE CUSTOMERID = CUST_ID;
    END;
/
DECLARE
CUST_ID NUMBER := 5;
FNAME CUSTOMER.FIRSTNAME%TYPE;
LNAME CUSTOMER.LASTNAME%TYPE;
COMP CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_CUST_DETAILS(CUST_ID, FNAME, LNAME, COMP);
    DBMS_OUTPUT.PUT_LINE(FNAME||' '||LNAME||' works for '||COMP);
END;
/

--------------------------------------------------------------------------------------------------------------------------------
-- 5.0 Transactions

-- Create a transaction that given a invoiceId will delete that invoice
    -- basic procedure containing delete statement which, due to foreign key constraints, requires cascading deletion
CREATE OR REPLACE PROCEDURE DELETE_INVOICE
    (INV_ID IN NUMBER)
    IS
    BEGIN
        DELETE FROM INVOICELINE WHERE INVOICEID = INV_ID;
        DELETE FROM INVOICE WHERE INVOICEID = INV_ID;
    END;
/
DECLARE
INV_ID NUMBER := 412;
BEGIN
    DELETE_INVOICE(INV_ID);
END;
/
-- Create a transaction nested within a stored procedure that inserts a new record in the Customer table
    -- basic procedure demonstrating usage of a stored procedure for insertion
CREATE OR REPLACE PROCEDURE INSERT_CUSTOMER
    (CUST_ID IN NUMBER,
    CUST_FNAME IN CUSTOMER.FIRSTNAME%TYPE,
    CUST_LNAME IN CUSTOMER.LASTNAME%TYPE,
    CUST_EMAIL IN CUSTOMER.EMAIL%TYPE)
    IS
    BEGIN
        INSERT INTO CUSTOMER 
        (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL)
        VALUES
        (CUST_ID, CUST_FNAME, CUST_LNAME, CUST_EMAIL);
    END;
/
DECLARE
CUST_ID NUMBER := 60;
CUST_FNAME CUSTOMER.FIRSTNAME%TYPE := 'Dave';
CUST_LNAME CUSTOMER.LASTNAME%TYPE := 'Grohl';
CUST_EMAIL CUSTOMER.EMAIL%TYPE := 'daveGrohl@fooFighters.com';
BEGIN
    INSERT_CUSTOMER(CUST_ID, CUST_FNAME, CUST_LNAME, CUST_EMAIL);
END;
/

--------------------------------------------------------------------------------------------------------------------------------
-- 6.0 Transactions

-- 6.1 AFTER/FOR

-- Create an after insert trigger on the employee table fired after a new record is inserted into the table
    -- -- basic trigger that prints a statement after a row is inserted
CREATE OR REPLACE TRIGGER EMP_INSERT_TRIGGER
AFTER INSERT
    ON EMPLOYEE
    FOR EACH ROW
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Employee has been successfully added');
END;
/

-- Create an after update trigger on the album table that fires after a row is inserted in the table
    -- basic trigger that prints a statement after a row is updated
CREATE OR REPLACE TRIGGER ALBUM_UPDATE_TRIGGER
AFTER UPDATE
    ON ALBUM
    FOR EACH ROW
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album has been successfully updated');
END;
/
-- Create an after delete trigger on the customer table that fires after a row is deleted from the table
    -- basic trigger that prints a statement after a row is deleted
CREATE OR REPLACE TRIGGER CUSTOMER_DELETE_TRIGGER
AFTER DELETE
    ON CUSTOMER
    FOR EACH ROW
DECLARE
BEGIN
    DBMS_OUTPUT.PUT_LINE('Album has been successfully deleted');
END;
/

--------------------------------------------------------------------------------------------------------------------------------
-- 7.0 JOINS

-- 7.1 INNER

-- Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
    -- basic select statement demonstrating INNER JOIN functionality
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID;

-- 7.2 OUTER

-- Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
    -- basic select statement demonstrating FULL OUTER JOIN functionality
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

-- 7.3 RIGHT

-- Create a right join that joins album and artist specifying artist name and title
    -- basic select statement demonstrating RIGHT OUTER JOIN functionality
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ALBUM RIGHT OUTER JOIN ARTIST
ON ALBUM.ARTISTID = ALBUM.ARTISTID;

-- 7.4 CROSS

-- Create a cross join that joins album and artist and sorts by artist name in ascending order
    -- basic select statement demonstrating CROSS JOIN functionality
SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

-- 7.5 SELF

-- Perform a self-join on the employee table, joining on the reportsto column
    -- basic select statment demonstrating usage of a self join to return new, useful data from a single table
SELECT A.FIRSTNAME || A.LASTNAME AS EMPLOYEE_NAME, B.FIRSTNAME || B.LASTNAME AS BOSS_NAME
FROM EMPLOYEE A LEFT OUTER JOIN EMPLOYEE B
ON A.REPORTSTO = B.EMPLOYEEID;
