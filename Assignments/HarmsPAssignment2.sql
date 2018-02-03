--2.1 SELECT
--Task – Select all records from the Employee table.
--This was a simple select statment, I just used the wildcard character to specify I wanted everything
SELECT * 
FROM EMPLOYEE;
--Task – Select all records from the Employee table where last name is King.
--This task was slightly more complicated, I had to include a where condiotion to speciy that I only wanted people with the sir name king
SELECT * 
FROM EMPLOYEE
WHERE LASTNAME = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
--This task I had to basicall do the same thing as th orevious problem, but this time with two conditionals joined by an and
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO  is null;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
--For this task, I just used the wildcard character to retrieve all from the album table and used order by to sort the results in descending order
SELECT * 
FROM ALBUM
ORDER BY TITLE DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
--This task asked us to specify a certain row from the customer column and then sort it using the order by based on the city column
--I did not specify ascending because it is a;ready the default
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY;
--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
--This was just two seperate DML insert statements 
INSERT INTO GENRE(GENREID, NAME)
VALUES(26, 'MATHROCK');
INSERT INTO GENRE(GENREID, NAME)
VALUES(27, 'HULA MUSIC');
--Task – Insert two new records into Employee table
--Pretty much the same as before, but with more data required in the table
--I also had to "cast" my format for date
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES(9, 'HARMS','PRESTON','LORD OF THE FLIES',NULL,TO_DATE('1993-03-30', 'YYYY-MM-DD'),TO_DATE('2018-01-22', 'YYYY-MM-DD'),'809 DEXTER','DENVER','COLORDAO', 'USA', '80220','970-518-2916','970-518-2916','PRESTONHARMS5@GMAIL.COM');
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
VALUES(10, 'JENNY','JENNY','FOR A GOOD TIME CALL',1,TO_DATE('1993-03-30', 'YYYY-MM-DD'),TO_DATE('2018-01-22', 'YYYY-MM-DD'),'221b Baker St','Marylebone','London', 'UK ', '6XE','970-867-5309','970-867-5309','JENNY42@GMAIL.COM');
--Task – Insert two new records into Customer table
--Again, simple DML with the date "casting"
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(60,'JOHN','DOE','REVATURE', '11730 Plaza America Dr #205', 'RESTON', 'VERGINA', 'USA', '20190','(703) 570-8181','(703) 570-8181','JDOE@GMAIL.COM',1);
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(61,'JANE','DOE','REVATURE', '11730 Plaza America Dr #205', 'RESTON', 'VERGINA', 'USA', '20190','(703) 570-8181','(703) 570-8181','JDOE@GMAIL.COM',10);
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
--I just used asn update too find Aaron Mitchell and replace him with Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
--Simple DML to get the information chjanged in the artist table
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
--This was a little more enjoyable, as I can see the like coming nin really handy for future searching
--I used the % character to specify that any number of characters could come after the T and that those entries should also be returned
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
--The between statement also seeems handy, as I used it later to specify a birth window
--this was more simple, as all ihad to do was say that the total must be between 15 aand 50
SELECT *
FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
--A more interesting application of the between keyword
SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-06-01', 'YYYY-MM-DD') AND TO_DATE('2004-03-31', 'YYYY-MM-DD');
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
--I nested the a select statement so that I could remove any of the child data before I was able to remove the parent data
DELETE FROM INVOICELINE
WHERE INVOICEID IN
(SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME= 'Walter'));
DELETE FROM INVOICE
WHERE CUSTOMERID IN
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME= 'Walter');
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME= 'Walter';
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
--Essentially a wrapper function, since it just returns the output of another function
CREATE OR REPLACE FUNCTION NOW
RETURN TIMESTAMP IS 
BEGIN
RETURN CURRENT_TIMESTAMP;
END;
/
SELECT NOW FROM DUAL;
--Task – create a function that returns the length of name in MEDIATYPE table
--Given an id it returns the length of the titles name
--The function uses the built in Length function to return the length of the varchar
CREATE OR REPLACE FUNCTION Media_Type_Length(SEARCHID NUMBER)
RETURN NUMBER IS 
    LEN VARCHAR2(200);
    BEGIN
        SELECT NAME INTO LEN FROM MEDIATYPE WHERE MEDIATYPEID = SEARCHID;
        RETURN LENGTH(LEN);
    END;
