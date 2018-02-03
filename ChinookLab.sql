/******************************************************************************************************************************
2.0 SQL Queries
******************************************************************************************************************************/

--2.1 Select Task 1 – Select all records from the Employee table.

SELECT * FROM Employee;

--2.1 Select Task 2 – Select all records from the Employee table where last name is King.

SELECT * FROM Employee WHERE UPPER(LASTNAME) = UPPER('King');

--2.1 Select Task 3 – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL

SELECT * FROM Employee WHERE UPPER(FIRSTNAME) = UPPER('Andrew') AND REPORTSTO IS NULL;

--2.2 Order By Task 1 - Select all albums in Album table and sort result set in descending order by title.

SELECT * FROM Album ORDER BY Title DESC;

--2.3 Order By Task 2 - Select first name from Customer and sort result set in ascending order by city


SELECT FIRSTNAME FROM CUSTOMER ORDER BY City ASC;

--2.3 Insert Into Task 1 – Insert two new records into Genre table 

INSERT INTO Genre VALUES (26, 'K-POP');
INSERT INTO Genre VALUES (27, 'J-POP');

--2.3 Insert Into Task 2 – Insert two new records into Employee table 

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (
    9, 'Chan', 'Conan', 'Software Developer', 6, TO_DATE('1990-1-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
    TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '11730 Plaza America Dr', 'Reston', 'VA', 'United States of America', 
    '20190', '(703) 570-8181', '+1 (403) 467-8772', 'thisIsSoLong@gmail.com'
);

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email)
VALUES (
    10, 'Ketchum', 'Ash', 'Pokemon Master', 9, TO_DATE('1990-1-10 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
    TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '213 S Temple Drive', 'Milpitas', 'CA', 'United States of America', 
    '95035', '(123) 456-7890', '+1 (403) 467-8772', 'pokemonMaster@gmail.com'
);


--2.3 Insert Into Task 3 – Insert two new records into Customer table


INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId)
SELECT CustomerId+1,'Bruce', 'Lee', '1234 Dragon Road', 'San Francisco', 'California', '94061', '+91 080 22289999', 'brucelee@dragon.com', 5
FROM Customer
WHERE ROWNUM <= 1 ORDER BY CustomerId DESC;

INSERT INTO Customer (CustomerId, FirstName, LastName, Address, City, Country, PostalCode, Phone, Email, SupportRepId)
VALUES (61,'Jet', 'Li', '1234 Dragon Road', 'Beijing', 'China', '94061', '+91 080 22289999', 'jetli@wushu.com', 5);


--2.4 Update Task 1 - Update Aaron Mitchell in Customer table to Robert Walter


UPDATE Customer SET FIRSTNAME = 'Robert', LASTNAME = 'Walter' WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';


--2.4 Update Task 2 - Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”


UPDATE Artist SET NAME = 'CCR' WHERE NAME = 'Creedence Clearwater Revival';


--2.5 Like Task 1 - Select all invoices with a billing address like “T%”


SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';


--2.6 Between Task 1 - Select all invoices that have a total between 15 and 50


SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;


--2.6 Between Task 2 -  Select all employees hired between 1st of June 2003 and 1st of March 2004


SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('06/01/2003', 'DD/MM/YYYY') AND TO_DATE('03/01/2004', 'DD/MM/YYYY');


--2.7 Delete Task 1 - Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).

BEGIN
    FOR invoiceID_row IN (SELECT INVOICEID FROM INVOICE WHERE INVOICE.CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME='Walter'))
    LOOP
        DELETE FROM INVOICELINE WHERE INVOICEID = invoiceID_row.INVOICEID;
    END LOOP;
    DELETE FROM INVOICE WHERE INVOICE.CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Robert' AND CUSTOMER.LASTNAME='Walter');
    DELETE FROM Customer WHERE FIRSTNAME = 'Skyrim' AND CUSTOMER.LASTNAME='Player';
END;
/


