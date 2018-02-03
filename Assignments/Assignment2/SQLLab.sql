--CREATE VIEW TEST2
--AS SELECT ARTIST.NAME, ALBUM.TITLE
--FROM ARTIST FULL OUTER JOIN ALBUM
--ON ARTIST.ARTISTID=ALBUM.ARTISTID;
--
--SELECT * FROM TEST2 WHERE TITLE LIKE 'F%' ORDER BY NAME;
--
--CREATE SEQUENCE STUDENTS_1
--MAXVALUE 10000
--START WITH 1000;
--
--SELECT STUDENTS_1.NEXTVAL FROM DUAL;

CREATE OR REPLACE FUNCTION avg_song
    (artist_id INT)
    RETURN FLOAT
    IS media_name VARCHAR2(500);
    album_num FLOAT;
    track_num FLOAT;
BEGIN
    SELECT COUNT(ALBUM.ALBUMID)
    INTO track_num
    FROM ALBUM INNER JOIN TRACK 
    ON ALBUM.ALBUMID=TRACK.ALBUMID WHERE ALBUM.ARTISTID=artist_id;

    SELECT COUNT(DISTINCT ALBUM.ALBUMID)
    INTO album_num
    FROM ALBUM INNER JOIN TRACK 
    ON ALBUM.ALBUMID=TRACK.ALBUMID WHERE ALBUM.ARTISTID=artist_id;
    
    RETURN(track_num/album_num);
    --RETURN(LENGTH(inputString));
END;
/

SELECT avg_song(50) FROM DUAL;

SELECT COUNT(ALBUM.ALBUMID)
FROM ALBUM INNER JOIN TRACK 
ON ALBUM.ALBUMID=TRACK.ALBUMID WHERE ALBUM.ARTISTID=50
ORDER BY ALBUM.ALBUMID;

SELECT COUNT(DISTINCT ALBUM.ALBUMID)
FROM ALBUM INNER JOIN TRACK 
ON ALBUM.ALBUMID=TRACK.ALBUMID WHERE ALBUM.ARTISTID=50
ORDER BY ALBUM.ALBUMID;

-- 2.1 SELECT
-- Select all records from the Employee table
SELECT * FROM EMPLOYEE;

-- Select all records from the Employee table where last name is King
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';

-- Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE (FIRSTNAME='Andrew' AND REPORTSTO IS NULL);

-- 2.2 ORDER BY
-- Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

-- 2.3 INSERT INTO
-- Insert two new records into Genre table
INSERT INTO GENRE VALUES(26, 'Country');
INSERT INTO GENRE VALUES(27, 'Hick Hop');
-- Insert two new records into Employee table
-- INSERT INTO EMPLOYEE VALUES(9, 'Jobs', 'Steve', 'Lead Engineer', 7, TO_DATE('1991/10/07'), TO_DATE('2017/07/10'), 'address', 'city', 'state', 'country', '37427', '1234567', '1234567', 'fakemail@fakedomain.com');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES(9, 'Jobs', 'Steve');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES(10, 'Name', 'Fake');

-- Insert two new records into Customer table
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES(60, 'Jobs', 'Steve', 'notarealemail12@alsonotreal.com');
INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES(61, 'Name', 'Fake', 'fakeemail@fakedomain.com');

-- 2.4 UPDATE
-- Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE(FIRSTNAME='Aaron' AND LASTNAME='Mitchell');

-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival';

-- 2.5 LIKE
-- Select all invoices with a billing address like “T%”
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN
-- Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;

-- Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
-- Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
DELETE FROM INVOICELINE WHERE INVOICEID IN
(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME= 'Walter'));

DELETE FROM INVOICE WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME= 'Walter');

DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME= 'Walter';

-- 3. SQL Functions
-- 3.1 System Defined Functions
-- Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time
    RETURN DATE IS
BEGIN
    RETURN(SYSDATE);
END;
/

SELECT get_time FROM DUAL;

--  create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION get_length
    (media INT)
    RETURN INT
    IS media_name VARCHAR2(500);
    