/
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
--This function simply returns the avergae function to average the tota;l from all total invoice costs
CREATE OR REPLACE FUNCTION AVERAGEINVOICE
RETURN NUMBER IS 
    AVERAGE NUMBER;
    BEGIN
        SELECT AVG(TOTAL) INTO AVERAGE FROM INVOICE; 
        RETURN AVERAGE;       
    END;
/
SELECT AVERAGEINVOICE FROM DUAL;  
--Task – Create a function that returns the most expensive track
--This function finds the most expensive track by using the max function on the unit proce in the track table
CREATE OR REPLACE FUNCTION MOSTEXPENSIVE
RETURN FLOAT IS
    MOST FLOAT;
    BEGIN
        SELECT MAX(UNITPRICE) INTO MOST FROM TRACK;
        RETURN MOST;
    END; 
SELECT MOSTEXPENSIVE FROM DUAL;  
--3.3 User Defined Scalar Functions 
--Task – Create a function that returns the average price of invoice line items in the invoice line table
--This task uses the average function to find trhe average of the unitprice column in the invoice line table
CREATE OR REPLACE FUNCTION AVERAGELINE
RETURN FLOAT IS
    AVERAGE FLOAT;
    BEGIN
        SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
        RETURN AVERAGE;
    END;
/
SELECT AVERAGELINE FROM DUAL; 
--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
--This funcction actaully uses a cursor, which I found out about online before it was mentioned in class
--I simple stored the result sof a select statment and returned the corsor pointing to it
CREATE OR REPLACE FUNCTION OLDMEN
RETURN SYS_REFCURSOR IS
 OLD_GUYS SYS_REFCURSOR; 
    BEGIN 
        OPEN OLD_GUYS FOR
        SELECT FIRSTNAME, LASTNAME, birthdate FROM EMPLOYEE WHERE BIRTHDATE BETWEEN TO_DATE('1969-01-01', 'YYYY-MM-DD') AND TO_DATE('2018-02-01', 'YYYY-MM-DD'); 
        RETURN OLD_GUYS;
    END;
/
SELECT OLDMEN FROM DUAL;        
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
--I used the sysref cursor again here to store the select statmetn that would return the first and last name from the employees table
CREATE OR REPLACE PROCEDURE DISP_EMPLOYEES(PEEPS OUT SYS_REFCURSOR) AS 
    BEGIN 
        OPEN PEEPS FOR
        SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE; 
    END;
--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
--This procedure takes in the employees old last name and replacecs it with the new one
--I thiough it might come in handy if antyone get married...
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE_NAME(NOW_EMP_NAME IN VARCHAR2, NEW_EMP_NAME VARCHAR2) AS 
    BEGIN 
        UPDATE EMPLOYEE
        SET LASTNAME = NEW_EMP_NAME
        WHERE LASTNAME = NOW_EMP_NAME;
    END;
--Task – Create a stored procedure that returns the managers of an employee.
--This procedure takes in the first and lasst name of an employee as input variables and put their manager into aanother variable
CREATE OR REPLACE PROCEDURE SPEAK_TO_MANAGER(EMP_FIRST_NAME IN VARCHAR2,EMP_LAST_NAME IN VARCHAR2, MANAGER OUT VARCHAR2) AS 
    BEGIN 
        SELECT REPORTSTO INTO MANAGER FROM EMPLOYEE WHERE FIRSTNAME = EMP_FIRST_NAME AND LASTNAME = EMP_LAST_NAME;
    END;
    /
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
--This procedure takes in the first and lasst name of an employee as input variables and put their copmany into aanother variable
CREATE OR REPLACE PROCEDURE Name_and_CO(CUST_FIRST_NAME_IN IN VARCHAR2,CUST_LAST_NAME_IN IN VARCHAR2, CUST_FIRST_NAME_OUT OUT VARCHAR2,CUST_LAST_NAME_OUT OUT VARCHAR2, CO OUT VARCHAR2) AS 
    BEGIN 
        SELECT COMPANY INTO CO FROM CUSTOMER WHERE FIRSTNAME = CUST_FIRST_NAME_IN AND LASTNAME = CUST_LAST_NAME_IN;
        CUST_FIRST_NAME_OUT := CUST_FIRST_NAME_IN;
        CUST_LAST_NAME_OUT := CUST_LAST_NAME_IN;
    END;
    /
