/*
Sungkwon Kudo
Assignment 2 
Revature
February 5, 2018
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

