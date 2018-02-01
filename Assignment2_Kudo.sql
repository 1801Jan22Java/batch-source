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
    26,
    'Witch House'
);
INSERT INTO GENRE VALUES (
    27,
    'Hobo Punk'
);
-- 2 rows into Employee
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME
) VALUES (
    9,
    'Laura',
    'Croft'
);
INSERT INTO EMPLOYEE (
    EMPLOYEEID,
    LASTNAME,
    FIRSTNAME
) VALUES (
    10,
    'Donald',
    'Trump'
);
-- 2 rows into Customer
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    EMAIL
) VALUES (
    60,
    'Super',
    'Man',
    'krypton@spacemail.com'
);
INSERT INTO CUSTOMER (
    CUSTOMERID,
    FIRSTNAME,
    LASTNAME,
    EMAIL
) VALUES (
    61,
    'Wonder',
    'Bread',
    'flour@oven.bread'
);

--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE CUSTOMER
    SET
        FIRSTNAME = 'Robert',
        LASTNAME = 'Walter'
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
SELECT CUSTOMERID,
       INVOICEID,
       INVOICEDATE
FROM INVOICE
WHERE TOTAL > 15
      AND   TOTAL < 50;
-- Employees between dates     
SELECT EMPLOYEEID,
       FIRSTNAME,
       LASTNAME
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
CREATE OR REPLACE FUNCTION TIME_RETURN RETURN TIMESTAMP AS
BEGIN
    RETURN CURRENT_TIMESTAMP;
END TIME_RETURN;
      
/
SELECT TIME_RETURN() FROM DUAL;

-- Length finder of MEDIATYPE table
-- Assumes that chinook is NOT a separate user, 
-- and the columns are in USER_TAB_COLUMNS
CREATE OR REPLACE FUNCTION LENGTH_RETURN RETURN NUMBER AS
    N NUMBER;
BEGIN
    SELECT DATA_LENGTH INTO
        N
    FROM USER_TAB_COLUMNS
    WHERE TABLE_NAME = 'MEDIATYPE'
          AND   COLUMN_NAME = 'NAME';
    RETURN N;
END;

/
SELECT LENGTH_RETURN() FROM DUAL;

--3.2 System Defined Aggregate Functions

-- -- A function to return the total average of invoice.
CREATE OR REPLACE FUNCTION INVOICE_TOTAL_AVERAGE RETURN NUMBER AS
    N NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO
        N
    FROM INVOICE;
    RETURN N;
END;

/
SELECT INVOICE_TOTAL_AVERAGE() FROM DUAL;

-- A function to return the most expensive track from TRACK
CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK RETURN NUMBER AS
    N NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO
        N
    FROM TRACK;
    RETURN N;
END;

/
SELECT GET_MOST_EXPENSIVE_TRACK() FROM DUAL;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average 
--price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICE_PRICE RETURN NUMBER AS
    N NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO
        N
    FROM INVOICELINE;
    RETURN N;
END;

/
SELECT AVG_INVOICE_PRICE() FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

---- Create a custom user type to store the data type.
CREATE OR REPLACE TYPE EMPLOYEE_TYPE AS OBJECT (
    EMP_ID      NUMBER,
    FIRSTNAME   VARCHAR2(20),
    LASTNAME    VARCHAR2(20)
);
/
 --create a nested table to store data
CREATE OR REPLACE TYPE TABLE_EMP AS
    TABLE OF EMPLOYEES;
    /
-- Create function
CREATE OR REPLACE FUNCTION EMPLOYEE_AFTER_YEAR (
    VC_YEAR IN VARCHAR2
) RETURN TABLE_EMP AS
    RET_TABLE_EMP TABLE_EMP;
    DATE_HOLDER VARCHAR2(20);
BEGIN
    DATE_HOLDER := '31-DEC-'
    || VC_YEAR;
-- use cast-multiset to insert data into the nested table
    SELECT CAST(MULTISET(
        SELECT EMPLOYEEID,FIRSTNAME,LASTNAME
        FROM EMPLOYEE
        WHERE BIRTHDATE > DATE_HOLDER
    ) AS TABLE_EMP) INTO
        RET_TABLE_EMP
    FROM DUAL;
    RETURN RET_TABLE_EMP;
END;

