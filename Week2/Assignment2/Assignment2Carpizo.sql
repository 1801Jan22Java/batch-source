-- Eric Carpizo - Assignment 2

-- 2.1a - Select all records from the Employee table.
SELECT * FROM Employee;

-- 2.1b - Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LastName='King';

-- 2.1c - Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FirstName='Andrew' AND ReportsTo IS NULL;

-- 2.2a - Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY Title DESC;

-- 2.2b - Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer ORDER BY City ASC;

-- MAKE SURE TO REPLACE ARG AND VALUE NAMES
-- 2.3a - Insert two new records into Genre table.
-- created a sequence for auto incrementing practice
-- tableName_sequence# is a good naming scheme because
-- different tables can have a auto incrementer sequence
-- and there can be more than one sequence for a table
CREATE SEQUENCE Genre_s1 START WITH 26;
INSERT INTO Genre (GenreId, Name) VALUES (Genre_s1.nextVal, 'Dubstep');
INSERT INTO Genre (GenreId, Name) VALUES (Genre_s1.nextVal, 'JPop');

-- 2.3b - Insert two new records into Employee table
CREATE SEQUENCE Employee_s1 START WITH 9;
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (Employee_s1.nextVal, 'Gonzalez', 'Clarissa');
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (Employee_s1.nextVal, 'Carpizo', 'Eric');


-- 2.3c - Insert two new records into Customer table
-- Remove entries from last test;
DELETE FROM Customer WHERE CustomerId>59;
INSERT INTO Customer (CustomerId, FirstName, LastName, Email) VALUES (60, 'Jimmy', 'John', 'jimmyj@gmail.com');
INSERT INTO Customer (CustomerId, FirstName, LastName, Email) VALUES (61, 'Jan', 'Jones', 'janjones@gmail.com');

-- 2.4a - Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName='Robert', LastName='Walter' WHERE FirstName='Aaron' AND LastName='Mitchell';

-- 2.4b - Update name of artist in the Artist table -Creedence Clearwater Revival- to -CCR-
UPDATE Artist SET Name='CCR' WHERE Name='Creedence Clearwater Revival';

-- 2.5 - Select all invoices with a billing address like "T%"
SELECT * FROM Invoice WHERE BillingAddress LIKE 'T%';

-- 2.6a - Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;

-- 2.6b - Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HireDate>=TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND HireDate<=TO_DATE('2004-3-1 00:00:00','yyyy-mm-dd hh24:mi:ss');

-- 2.7 - Delete a record in Customer table where the name is Robert Walter 
-- (There may be constraints that rely on this, find out how to resolve them).
DECLARE
eId NUMBER;
BEGIN
SELECT SupportRepId INTO eId FROM Employee WHERE FirstName='Robert' AND LastName='Walter';
DELETE FROM Employee WHERE EmployeeId=eId;
DELETE FROM Customers WHERE FirstName='Robert' AND LastName='Walter';
END;
/

-- 3.1a - Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_curr_time
RETURN VARCHAR2
IS
    curr_time VARCHAR2(20);
BEGIN
-- cannot use ':=' with to_char, only with static variables like SYSDATE
-- the system has to give the data we are requesting to DUAL, 
-- and we are getting it from DUAL and storing it into time.
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH12:MI:SS') INTO curr_time FROM DUAL;
    RETURN curr_time;
END;
/

SELECT get_curr_time FROM DUAL;

-- 3.1b - create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION name_length(pv_mediaTypeId NUMBER) RETURN NUMBER
IS
    name_length NUMBER;
BEGIN
    SELECT LENGTH(Name) INTO name_length FROM MediaType WHERE MediaTypeId=pv_mediaTypeId;
    RETURN name_length;
END;
/

SELECT name_length(4) FROM DUAL;

-- 3.2a - Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION average_total_invoices RETURN NUMBER
IS
    average NUMBER;
BEGIN
    SELECT AVG(Total) INTO average FROM Invoice;
    RETURN average;
END;
/

SELECT average_total_invoices FROM DUAL;

-- 3.2b - Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION most_expensive_track RETURN VARCHAR2
IS
    most_expensive VARCHAR(20);
BEGIN
    SELECT MAX(UnitPrice) INTO most_expensive FROM Track;
    RETURN most_expensive;
END;
/

SELECT most_expensive_track FROM DUAL;

-- 3.3 - Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION average_invoiceline_price RETURN NUMBER
IS
    average NUMBER;
BEGIN
    SELECT AVG(UnitPrice) INTO average FROM InvoiceLine;
    RETURN average;
END;
/

SELECT average_invoiceline_price FROM DUAL;

-- 3.4 - Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION employees_after_1968 RETURN SYS_REFCURSOR
AS
    result SYS_REFCURSOR;
BEGIN
    OPEN result FOR
        SELECT * 
        From Employee 
        WHERE BirthDate >= TO_DATE('1969-1-1 00:00:00','yyyy-mm-dd hh24:mi:ss');
    RETURN result;