/******************************************************************************************************************************
3.0 SQL Functions
******************************************************************************************************************************/
--3.1 System Defined Functions Task 1 - Create a function that returns the current time.
create or replace FUNCTION thisIsMyFunction
RETURN TIMESTAMP
IS HELLO TIMESTAMP;
BEGIN
    SELECT CURRENT_TIMESTAMP INTO HELLO FROM DUAL;
    RETURN HELLO;
END;
/

SELECT thisIsMyFunction FROM DUAL;

--3.2 System Defined Functions Task 2 - Create a function that returns the length of name in MEDIATYPE table.

create or replace FUNCTION getLengthFunction(nameSearch in varchar2) 
    RETURN number IS
    nameFound varchar2(120);

CURSOR C IS 
    SELECT MEDIATYPE.NAME 
    FROM MEDIATYPE
    WHERE MEDIATYPE.NAME = nameSearch
    AND ROWNUM = 1;

BEGIN
    OPEN C;
    FETCH C INTO nameFound;
    CLOSE C;
RETURN LENGTH(nameFound);
END;
/

SELECT getLengthFunction('MPEG audio file') FROM DUAL;

--3.2 System Defined Aggregate Functions Task 1 - Create a function that returns the average total of all invoices 
create or replace FUNCTION MYAVERAGEFUNCTION 
RETURN NUMBER
IS AVG_TOTAL NUMBER;

BEGIN
    SELECT AVG(TOTAL) INTO AVG_TOTAL FROM INVOICE;
    RETURN AVG_TOTAL;
END;
/

SELECT MYAVERAGEFUNCTION FROM DUAL;

--3.2 System Defined Aggregate Functions Task 2 - Create a function that returns the most expensive track

create or replace FUNCTION GRABMAXVALUE
    RETURN Number
    IS max_value NUMBER;
BEGIN
    SELECT MAX(UNITPRICE) INTO MAX_VALUE FROM TRACK;
    RETURN MAX_VALUE;
END;
/

SELECT GRABMAXVALUE FROM DUAL;

--3.3 User Defined Scalar Functions Task 1 - Create a function that returns the average price of invoiceline items in the invoiceline table

create or replace FUNCTION GetAverageOfInvoiceLine 
    RETURN NUMBER
    IS average_price NUMBER;
BEGIN
    SELECT AVG(UNITPRICE) INTO average_price FROM INVOICELINE;
    RETURN average_price;
END;
/

SELECT GetAverageOfInvoiceLine FROM DUAL;

--3.4 User Defined Table Defined Task 1 - Create a function that returns all employees who are born after 1968.

create or replace TYPE birthdayYears IS OBJECT(First_Name VARCHAR2(120), Last_Name VARCHAR2(120), Year_Born DATE);
/

CREATE OR REPLACE TYPE EMPLOYEE_TABLE IS TABLE OF birthdayYears;
/

create or replace FUNCTION EmployeesAfter1968
    RETURN EMPLOYEE_TABLE
    IS 
    NEW_EMPLOYEE_TABLE EMPLOYEE_TABLE := EMPLOYEE_TABLE();
    N INTEGER := 0;

BEGIN
    FOR R IN (SELECT FIRSTNAME, LASTNAME, BIRTHDATE FROM EMPLOYEE WHERE EXTRACT(YEAR FROM BIRTHDATE) > 1968)
    LOOP
        NEW_EMPLOYEE_TABLE.EXTEND;
        N := N + 1;
        NEW_EMPLOYEE_TABLE(N) := birthdayYears(R.FIRSTNAME, R.LASTNAME, R.BIRTHDATE);
    END LOOP;
RETURN NEW_EMPLOYEE_TABLE;
END;
/

SELECT * FROM TABLE(EmployeesAfter1968);

/******************************************************************************************************************************
4.0 Stored Procedures
******************************************************************************************************************************/
--4.1 Basic Stored Procedure Task 1 – Create a stored procedure that selects the first and last names of all the employees.