BEGIN
    SELECT NAME INTO media_name FROM MEDIATYPE WHERE MEDIATYPEID=media;
    RETURN( LENGTH(media_name));
END;
/

SELECT get_length(3) FROM DUAL;


-- 3.2 System Defined Aggregate Functions
--  Create a function that returns the average total of all invoices
CREATE OR REPLACE FUNCTION get_length
    RETURN FLOAT 
    IS average FLOAT;
    
BEGIN
    SELECT AVG(TOTAL) INTO average FROM INVOICE;
    RETURN(average);
END;
/

SELECT AVG(TOTAL) FROM INVOICE;


--  Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_most_expensive_track
    RETURN VARCHAR
    IS track VARCHAR(500);
    
BEGIN
    SELECT NAME INTO track FROM TRACK WHERE (UNITPRICE=(SELECT MAX(UNITPRICE) FROM TRACK) AND ROWNUM=1);
    RETURN(track);
END;
/

SELECT get_most_expensive_track FROM DUAL;


-- 3.3 User Defined Scalar Functions
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION get_avg_unit_price
    RETURN FLOAT 
    IS average FLOAT;
    
BEGIN
    SELECT AVG(UNITPRICE) INTO average FROM INVOICELINE;
    RETURN(average);
END;
/

SELECT get_avg_unit_price FROM DUAL;


-- 3.4 User Defined Table Valued Functions
-- Create a function that returns all employees who are born after 1968
-- CREATE TYPE employee_table OF EMPLOYEE; 

CREATE OR REPLACE FUNCTION get_employees_date
    (input_date DATE)
    RETURN SYS_REFCURSOR AS S SYS_REFCURSOR;
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE WHERE(BIRTHDATE>input_date);
    
    RETURN(S);
END;
/

DECLARE
    S SYS_REFCURSOR;
    FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME EMPLOYEE.LASTNAME%TYPE;
    BIRTHDATE EMPLOYEE.BIRTHDATE%TYPE;
BEGIN
    S := get_employees_date('01-JAN-68');
        LOOP
        FETCH S INTO FIRSTNAME, LASTNAME, BIRTHDATE;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(LASTNAME|| ', ' || FIRSTNAME || ' Born: ' || BIRTHDATE);
        END LOOP;
    CLOSE s;
END;
/

