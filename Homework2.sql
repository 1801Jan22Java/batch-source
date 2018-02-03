/*
2.1 TASK 1 - select all records from employee table
*/

SELECT * FROM EMPLOYEE;

/*
2.1 TASK 2 - select all records from employee table where last name is King
*/
-- to ignore case, i added UPPER(LASTNAME) LIKE UPPER('King') in case the
-- db was not consistant in naming convention
SELECT * FROM EMPLOYEE WHERE UPPER(LASTNAME) LIKE UPPER('King');

/*
2.1 TASK 3 - select all records from the Employee table where first name is Andrew and REPORTSTO is NULL
*/

-- to ignore case, i added UPPER(FIRSTNAME) LIKE UPPER('Andrew') in case the
-- db was not consistant in naming convention
SELECT * FROM EMPLOYEE WHERE UPPER(FIRSTNAME) LIKE UPPER('Andrew') AND REPORTSTO = NULL;

/*
2.2 TASK 1 - select all albums in Album table and sort result set in descending order by title
*/

SELECT * FROM ALBUM ORDER BY TITLE DESC;

/*
2.2 TASK 2 - select first name from Customer and sort result set in ascending order by city
*/

SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

/*
2.3 TASK 1 - insert two new records into Genre table  
*/

--instead of hard coding the genreid, i pulled the last found genre id and incremented
--it and used it to insert a new genre to the table
INSERT INTO GENRE (GENREID,NAME)
SELECT MAX(GENREID) + 1,'LOFI' FROM GENRE;

--instead of hard coding the genreid, i pulled the last found genre id and incremented
--it and used it to insert a new genre to the table
INSERT INTO GENRE (GENREID,NAME)
SELECT MAX(GENREID) + 1,'K-pop' FROM GENRE;

/*
2.3 TASK 2 - insert two new records into Employee table
*/

