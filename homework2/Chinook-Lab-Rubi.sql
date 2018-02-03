/** SQL Lab **/

/** 2.0 SQL Queries 
In this section you will be performing various queries against the Oracle Chinook database.
**/

/** 2.1 SELECT **/
-- Task – Select all records from the Employee table.
SELECT * FROM Employee;
-- Task – Select all records from the Employee table where last name is King.
SELECT * FROM Employee WHERE LastName = 'King';
-- Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM Employee WHERE FirstName = 'Andrew' AND ReportsTo IS NULL;

/** 2.2 ORDER BY **/
-- Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM Album ORDER BY(Title) DESC;
-- Task – Select first name from Customer and sort result set in ascending order by city
SELECT FirstName FROM Customer ORDER BY(City) ASC;

/** 2.3 INSERT INTO **/
-- Task – Insert two new records into Genre table 
INSERT INTO Genre(GenreId, Name) VALUES(26, 'Kinky');
INSERT INTO Genre(GenreId, Name) VALUES(27, 'Workout');
-- Task – Insert two new records into Employee table
INSERT INTO Employee(EmployeeId, LastName, FirstName) VALUES(9, 'Five', 'Johnny');
INSERT INTO Employee(EmployeeId, LastName, FirstName) VALUES(10, 'Venus', 'Hello');
-- Task – Insert two new records into Customer table
INSERT INTO Customer(CustomerId, FirstName, LastName, Email) VALUES(60, 'Kim', 'Taeyeon', 'shopper123@gmail.com');
INSERT INTO Customer(CustomerId, FirstName, LastName, Email) VALUES(61, 'Park', 'Jungun', 'shopper456@gmail.com');

/** 2.4 UPDATE **/
-- Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE Customer SET FirstName = 'Robert', LastName = 'Walter' WHERE FirstName = 'Aaron' AND LastName = 'Mitchell';
-- Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE Artist SET Name = 'CCR' WHERE Name = 'Creedence Clearwater Revival';

/** 2.5 LIKE **/
-- Task – Select all invoices with a billing address like “T%”
SELECT * FROM Invoice WHERE BILLINGADDRESS LIKE 'T%';

/** 2.6 BETWEEN **/
-- Task – Select all invoices that have a total between 15 and 50
SELECT * FROM Invoice WHERE Total BETWEEN 15 AND 50;
-- Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM Employee WHERE HireDate BETWEEN TO_DATE('2003-6 00:00:00','yyyy-mm hh24:mi:ss') AND TO_DATE('2004-3 00:00:00','yyyy-mm hh24:mi:ss');

/***** COMMIT *****/

/** 2.7 DELETE **/
/***** INCOMPLETE *****/
-- Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE Invoice DROP CONSTRAINT FK_INVOICELINEINVOICEID;
DELETE FROM InvoiceLine WHERE InvoiceId = (
    SELECT InvoiceID FROM Invoice WHERE CustomerId = (
        SELECT CustomerId FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter'
        )
    );