-- 4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types
-- of stored procedures that take input and output parameters.
-- 4.1 Basic Stored Procedure
-- Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE names_select (S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    S SYS_REFCURSOR;
    FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    names_select(S);
        LOOP
        FETCH S INTO FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(LASTNAME|| ', '|| FIRSTNAME);
        END LOOP;
    CLOSE S;
END;
/

-- 4.2 Stored Procedure Input Parameters
-- Create a stored procedure that updates the personal information of an employee.
--This procedure takes in employeeid and changes their phone and email to keep it simple
CREATE OR REPLACE PROCEDURE info_update
(emp_id VARCHAR, emp_phone VARCHAR, emp_email VARCHAR)AS 
BEGIN
 UPDATE EMPLOYEE SET PHONE=emp_phone, EMAIL=emp_email WHERE(EMPLOYEEID=emp_id);
END;
/

EXECUTE info_update(10, '18001234567', 'thisisafakeemail@thisisafakedomain.com');

-- Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE get_manager (emp_id INT, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT t2.FIRSTNAME, t2.LASTNAME FROM EMPLOYEE t1, EMPLOYEE t2 WHERE t1.EMPLOYEEID=emp_id AND t1.REPORTSTO=t2.EMPLOYEEID;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    S SYS_REFCURSOR;
    FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
    LASTNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    get_manager(3, S);
        LOOP
        FETCH S INTO FIRSTNAME, LASTNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Manager is: ' || LASTNAME|| ', '|| FIRSTNAME);
        END LOOP;
    CLOSE S;
END;
/

-- 4.3 Stored Procedure Output Parameters
-- Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customer (cust_id INT, S OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER WHERE CUSTOMERID=cust_id;
END;
/

SET SERVEROUTPUT ON;

DECLARE
    S SYS_REFCURSOR;
    FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
    LASTNAME CUSTOMER.LASTNAME%TYPE;
    COMPANY CUSTOMER.COMPANY%TYPE;
    
BEGIN
    get_customer(5, S);
        LOOP
        FETCH S INTO FIRSTNAME, LASTNAME, COMPANY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Customer: ' || LASTNAME|| ', '|| FIRSTNAME || ' Company: ' || COMPANY);
        END LOOP;
    CLOSE S;
END;
/


-- 5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored
-- procedure.

-- Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
-- rely on this, find out how to resolve them).
-- We also need to delete references to that ID in invoiceline
CREATE OR REPLACE PROCEDURE DELETE_INVOICE (INVOICE_ID INT)
IS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID=INVOICE_ID;
    DELETE FROM INVOICE WHERE INVOICEID=INVOICE_ID;
    COMMIT;
END;
/

EXECUTE DELETE_INVOICE(110);

-- Create a transaction nested within a stored procedure that inserts a new record in the Customer
-- table
CREATE OR REPLACE PROCEDURE NEW_CUSTOMER
(CUSTOMER_ID INT, FIRSTN VARCHAR, LASTN VARCHAR, EMAIL VARCHAR )
IS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, LASTNAME, FIRSTNAME, EMAIL) VALUES(CUSTOMER_ID, FIRSTN, LASTN, EMAIL);
    COMMIT;
END;
/

EXECUTE NEW_CUSTOMER(62, 'Rocky', 'Balboa', 'Rockie''srealemail@4real.com');

-- 6.0 Triggers
-- In this section you will create various kinds of triggers that work when certain DML statements are
-- executed on a table.
-- 6.1 AFTER/FOR
-- Create an after insert trigger on the employee table fired after a new record is inserted into the
-- table.
CREATE OR REPLACE TRIGGER AFTER_NEW_RECORD
    AFTER INSERT ON EMPLOYEE
    BEGIN
        UPDATE CUSTOMER SET FIRSTNAME='Ricky', LASTNAME='Bobby' WHERE FIRSTNAME='Kara';
    END;
/

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME) VALUES(12, 'Mark', 'Twain');

-- Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
    AFTER UPDATE ON ALBUM
    BEGIN
        UPDATE TRACK SET UNITPRICE=5.0 WHERE TRACKID=102;
    END;
/

UPDATE ALBUM SET TITLE='My Title Now' WHERE ALBUMID=225;

-- Create an after delete trigger on the customer table that fires after a row is deleted from the
-- table.
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
    AFTER DELETE ON CUSTOMER
    BEGIN
        UPDATE PLAYLIST SET NAME='Even Better Music' WHERE PLAYLISTID=5;
    END;
/

DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME= 'Walter';

-- 7.0 JOINS
-- In this section you will be working with combining various tables through the use of joins. You will work
-- with outer, inner, right, left, cross, and self joins.
-- 7.1 INNER
-- Create an inner join that joins customers and orders and specifies the name of the customer and
-- the invoiceId.
SELECT CUSTOMER.LASTNAME, CUSTOMER.FIRSTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID
ORDER BY LASTNAME;


-- 7.2 OUTER
-- Create an outer join that joins the customer and invoice table, specifying the CustomerId,
-- firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.LASTNAME, CUSTOMER.FIRSTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID
ORDER BY LASTNAME;


-- 7.3 RIGHT
-- Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.TITLE, ARTIST.NAME 
FROM ALBUM RIGHT JOIN ARTIST
ON ALBUM.ARTISTID=ARTIST.ARTISTID
ORDER BY ALBUM.TITLE;


-- 7.4 CROSS
-- Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY ARTIST.NAME;


-- 7.5 SELF
-- Perform a self-join on the employee table, joining on the reportsto column.
SELECT * FROM EMPLOYEE t1, EMPLOYEE t2 WHERE t1.REPORTSTO=t2.EMPLOYEEID;