--instead of hard coding the employeeid, i pulled the last found employee id and incremented
--it and used it to insert a new genre to the table
INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
SELECT MAX(EMPLOYEEID) + 1,'Jackson','Peter','Junior IT Staff',NULL,TO_DATE('1990-1-10 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '213 S Temple Drive', 'Milpitas', 'CA', 'United States of America',
   '95035', '(123) 456-7890', '+1 (403) 467-8772', 'pokemonMaster@gmail.com'
FROM EMPLOYEE;

--instead of setting a hard coded reports to field in employee
--i updated the recent entry with a select that found the employee id of the IT Manager 
UPDATE EMPLOYEE
SET REPORTSTO = (SELECT EMPLOYEEID
                 FROM EMPLOYEE
                 WHERE TITLE = 'IT Manager')
WHERE TITLE = 'Junior IT Staff';

--instead of hard coding the employeeid, i pulled the last found employeeid and incremented
--it and used it to insert a new genre to the table
INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
SELECT MAX(EMPLOYEEID) + 1,'Chan','Conan','Master of Cheese',NULL,TO_DATE('1993-9-16 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '213 S Temple Drive', 'Milpitas', 'CA', 'United States of America',
   '95035', '(123) 456-7890', '+1 (403) 467-8772', 'conanIsReallyCool@gmail.com'
FROM EMPLOYEE;

--instead of setting a hard coded reports to field in employee
--i updated the recent entry with a select that found the employee id of the General Manager
UPDATE EMPLOYEE
SET REPORTSTO = (SELECT EMPLOYEEID
                 FROM EMPLOYEE
                 WHERE TITLE = 'General Manager')
WHERE TITLE = 'Master of Cheese';

/*
2.3 TASK 3 - insert two new records into Customer table
*/

--instead of hard coding the customerid, i pulled the last found customerid and incremented
--it and used it to insert a new genre to the table
INSERT INTO CUSTOMER (CUSTOMERID,LASTNAME,FIRSTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
SELECT MAX(CUSTOMERID) + 1, 'Chan','Jackie','Dragon Fist Co.','777 Lucky Dragon Ln.','San Francisco','CA','United States of America','90210','(987) 654-3210','+1 (123) 456-7890','KungFu@master.com',NULL
FROM CUSTOMER;

--instead of hard coding the supportrepid i updated the entry with a select to the IT Manager
UPDATE CUSTOMER
SET SUPPORTREPID = (SELECT EMPLOYEEID
                 FROM EMPLOYEE
                 WHERE TITLE = 'IT Manager')
WHERE FIRSTNAME = 'Jackie' AND LASTNAME = 'Chan';

--instead of hard coding the customerid, i pulled the last found customerid and incremented
--it and used it to insert a new genre to the table; the supportrepid is hard coded in this query
INSERT INTO CUSTOMER (CUSTOMERID,LASTNAME,FIRSTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
SELECT MAX(CUSTOMERID) + 1, 'Duck','Donald',NULL,'Ducky Duck Dr.','Houston','TX','United States of America','77352','(936) 654-3210','+1 (484) 456-7890','DuckyMcDuck@DuckFace.com',4
FROM CUSTOMER;

/*
2.4 TASK 1 - update Aaron Mitchell to Robert Walter in Customers
*/

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert',LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

/*
2.4 TASK 2 - update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/*
2.5 TASK 1 - find all invoices with a billing address like “T%”
*/

SELECT * 
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/*
2.6 TASK 1 - select all invoices that have a total between 15 and 50
*/

SELECT *
FROM INVOICE 
WHERE TOTAL BETWEEN 15 AND 50;

/*
2.6 TASK 2 - select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT * 
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-6-1','yyyy-mm-dd')AND TO_DATE('2004-3-1','yyyy-mm-dd');

/*
2.7 TASK 1 - delete a record in Customer table where the name is Robert Walter
*/

-- delete all references in invoiceline to the invoice that references the record that is for Robert Walker                    
DELETE FROM INVOICELINE WHERE INVOICEID IN(SELECT INVOICEID 
                                           FROM INVOICE
                                           WHERE CUSTOMERID IN (SELECT CUSTOMERID
                                                               FROM CUSTOMER
                                                               WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));

-- delete all references in invoice that references the record that is for Robert Walker
DELETE FROM INVOICE WHERE CUSTOMERID IN (SELECT CUSTOMERID
                                         FROM CUSTOMER
                                         WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');

-- delete the record for Robert Walker                                                               
DELETE FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

/*
3.1 TASK 1 - create a function that returns the current time
*/

--make a function that returns a varchar2
--create a return variable called return_var that will store the value to be returned
--get the time from the select statement and convert it to a varchar in the specified format
CREATE OR REPLACE FUNCTION MYTIMEFUNCTION
RETURN VARCHAR2
IS RETURN_VAR VARCHAR2(50);
BEGIN
    SELECT TO_CHAR (CURRENT_TIMESTAMP, 'HH24:MI:SS')INTO RETURN_VAR FROM DUAL;
    RETURN RETURN_VAR;
END;
/

--run the function to get the current time
SELECT MYTIMEFUNCTION FROM DUAL;

/*
3.1 TASK 2 - create a function that returns the length of a name in the MEDIATYPE table
*/

-- make the funtion mylengthfunction that takes a parameter select name
--and finds the length of the parameter and puts it in the name var to be returned
CREATE OR REPLACE FUNCTION MYLENGTHFUNCTION (SELECTNAME IN VARCHAR2) 
RETURN NUMBER
IS NAME_VAR VARCHAR2(120);
BEGIN
    SELECT NAME INTO NAME_VAR FROM MEDIATYPE WHERE NAME = SELECTNAME AND ROWNUM <=1;
    RETURN LENGTH(NAME_VAR);
END;
/

--run the function created
SELECT MYLENGTHFUNCTION('MPEG audio file') FROM DUAL;

/*
3.2 TASK 1 - create a function that returns the average total of all invoices 
*/

--create myavgfunction that takes no parameters and returns a number that is stored in 
--my_total. use the system defined avg function
CREATE OR REPLACE FUNCTION MYAVGFUNCTION
RETURN NUMBER
IS MY_TOTAL NUMBER;
BEGIN
    SELECT AVG(TOTAL) INTO MY_TOTAL FROM INVOICE;
    RETURN MY_TOTAL;
END;
/

--run the myavgfunction
SELECT MYAVGFUNCTION FROM DUAL;

/*
3.2 TASK 2 - create a function that returns the most expensive track
*/

--create myexpensive function that finds the max value of the unitprice in the track table
--and returns it in the my_expensive variable
CREATE OR REPLACE FUNCTION MYEXPENSIVEFUNCTION
RETURN NUMBER
IS MY_EXPENSIVE NUMBER; 
BEGIN
    SELECT MAX(UNITPRICE)INTO MY_EXPENSIVE FROM TRACK;
    RETURN MY_EXPENSIVE;
END;
/

--run the my expensivefucntion
SELECT MYEXPENSIVEFUNCTION FROM DUAL;

/*
3.3 TASK 1 - create a function that returns the average price of invoiceline items in the invoiceline table
*/

--the function myavginvoice takes no arguments and returns a number
--the my_expensive is a return variable that gets its value from the select statement that runs the avg function
CREATE OR REPLACE FUNCTION MYAVGINVOICE
RETURN NUMBER
IS MY_EXPENSIVE NUMBER; 
BEGIN
    SELECT AVG(UNITPRICE) INTO MY_EXPENSIVE FROM INVOICELINE;
    RETURN MY_EXPENSIVE;
END;
/

--run the myavginvoice function
SELECT MYAVGINVOICE FROM DUAL;

/*
3.4 TASK - ceate a function that returns all employees who are born after 1968
*/
--create a born_after function that takes a year and returns a sysrefcursor
--the function creates and opens a cursor on a select that aggregates the employeeid, firstname, and lastname
--for all employees who are older than the given year
CREATE OR REPLACE FUNCTION BORN_AFTER (BORN_YEAR IN NUMBER)
RETURN SYS_REFCURSOR
IS
MYCURSOR SYS_REFCURSOR;
BEGIN
    OPEN MYCURSOR FOR
    SELECT EMPLOYEEID,FIRSTNAME,LASTNAME
    FROM EMPLOYEE
    WHERE EXTRACT(YEAR FROM TO_DATE(BIRTHDATE)) > BORN_YEAR;
    RETURN MYCURSOR; 
END;
/

--get the cursor and find all the results
DECLARE
S SYS_REFCURSOR;
EMPLOYEE_ID EMPLOYEE.EMPLOYEEID%TYPE;
EMPLOYEEFNAME EMPLOYEE.FIRSTNAME%TYPE;
EMPLOYEELNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    S := BORN_AFTER(1960);
    LOOP
        FETCH S INTO EMPLOYEE_ID, EMPLOYEEFNAME, EMPLOYEELNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('ID: ' || EMPLOYEE_ID || ' EMPLOYEE NAME: ' || EMPLOYEEFNAME || ' ' || EMPLOYEELNAME);
    END LOOP;
    CLOSE S;
END;
/

/*
4.1 TASK 1 - create a stored procedure that selects the first and last names of all the employees
*/

--create a procedure that returns a sysrefcursor on a select of the first and last names of the employees
CREATE OR REPLACE PROCEDURE FIRST_LAST
(
    R_CURSOR OUT SYS_REFCURSOR
)
AS
BEGIN
    OPEN R_CURSOR FOR
    SELECT FIRSTNAME,LASTNAME
    FROM EMPLOYEE;
END;
/

--get the cursor from the procedure and print all the names to the console
DECLARE
S SYS_REFCURSOR;
EMPLOYEEFNAME EMPLOYEE.FIRSTNAME%TYPE;
EMPLOYEELNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    FIRST_LAST(S);
    LOOP
        FETCH S INTO EMPLOYEEFNAME, EMPLOYEELNAME;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('EMPLOYEE NAME: ' || EMPLOYEEFNAME || ' ' || EMPLOYEELNAME);
    END LOOP;
    CLOSE S;
END;
/

/*
4.2 TASK 1 - create a stored procedure that updates the personal information of an employee.
*/

--create a procedure that takes in an employee id and a title and updates the record in the table 
--corresponding to the employee id to the new title
CREATE OR REPLACE PROCEDURE UPDATE_INFO
(
    EMPID IN NUMBER,
    TITL IN VARCHAR2
)
AS
BEGIN
    UPDATE EMPLOYEE
    SET TITLE = TITL
    WHERE EMPLOYEEID = EMPID;
END;
/

SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 10;
--run the procedure to update empid = 10 title to master of not cheese
BEGIN
UPDATE_INFO(10,'Master of Not Cheese');
END;
/
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 10;


/*
4.2 TASK 2 - create a stored procedure that returns the managers of an employee
*/

--create a procedure that gets the managers by getting the reports to 
--field in the employee and uses that id to select the next level of management and his/her reportsto
--until you reach null and printing out at each iteration
CREATE OR REPLACE PROCEDURE GET_MANAGERS
( 
    EMPID IN NUMBER    
)
IS
F_NAME EMPLOYEE.FIRSTNAME%TYPE;
L_NAME EMPLOYEE.LASTNAME%TYPE;
CUR_REPORTSTO EMPLOYEE.REPORTSTO%TYPE;
BEGIN
    SELECT REPORTSTO INTO CUR_REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = EMPID;
    SELECT FIRSTNAME INTO F_NAME FROM EMPLOYEE WHERE EMPLOYEEID = EMPID;
    SELECT LASTNAME INTO L_NAME FROM EMPLOYEE WHERE EMPLOYEEID = EMPID;
    DBMS_OUTPUT.PUT_LINE(F_NAME || ' ' || L_NAME || ' REPORTS TO: ');
    LOOP
        
        
        SELECT FIRSTNAME INTO F_NAME FROM EMPLOYEE WHERE EMPLOYEEID = CUR_REPORTSTO;
        SELECT LASTNAME INTO L_NAME FROM EMPLOYEE WHERE EMPLOYEEID = CUR_REPORTSTO;
        SELECT REPORTSTO INTO CUR_REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = CUR_REPORTSTO;
        DBMS_OUTPUT.PUT_LINE(F_NAME || ' ' || L_NAME || ' REPORTS TO: ');
        EXIT WHEN CUR_REPORTSTO IS NULL;
    END LOOP;
    DBMS_OUTPUT.PUT_LINE('NO ONE!');
END;
/

-- run the procedure that was created
BEGIN
GET_MANAGERS(8);
END;
/

/*
4.3 TASK 1 - create a stored procedure that returns the name and company of a customer
*/

--using the customer id, the procedure uses a select statement for each field and returns it using the
--output parameters 
CREATE OR REPLACE PROCEDURE GET_NAME_COMPANY
(
    CID IN NUMBER,
    C_FIRSTNAME OUT CUSTOMER.FIRSTNAME%TYPE,  
    C_LASTNAME OUT CUSTOMER.LASTNAME%TYPE,
    C_COMPANY OUT CUSTOMER.COMPANY%TYPE
)
AS
BEGIN
    SELECT FIRSTNAME
    INTO C_FIRSTNAME
    FROM CUSTOMER
    WHERE CUSTOMERID = CID;
    
    SELECT LASTNAME
    INTO C_LASTNAME
    FROM CUSTOMER
    WHERE CUSTOMERID = CID;
    
    SELECT COMPANY
    INTO C_COMPANY
    FROM CUSTOMER
    WHERE CUSTOMERID = CID;
END;
/
-- declare variables that can be used as output from the procedure
-- if the company name is null print not available instead
DECLARE 
C_FIRSTNAME CUSTOMER.FIRSTNAME%TYPE;
C_LASTNAME CUSTOMER.LASTNAME%TYPE;
C_COMPANY CUSTOMER.COMPANY%TYPE;
BEGIN
GET_NAME_COMPANY(2,C_FIRSTNAME,C_LASTNAME,C_COMPANY);
IF C_COMPANY IS NULL THEN
    DBMS_OUTPUT.PUT_LINE(C_FIRSTNAME || ' ' || C_LASTNAME || ' WORKS FOR IS NOT AVAILABLE');
ELSE 
    DBMS_OUTPUT.PUT_LINE(C_FIRSTNAME || ' ' || C_LASTNAME || ' WORKS FOR ' || C_COMPANY);
END IF;
END;
/

/*
5.0 TASK 1 - ceate a transaction that given a invoiceId will delete that invoice
*/

--delete the invoicelines that reference the particular invoice id, then delete the invoice id, then commit
BEGIN

DELETE FROM INVOICELINE
WHERE INVOICEID = 1;

DELETE FROM INVOICE
WHERE INVOICEID = 1;

COMMIT;
END;
/

/*
5.0 TASK 2 - create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

--pass in all the necessary information to add a customer into the table and insert the new customer into the table
CREATE OR REPLACE PROCEDURE ADD_CUSTOMER_TRANSACTION
(
LN IN CUSTOMER.LASTNAME%TYPE,
FN IN CUSTOMER.FIRSTNAME%TYPE,
CPNY IN CUSTOMER.COMPANY%TYPE,
ADR IN CUSTOMER.ADDRESS%TYPE,
CTY IN CUSTOMER.CITY%TYPE,
ST IN CUSTOMER.STATE%TYPE,
CTRY IN CUSTOMER.COUNTRY%TYPE,
ZIP IN CUSTOMER.POSTALCODE%TYPE,
PN IN CUSTOMER.PHONE%TYPE,
FX IN CUSTOMER.FAX%TYPE,
EM IN CUSTOMER.EMAIL%TYPE,
SID IN CUSTOMER.SUPPORTREPID%TYPE
)
AS
BEGIN
    INSERT INTO CUSTOMER (CUSTOMERID,LASTNAME,FIRSTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
    SELECT MAX(CUSTOMERID) + 1, LN,FN,CPNY,ADR,CTY,ST,CTRY,ZIP,PN,FX,EM,SID
    FROM CUSTOMER;
    COMMIT;
END;
/

--run the procedure that adds the customer
BEGIN
ADD_CUSTOMER_TRANSACTION('Curry','Steph','Golden State Warriors','123 make money ln.','Fremont','CA','United States of America','19023','1231231231231','0979879879','steph@curry.com',10);
END;
/
/*
6.1 TASK 1 - create an after insert trigger on the employee table fired after a new record is inserted into the table.
*/

--creates a trigger that outputs a line whenever the next call to dbms is
CREATE OR REPLACE TRIGGER EMPLOYEE_ADDED_TRIGGER
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('KHAJIT HAS WARES IF YOU HAVE COIN');
END;
/

/*
6.1 TASK 2 - create an after update trigger on the album table that fires after a row is inserted in the table
*/

--creates a trigger that outputs a line whenever the next call to dbms is
CREATE OR REPLACE TRIGGER AFTER_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('LET ME GUESS DID SOMEONE STEAL YOUR SWEETROLL?');
END;
/
update album set title='balls to the werl' where albumid = 2;
update album set title='Balls to the Wall' where albumid = 2;
/*
6.1 TASK 3 - create an after delete trigger on the customer table that fires after a row is deleted from the table
*/

--creates a trigger that outputs a line whenever the next call to dbms is
CREATE OR REPLACE TRIGGER AFTER_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('*BLACK HANDPRINT* WE KNOW.');
END;
/
insert into customer values(12312313,'test','alsotest',null,null,null,null,null,null,null,null,'test',null);
delete customer where customerid = 12312313;
/*
7.1 TASK 1 - create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId
*/

--makes an inner join on customer and invoice on the customer id
SELECT FIRSTNAME, LASTNAME, INVOICEID
FROM CUSTOMER C INNER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

/*
7.2 TASK 1 - create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total
*/

--makes a full outer join on customer and invoice on the customerid
SELECT  C.CUSTOMERID, C.FIRSTNAME, C.LASTNAME, I.INVOICEID, I.TOTAL, I.CUSTOMERID
FROM CUSTOMER C FULL OUTER JOIN INVOICE I
ON C.CUSTOMERID = I.CUSTOMERID;

/*
7.3 TASK 1 - create a right join that joins album and artist specifying artist name and title
*/

--makes a right join between album and artist on the artist id
SELECT NAME, TITLE
FROM ALBUM A RIGHT JOIN ARTIST P
ON A.ARTISTID = P.ARTISTID;

/*
7.4 TASK 1 - create a cross join that joins album and artist and sorts by artist name in ascending order
*/

--makes a cross join on artist and album and in ascending order on the artist name
SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME ASC;

/*
7.5 TASK 1 - perform a self-join on the employee table, joining on the reportsto column
*/

--self joins the employee table on the reports to column
SELECT *
FROM EMPLOYEE A JOIN EMPLOYEE B
ON A.REPORTSTO = B.REPORTSTO;