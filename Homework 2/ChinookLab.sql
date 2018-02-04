alter session set current_schema = KIRIK0;
alter session set time_zone = '-7:0';
SET SERVEROUTPUT ON;

--2.1 SELECT
SELECT * FROM EMPLOYEE; --Select all records from the Employee table
SELECT * FROM EMPLOYEE WHERE LASTNAME='King';   --Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME='Andrew' AND REPORTSTO IS NULL; --Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

--2.2 ORDER BY
SELECT * FROM ALBUM ORDER BY TITLE DESC;--Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM CUSTOMER ORDER BY CITY ASC;--Select first name from Customer and sort result set in ascending order by city.

--2.3 INSERT INTO
INSERT INTO GENRE VALUES (26, 'J-Pop');--Insert two new records into Genre table.
INSERT INTO GENRE VALUES (27, 'K-Pop');

INSERT INTO EMPLOYEE VALUES (9, 'Connor', 'John', 'Counselor', 1, '18-MAY-92', '31-JAN-18', '777 Lord Lane',  --Insert two new records into Employee table
    'Honolulu', 'HI', 'USA', '96822', '+1 (808) 111-1111', '+1 (808) 111-1110', 'john@chinookcorp.com');       
INSERT INTO EMPLOYEE VALUES (10, 'Brewster', 'Katherine', 'Counselor', 1, '01-JAN-92', '30-JAN-18', '888 Lady Lane',
    'Mililani', 'HI', 'USA', '96789', '+1 (808) 222-2222', '+1 (808) 222-2220', 'katherine@chinookcorp.com');
    
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'Bugs', 'Bunny', 'bugs@looney.com');    --Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61, 'Daffy', 'Duck', 'daffy@looney.com');

--2.4 UPDATE
UPDATE CUSTOMER SET FIRSTNAME='Robert',LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';    --Update Aaron Mitchell in Customer table to Robert Walter
UPDATE ARTIST SET NAME='CCR' WHERE NAME='Creedence Clearwater Revival'; --Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”

--2.5 LIKE
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';   --Select all invoices with a billing address like “T%”

--2.6 BETWEEN
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;    --Select all invoices that have a total between 15 and 50
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; --Select all employees hired between 1st of June 2003 and 1st of March 2004

--2.7 DELETE
--CUSTOMERID IS 32

CREATE TABLE INVOICES_TO_DELETE (
    INVOICEID NUMBER,
    CONSTRAINT PK_Invoice_To_Delete PRIMARY KEY (INVOICEID)
);

DECLARE
    MAXVALUE NUMBER;
    MINVALUE NUMBER;
BEGIN
    INSERT INTO INVOICES_TO_DELETE SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID=32;   --Insert invoice IDs into the new table to track which invoices belong to the customer
    SELECT MIN(INVOICEID) INTO MINVALUE FROM INVOICES_TO_DELETE;    --Set the min and max values of the invoice IDs, so narrow down the list of IDs to iterate through.
    SELECT MAX(INVOICEID) INTO MAXVALUE FROM INVOICES_TO_DELETE;
    FOR i IN MINVALUE..MAXVALUE LOOP        --Delete all invoices from INVOICELINE with INVOICEIDs in the new table
        DELETE FROM INVOICELINE WHERE INVOICEID=i AND INVOICEID IN (SELECT INVOICEID FROM INVOICES_TO_DELETE);  
    END LOOP;
    DELETE FROM INVOICE WHERE CUSTOMERID=32;    --Delete the invoices belonging to the customer
    DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';    --Delete the customer 
END;    

--3 - SQL FUNCTIONS (Once function is defined, can be removed from .sql file.)

--3.1 System Defined Functions - Create a function that returns the current time.

ALTER SESSION SET TIME_ZONE = '-7:0';
SELECT CURRENT_TIMESTAMP FROM DUAL;     --Get the CURRENT_TIMESTAMP
GRANT EXECUTE ON GETDT TO KIRIK0;


CREATE OR REPLACE FUNCTION GETDT
    RETURN TIMESTAMP        --Will return a TIMESTAMP type variable
