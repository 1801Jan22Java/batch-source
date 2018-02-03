--SECTION 2.0
--In this section you will be performing various queries against the Oracle Chinook database.
SELECT a.title, at.name,t.name FROM ALBUM a 
JOIN ARTIST at ON a.artistID = at.artistID
JOIN TRACK t ON t.AlbumID = a.albumID;

-- SECTION 2.1
--Task – Select all records from the Employee table.
SELECT * FROM Employee;
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE lastname = 'King';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE firstname = 'Andrew'
AND REPORTSTO IS NULL;

--SECTION 2.2
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM ORDER BY title DESC;
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT * FROM Customer ORDER BY city;
--SECTION 2.3
--Task – Insert two new records into Genre table 
SELECT * FROM genre;
INSERT INTO genre VALUES (26,'Pop-punk');
INSERT INTO genre VALUES (27,'Baroque');
SELECT * FROM genre;
--Task – Insert two new records into Employee table
SELECT * FROM Employee;
INSERT INTO Employee VALUES (9,'Julian','Bashir','On-Staff Doctor',1,'18-FEB-65','01-FEB-2018','1230 Forest road','Calgary','AB','Canada','T2P 2T3',null,null,'jbashir@chinookcorp,com');
INSERT INTO Employee VALUES (10,'Harry','Kim','IT STaff',1,'1-MAR-70','01-FEB-2018','10 Grant Ave','Calgary','AB','Canada','T2P 2T3',null,null,'hkim@chinookcorp,com');

--SECTION 2.4
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET Firstname = 'Robert', Lastname ='Walter' WHERE Firstname = 'Aaron' AND Lastname ='Mitchell';
COMMIT;
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';


--SECTION 2.5
--Task – Select all invoices with a billing address like “T%”
SELECT * FROM invoice WHERE BILLINGADDRESS LIKE 'T%';


--SECTION 2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM invoice WHERE total BETWEEN 15 and 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM employee WHERE HIREDATE BETWEEN '01-June-2003' AND '01-March-2004';
/
--SECTION 2.7
/*Task – Delete a record in Customer table where the name is 
Robert Walter (There may be constraints that rely on this, 
find out how to resolve them).*/

--SELECT * FROM CUSTOMER WHERE Firstname = 'Robert' AND Lastname= 'Walter';
--SELECT * FROM INVOICE WHERE CUSTOMERID = 32;
--SELECT * FROM INVOICELINE WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID = 32);

DELETE FROM INVOICELINE WHERE INVOICEID IN (SELECT  INVOICEID FROM INVOICE WHERE CUSTOMERID = 32);
DELETE FROM INVOICE WHERE CUSTOMERID = 32;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 32;
SELECT * FROM Customer WHERE CUSTOMERID = 32;
ROLLBACK;
/
---SECTION 3
/*
arious actions against the database
3.1 System Defined Functions
Task – Create a function that returns the current time.
Task – create a function that returns the length of name in MEDIATYPE table
3.2 System Defined Aggregate Functions
Task – Create a function that returns the average total of all invoices 
Task – Create a function that returns the most expensive track
3.3 User Defined Scalar Functions
Task – Create a function that returns the average price of invoiceline items in the invoiceline table
3.4 User Defined Table Valued Functions
Task – Create a function that returns all employees who are born after 1968.

*/
--SECTION 3.1 - Get Current time

create or replace FUNCTION FUNCTION_HW_3_1_A  
RETURN TIMESTAMP  IS RightNow TIMESTAMP;
BEGIN
SELECT LOCALTIMESTAMP into RightNow FROM Dual;

RETURN RightNow;
END FUNCTION_HW_3_1_A;

/
SELECT function_hw_3_1_a() from dual;
/
-- Get Length of name in media type
--Task – create a function that returns the length of name in MEDIATYPE table
DECLARE 
ML SYS_REFCURSOR;  -- CAN CREATE OTHER CURSORS.  DON'T NEED TO USE SYS_REFCURSOR BUT IT IS CONVENIENT.
NAME MEDIATYPE.NAME%TYPE;
MEDIALENGTH NUMBER;
BEGIN
    FUNCTION_HW_3_1_B(ML);  --GET ALBUM_ID AS WHATEVER DATATYPE 
    LOOP
        FETCH ML INTO NAME, MEDIALENGTH;
        EXIT WHEN ML%NOTFOUND; -- BREAK OUT OF LOOP WHEN NO MORE ROWS ARE AVAILABLE
        DBMS_OUTPUT.PUT_LINE(NAME || ' IS CURRENT NAME, '  || ' IS CURRENT LENGTH ');
    END LOOP;
    CLOSE ML;
END;
/
create or replace FUNCTION FUNCTION_HW_3_1_B
RETURN SYS_REFCURSOR 
AS result_set_cursor SYS_REFCURSOR;
BEGIN
  OPEN result_set_cursor FOR SELECT name, LENGTH(name) FROM MEDIATYPE;
 
  RETURN result_set_cursor;
END FUNCTION_HW_3_1_B;
/
SELECT FUNCTION_HW_3_1_B FROM dual;
/
--SELECT * FROM MEDIATYPE;
/