create or replace PROCEDURE getAllEmployees AS
BEGIN
   For employee_row in (SELECT * FROM EMPLOYEE) 
   Loop
      DBMS_Output.Put_Line((employee_row.FIRSTNAME) || '   ' || employee_row.LASTNAME || '    ' || employee_row.TITLE);
   End Loop;
COMMIT;
END;
/

EXECUTE GETALLEMPLOYEES;

--4.2 Stored Procedure Input Parameters Task 1 -  Create a stored procedure that updates the personal information of an employee.

create or replace PROCEDURE updateEmployee(emp_id NUMBER, new_title varchar2) AS
BEGIN
    UPDATE EMPLOYEE SET TITLE = new_title WHERE EMPLOYEE.EMPLOYEEID = emp_id;
COMMIT;
END;
/

EXECUTE updateEmployee(10, 'Pokemon Master');

--4.2 Stored Procedure Input Parameters Task 2 - Create a stored procedure that returns the managers of an employee.

create or replace PROCEDURE EmployeeManager(emp_id NUMBER) 
AS
manager_id NUMBER;
BEGIN
    SELECT REPORTSTO INTO manager_id FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = emp_id;
    FOR manager_name IN (SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE EMPLOYEE.EMPLOYEEID = manager_id)
    LOOP
        dbms_output.put_line('Manager:' || manager_name.FIRSTNAME || ' ' || manager_name.LASTNAME);
    END LOOP;
COMMIT;
END;
/

EXECUTE EMPLOYEEMANAGER(10);

--4.3 Stored Procedure Output Parameters Task 1 – Create a stored procedure that returns the name and company of a customer.

create or replace PROCEDURE CustomerNameAndCompany(cust_id NUMBER) AS
cust_firstname varchar2(120);
cust_lastname varchar2(120);
comp_name varchar2(120);
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO cust_firstname, cust_lastname, comp_name FROM CUSTOMER 
    WHERE CUSTOMER.CUSTOMERID = cust_id;
    dbms_output.Put_line('Customer Information: ' || cust_firstname || ' ' || cust_lastname);
    DBMS_OUTPUT.NEW_LINE;
    dbms_output.put_line('Company Name: ' || comp_name);
COMMIT;
END;
/
EXECUTE CUSTOMERNAMEANDCOMPANY(1);

/******************************************************************************************************************************
5.0 Transactions
******************************************************************************************************************************/
 
 --5.0 Transactions Task 1 - Create a transaction that given a invoiceId will delete that invoice 
 --(There may be constraints that rely on this, find out how to resolve them).
create or replace PROCEDURE DELETEINVOICE(invoice_id NUMBER) AS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = invoice_id;
    DELETE FROM INVOICE WHERE INVOICEID = invoice_id;
    dbms_output.put_line('Invoice ' || invoice_id || ' deleted');
COMMIT;
END;
/
EXECUTE DELETEINVOICE(409);

--5.0 Transactions Task 2 - Create a transaction nested within a stored procedure that inserts a new record in the Customer table
create or replace PROCEDURE insertIntoCustomer(
    cust_firstname varchar2, 
    cust_lastname varchar2, 
    cust_email varchar2,
    support_rep_id number
) 
AS
BEGIN
    INSERT INTO CUSTOMER(CustomerId, FirstName, LastName, Email, SupportRepId)
    SELECT CustomerId + 1, cust_firstname, cust_lastname, cust_email, support_rep_id
    FROM CUSTOMER
    WHERE ROWNUM <= 1 ORDER BY CUSTOMERID DESC;
    dbms_output.put_line(cust_firstname || ' ' ||cust_lastname || ' inserted to Customer Table.');
COMMIT;
END;
/

EXECUTE INSERTINTOCUSTOMER('Skyrim', 'Player', 'arrowtotheknee@gmail.com', 10);

/******************************************************************************************************************************
6.0 Triggers
******************************************************************************************************************************/
--6.1 After/For Task 1 - Create an after insert trigger on the employee table fired after a new record is inserted into the table.