IS DT TIMESTAMP;            --DT is the variable holding a TIMESTAMP 
BEGIN
    SELECT CURRENT_TIMESTAMP    --Put CURRENT_TIMESTAMP into DT
    INTO DT
    FROM DUAL;
    RETURN(DT);
END;
/

SELECT GETDT FROM DUAL;     --Call the function 

--3.1 Create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION GetLengthMediaType(MEDIAID IN NUMBER)     --Take in an ID corresponding to the MEDIATYPEIDs from the MEDIATYPE table
    RETURN NUMBER
    IS MEDIALENGTH NUMBER;
BEGIN
    SELECT LENGTH(NAME)        --Get the length of the NAME from MEDIATYPE
    INTO MEDIALENGTH
    FROM MEDIATYPE
    WHERE MEDIAID=MEDIATYPEID;
    RETURN MEDIALENGTH;
END;
/

SELECT GetLengthMediaType(1) FROM DUAL;     --Call the function using the ID of an MP3


--3.2 Create a function that returns the average total of all invoices

CREATE OR REPLACE FUNCTION RETURNAVG
    RETURN NUMBER
    IS AVGTOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL)   --Take the average of all the totals and put the value into AVGTOTAL
    INTO AVGTOTAL
    FROM INVOICE;
    RETURN AVGTOTAL;
END;
/

SELECT RETURNAVG FROM DUAL;


--3.2 Create a function that returns the most expensive track

CREATE OR REPLACE FUNCTION RETURNMOSTEXPENSIVE
    RETURN NUMBER
    IS MOSTEXPENSIVE NUMBER;    --Holds the price of the most expensive track
BEGIN
    SELECT MAX(UNITPRICE)       --Places the max into MOSTEXPENSIVE
    INTO MOSTEXPENSIVE
    FROM TRACK;
    RETURN MOSTEXPENSIVE;
END;
/

CREATE OR REPLACE VIEW EXPENSIVE_VIEW
    AS SELECT TRACK.NAME,TRACK.UNITPRICE    --Creates a view that displays all of the track names that tie for most expensive.
    FROM TRACK
    WHERE TRACK.UNITPRICE = (SELECT RETURNMOSTEXPENSIVE FROM DUAL);
SELECT * FROM EXPENSIVE_VIEW;               --Select all entries from the view

--3.3 Create a function that returns the average price of invoiceline items in the invoiceline table

/*DROP TABLE INVOICELINE_ITEMS;
DROP TYPE INVOICELINE_TABLE;
DROP TYPE INVOICELINE_TYPE;*/

CREATE TABLE INVOICELINE_ITEMS (        --Creates a table that holds the average prices of all INVOICELINE items grouped by INVOICEID
    INVOICEID NUMBER,
    AVGPRICE NUMBER,
    CONSTRAINT PK_INVOICELINE_ITEMS PRIMARY KEY (INVOICEID)
);


CREATE TYPE INVOICELINE_TYPE IS OBJECT (    --Creates an object type that holds the columns of the INVOICELINE_ITEMS table
    INVOICEID NUMBER,
    AVGPRICE NUMBER
);
/

CREATE TYPE INVOICELINE_TABLE IS TABLE OF INVOICELINE_TYPE;     --Creates a table of the object INVOICELINE_TYPE
/

CREATE OR REPLACE FUNCTION AVG_INVOICELINE_ITEMS
    RETURN INVOICELINE_TABLE PIPELINED              --Returns a table of type INVOICELINE_TABLE through a pipeline in the function
    IS
        CURRAVG NUMBER;           --Holds the average price of the current iteration
        MAXINDEX NUMBER;
        MININDEX NUMBER;
BEGIN
    SELECT MAX(INVOICEID) INTO MAXINDEX FROM INVOICELINE;   --Find the boundaries for the for-loop
    SELECT MIN(INVOICEID) INTO MININDEX FROM INVOICELINE;
    
    FOR i IN MININDEX..MAXINDEX LOOP
        SELECT AVG(UNITPRICE) INTO CURRAVG FROM INVOICELINE WHERE INVOICEID=i;      --Find the average of the prices in INVOICELINE where the INVOICEID of the track = i
        PIPE ROW(INVOICELINE_TYPE(i,CURRAVG));         --Pipe the row into the returned table, storing the current index as INVOICEID and average as AVGPRICE
    END LOOP;
    RETURN;