/
SELECT *
FROM TABLE ( EMPLOYEE_AFTER_YEAR('1968') );
-- referenced: 
--http://www.baigzeeshan.com/2010/01/plsql-function-to-return-table-type.html
--https://stackoverflow.com/questions/23755660/table-cast-vs-cast-multiset-in-pl-sql
--https://docs.oracle.com/cd/B19306_01/server.102/b14200/operators006.htm

--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.

--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees. 
CREATE OR REPLACE PROCEDURE FIRST_LAST_NAMES AS
    CURSOR C_NAME IS SELECT FIRSTNAME,
                            LASTNAME FROM EMPLOYEE;
BEGIN
    FOR VC_NAME IN C_NAME LOOP
        DBMS_OUTPUT.PUT_LINE(VC_NAME.FIRSTNAME
        || ' '
        || VC_NAME.LASTNAME);
    END LOOP;
END;

/
BEGIN
    FIRST_LAST_NAMES;
END;
/

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information
--of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMP (
    N_EMPID      IN NUMBER,
    VC_LNAME     IN VARCHAR2,
    VC_FNAME     IN VARCHAR2,
    VC_TITLE     IN VARCHAR2,
    N_REPORT     IN NUMBER,
    D_BDATE      IN DATE,
    D_HIRE       IN DATE,
    VC_ADDRESS   IN VARCHAR2,
    VC_CITY      IN VARCHAR2,
    VC_STATE     IN VARCHAR2,
    VC_COUNTRY   IN VARCHAR2,
    VC_POSTAL    IN VARCHAR2,
    VC_PHONE     IN VARCHAR2,
    VC_FAX       IN VARCHAR2,
    VC_EMAIL     IN VARCHAR2
)
    AS
BEGIN
    UPDATE EMPLOYEE
        SET
            LASTNAME = VC_LNAME,
            FIRSTNAME = VC_FNAME,
            TITLE = VC_TITLE,
            REPORTSTO = N_REPORT,
            BIRTHDATE = D_BDATE,
            HIREDATE = D_HIRE,
            ADDRESS = VC_ADDRESS,
            CITY = VC_CITY,
            STATE = VC_STATE,
            COUNTRY = VC_COUNTRY,
            POSTALCODE = VC_POSTAL,
            PHONE = VC_PHONE,
            FAX = VC_FAX,
            EMAIL = VC_EMAIL
    WHERE EMPLOYEEID = N_EMPID;
 
END;
/
BEGIN
    update_emp(1,'William','Overture','Sharp Shooter',1,'12-DEC-1912','03-MAR-1950'
,'1111 One Avenue','Dallas','Texas','USA','10101','1111111111','2222222222'
,'applesonhead@arrow.com');
END;
/
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE ret_employee_managers (
    n_empid   IN NUMBER
) IS
    n_manager_id       NUMBER;
    vc_manager_last    VARCHAR2(20);
    vc_manager_first   VARCHAR2(20);
BEGIN
SELECT employeeid,firstname,
                       lastname INTO
        n_manager_id,vc_manager_last,vc_manager_first
                FROM employee
                WHERE employeeid = (
        SELECT reportsto FROM employee WHERE employeeid = n_empid
    );
    dbms_output.put_line(n_manager_id
    || ' '
    || vc_manager_first
    || ' '
    || vc_manager_last);
END;
/
BEGIN
    ret_employee_managers(3);
END;
/

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_cust_name_company (
    n_customerid   IN NUMBER
) AS
    vc_firstname   VARCHAR2(20);
    vc_lastname    VARCHAR2(20);
    vc_company     VARCHAR2(20);
BEGIN
    SELECT firstname,
                       lastname,
                       company INTO
        vc_firstname,vc_lastname,vc_company
                FROM customer
                WHERE customerid = n_customerid;
    dbms_output.put_line(vc_firstname
    || ' '
    || vc_lastname
    || ' '
    || vc_company);
END;
/
BEGIN
get_cust_name_company(2);
END;
/

--5.0 Transactions
--In this section you will be working with transactions. Transactions 
--are usually nested within a stored procedure.

--Task – Create a transaction that given a invoiceId will delete that 
--invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice (
    n_invoiceid IN NUMBER
)
    AS
BEGIN
    DELETE FROM invoice WHERE invoiceid = n_invoiceid;
    commit;
