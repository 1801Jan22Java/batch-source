/*
Sungkwon Kudo
Assignment 2 
Revature
February 5, 2018

Notes:
Function and package definitions are commented out to prevent compilation errors.

*/

-- 2.1 SELECT
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
      AND   REPORTSTO IS NULL;
      
-- 2.2 ORDER BY
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
SELECT * FROM CUSTOMER
ORDER BY CITY ASC;

-- 2.3 INSERT INTO
-- 2 rows into Genre
INSERT INTO GENRE VALUES (
    26,'Witch House'
);
INSERT INTO GENRE VALUES (
    27,'Hobo Punk'
);
-- 2 rows into Employee
INSERT INTO EMPLOYEE (
    EMPLOYEEID,LASTNAME,FIRSTNAME
) VALUES (
    9,'Laura','Croft'
);
INSERT INTO EMPLOYEE (
    EMPLOYEEID,LASTNAME,FIRSTNAME
) VALUES (
    10,'Donald','Trump'
);
-- 2 rows into Customer
INSERT INTO CUSTOMER (
    CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL
) VALUES (
    60,'Super','Man','krypton@spacemail.com'
);
INSERT INTO CUSTOMER (
    CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL
) VALUES (
    61,'Wonder','Bread','flour@oven.bread'
);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CUSTOMER
    SET
        FIRSTNAME = 'Robert',LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron'
      AND   LASTNAME = 'Mitchell';
-- update artist
UPDATE ARTIST
    SET
        NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT INVOICEID FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
--Total between 15 and 50
SELECT CUSTOMERID,INVOICEID,INVOICEDATE
FROM INVOICE
WHERE TOTAL > 15
      AND   TOTAL < 50;
-- Employees between dates     
SELECT EMPLOYEEID,FIRSTNAME,LASTNAME
FROM EMPLOYEE
WHERE HIREDATE < '01-MAR-2004'
      AND   HIREDATE > '01-JUN-2003';
      
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter 
--(There may be constraints that rely on this, find out how to resolve them).

-- Change constraints by dropping and creating a new one with
-- a cascade delete.

-- Change the first constraint for invoice.customerid and customer.customerid
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
ALTER TABLE INVOICE
    ADD CONSTRAINT FK_INVOICECUSTOMERID FOREIGN KEY ( CUSTOMERID )
        REFERENCES CUSTOMER ( CUSTOMERID )
            ON DELETE CASCADE;
-- Change another constraint, this time between 
-- invoice.invoicelineinvoiceid and invoiceline.invoicelineinvoicelineid
ALTER TABLE INVOICELINE DROP CONSTRAINT FK_INVOICELINEINVOICEID;
ALTER TABLE INVOICELINE
    ADD CONSTRAINT FK_INVOICELINEINVOICEID FOREIGN KEY ( INVOICEID )
        REFERENCES INVOICE ( INVOICEID )
            ON DELETE CASCADE;
-- FINALLY delete the customer.             
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
      AND   LASTNAME = 'Walter';
      
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Task – create a function that returns the length of name in MEDIATYPE table

-- Time returner, select function and ctrl + / to uncomment
--CREATE OR REPLACE FUNCTION TIME_RETURN RETURN TIMESTAMP AS
--BEGIN
--    RETURN CURRENT_TIMESTAMP;
--END TIME_RETURN;
SELECT TIME_RETURN() FROM DUAL;

-- Length finder of MEDIATYPE table
-- Assumes that chinook is NOT a separate user, 
-- and the columns are in USER_TAB_COLUMNS
--CREATE OR REPLACE FUNCTION LENGTH_RETURN RETURN NUMBER AS
--    N NUMBER;
--BEGIN
--    SELECT DATA_LENGTH INTO
--        N
--    FROM USER_TAB_COLUMNS
--    WHERE TABLE_NAME = 'MEDIATYPE'
--          AND   COLUMN_NAME = 'NAME';
--    RETURN N;
--END;
SELECT LENGTH_RETURN() FROM DUAL;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
--Task – Create a function that returns the most expensive track

-- -- A function to return the total average of invoice.
--CREATE OR REPLACE FUNCTION INVOICE_TOTAL_AVERAGE RETURN NUMBER AS
--    N NUMBER;
--BEGIN
--    SELECT AVG(TOTAL) INTO
--        N
--    FROM INVOICE;
--    RETURN N;
--END;
SELECT INVOICE_TOTAL_AVERAGE() FROM DUAL;

-- A function to return the most expensive track from TRACK
--CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK RETURN NUMBER AS
--    N NUMBER;
--BEGIN
--    SELECT MAX(UNITPRICE) INTO
--        N
--    FROM TRACK;
--    RETURN N;
--END;
SELECT GET_MOST_EXPENSIVE_TRACK() FROM DUAL;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average 
--price of invoiceline items in the invoiceline table
--CREATE OR REPLACE FUNCTION AVG_INVOICE_PRICE RETURN NUMBER AS
--    N NUMBER;
--BEGIN
--    SELECT AVG(UNITPRICE) INTO
--        N
--    FROM INVOICELINE;
--    RETURN N;
--END;
SELECT AVG_INVOICE_PRICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

---- Create a custom user type to store the data type.
CREATE OR REPLACE TYPE EMPLOYEE_TYPE AS OBJECT (
    EMP_ID NUMBER,FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20)
);
-- create a nested table to store data
--CREATE OR REPLACE TYPE TABLE_EMP AS
--    TABLE OF EMPLOYEES;
---- Create function
--CREATE OR REPLACE FUNCTION EMPLOYEE_AFTER_YEAR (
--    VC_YEAR IN VARCHAR2
--) RETURN TABLE_EMP AS
--    RET_TABLE_EMP TABLE_EMP;
--    DATE_HOLDER VARCHAR2(20);
--BEGIN
--    DATE_HOLDER := '31-DEC-'
--    || VC_YEAR;
---- use cast-multiset to insert data into the nested table
--    SELECT CAST(MULTISET(
--        SELECT EMPLOYEEID,FIRSTNAME,LASTNAME
--        FROM EMPLOYEE
--        WHERE BIRTHDATE > DATE_HOLDER
--    ) AS TABLE_EMP) INTO
--        RET_TABLE_EMP
--    FROM DUAL;
--    RETURN RET_TABLE_EMP;
--END;
SELECT *
FROM TABLE ( EMPLOYEE_AFTER_YEAR('1968') );
-- referenced: 
--http://www.baigzeeshan.com/2010/01/plsql-function-to-return-table-type.html
--https://stackoverflow.com/questions/23755660/table-cast-vs-cast-multiset-in-pl-sql
--https://docs.oracle.com/cd/B19306_01/server.102/b14200/operators006.htm


--7.1 INNER
--Task – Create an inner join that joins customers and orders and
--specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME,LASTNAME,INVOICEID
FROM CUSTOMER C
INNER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID,FIRSTNAME,LASTNAME,INVOICEID,TOTAL
FROM CUSTOMER C
FULL OUTER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying 
--artist name and title.
SELECT AR.NAME,AL.TITLE
FROM ARTIST AR
INNER JOIN ALBUM AL ON AR.ARTISTID = AL.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by 
--artist name in ascending order.
SELECT NAME,TITLE FROM ARTIST,ALBUM
ORDER BY NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.