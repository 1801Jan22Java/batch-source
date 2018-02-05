--2.1 SELECT
--Select all records from the Employee table.
SELECT * FROM EMPLOYEE;

--Select all records from the Employee table where last name is King.
SELECT * 
FROM EMPLOYEE 
WHERE LASTNAME = 'King';

--Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--2.2 ORDER BY
--select all albums in Album table and sort result set in descending order by title
SELECT *
FROM ALBUM
ORDER BY TITLE DESC;

-- Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
-- Insert two new records into Genre table ]

INSERT INTO GENRE (GENREID, NAME) VALUES (28,'KPOP');
INSERT INTO GENRE (GENREID, NAME) VALUES (29, 'Anime');

--Insert two new records into Employee table        not tested
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (56348, 'Janet', 'Jackson');
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, REPORTSTO) 
            VALUES (9861, 'BEYONCE', 'Knowles-Carter', 2);

--Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
            VALUES (136, 'Natalie', 'Jones', 'natalie.jones@gmail.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) 
            VALUES (146, 'William', 'Jenkins', 'will.jenkins@gmail.com');
--2.4 UPDATE
--Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER 
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';


-- Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST 
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5 LIKE
--– Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;


--Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-06-01', 'YYYY-MM-DD') AND TO_DATE('2004-03-01', 'YYYY-MM-DD');

--2.7 DELETE
--Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them)
ALTER TABLE INVOICE                             --DELETE FOREIGN KEY CONSTRAINT IN INVOICE 
DROP  CONSTRAINT FK_INVOICECUSTOMERID;

ALTER TABLE INVOICE                             --REPLACE FOREIGN KEY WITH CASCADE SO WHEN CORRESPONDING ROWS IN CUSTOMER ARE DELETED THE COUNTERPARTS IN INVOICE ARE DELETED AS WELL 
ADD CONSTRAINT FK_INVOICECUSTOMERID
    FOREIGN KEY (CUSTOMERID)
    REFERENCES CUSTOMER (CUSTOMERID)
    ON DELETE CASCADE;

ALTER TABLE INVOICELINE
DROP  CONSTRAINT FK_INVOICELINEINVOICEID;       --DELETE FOREIGN KEY CONSTRAINT IN INVOICELINE SO WE CAN DELETE A ROW IN INVOICE

ALTER TABLE INVOICELINE                         --REPLACE FOREIGN KEY WITH CASCADE SO WHEN CORRESPONDING ROWS IN INVOICE ARE DELETED THE COUNTERPARTS IN INVOICELINE ARE DELETED AS WELL
ADD CONSTRAINT FK_INVOICELINEINVOICEID
    FOREIGN KEY (INVOICEID)
    REFERENCES INVOICE (INVOICEID)
    ON DELETE CASCADE;

DELETE FROM CUSTOMER                                --FINALLY DELETE THE ROW IN CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION CURR_TIME 
RETURN TIMESTAMP
IS  CURTIMESTAMP TIMESTAMP;
BEGIN
    RETURN LOCALTIMESTAMP;
END;



--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION MEDIA_TYPE_LENGTH(NAME IN VARCHAR2) 
RETURN NUMBER IS TYPE_LENGTH NUMBER;
BEGIN
RETURN LENGTH(NAME);
END;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION INVOICE_AVG (TOTAL IN NUMBER)
RETURN NUMBER IS I_AVG NUMBER;
BEGIN
SELECT AVG(TOTAL)
    INTO I_AVG
    FROM INVOICE;
RETURN I_AVG;
END;

--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MOST_EXPENSIVE_TRACK
RETURN NUMBER IS TRACK_ID NUMBER;
CURSOR CURS IS
SELECT TRACKID FROM TRACK WHERE UNITPRICE IN (SELECT MAX(UNITPRICE) FROM TRACK) AND ROWNUM = 1;
BEGIN
    OPEN CURS;
    FETCH CURS INTO TRACK_ID;
    CLOSE CURS;
    RETURN TRACK_ID;
END MOST_EXPENSIVE_TRACK;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AVG_INVOICELINE_PRICE 
RETURN NUMBER AS
    N NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO
        N
    FROM INVOICELINE;
    RETURN N;
END;
/

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.

CREATE OR REPLACE FUNCTION GET_YOUNG_EMPLOYEE 
RETURN SYS_REFCURSOR IS C1 SYS_REFCURSOR;
BEGIN
    OPEN C1 FOR SELECT * FROM EMPLOYEE WHERE BIRTHDATE > '31-DEC-68';
    RETURN C1;
END;
/

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_ALL_NAMES (S OUT SYS_REFCURSOR)

IS

BEGIN

OPEN S FOR

SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;

END;

/

DECLARE

S SYS_REFCURSOR;

FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; 

LASTNAME EMPLOYEE.LASTNAME%TYPE; 


BEGIN

 GET_ALL_NAMES(S);

 LOOP

   FETCH S INTO FIRSTNAME, LASTNAME;

   EXIT WHEN S%NOTFOUND; --BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE

   DBMS_OUTPUT.PUT_LINE('EMPLOYEES NAME IS '||FIRSTNAME||' '||LASTNAME);

 END LOOP;

 CLOSE S;

END;

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE UPDATE_EMPLOYEE(
	   E_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
	   E_FNAME IN EMPLOYEE.FIRSTNAME%TYPE)