--SELECT * FROM InvoiceLine WHERE InvoiceId = 245;
DELETE FROM Invoice WHERE CustomerId = (SELECT CustomerId FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter');
--SELECT * FROM Invoice WHERE CustomerId = 32;
DELETE FROM Customer WHERE FirstName = 'Robert' AND LastName = 'Walter'; 

/** 3.0 SQL Functions
In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
**/

/** 3.1 System Defined Functions **/
-- Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION ReturnCurrentTime
RETURN TIMESTAMP
IS
    some_Time TIMESTAMP;
BEGIN
    some_Time := LOCALTIMESTAMP;
    RETURN some_Time;
END ReturnCurrentTime;
/

SET SERVEROUTPUT ON;
DECLARE
    my_Time TIMESTAMP;
BEGIN
    my_Time := ReturnCurrentTime();
    dbms_output.put_line('Your current time is ' || my_Time); 
END; 
/

-- Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION LenOfName
RETURN INT
IS
    f1 VARCHAR2(120);
    some_LEN INT;
BEGIN
    SELECT Name INTO f1 FROM MEDIATYPE WHERE MEDIATYPEID = 2;
    some_Len := LENGTH(f1);
    RETURN some_Len;
END LenOfName;
/

SET SERVEROUTPUT ON;
DECLARE
    name_Length INT;
BEGIN
    name_Length := LenOfName();
    dbms_output.put_line('Your name length is ' || name_Length); 
END; 
/

/** 3.2 System Defined Aggregate Functions **/
-- Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION AvgTotalInvoices
RETURN NUMBER AS avg_Of NUMBER;
CURSOR S IS 
    SELECT AVG(Total) FROM Invoice;
BEGIN
    OPEN S;
    FETCH S INTO avg_Of;
    CLOSE S;
    RETURN avg_Of;
END AvgTotalInvoices;
/

SELECT AvgTotalInvoices FROM DUAL;

-- Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION MostExpTrack
RETURN NUMBER AS pricey NUMBER;
CURSOR S IS 
    SELECT MAX(UNITPRICE) FROM Track;
BEGIN
    OPEN S;
    FETCH S INTO pricey;
    CLOSE S;
    RETURN pricey;
END MostExpTrack;
/

SELECT MostExpTrack FROM DUAL;

/** 3.3 User Defined Scalar Functions **/
-- Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION AvgPriceInvoiceLine
RETURN NUMBER AS avg_Of_UnitPrice NUMBER;
CURSOR S IS 
    SELECT AVG(UnitPrice) FROM InvoiceLine;
BEGIN
    OPEN S;
    FETCH S INTO avg_Of_UnitPrice;
    CLOSE S;
    RETURN avg_Of_UnitPrice;
END AvgPriceInvoiceLine;
/

SELECT AvgPriceInvoiceLine FROM DUAL;

/** 3.4 User Defined Table Valued Functions **/
-- Task – Create a function that returns all employees who are born after 1968.
--SELECT * FROM Employee WHERE BirthDate > TO_DATE('1968','yyyy');

CREATE OR REPLACE FUNCTION GetEmployeeAfter
    RETURN SYS_REFCURSOR
IS
    l_rc SYS_REFCURSOR;
BEGIN
    OPEN l_rc
    FOR SELECT * FROM Employee WHERE BirthDate > TO_DATE('1968','yyyy');
    RETURN l_rc;
END GetEmployeeAfter;
/

SELECT GetEmployeeAfter FROM DUAL;

/** 4.0 Stored Procedures
 In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
**/

/***** INCOMPLETE *****/
/** 4.1 Basic Stored Procedure **/
-- Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GetFirstLast (RUNNING OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN RUNNING FOR 
    SELECT FirstName, LastName FROM Employee;
    DBMS_SQL.RETURN_RESULT(RUNNING);
END;
/

DECLARE
CURR SYS_REFCURSOR;
BEGIN
    GetFirstLast(RUNNING=>CURR);
END;
/

/** 4.2 Stored Procedure Input Parameters **/
-- Task – Create a stored procedure that updates the personal information of an employee.
-- Task – Create a stored procedure that returns the managers of an employee.

/** 4.3 Stored Procedure Output Parameters **/
-- Task – Create a stored procedure that returns the name and company of a customer.

/** 5.0 Transactions
In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
**/
-- Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
-- Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table

/** 6.0 Triggers
In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
**/

/** 6.1 AFTER/FOR **/
-- Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER AfterInsertEmployee  
    AFTER INSERT 
    ON Employee
BEGIN
    CASE
        WHEN INSERTING THEN
            DBMS_OUTPUT.PUT_LINE('Inserting');
    END CASE;
END;
/

/** CAUTION: DO NOT FORGET TO TURN ON 'Dbms Output' and 'Enable DBMS_OUTPUT for connection' **/
SET SERVEROUTPUT ON;
--DBMS_OUTPUT.ENABLE;
INSERT INTO Employee(EmployeeId, LastName, FirstName) VALUES(31, 'Blurr', 'Raymond');
commit;
--DELETE FROM Employee WHERE EmployeeId = 31;

-- Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER AfterUpdateAlbum 
    AFTER UPDATE 
    ON Album
BEGIN
    CASE
        WHEN UPDATING THEN
            DBMS_OUTPUT.PUT_LINE('Updating');
    END CASE;
END;
/

/** CAUTION: DO NOT FORGET TO TURN ON 'Dbms Output' and 'Enable DBMS_OUTPUT for connection' **/
SET SERVEROUTPUT ON;
--DBMS_OUTPUT.ENABLE;
UPDATE Album SET Title = 'Fly Me To The Moon' WHERE AlbumId = 100 AND Title = 'Iron Maiden';
commit;

/***** INCOMPLETE *****/
-- Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER AfterDeleteCustomer 
    AFTER UPDATE 
    ON Customer
BEGIN
    CASE
        WHEN DELETING THEN
            DBMS_OUTPUT.PUT_LINE('Deleting');
    END CASE;
END;
/

/** CAUTION: DO NOT FORGET TO TURN ON 'Dbms Output' and 'Enable DBMS_OUTPUT for connection' **/
--DBMS_OUTPUT.ENABLE;
SET SERVEROUTPUT ON;
DELETE FROM Customer WHERE FirstName = 'Luís' AND LastName = 'Gonçalves'; 
commit;

/** 7.0 JOINS
In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
**/

/** 7.1 INNER **/
-- Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FirstName, LastName, InvoiceId 
FROM Customer INNER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;

/** 7.2 OUTER **/
-- Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT Customer.CustomerId, FirstName, LastName, InvoiceId, Total
FROM Customer FULL OUTER JOIN Invoice
ON Customer.CustomerId = Invoice.CustomerId;
-- Note: Customer.CustomerId had to be explicitly defined because 'CustomerId' exist in both Customer Table and Invoice Table.

/** 7.3 RIGHT **/
-- Task – Create a right join that joins album and artist specifying artist name and title.
SELECT Name, Title
FROM Artist RIGHT JOIN Album
ON ARTIST.ARTISTID = ALBUM.ARTISTID;

/** 7.4 CROSS **/
-- Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM Album CROSS JOIN Artist
ORDER BY Name ASC;

/** 7.5 SELF **/
-- Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT A.EmployeeId AS TechnicianId, A.FirstName, A.LastName, B.EmployeeId AS ManagerId, B.FirstName, B.LastName 
FROM Employee A JOIN Employee B
ON A.ReportsTo = B.EmployeeId;