--5.0 Transactions
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
--Since a transaction is simply anything that happens before a commit..
--I just stored the required delete and the prior delete that is required to remove the dependencies
CREATE OR REPLACE PROCEDURE DELETE_INVOICE(ID_NUM IN NUMBER)AS
    BEGIN
        DELETE FROM INVOICELINE WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE WHERE INVOICEID = ID_NUM);
        DELETE FROM INVOICE WHERE INVOICEID = ID_NUM;
    COMMIT;
    END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
--this procedure takes in a customers first and last name and an id and the emil, the required values
--and inserts them into the customer table
create or replace PROCEDURE INSERT_CUSTOMER
( FIRST_NAME VARCHAR2, LAST_NAME VARCHAR2, CUSTOMER_ID NUMBER, cemail VARCHAR2) AS
    BEGIN
        INSERT INTO CUSTOMER(CUSTOMERID,FIRSTNAME,LASTNAME, EMAIL) 
        VALUES(CUSTOMER_ID, FIRST_NAME, LAST_NAME, cemail);
    COMMIT;
    END;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
--JUST A TRIGGER THAT WILL PRINT OUT THE NAME OF ANY EMPLOYEE INSERTED INTO THE EMPLOYEE TABLE
CREATE OR REPLACE TRIGGER NEW_EMPLOYEE
    AFTER INSERT ON EMPLOYEE
    FOR EACH ROW
    BEGIN
        DBMS_OUTPUT.PUT_LINE('FAILED TO FEED BEAR'||:OLD.FIRSTNAME||' '||:OLD.LASTNAME||' DELETED FROM EMPLOYEE');
    END;
/
--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
--Just a trigger that prints out what was inserted from into album
CREATE OR REPLACE TRIGGER NEW_ALBUM
    AFTER INSERT ON ALBUM
    FOR EACH ROW
    DECLARE
    ALBUM_NAME VARCHAR2(200);
    BEGIN
        DBMS_OUTPUT.PUT_LINE(:new.FIRSTNAME||' '||:new.LASTNAME||' ADDED TO ALBUM');
    END;
/

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
--This trigger will simply prints out what was deleted from customer when it's deleted
CREATE OR REPLACE TRIGGER CUSTOMER_LOST
    AFTER DELETE ON CUSTOMER
    FOR EACH ROW
    DECLARE
    CUSTOMER_NAME VARCHAR2(200);
    BEGIN
        DBMS_OUTPUT.PUT_LINE(:OLD.FIRSTNAME||' '||:OLD.LASTNAME||' DELETED FROM CUSTOMER');
    END;
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
--Just a simple join on the above, gives lots of repeated data 
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID= INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME, CUSTOMER.CUSTOMERID, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER LEFT OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.ARTISTID = ARTIST.ARTISTID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ALBUM.TITLE, ARTIST.NAME
FROM ALBUM CROSS JOIN ARTIST ORDER BY ARTIST.NAME ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME AS EMPLOYEE1_FIRSTNAME, B.FIRSTNAME AS EMPLOYEE2_FIRSTNAME, A.LASTNAME AS EMPLOYEE1_LASTNAME, B.LASTNAME AS EMPLOYEE2_LASTNAME, A.REPORTSTO, B.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B WHERE A.REPORTSTO = B.REPORTSTO;