END;
/
SELECT employees_after_1968 FROM DUAL;

-- 4.1 - Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE employee_names(cursor1 OUT SYS_REFCURSOR)
IS
BEGIN
    OPEN cursor1 FOR SELECT FirstName, LastName FROM Employee;
END;
/

-- Testing the procedure    

DECLARE
curs1 SYS_REFCURSOR;
BEGIN
employee_names(curs1);
END;
/

-- 4.2a - Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_employee(id IN NUMBER, e_LastName IN VARCHAR2, e_FirstName IN VARCHAR2, e_Title IN VARCHAR2, 
e_ReportsTo IN NUMBER, e_BirthDate IN DATE, e_HireDate IN DATE, e_Address IN VARCHAR2, e_City IN VARCHAR2, e_State IN VARCHAR2, 
e_Country IN VARCHAR2, e_PostalCode IN VARCHAR2, e_Phone IN VARCHAR2, e_Fax IN VARCHAR2, e_Email IN VARCHAR2)
AS
BEGIN
    IF e_LastName IS NOT NULL THEN
        UPDATE Employee SET LastName=e_LastName WHERE EmployeeId=id;
    END IF;
    IF e_FirstName IS NOT NULL THEN
        UPDATE Employee SET FirstName=e_FirstName WHERE EmployeeId=id;
    END IF;
    IF e_Title IS NOT NULL THEN
        UPDATE Employee SET Title=e_Title WHERE EmployeeId=id;
    END IF;
    IF e_ReportsTo IS NOT NULL THEN
        UPDATE Employee SET ReportsTo=e_ReportsTo WHERE EmployeeId=id;
    END IF;
    IF e_BirthDate IS NOT NULL THEN
        UPDATE Employee SET BirthDate=e_BirthDate WHERE EmployeeId=id;
    END IF;
    IF e_HireDate IS NOT NULL THEN
        UPDATE Employee SET HireDate=e_HireDate WHERE EmployeeId=id;
    END IF;
    IF e_Address IS NOT NULL THEN
        UPDATE Employee SET Address=e_Address WHERE EmployeeId=id;
    END IF;
    IF e_City IS NOT NULL THEN
        UPDATE Employee SET City=e_City WHERE EmployeeId=id;
    END IF;
    IF e_State IS NOT NULL THEN
        UPDATE Employee SET State=e_State WHERE EmployeeId=id;
    END IF;
    IF e_Country IS NOT NULL THEN
        UPDATE Employee SET Country=e_Country WHERE EmployeeId=id;
    END IF;
    IF e_PostalCode IS NOT NULL THEN
        UPDATE Employee SET PostalCode=e_PostalCode WHERE EmployeeId=id;
    END IF;
    IF e_Phone IS NOT NULL THEN
        UPDATE Employee SET Phone=e_Phone WHERE EmployeeId=id;
    END IF;
    IF e_Fax IS NOT NULL THEN
        UPDATE Employee SET Fax=e_Fax WHERE EmployeeId=id;
    END IF;    
    IF e_Email IS NOT NULL THEN
        UPDATE Employee SET Email=e_Email WHERE EmployeeId=id;
    END IF;
END;
/