END;
/

SELECT * FROM TABLE(AVG_INVOICELINE_ITEMS);     --Select everything from the returned piped table.

--3.4 Create a function that returns all employees who are born after 1968.

CREATE TYPE EMPLOYEE_TYPE IS OBJECT (   --Create an object that holds the fields of EMPLOYEE
    EmployeeId NUMBER,
    LastName VARCHAR2(20),
    FirstName VARCHAR2(20),
    Title VARCHAR2(30),
    ReportsTo NUMBER,
    BirthDate DATE,
    HireDate DATE,
    Address VARCHAR2(70),
    City VARCHAR2(40),
    State VARCHAR2(40),
    Country VARCHAR2(40),
    PostalCode VARCHAR2(10),
    Phone VARCHAR2(24),
    Fax VARCHAR2(24),
    Email VARCHAR2(60)
);
/

CREATE TYPE YOUNG_EMPLOYEES IS TABLE OF EMPLOYEE_TYPE;  --Create a table that holds EMPLOYEE_TYPE objects
/

--PIPE ROW CAN ONLY APPEAR IN A PIPELINED TABLE FUNCTION. ALLOWS RETURN OF TABLE ROW.
CREATE OR REPLACE FUNCTION GET_YOUNG_EMPLOYEES(MINYEAR IN NUMBER)
    RETURN YOUNG_EMPLOYEES PIPELINED IS         --Return the table of type YOUNG_EMPLOYEES through a pipeline
BEGIN
    FOR e IN (SELECT * FROM EMPLOYEE WHERE EXTRACT(YEAR FROM BIRTHDATE) >= MINYEAR) LOOP
        PIPE ROW(EMPLOYEE_TYPE(e.EmployeeId,e.LastName,e.FirstName,e.Title,e.ReportsTo,e.BirthDate,
                e.HireDate,e.Address,e.City,e.State,e.Country,e.PostalCode,e.Phone,e.Fax,e.Email));     --Enter all employees into the YOUNG_EMPLOYEES type table who born after the given year.
    END LOOP;
    RETURN;
END;
/

SELECT * FROM TABLE(GET_YOUNG_EMPLOYEES(1968));     --Call the function with the minimum year as a parameter.


--4 STORED PROCEDURES

--4.1 Create a stored procedure that selects the first and last names of all the employees.
CREATE TABLE EMP_NAMES_TABLE (  --Create a table that holds only EMPLOYEE names and IDs
    EMP_NAMES_ID NUMBER,
    FNAME VARCHAR2(20),
    LNAME VARCHAR2(20)
);

CREATE SEQUENCE EMP_NAMES_INDICES
    MINVALUE 0
    START WITH 0
    INCREMENT BY 1;         --Create a sequence that generates primary key values for EMP_NAMES_TABLE
    
CREATE OR REPLACE TRIGGER EMP_NAMES_ID_INCREMENTER
BEFORE INSERT ON EMP_NAMES_TABLE
FOR EACH ROW
BEGIN
    UPDATE EMP_NAMES_TABLE SET EMP_NAMES_ID = EMP_NAMES_INDICES.NEXTVAL;    --Create a trigger to call the sequence and generate PKs
END;
/
    

CREATE OR REPLACE PROCEDURE SELECT_NAMES AS
    FNAME VARCHAR2(20);
    LNAME VARCHAR2(20);
BEGIN
    FOR e IN (SELECT * FROM EMPLOYEE) LOOP
        INSERT INTO EMP_NAMES_TABLE (FNAME,LNAME) VALUES (e.FIRSTNAME,e.LASTNAME);      --Select all EMPLOYEEs and insert their names into the new table.
    END LOOP;
    COMMIT;
END;
/

BEGIN SELECT_NAMES; END;        --Call the stored procedure.


--4.2 Create a stored procedure that updates the personal information of an employee.