END;
/
BEGIN
delete_invoice(215);
END;
/
--Task – Create a transaction nested within a stored procedure that 
--inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE add_new_customer(
n_customerid IN NUMBER,
vc_firstname IN VARCHAR2,
vc_lastname IN VARCHAR2,
vc_company IN VARCHAR2,
vc_address IN VARCHAR2,
vc_city IN VARCHAR2,
vc_state IN VARCHAR2,
vc_country IN VARCHAR2,
vc_postalcode IN VARCHAR2,
vc_phone IN VARCHAR2,
vc_fax IN VARCHAR2,
n_email IN VARCHAR2,
n_supportrepid IN NUMBER
) AS
row_exists NUMBER;
BEGIN
SELECT customerid
INTO row_exists
FROM customer
WHERE customerid=n_customerid;
-- Don't insert if row already exists with PK
IF row_exists >=1 THEN
    dbms_output.put_line('row exists');
  ELSE
    INSERT INTO customer(
    customerid,
    firstname,
    lastname,
    company,
    address,
    city,
    STATE,
    country,
    postalcode,
    phone,
    fax,
    email,
    supportrepid)
    VALUES(
    n_customerid,
    vc_firstname,
    vc_lastname,
    vc_company ,
    vc_address ,
    vc_city ,
    vc_state ,
    vc_country ,
    vc_postalcode ,
    vc_phone ,
    vc_fax ,
    n_email,
    n_supportrepid);
    COMMIT;
  END IF;
  
END;
/
BEGIN 
add_new_customer(300, 'Yordle','Hunter','Rito Mages', '1337 Rift Lane',
'San Fran', 'California', 'USA','12345','1234567890','0987654321', 'hunteem@run.com',4);
END;
/

--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired
--after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TRG_AI_EMPLOYEE AFTER
    INSERT ON EMPLOYEE
DECLARE
    N   NUMBER;
BEGIN
    SELECT COUNT(EMPLOYEEID) INTO
        N
    FROM EMPLOYEE;
    DBMS_OUTPUT.PUT_LINE(N);
END;
/
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUES(93, 'John','Smith');
/
--Task – Create an after update trigger on the album table that fires 
--after a row is updated in the table
CREATE OR REPLACE TRIGGER TRG_AU_ALBUM AFTER
    UPDATE ON ALBUM FOR EACH ROW
BEGIN

    DBMS_OUTPUT.PUT_LINE('Album updated from: '||:OLD.albumid || ' to '||:NEW.albumid);
END;

/
UPDATE ALBUM
SET ARTISTID = 15
WHERE ALBUMID = 28;
/
--Task – Create an after delete trigger on the customer table that 
--fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TRG_AD_CUSTOMER_LOG AFTER
    DELETE ON CUSTOMER
    FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('Deleted '
    ||:OLD.CUSTOMERID
    || ', '
    || :OLD.FIRSTNAME
    || ', '
    || :OLD.LASTNAME);
END;
/
DELETE FROM CUSTOMER
WHERE customerID = 300;
/
--7.1 INNER
--Task – Create an inner join that joins customers and orders and
--specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME,
      LASTNAME,
      INVOICEID
FROM CUSTOMER C
INNER JOIN INVOICE I ON C.CUSTOMERID = I.CUSTOMERID;

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, 
--specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT C.CUSTOMERID,
      FIRSTNAME,
      LASTNAME,
      INVOICEID,
      TOTAL
FROM CUSTOMER C FULL OUTER
JOIN INVOICE I ON C.CUSTOMERID =
I.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying 
--artist name and title.
SELECT AR.NAME,
       AL.TITLE
FROM ARTIST AR
INNER JOIN ALBUM AL ON AR.ARTISTID = AL.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by 
--artist name in ascending order.
SELECT NAME,
       TITLE FROM ARTIST,
                 ALBUM
ORDER BY NAME ASC;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
-- Note: Practically a cross join without the join keyword used.
SELECT A.EMPLOYEEID AS TRAINEE,
       A.FIRSTNAME,
       A.LASTNAME,
       B.EMPLOYEEID AS EMPLOYER,
       B.FIRSTNAME,
       B.LASTNAME
FROM EMPLOYEE A,
     EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;