-- Testing the procedure    
EXECUTE update_employee(8 , 'Jimmy' , NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
SELECT LastName FROM Employee WHERE EmployeeId=8;

-- 4.2b - Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE managers(id IN NUMBER, fname OUT VARCHAR2, lname OUT VARCHAR2)
AS
managerId NUMBER;
BEGIN
    SELECT ReportsTo INTO managerId FROM Employee WHERE EmployeeId=id;
    SELECT FirstName, LastName INTO fname, lname FROM Employee WHERE EmployeeId=managerId;
END;
/

-- Test if the procedure works
DECLARE
f VARCHAR2(20);
l VARCHAR2(20);
BEGIN
managers(2, f, l);
managers(4, f, l);
IF f IS NULL AND l IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('No manager');
ELSE
    DBMS_OUTPUT.PUT_LINE(f || ' ' || l || ' is this employees manager');
END IF;
END;
/

-- 4.3 - Create a stored procedure that returns the name and company of a customer.
SET SERVEROUT ON;
CREATE OR REPLACE PROCEDURE customer_info(id IN NUMBER, fname OUT VARCHAR2, lname OUT VARCHAR2, c_company OUT VARCHAR2)
AS
BEGIN
    SELECT FirstName, LastName, Company INTO fname, lname, c_company FROM Customer WHERE CustomerId=id;
END;
/

-- Test if the procedure works
DECLARE
f VARCHAR2(40);
l VARCHAR2(20);
c VARCHAR2(80);
BEGIN
customer_info(2, f, l, c);
customer_info(1, f, l, c);
IF c IS NULL THEN
    DBMS_OUTPUT.PUT_LINE(f || ' ' || l || ' has no company');
ELSE
    DBMS_OUTPUT.PUT_LINE(f || ' ' || l || ' is from ' || c);
END IF;
END;
/

-- 5.0a - Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE remove_invoice(id NUMBER)
AS
BEGIN
    DELETE FROM InvoiceLine WHERE InvoiceId=id;
    DELETE FROM Invoice WHERE InvoiceId=id;
    COMMIT;
END;
/

-- Test if the trigger works
BEGIN
remove_invoice(5);
END;
/

-- 5.0b - Create a transaction nested within a stored procedure that inserts a new record in the Customer table
-- Delete the employee from the last test
DELETE FROM Customer WHERE CustomerId=60;

CREATE OR REPLACE PROCEDURE insert_customer(id NUMBER, last VARCHAR2, first VARCHAR2, c_email VARCHAR2)
AS
BEGIN
    INSERT INTO Customer(CustomerId, FirstName, LastName, Email) VALUES (id, last, first, c_email);
    COMMIT;
END;
/

-- Test if the trigger works
BEGIN
insert_customer(60, 'Jan', 'Jim', 'jimj@gmail.com');
END;
/
SELECT * FROM Customer WHERE CustomerId=60;

-- 6.1a - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
SET SERVEROUT ON;
CREATE OR REPLACE TRIGGER after_insert_employee
AFTER INSERT ON Employee
BEGIN
    DBMS_OUTPUT.PUT_LINE('Inserted into Employee');
END;
/

-- Test if the trigger works
CREATE SEQUENCE employee_s1
START WITH 9
INCREMENT BY 1;

DELETE FROM Employee WHERE EmployeeId > 8;
BEGIN
INSERT INTO Employee (EmployeeId, LastName, FirstName) VALUES (employee_s1.nextVal, 'Bells', 'Clang');
END;
/
SELECT * FROM Employee WHERE EmployeeId>9;

-- 6.1b - Create an after update trigger on the album table that fires after a row is inserted in the table
SET SERVEROUT ON;
CREATE OR REPLACE TRIGGER after_update_album
AFTER UPDATE OR INSERT ON Album
BEGIN
    CASE
        WHEN UPDATING THEN
            DBMS_OUTPUT.PUT_LINE('Updated Album');
        WHEN INSERTING THEN
            DBMS_OUTPUT.PUT_LINE('Inserted into Album');
    END CASE;
END;
/

-- Test if the trigger works
CREATE SEQUENCE album_s1
START WITH 248
INCREMENT BY 1;

DELETE FROM Album WHERE AlbumId > 347;
BEGIN
INSERT INTO Album (AlbumId, Title, ArtistId) VALUES (album_s1.nextVal, 'Ethereal', 12);
UPDATE Album SET ArtistId=13 WHERE AlbumId=348;
END;
/
SELECT * FROM Album WHERE AlbumId > 347;

-- 6.1c - Create an after delete trigger on the customer table that fires after a row is deleted from the table.
-- Create a table to log the deleted customer
SET SERVEROUT ON;
CREATE OR REPLACE TRIGGER after_delete_customer
AFTER DELETE ON Customer
BEGIN
    DBMS_OUTPUT.PUT_LINE('Delete Successful');
END;
/

-- Test if the trigger works
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Email) VALUES (60, 'Izzy', 'yzzi', 'asffdasdf@gmail.com');
SELECT * FROM Customer WHERE CustomerId=60;
BEGIN
DELETE FROM Customer WHERE CustomerId=60;
END;
/

-- 7.1 - Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT CONCAT(CONCAT(customer.FirstName,' '), customer.LastName) AS Name, invoice.InvoiceId
FROM Customer customer INNER JOIN Invoice invoice ON customer.CustomerId=invoice.InvoiceId ORDER BY customer.FirstName ASC;

-- 7.2 - Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME , CUSTOMER.LASTNAME, invoice.InvoiceId, invoice.Total
FROM Customer customer FULL OUTER JOIN Invoice invoice ON customer.CustomerId=invoice.CustomerId;

-- 7.3 - Create a right join that joins album and artist specifying artist name and title.
SELECT artist.Name, album.Title
FROM Artist artist RIGHT JOIN ALBUM album ON artist.ArtistId=album.ArtistId;

-- 7.4 - Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM Album CROSS JOIN Artist ORDER BY ARTIST.Name ASC;

-- 7.5 - Perform a self-join on the employee table, joining on the reportsto column.
SELECT CONCAT(CONCAT(E1.FirstName,' '),E1.LastName) AS Subordinate, 
       CONCAT(CONCAT(E2.FirstName,' '),E2.LastName) AS Manager
FROM Employee E1 JOIN Employee E2 ON E1.EmployeeID=E2.ReportsTo;
-- Can also do FROM table alias1, table alias2 WHERE alias1.columnName=alias2.columnName
-- ex: SELECT CONCAT(CONCAT(E1.FirstName,' '),E1.LastName) AS Subordinate, 
--     CONCAT(CONCAT(E2.FirstName,' '),E2.LastName) AS Manager
--     FROM Employee E1, Employee E2 WHERE E1.EmployeeID=E2.ReportsTo;