--SECTION 3.2
--SECTION 3.2 A Average Price of invoiceline times in invoiceline table
create or replace FUNCTION FUNCTION_HW_3_2_A 
RETURN NUMBER IS
 AVERAGE_PRICE number(4,2);
BEGIN
select sum(total)/count(*) INTO AVERAGE_PRICE from invoice;
RETURN AVERAGE_PRICE;
END FUNCTION_HW_3_2_A;
/
declare avg_price number(4,2);
BEGIN 
avg_price:= FUNCTION_HW_3_2_A();
dbms_output.Put_line('Average invoice total: ' ||  TO_CHAR(avg_price,'FML999G999D99'));
end;
/


--SECTION 3.2 B - Maximum price of a track
create or replace FUNCTION FUNCTION_HW_3_2_B
RETURN NUMBER IS
 MAX_PRICE number(4,2);
BEGIN
select MAX(unitprice) INTO MAX_PRICE FROM track;
RETURN MAX_PRICE;
END FUNCTION_HW_3_2_B;
/
SELECT MAX(UnitPrice) AS MOST_EXPENSIVE_TRACK FROM Track; --GROUP BY Name;
/
declare maxprice number(4,2);
BEGIN 
maxprice:= function_hw_3_2_B();
dbms_output.Put_line('Most expensive track price: ' ||  TO_CHAR(maxprice,'FML999G999D99'));
end;
/

--SECTION 3.3
create or replace FUNCTION FUNCTION_HW_3_3
RETURN NUMBER IS
 AVERAGE_PRICE number(4,2);
BEGIN
select sum(unitprice)/count(*) INTO AVERAGE_PRICE from invoiceline;
RETURN AVERAGE_PRICE;
END FUNCTION_HW_3_3;
/
declare avginvoicelineprice number(4,2);
BEGIN 
avginvoicelineprice:= function_hw_3_3();
dbms_output.Put_line('Average invoice line price: ' ||  TO_CHAR(avginvoicelineprice,'FML999G999D99'));
end;
/



--SECTION 3.4 All employees born after 1968
create or replace FUNCTION FUNCTION_HW_3_4
RETURN SYS_REFCURSOR 
AS result_set_cursor SYS_REFCURSOR;
BEGIN
  OPEN result_set_cursor FOR SELECT FirstName || ' '|| LastName, Address FROM Employee WHERE EXTRACT(year from BIRTHDATE) > 1968;
  RETURN result_set_cursor;
END FUNCTION_HW_3_4;
/
select function_hw_3_4() from dual;

--SECTION 4 - Stored Procedures
--SECTION 4.1
/*Task – Create a stored procedure that selects the first 
and last names of all the employees.
*/
create or replace PROCEDURE HW_4_1 
(p_HW_4_1 OUT SYS_REFCURSOR)
AS
BEGIN 
OPEN p_HW_4_1 FOR
SELECT firstname, lastname FROM Employee;
END HW_4_1;
/
variable mycursor refcursor;
exec HW_4_1(:mycursor);
print mycursor;
--SECTION 4.2 A
/*
Task – Create a stored procedure that updates the personal information 
of an employee.
*/
create or replace PROCEDURE HW_4_2_A 
(
 FNAME IN VARCHAR2 
, LNAME IN VARCHAR2 
, NEWADDRESS IN VARCHAR2 
, NEWCITY IN VARCHAR2 
, NEWSTATE IN VARCHAR2 
, NEWCOUNTRY IN VARCHAR2 
, NEWPOSTCODE IN VARCHAR2 
, NEWPHONE IN VARCHAR2 
, NEWFAX IN VARCHAR2 
, NEWEMAIL IN VARCHAR2 
, NEWBIRTHDATE IN DATE
) AS 
BEGIN
UPDATE EMPLOYEE SET LASTNAME=LNAME, ADDRESS = NEWADDRESS, CITY=NEWCITY, STATE=NEWSTATE,
COUNTRY=NEWCOUNTRY,POSTALCODE=NEWPOSTCODE, PHONE= NEWPHONE, FAX=NEWFAX,
EMAIL=NEWEMAIL,BIRTHDATE=NEWBIRTHDATE WHERE LASTNAME = LNAME AND FIRSTNAME = FNAME;
COMMIT;
END HW_4_2_A;
/
SELECT * FROM Employee WHERE FIRSTNAME = 'Jane' AND LASTNAME = 'Peacock';
EXEC HW_4_2_A('Jane','Peacock','222 6 AVE SW','Calgary','AB','Canada','T2P 2T3','+1 (403) 343-3210','+1 (403) 262-6712','jane@chinookcorp.com','29-AUG-73');
SELECT * FROM Employee WHERE FIRSTNAME = 'Jane' AND LASTNAME = 'Peacock';
/
--SECTION 4.2 B
/*
Task – Create a stored procedure that returns the managers of an employee.
*/
create or replace PROCEDURE HW_4_2_B 
(
p_HW_4_2_B OUT SYS_REFCURSOR
 , EMP_FIRST_NAME IN VARCHAR2 
, EMP_LAST_NAME IN VARCHAR2 
) AS 
BEGIN
OPEN p_HW_4_2_B FOR
SELECT FIRSTNAME,LASTNAME FROM EMPLOYEE WHERE EmployeeID = (
SELECT REPORTSTO FROM Employee WHERE LASTNAME = EMP_LAST_NAME AND FIRSTNAME = 
EMP_FIRST_NAME);
COMMIT;
END HW_4_2_B;
/
exec HW_4_2_B(:mycursor,'Jane','Peacock');
print mycursor;