CREATE OR REPLACE PROCEDURE MODIFY_EMPLOYEE_EMAIL (NEW_EMAIL IN VARCHAR2, THE_EMPLOYEE_ID IN NUMBER) AS
BEGIN
    UPDATE EMPLOYEE SET Email = NEW_EMAIL WHERE EMPLOYEEID=THE_EMPLOYEE_ID; --Update the email of the EMPLOYEE whose ID matches the value passed in as a parameter
    COMMIT;
END;
/

INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME, EMAIL) VALUES (9, 'Mister', 'Garfield', 'NotGarfield@friends.com');
BEGIN MODIFY_EMPLOYEE_EMAIL('GARFIELD@FRIENDS.COM',9); END;     --Call the procedure, passing in the sample row created above.
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID=9;                      --Select the resulting row.

--4.2 Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_MANAGER (S OUT SYS_REFCURSOR, EMPID IN NUMBER) IS
BEGIN
    OPEN S FOR
    SELECT FIRSTNAME,LASTNAME,EMPLOYEEID    --Select only the first name, last name and ID of the employees who are managers of
    FROM EMPLOYEE                           --the employee with ID=EMPID
    WHERE EMPLOYEEID=(
        SELECT REPORTSTO
        FROM EMPLOYEE
        WHERE EMPID = EMPLOYEEID
    );
END;
/

DECLARE
S SYS_REFCURSOR;                --SYSTEM REFERENCE CURSOR. ALREADY THERE FOR USE, BUT WE CAN CREATE OUR OWN CURSOR.
MANAGERFIRST EMPLOYEE.FIRSTNAME%TYPE;       
MANAGERLAST EMPLOYEE.LASTNAME%TYPE;
CURR_EMPLOYEE_ID EMPLOYEE.EMPLOYEEID%TYPE;
EMPLOYEEFIRST EMPLOYEE.FIRSTNAME%TYPE;
EMPLOYEELAST EMPLOYEE.LASTNAME%TYPE;

BEGIN
    CURR_EMPLOYEE_ID := 8;
    SELECT FIRSTNAME INTO EMPLOYEEFIRST FROM EMPLOYEE WHERE CURR_EMPLOYEE_ID=EMPLOYEEID;        --Place the employee's information into the declared variables
    SELECT LASTNAME INTO EMPLOYEELAST FROM EMPLOYEE WHERE CURR_EMPLOYEE_ID=EMPLOYEEID;
    SELECT EMPLOYEEID INTO CURR_EMPLOYEE_ID FROM EMPLOYEE WHERE CURR_EMPLOYEE_ID=EMPLOYEEID;
     
    DBMS_OUTPUT.PUT_LINE(EMPLOYEEFIRST||' '||EMPLOYEELAST||' IS AN EMPLOYEE');          --Print the employee's first and last name
    LOOP
        GET_MANAGER(S, CURR_EMPLOYEE_ID);          --GRAB INFORMATION WITH STORED PROCEDURE AND
        FETCH S INTO MANAGERFIRST,MANAGERLAST,CURR_EMPLOYEE_ID;   --PLACE THIS MANAGER'S NAME AND ID INTO THE CURSOR S
        EXIT WHEN S%NOTFOUND;               --BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE('WITH A MANAGER NAMED '||MANAGERFIRST||' '||MANAGERLAST);  --OUTPUT THIS MANAGER'S NAME
        CLOSE S;
    END LOOP;
    CLOSE S;
END;

--4.3 Create a stored procedure that returns the name and company of a customer.

CREATE OR REPLACE PROCEDURE GET_CUST_INFO (CUSTID IN NUMBER,
    S OUT SYS_REFCURSOR, CUSTFIRST OUT VARCHAR2, CUSTLAST OUT VARCHAR2, CUSTCOMPANY OUT VARCHAR2) IS
BEGIN
    OPEN S FOR      --Open the cursor
    SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,CUSTOMER.COMPANY
    FROM CUSTOMER
    WHERE CUSTID=CUSTOMERID;
END;
/