IS
BEGIN

  UPDATE EMPLOYEE SET FIRSTNAME = E_FNAME 
  WHERE EMPLOYEEID = E_ID;

  COMMIT;

END;

--Task – Create a stored procedure that returns the managers of an employee.***************************************************
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_MANAGERS (
    EMPL_ID IN EMPLOYEE.EMPLOYEEID%TYPE,
    C1 OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN C1 FOR
        SELECT * FROM EMPLOYEE WHERE EMPLOYEEID IN (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPL_ID);
    DBMS_SQL.RETURN_RESULT(C1);
END GET_EMPLOYEE_MANAGERS;
/

DECLARE 
MY_CURSOR SYS_REFCURSOR;
BEGIN
GET_EMPLOYEE_MANAGERS(2, c1=>MY_CURSOR/*REF CURSOR*/);
END;
/



--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.********************************************
CREATE OR REPLACE PROCEDURE GET_CUST_NAME_COMPANY (
    N_CUSTOMERID IN NUMBER,C_CURSOR OUT SYS_REFCURSOR
) AS
    VC_FIRSTNAME VARCHAR2(20);
    VC_LASTNAME VARCHAR2(20);
    VC_COMPANY VARCHAR2(20);
BEGIN
    OPEN C_CURSOR FOR SELECT FIRSTNAME,LASTNAME,COMPANY
                      FROM CUSTOMER
                      WHERE CUSTOMERID = N_CUSTOMERID;
END;
/
DECLARE
    C SYS_REFCURSOR;
    FNAME VARCHAR2(40);
    LNAME VARCHAR2(40);
    COMPANY VARCHAR2(40);
BEGIN
    GET_CUST_NAME_COMPANY(5,C);
    LOOP
        FETCH C INTO FNAME,LNAME,COMPANY;
        EXIT WHEN C%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('CUSTOMER: '|| FNAME|| ' ' || LNAME || ' IS WITH ' || COMPANY);
    END LOOP;
    CLOSE C;
END;
/
COMMIT;

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE (I_ID IN INVOICE.INVOICEID%TYPE)
IS 
BEGIN
UPDATE INVOICELINE SET INVOICEID = NULL
WHERE INVOICEID = I_ID;
DELETE FROM INVOICE
WHERE I_ID = INVOICE.INVOICEID;
COMMIT;
END;
/
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE ADDCUSTOMER (
    C_ID IN CUSTOMER.CUSTOMERID%TYPE,
    FNAME IN CUSTOMER.FIRSTNAME%TYPE,
    LNAME IN CUSTOMER.LASTNAME%TYPE,
    C_COMPANY IN CUSTOMER.COMPANY%TYPE,
    C_ADDRESS IN CUSTOMER.ADDRESS%TYPE,
    C_CITY IN CUSTOMER.CITY%TYPE,
    C_STATE IN CUSTOMER.STATE%TYPE,
    C_COUNTRY IN CUSTOMER.COUNTRY%TYPE,
    C_ZIP IN CUSTOMER.POSTALCODE%TYPE,
    C_PHONE IN CUSTOMER.PHONE%TYPE,
    C_FAX IN CUSTOMER.FAX%TYPE,
    C_EMAIL IN CUSTOMER.EMAIL%TYPE,
    C_SUPPORTID IN CUSTOMER.SUPPORTREPID%TYPE
    )
    
IS 
BEGIN 
    INSERT INTO CUSTOMER
    VALUES (C_ID, FNAME, LNAME, C_COMPANY, C_ADDRESS, C_CITY, C_STATE, C_COUNTRY, C_ZIP, C_PHONE, C_FAX, C_EMAIL, C_SUPPORTID);
END;
/
--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW 
WHEN (NEW.EMPLOYEEID>0)
BEGIN
DBMS_OUTPUT.PUT_LINE('new employee has been added to table');
END;
/
commit;
SET SERVEROUTPUT ON;
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) 
VALUES (993, 'Bob', 'Smith');

--Task – Create an after update trigger on the album table that fires after a row is inserted in the table

CREATE OR REPLACE TRIGGER TR_INSERT_ALBUM
AFTER INSERT ON ALBUM
FOR EACH ROW
DECLARE 
MSG VARCHAR2 (35) := 'new album has been added to table';
BEGIN
DBMS_OUTPUT.PUT_LINE(MSG);
END;
/
commit;
SET SERVEROUTPUT ON;
INSERT INTO ALBUM  VALUES (2019,'EXAMPLE', 1);

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER TR_DELETE_ALBUM
AFTER DELETE ON CUSTOMER
FOR EACH ROW 
DECLARE
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER HAS BEEN REMOVED');
END;
/
commit;
SET SERVEROUTPUT ON;
DELETE FROM CUSTOMER WHERE CUSTOMERID =2;

--7.1 INNER
--Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID
FROM CUSTOMER INNER JOIN INVOICE ON
CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.2 OUTER
--Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE ON
CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--7.3 RIGHT
--Create a right join that joins album and artist specifying artist name and title
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST RIGHT OUTER JOIN ALBUM ON
ARTIST.ARTISTID = ALBUM.ARTISTID;

--7.4 CROSS
--Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST CROSS JOIN ALBUM;


--7.5 SELF
--Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.EMPLOYEEID, A.FIRSTNAME, A.LASTNAME,
B.EMPLOYEEID AS "SUPERVISOR ID", B.FIRSTNAME AS "SUPERVISOR NAME", B.LASTNAME
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;

