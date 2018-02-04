--CREATED BY: KARANDEEP SAINI
SET SERVEROUTPUT ON;

--2.1 SELECT
--Task – Select all records from the Employee table.
SELECT * FROM EMPLOYEE;
-- A SELECT statement is used for a query. * specifies all. The FROM clause is used to specify table_name(s) or column_name(s).

--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE 
WHERE LASTNAME = 'King'; 
-- This query returns all records from Employee where the varchar in LastName is equal to 'King'.

--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE 
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;
--This query return all records from Employee where the varchar in FirstName is equal to 'Andrew' and where ReporsTo is null.


--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
ORDER BY TITLE DESC;
--This query return all records from Album and orders them by the title name in descending order.

--Task – Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER
ORDER BY CITY;
--This query returns FirstName records from Customer in ascending order of the City field

--2.3 INSERT INTO
--Task – Insert two new records into Genre table
INSERT ALL 
INTO GENRE
VALUES 
(26, 'Suspense')
INTO GENRE
VALUES
(27, 'Grunge')
SELECT 1 FROM DUAL;
--Here the values of 26, 'Suspense' and 27, 'Grunge' are being inserted into the Genre table for GenreID and name.
--The SELECT FROM DUAL clause for syntax purposes since it is required when using INSERT ALL.
--It is not necessary to put the column names after INSERT INTO table_name since an input is being specified for each 
--column in the table. 

--Task – Insert two new records into Employee table
INSERT ALL 
INTO EMPLOYEE
VALUES
(9, 'Jones', 'Bob', 'IT Staff', 6, TO_DATE('01-JAN-78', 'DD-MON-RR'), TO_DATE('14-APR-05', 'DD-MON-RR'), 
'555 Fake ST', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (403) 555-5555', '+1 (403) 555-5556', 'bob@chinookcorp.com')
INTO EMPLOYEE
VALUES
(10, 'Dillon', 'Francis', 'IT Staff', 6, TO_DATE('15-DEC-79', 'DD-MON-RR'), TO_DATE('20-NOV-05', 'DD-MON-RR'), 
'555 Real ST', 'Lethbridge', 'AB', 'Canada', 'T1K 5N8', '+1 (403) 666-6666', '+1 (403) 666-6667', 'francis@chinookcorp.com')
SELECT 1 FROM DUAL;
-- Insert all is used to insert multiple lines into a table. A select statement is needed to use insert all 
-- so select 1 from dual is used to get rid of that to give 1 row of dummy data.
-- The column names do not have to be listed after INTO table_name since 
-- a value for each column is being specified after VALUES.

--Task – Insert two new records into Customer table
INSERT ALL 
INTO CUSTOMER
VALUES
(60, 'Rob', 'Doogan', null, '2222 W Berry Street', 'Fort Worth', 'TX', 'USA', 
76110, '+1 (817) 555-5555', null, 'rdoogan@hotmail.com', 4) 
INTO CUSTOMER
VALUES
(61, 'John', 'Rickson', null, '1037 N Park Ave', 'Tuscon', 'AZ', 'USA', 
85719, '+1 (520) 555-5555', null, 'jrickson@hotmail.com', 4)
SELECT 1 FROM DUAL;
--Used INSERT ALL to insert multiple rows (with a dummy row used for the select statement).
--Specified the value for each column thus eliminating the need to specify each column in the statement.


--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',
    LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron'
AND LASTNAME = 'Mitchell';
--Where both firstname = 'Aaron' and lastname = 'Mitchell' both evaluate to true
--update firstname to 'Robert' and lastname to 'Walter'. This updated the row that had customerid 32.

--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--Replaced 'Creedence Clearwater Revival' with 'CCR'.

--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE;
SELECT * FROM INVOICE
WHERE BILLINGADDRESS
LIKE 'T%';
-- Returns all records from the Invoice table that have a BillingAddress field that starts with T.

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE
WHERE TOTAL
BETWEEN 15 AND 50;
-- Returns all records from the Invoice table that have a Total field with a value between 15 and 50.

--Task – Select all employees hired between 1 st of June 2003 and 1 st of March 2004
SELECT * FROM EMPLOYEE
WHERE HIREDATE
BETWEEN TO_DATE('01-JUN-03', 'DD-MON-RR') AND TO_DATE('01-MAR-04', 'DD-MON-RR');
-- Returns all records from Employee table where the HireDate field has a value between June 1st, 2003 and March 1st, 2004.


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).