DECLARE
    S SYS_REFCURSOR;
    CUSTOMERFIRST CUSTOMER.FIRSTNAME%TYPE;
    CUSTOMERLAST CUSTOMER.LASTNAME%TYPE;
    CUSTOMERCOMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
    GET_CUST_INFO(1,S,CUSTOMERFIRST,CUSTOMERLAST,CUSTOMERCOMPANY);      --Call the procedure and place the appropriate values into their respective variables
    FETCH S INTO CUSTOMERFIRST,CUSTOMERLAST,CUSTOMERCOMPANY;
    DBMS_OUTPUT.PUT_LINE('CUSTOMER: '||CUSTOMERFIRST||' '||CUSTOMERLAST);   --Output the customer's name and company
    DBMS_OUTPUT.PUT_LINE('COMPANY: '||CUSTOMERCOMPANY);
    CLOSE S;
END;


--5 - TRANSACTIONS

--5.1 Create a transaction that given an invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).


COMMIT;

DECLARE
    INVOICE_TO_DELETE NUMBER := 123;        --ID of the invoice to delete
BEGIN
    FOR i IN (SELECT * FROM INVOICELINE WHERE INVOICE_TO_DELETE=INVOICEID) LOOP        --Iterate through INVOICELINE and delete all tied to the specified INVOICE
        DELETE FROM INVOICELINE WHERE INVOICEID=INVOICE_TO_DELETE;
    END LOOP;
    DELETE FROM INVOICE WHERE INVOICEID=INVOICE_TO_DELETE;      --Delete the invoice once all dependencies are cleared
    COMMIT;
END;
/


--5.2 Create a transaction nested within a stored procedure that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE INSERT_CUST_RECORD(CUSTID IN NUMBER, CUSTFIRST IN VARCHAR2, CUSTLAST IN VARCHAR2, CUSTEMAIL IN VARCHAR2)
IS
BEGIN
    COMMIT; --Commit before starting the transaction
    BEGIN
        INSERT INTO CUSTOMER (CUSTOMERID,FIRSTNAME,LASTNAME,EMAIL) VALUES (CUSTID, CUSTFIRST, CUSTLAST, CUSTEMAIL);     --
        COMMIT; --Commit at the end of the transaction
    END;
END;    
/

BEGIN INSERT_CUST_RECORD(61, 'Porky', 'Pig', 'PORKYPIG@LOONEY.COM'); END;


--6 - TRIGGERS

--6.1 - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

CREATE OR REPLACE TRIGGER AFTER_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An EMPLOYEE has been inserted!');
END;
/

SET SERVEROUTPUT ON;
BEGIN
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (22, 'Mister', 'Daffy');
END;
/

--6.1 Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('An ALBUM has been updated!');
END;
/

COMMIT;
BEGIN
    INSERT INTO ALBUM VALUES (348,'Goodbye Lullaby',166);                               --Insert a new album into the ALBUM table
    UPDATE ALBUM SET TITLE='The Best Damn Thing' WHERE ARTISTID=166 AND ALBUMID=348;    --Update the album you just inserted with another title.
END;
/

--6.1 Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
    DBMS_OUTPUT.PUT_LINE('A CUSTOMER has been deleted!');
END;
/

COMMIT;
BEGIN
    DELETE FROM CUSTOMER WHERE CUSTOMERID=61;
END;
/


--7 - JOINS

--7.1 INNER - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID   --Select the customer's first/last name and the invoice ID
FROM CUSTOMER INNER JOIN INVOICE                                --Inner join customer and invoice tables
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID ORDER BY FIRSTNAME ASC;   --Select only if customer's ID matches the customer ID on the invoice

--7.2 OUTER - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID,CUSTOMER.FIRSTNAME,CUSTOMER.LASTNAME,INVOICE.INVOICEID,INVOICE.TOTAL
FROM CUSTOMER FULL OUTER JOIN INVOICE
ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID ORDER BY FIRSTNAME ASC;

--7.3 RIGHT - Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME,ALBUM.TITLE
FROM ALBUM RIGHT JOIN ARTIST
ON ALBUM.ARTISTID=ARTIST.ARTISTID ORDER BY NAME ASC;

--7.4 CROSS - Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ARTIST CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC; 

--7.5 SELF - Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.EMPLOYEEID AS AID, B.EMPLOYEEID AS BID, A.REPORTSTO
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.EMPLOYEEID <> B.EMPLOYEEID
AND A.REPORTSTO=B.REPORTSTO
ORDER BY A.REPORTSTO;