create or replace TRIGGER AFTERINSERTEMPLOYEE AFTER INSERT
ON EMPLOYEE
DECLARE 
EMP_ID EMPLOYEE.EMPLOYEEID%TYPE;
BEGIN
    SELECT EMPLOYEEID INTO EMP_ID FROM EMPLOYEE WHERE ROWNUM <= 1 ORDER BY EMPLOYEEID DESC;
    UPDATE EMPLOYEE SET TITLE = 'FUS RO DAH' WHERE EMPLOYEEID = EMP_ID;
    dbms_output.put_line('FUS RO DAH, Employee ID is: ' || EMP_ID);
END;
/
SET SERVEROUTPUT ON
BEGIN
    INSERT INTO EMPLOYEE(EMPLOYEEID, FIRSTNAME, LASTNAME)
    SELECT EMPLOYEEID+1, 'THIS!', 'WORKS!'
    FROM EMPLOYEE
    WHERE ROWNUM <= 1 ORDER BY EMPLOYEEID DESC;
END;
/

--6.1 After/For Task 2 – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AFTERUPDATEALBUM AFTER UPDATE ON ALBUM
BEGIN
    DBMS_OUTPUT.PUT_LINE('I used to be an adventurer like you. Then I took an arrow in the knee.');
END;
/

SET SERVEROUTPUT ON
BEGIN
    UPDATE ALBUM SET TITLE = 'SKYRIM' WHERE ALBUMID = 1;
END;
/
--6.1 After/For Task 3 - Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AFTERDELETECUSTOMER AFTER DELETE ON CUSTOMER
BEGIN
    DBMS_OUTPUT.PUT_LINE('I went through a lot of trouble to delete this customer.');
END;
/

SET SERVEROUTPUT ON
BEGIN
    FOR invoiceID_row IN (
        SELECT INVOICEID FROM INVOICE WHERE INVOICE.CUSTOMERID = (
            SELECT CUSTOMERID FROM CUSTOMER 
            WHERE FIRSTNAME = 'Skyrim' AND CUSTOMER.LASTNAME='Player'
            )
        )
    LOOP
        DELETE FROM INVOICELINE WHERE INVOICEID = invoiceID_row.INVOICEID;
    END LOOP;
    DELETE FROM INVOICE WHERE INVOICE.CUSTOMERID = (SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME = 'Skyrim' AND CUSTOMER.LASTNAME='Player');
    DELETE FROM Customer WHERE FIRSTNAME = 'Skyrim' AND CUSTOMER.LASTNAME='Player';
END;
/
    
/******************************************************************************************************************************
7.0 Joins
******************************************************************************************************************************/
--7.1 Inner Join Task 1 - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT Customer.FIRSTNAME, Customer.LASTNAME, Invoice.INVOICEID FROM Customer INNER JOIN INVOICE ON Customer.CustomerID = Invoice.CustomerID;

--7.2 Outer Join Task 1 - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT Customer.CustomerID, Customer.FIRSTNAME, Customer.LASTNAME, Invoice.INVOICEID, Invoice.TOTAL FROM Customer LEFT OUTER JOIN Invoice ON Customer.CustomerID = Invoice.CustomerID;

--7.3 Right Join Task 1 - Create a right join that joins album and artist specifying artist name and title.
SELECT Artist.NAME, Album.TITLE FROM Album RIGHT OUTER JOIN Artist ON Artist.ARTISTID = Album.ARTISTID;

--7.4 Cross Join Task 1 - Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM Album CROSS JOIN Artist ORDER BY Artist.NAME ASC;

--7.5 Self Join Task 1 - Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.FIRSTNAME AS "First Name", A.LASTNAME AS "Last Name", A.REPORTSTO AS "Supervisor", B.FIRSTNAME AS "Supervisor First Name", B.LASTNAME AS "Supervisor Last Name"
FROM Employee A, Employee B WHERE A.REPORTSTO = B.EMPLOYEEID;