--In order to delete Robert Walter from the Customer table his child data must first removed from
--the INVOICE table. In order to delete the records from the INVOICE table the child data from
--the INVOICELINE table must first be removed.

--Delete all INVOICELINEID's from the INVOICELINE table that correspond to Robert Walter
DELETE FROM INVOICELINE WHERE INVOICELINE.INVOICELINEID IN ( 
    SELECT INVOICELINE.INVOICELINEID
    FROM INVOICELINE
    INNER JOIN INVOICE
    ON INVOICELINE.INVOICEID = INVOICE.INVOICEID
    WHERE INVOICE.INVOICEID IN (
        SELECT INVOICE.INVOICEID
        FROM INVOICE
        INNER JOIN CUSTOMER
        ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
        WHERE CUSTOMER.FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter')); --38 rows deleted

--Delete all INVOICELINE's from the INVOICE table that correspond to Robert Walter
DELETE FROM INVOICE WHERE INVOICE.INVOICEID IN (
    SELECT INVOICE.INVOICEID
    FROM INVOICE
    INNER JOIN CUSTOMER
    ON INVOICE.CUSTOMERID = CUSTOMER.CUSTOMERID
    WHERE CUSTOMER.FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME = 'Walter'); --7 rows deleted

DELETE FROM CUSTOMER 
WHERE FIRSTNAME = 'Robert' 
AND LASTNAME = 'Walter';    --1 row deleted

--After attempting to delete the record, an error was displayed saying that an 
--integrity constraint in the INVOICE table was violated and child records were found.
--A similiar error was displayed when attempting to delete the corresponding invoices
--saying that child data existed in the INVOICELINE table. 
--The child data was deleted nesting SELECT statements with INNER JOINS into the 
--WHERE clause of the DELETE statement, as follows WHERE column_name IN (SELECT ...). 


--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION GET_TIME
    RETURN DATE
    IS CRNT_TIME DATE;
    BEGIN
        SELECT SYSDATE INTO CRNT_TIME FROM DUAL;
        RETURN CRNT_TIME;
    END;
/
--Above creates a function called GET_TIME. The IS clause is used to create a DATE variable
--and it is set in the BEGIN clause by selecting Sysdate (system defined function) from DUAL (a dummy variable)
--and storing the value INTO the CRNT_TIME variable. CRNT_TIME is then returned.
--The function is run below to test its functionality.
DECLARE
    CRNT_TIME DATE;
BEGIN
    CRNT_TIME := GET_TIME();
    DBMS_OUTPUT.PUT_LINE(CRNT_TIME);
END;
/

--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GET_LENGTH_OF_MEDIATYPE_NAME(MEDIATYPEID_IN IN NUMBER)
    RETURN NUMBER
    IS MEDIATYPE_LENGTH NUMBER;
    BEGIN
        SELECT LENGTH(NAME) 
        INTO MEDIATYPE_LENGTH 
        FROM MEDIATYPE 
        WHERE MEDIATYPEID = MEDIATYPEID_IN;
        RETURN MEDIATYPE_LENGTH;
    END;
/
--A function is created above to take a MEDIATYPEID as an input parameter.
--The function declares variable called MEDIATYPE_LENGTH of the NUMBER data type
--and it is set by calling the system defined function LENGTH() on the NAME column of the MEDIATYPE table
--according to the specified IN parameter.
--The MEDIATYPE_LENGTH variable is then returned.
--The function is run below for a MEDIATYPEID value of 1 to test its functionality.
DECLARE
    MEDIATYPE_LENGTH NUMBER;
    MEDIATYPEID_IN NUMBER;
BEGIN
    MEDIATYPEID_IN := 1;
    MEDIATYPE_LENGTH := GET_LENGTH_OF_MEDIATYPE_NAME(MEDIATYPEID_IN);
    DBMS_OUTPUT.PUT_LINE(MEDIATYPE_LENGTH);
END;
/


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION GET_AVERAGE_INVOICE
    RETURN NUMBER
    IS AVERAGE NUMBER;
    BEGIN
        SELECT AVG(TOTAL) 
        INTO AVERAGE
        FROM INVOICE;
        RETURN AVERAGE;
    END;
/
--The defined function above declares a variable called AVERAGE of the NUMBER data type
--and it is set by calling the system defined aggregate function AVG() on the TOTAL column of the INVOICE table.
--The AVERAGE variable is then returned.
--The function is run below for a MEDIATYPEID value of 1 to test its functionality.
DECLARE
    AVERAGE NUMBER;
BEGIN
    AVERAGE := GET_AVERAGE_INVOICE();
    DBMS_OUTPUT.PUT_LINE(AVERAGE);
END;
/

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION GET_MOST_EXPENSIVE_TRACK
    RETURN NUMBER
    IS MAX_TRACK NUMBER;
    BEGIN
        SELECT MAX(UNITPRICE) 
        INTO MAX_TRACK
        FROM TRACK;
        RETURN MAX_TRACK;
    END;
/
--The defined function above declares a variable named MAX_TRACK of the NUMBER data type
--and it is set by calling the system defined aggregate function MAX() on the UNITPRICE column of the MAX_TRACK table.
--The MAX_TRACK variable is then returned.
--The function is run below for a to test its functionality.
DECLARE
    MAX_TRACK NUMBER;
BEGIN
    MAX_TRACK := GET_MOST_EXPENSIVE_TRACK;
    DBMS_OUTPUT.PUT_LINE(MAX_TRACK);
END;
/


--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVERAGE_INVOICELINE(UNITPRICE IN NUMBER, QUANTITY IN NUMBER)
RETURN NUMBER
IS
BEGIN 
    RETURN UNITPRICE/QUANTITY;
END;
/
--The function defined above is specified to have two NUMBER input parameters.
--It returns the UNITPRICE divided by the QUANTITY for each row of the INVOICELINE table.
--The function is demonstrated in the SELECT statement below.
SELECT INVOICELINEID, AVERAGE_INVOICELINE(UNITPRICE,QUANTITY)
FROM INVOICELINE;


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION GET_BIRTHDATES_AFTER_1968(BIRTHDATE IN DATE)
RETURN DATE
IS NEWDATE DATE;
BEGIN
    IF BIRTHDATE > TO_DATE('31-DEC-68', 'DD-MON-RR') THEN
        NEWDATE := BIRTHDATE;
    ELSE
        NEWDATE := NULL;
    END IF;
    RETURN NEWDATE;
END;
/
--The above function is defined to take in a DATE argument. A new variable NEWDATE is declared within the function
--and it is initialized to be equal to the input argument if the date is after 1968 and is initialized to null if it isn't.
--The function is used below, in a SELECT statement, to return all employees that were after 1968. 
SELECT * FROM EMPLOYEE WHERE GET_BIRTHDATES_AFTER_1968(BIRTHDATE) IS NOT NULL;


--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEE_NAMES(S_CURSOR OUT SYS_REFCURSOR)
IS 
BEGIN
    OPEN S_CURSOR FOR
    SELECT EMPLOYEEID, LASTNAME, FIRSTNAME 
    FROM EMPLOYEE;
END;
/

DECLARE
    S_CURSE SYS_REFCURSOR;
    EMPLOYEE_ID EMPLOYEE.EMPLOYEEID%TYPE;
    LNAME EMPLOYEE.LASTNAME%TYPE;
    FNAME EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
    GET_ALL_EMPLOYEE_NAMES(S_CURSE);
    LOOP
        FETCH S_CURSE INTO EMPLOYEE_ID, LNAME, FNAME;
        EXIT WHEN S_CURSE%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EMPLOYEEID: ' || EMPLOYEE_ID || ' FirstName: ' || FNAME || ' LastName: ' || LNAME);
    END LOOP;
END;
/
--The procedure GET_ALL_EMPLOYEE_NAMES defined above opens a refcurser for a query on the EMPLOYEE table
--for the the EMPLOYEEID, FIRSTNAME, and LASTNAME columns.
--The procedure is used to retrieve the cursor/query result and it is iterated through using a for loop,
--with each loop the employee's EMPLOYEEID, FIRSTNAME, LASTNAME are printed to the console
--until there are no more rows and the loop is exited.


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_INFO(E_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
E_ADDRESS IN EMPLOYEE.ADDRESS%TYPE, E_CITY IN EMPLOYEE.CITY%TYPE, E_STATE IN EMPLOYEE.STATE%TYPE,
E_COUNTRY IN EMPLOYEE.COUNTRY%TYPE, E_POSTALCODE IN EMPLOYEE.POSTALCODE%TYPE, 
E_PHONE IN EMPLOYEE.PHONE%TYPE, E_FAX IN EMPLOYEE.FAX%TYPE, E_EMAIL IN EMPLOYEE.EMAIL%TYPE)
IS
BEGIN
    UPDATE EMPLOYEE
    SET ADDRESS = E_ADDRESS, CITY = E_CITY, STATE = E_STATE,
        COUNTRY = E_COUNTRY, POSTALCODE = E_POSTALCODE, 
        PHONE = E_PHONE, FAX = E_FAX, EMAIL = E_EMAIL
    WHERE EMPLOYEEID = E_ID;
END;
/

CALL UPDATE_EMPLOYEE_INFO(6, '555 Big ST', 'Calgary', 'AB', 'Canada', 'T3B 0C5', 
                        '+1 (403) 777-7777', '+1 (403) 777-7778', 'michael2@chinookcorp.com')
--A stored procedure named UPDATE_EMPLOYEE_INFO was created above that takes
--the ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, and EMPLOYEEID as input arguments.
--An UPDATE clause is put into the procedure so that the columns are updated according to their corresponding input arguments
--for the row specified with the EMPLOYEEID argument.
--The procedure is run above using the CALL keyword.

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_EMPLOYEES_MANAGER(E_ID IN EMPLOYEE.EMPLOYEEID%TYPE, MANAGER OUT EMPLOYEE.REPORTSTO%TYPE)
IS
    BEGIN
        SELECT REPORTSTO INTO MANAGER FROM EMPLOYEE WHERE EMPLOYEEID = E_ID;
    END;
/

DECLARE
    E_ID EMPLOYEE.EMPLOYEEID%TYPE;
    MANAGER EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    E_ID := 2;
    GET_EMPLOYEES_MANAGER(E_ID, MANAGER);
    DBMS_OUTPUT.PUT_LINE('Employee: ' || E_ID || ' reports to manager ' || MANAGER);
END;
/
--A procedure named GET_EMPLOYEES_MANAGER with an IN parameter for the EMPLOYEEID and an OUT parameter for REPORTSTO
--is defined above.
--The EMPLOYEEID is passed in as an argument and that row's corresponding REPORTSTO field is returned. 
--This is executed above and a message is displayed to the console.


--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_INFO(C_ID IN CUSTOMER.CUSTOMERID%TYPE, 
FNAME OUT CUSTOMER.FIRSTNAME%TYPE, LNAME OUT CUSTOMER.LASTNAME%TYPE)
IS
    BEGIN
        SELECT FIRSTNAME, LASTNAME
        INTO FNAME, LNAME 
        FROM CUSTOMER 
        WHERE CUSTOMERID = C_ID;
    END;
/

DECLARE
    C_ID CUSTOMER.CUSTOMERID%TYPE;
    FNAME CUSTOMER.FIRSTNAME%TYPE;
    LNAME CUSTOMER.LASTNAME%TYPE;
BEGIN
    C_ID := 1;
    GET_CUSTOMER_INFO(C_ID, FNAME, LNAME);
    DBMS_OUTPUT.PUT_LINE('CustomerID: ' || C_ID || ' FirstName: ' || FNAME || ' LastName: ' || LNAME);
END;
/
--A procedure named GET_CUSTOMER_INFO with an IN parameter for the CUSTOMERID and OUT parameters 
--for FIRSTNAME and LASTNAME is defined above.
--The CUSTOMERID is passed in as an argument and that row's corresponding FIRSTNAME
--and LASTNAME fields are returned. 
--This is executed above and a message is displayed to the console.


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
--procedure.

--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(INVOICE_ID IN INVOICE.INVOICEID%TYPE)
IS
    BEGIN
        DELETE FROM INVOICELINE WHERE INVOICELINE.INVOICELINEID IN (
            SELECT INVOICELINE.INVOICELINEID
            FROM INVOICELINE
            INNER JOIN INVOICE
            ON INVOICELINE.INVOICEID = INVOICE.INVOICEID
            WHERE INVOICELINE.INVOICEID = INVOICE_ID);
            
        DELETE FROM INVOICE WHERE INVOICE.INVOICEID = INVOICE_ID;
    COMMIT;
    END;
    /
--A transaction was created within a stored procedure called DELETE_INVOICE.
--The procedure takes an input argument for the INVOICEID.
--Then the INVOICELINE records corresponding to that INVOICEID are first deleted
--from the INVOICELINE table, followed by the INVOICE record being deleted from the INVOICE table.
--The records are deleted in this order because the INVOICE table has child data in the INVOICELINE table.
CALL DELETE_INVOICE(2);
--Tested for deleting INVOICE with an INVOICEID value of 2.
--Looking at the INVOICE table, this record was deleted.
--Also when looking at the INVOICELINE table it ca be seen that all 
--records with INVOICELINE_ID's corresponding to an INVOICEID of 2 (i.e. INVOICELINEID's 3, 4, 5, and 6)
--were also deleted.


--Task – Create a transaction nested within a stored procedure that inserts a 
--new record in the Customer table
CREATE OR REPLACE PROCEDURE INSERT_NEW_CUSTOMER(C_ID IN CUSTOMER.CUSTOMERID%TYPE, 
C_FIRSTNAME IN CUSTOMER.FIRSTNAME%TYPE, C_LASTNAME IN CUSTOMER.LASTNAME%TYPE, C_COMPANY IN CUSTOMER.COMPANY%TYPE,
C_ADDRESS IN CUSTOMER.ADDRESS%TYPE, C_CITY IN CUSTOMER.CITY%TYPE, C_STATE IN CUSTOMER.STATE%TYPE,
C_COUNTRY IN CUSTOMER.COUNTRY%TYPE, C_POSTALCODE IN CUSTOMER.POSTALCODE%TYPE, C_PHONE IN CUSTOMER.PHONE%TYPE,
C_FAX IN CUSTOMER.FAX%TYPE, C_EMAIL IN CUSTOMER.EMAIL%TYPE, C_SUPPORTREPID IN CUSTOMER.SUPPORTREPID%TYPE)
IS
    BEGIN       --TRANSACTION
        INSERT INTO CUSTOMER
        VALUES
        (C_ID, C_FIRSTNAME, C_LASTNAME, C_COMPANY, C_ADDRESS, C_CITY, C_STATE,   
         C_COUNTRY, C_POSTALCODE, C_PHONE, C_FAX, C_EMAIL, C_SUPPORTREPID);
    COMMIT;
    END;
/

CALL INSERT_NEW_CUSTOMER(62, 'Jim', 'Jimson', null, 'Boston', '222 Two Chains Street', 'MA',
                        'USA', 2113, '+1 (617) 222-2222', null, 'jjimson@hotmail.com', 4); 
--A procedure named INSERT_NEW_CUSTOMER with an IN parameter for CUSTOMERID and all other
--columns in the CUSTOMER table is defined above.
--A transaction is defined within the procedure represented between the BEGIN END keywords.
--A DML INSERT statement is executed if all the passed in arguments for the procedure are valid.
--The procedure is executed above with the CALL keyword.


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are
--executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--An AFTER TRIGGER is created below for when an employee is inserted into the EMPLOYEE table.
--The trigger inserts a dummy customer (that makes no purchases) into the CUSTOMER table for each new employee.
--In order to do this a BEFORE TRIGGER must be created for the CUSTOMER table's primary key using a SEQUENCE.
CREATE SEQUENCE SQ_CUSTOMER_PK  --SEQUENCE for PK of CUSTOMER table
START WITH 70
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER CUSTOMER_BEFORE_INSERT_PK --TRIGGER for BEFORE INSERT on CUSTOMER table
BEFORE INSERT ON CUSTOMER
FOR EACH ROW
BEGIN
    SELECT SQ_CUSTOMER_PK.NEXTVAL INTO :NEW.CUSTOMERID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER EMPLOYEE_AFTER_INSERT --TRIGGER for AFTER INSERT on EMPLOYEE table
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO CUSTOMER
    (FIRSTNAME, LASTNAME, EMAIL, SUPPORTREPID)
    VALUES
    ('Dummy', 'Customer', 'dummy@email.com', :new.EMPLOYEEID);
END;
/
--The EMPLOYEE_AFTER_INSERT TRIGGER will fire after an employee is inserted into the EMPLOYEE table.
--The INSERT within the body of the TRIGGER would not execute until the 
--BEFORE TRIGGER, CUSTOMER_BEFORE_INSERT_PK, for the CUSTOMER table executes first.


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--An AFTER TRIGGER is created below for when an album is inserted into the ALBUM table.
--The trigger inserts a dummy track into the TRACK table for each new album.
--In order to do this a BEFORE TRIGGER must be created for the TRACK table's primary key using a SEQUENCE.
CREATE SEQUENCE SQ_TRACK_PK  --SEQUENCE for PK of CUSTOMER table
START WITH 4000
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER TRACK_BEFORE_INSERT_PK --TRIGGER for BEFORE INSERT on CUSTOMER table
BEFORE INSERT ON TRACK
FOR EACH ROW
BEGIN
    SELECT SQ_TRACK_PK.NEXTVAL INTO :NEW.TRACKID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER ALBUM_AFTER_INSERT -- TRIGGER for AFTER INSERT on ALBUM table
AFTER INSERT ON ALBUM
FOR EACH ROW
BEGIN
    INSERT INTO TRACK
    (TRACK.NAME, ALBUMID, MEDIATYPEID, MILLISECONDS, UNITPRICE)
    VALUES
    ('Dummy Track', :new.ALBUMID, 1, 1000, 0);
END;
/

INSERT INTO ALBUM
VALUES (400, 'DUMN TITLE', 275);
--The ALBUM_AFTER_INSERT TRIGGER will fire after an album is inserted into the ALBUM table.
--The INSERT within the body of the TRIGGER would not execute until the 
--BEFORE TRIGGER, TRACK_BEFORE_INSERT_PK, for the TRACK executes first.


--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--An AFTER TRIGGER is created below for when a customer is deleted from the CUSTOMER table.
--The trigger inserts a dummy invoice into the INVOICE table each time a customer is deleted,
--if invoice corresponding to an INVOICEID of 1 exists in the INVOICE table.
--In order to do this a BEFORE TRIGGER must be created for the INVOICE table's primary key using a SEQUENCE.
CREATE SEQUENCE SQ_INVOICE_PK  --SEQUENCE for PK of INVOICE table
START WITH 500
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER INVOICE_BEFORE_INSERT_PK --TRIGGER for BEFORE INSERT on INVOICE table
BEFORE INSERT ON INVOICE
FOR EACH ROW
BEGIN
    SELECT SQ_INVOICE_PK.NEXTVAL INTO :NEW.INVOICEID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER CUSTOMER_AFTER_DELETE --TRIGGER for AFTER DELETE on CUSTOMER table
AFTER DELETE ON CUSTOMER
FOR EACH ROW
DECLARE
    FIRST_INVOICE_ID NUMBER;
    TODAYS_DATE DATE;
BEGIN
    SELECT INVOICEID INTO FIRST_INVOICE_ID FROM INVOICE WHERE INVOICEID = 1;
    SELECT SYSDATE INTO TODAYS_DATE FROM DUAL;
    IF FIRST_INVOICE_ID > 0 THEN
        INSERT INTO INVOICE
        (CUSTOMERID, INVOICEDATE, TOTAL)
        VALUES
        (1, TODAYS_DATE, 0);
    END IF;
END;
/
--The CUSTOMER_AFTER_DELETE TRIGGER will fire after a customer is deleted from the CUSTOMER table.
--The INSERT within the body of the TRIGGER would not execute until the 
--BEFORE TRIGGER, INVOICE_BEFORE_INSERT_PK, for the INVOICE table executes first.


--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work
--with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER
INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 
-- Return FirstName and LastName from the Customer table and InvoiceID from the Invoice table
-- by matching the CustomerID fields in each table.


--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER LEFT OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 60 OR CUSTOMERID = 61;
-- A left outer join is used above meaning that all fields for the columns specified in the
-- left table (Customer table) will show (i.e. CustomerID, FirstName, LastName). 
-- For the right table (Invoice table), for InvoiceID and Total, only the fields that satisfy the ON condition are returned.
-- the values for InvoiceID and Total are null for where CustomerID is 60 and 61 (buttom of returned query)
-- because these CustomerID's exist in the Customer table but not in the Invoice table.


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST RIGHT OUTER JOIN ALBUM
ON ARTIST.ARTISTID = ALBUM.ARTISTID;
-- A right outer join is used above meaning that all fields for the columns specified in the
-- right table (Album table) will show (i.e. Title). 
-- For the left table (Artist Table), for Name, only the fields that satisfy the ON condition are returned.
-- In this case the ON condition was met for all rows.


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.ALBUMID, ALBUM.TITLE, ARTIST.ARTISTID, ARTIST.NAME 
FROM ALBUM CROSS JOIN ARTIST;
-- A cross join was used here so the cartesian product of the two tables was returned.
-- The specific columns were written in the SELECT clause instead of *,
-- to avoid having two albums with ALBUMID since ALBUMID is a foreign key in the Artist table.
-- This means that each field for the four columns was multiplied by every other field to return all combinations.


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE;
SELECT A.FIRSTNAME AS NAME, B.REPORTSTO AS BOSS
FROM EMPLOYEE A JOIN EMPLOYEE B
ON A.EMPLOYEEID = B.EMPLOYEEID;
--A self join was used above. The column names are given an alias in the SELECT clause (these are returned from the query),
--two separate aliases are given in the FROM clause (A and B) and these are used for writing the clause.
--EmployeeID is used for the ON clause so that all rows are returned.