--SECTION 4.3
/*
Task – Create a stored procedure that returns the name 
and company of a customer.
*/
create or replace PROCEDURE HW_4_3
(p_HW_4_3 OUT SYS_REFCURSOR
, CUSTID IN NUMBER) AS 
BEGIN
OPEN p_HW_4_3 FOR 
SELECT FIRSTNAME,LASTNAME, COMPANY FROM Customer WHERE CustomerID = CUSTID;
COMMIT;
END HW_4_3;
/
variable  newcursor refcursor;
exec HW_4_3(:newcursor,1);
--print newcursor;
--

--SECTION 5 - Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
create or replace PROCEDURE HW_5_A
(INVOICE_NUM IN NUMBER) AS 
BEGIN 
DELETE FROM INVOICE WHERE INVOICEID = INVOICE_NUM;
COMMIT;
END HW_5_A;

/

SELECT * FROM INVOICE;
EXEC HW_5_A(216);
SELECT * FROM INVOICELINE WHERE INVOICEID = 216;

--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
SELECT CUSTOMERID FROM CUSTOMER ORDER BY CUSTOMERID DESC;
/
--Creating a sequence here to increment customer ID
CREATE SEQUENCE cust_seq 
MINVALUE 59 
START WITH 59 
INCREMENT BY 1;
/

CREATE OR REPLACE PROCEDURE HW_5_B
(
CUST_ID IN NUMBER,
FIRSTNAME IN VARCHAR2,
LASTNAME IN VARCHAR2,
COMPANY IN VARCHAR2,
ADDRESS IN VARCHAR2,
CITY IN VARCHAR2,
STATE IN VARCHAR2,
COUNTRY IN VARCHAR2,
POSTALCODE IN VARCHAR2,
PHONE IN VARCHAR2,
FAX IN VARCHAR2,
EMAIL IN VARCHAR2,
SUPPORTREPID NUMBER) AS
BEGIN
INSERT INTO CUSTOMER VALUES (CUST_ID,FIRSTNAME,LASTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID);
COMMIT;
END HW_5_B;
/

EXEC HW_5_B(cust_seq.NEXTVAL,'Marit','Ingvarson','Statoil','102 Karlsbadgate','Bergen','Bergen','Norway','34340','304-223-2321','none','mingvarson@gmail.com',3);
COMMIT;
/
SELECT * FROM CUSTOMER WHERE firstname = 'Marit';
/
--SECTION 6 - Triggers

--Task - Create an after insert trigger on the employee table 
--fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER t_employee_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
      DBMS_OUTPUT.PUT_LINE('New Employee Inserted');
END;
/
--Task – Create an after update trigger on the album table 
--that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER t_album_instert
AFTER INSERT ON ALBuM
FOR EACH ROW
BEGIN
      DBMS_OUTPUT.PUT_LINE('New Album Inserted');
END;
/
--Task – Create an after delete trigger on the customer table 
--that fires after a row is deleted from the table.
SET SERVEROUTPUT ON;
CREATE OR REPLACE TRIGGER t_customer_deleted
AFTER DELETE ON customer
BEGIN
      DBMS_OUTPUT.PUT_LINE('Customer deleted');
END;
/

SET SERVEROUTPUT ON;
BEGIN
VARIABLE CustomerToBeDeleted integer:= 55;
SELECT * FROM CUSTOMER WHERE CustomerID=:CustomerToBeDeleted;
DELETE FROM INVOICELINE WHERE INVOICEID IN 
(SELECT  INVOICEID FROM INVOICE WHERE CUSTOMERID =:CustomerToBeDeleted);
DELETE FROM INVOICE WHERE CUSTOMERID =:CustomerToBeDeleted;
DELETE FROM CUSTOMER WHERE CUSTOMERID =:CustomerToBeDeleted;
END;
COMMIT;
/
--SECTION 7
--SECTION 7.1
SELECT c.firstname,c.lastname,i.invoiceid FROM customers c 
INNER JOIN invoice i
ON c.customerid = i.CUSTOMERID;

--SECTION 7.2
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid 
FROM customers c FULL OUTER JOIN invoice i 
ON i.customerid = c.customerid;

-- SECTION 7.3
SELECT al.TITLE, ar.name FROM album al RIGHT JOIN artist ar ON al.artistid=ar.artistid;

--SECTION 7.4
SELECT a.name,al.TITLE FROM artist a CROSS JOIN album al 
ORDER BY a.name;

--SECTION 7.5
SELECT * FROM employee e1 JOIN employee e2 
ON e1.reportsto = e2.REPORTSTO;


--SELECT MAX(unitprice) FROM TRACK;

