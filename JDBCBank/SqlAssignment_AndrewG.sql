--2.1 SELECT
--Task kelect all records from the Employee table.
SELECT *
FROM EMPLOYEE;

--Task Select all records from the Employee table where last name is King.
SELECT *
FROM EMPLOYEE
WHERE LASTNAME LIKE 'King';

--Task Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'Andrew'
AND REPORTSTO IS NULL;

--2.2 ORDER BY
--Task Select all albums in Album table and sort result set in descending order by title.
SELECT *
FROM ALBUM
ORDER  BY TITLE DESC;

--Task Select first name from Customer and sort result set in ascending order by city
SELECT FIRSTNAME --, CITY   // CHECK IF IT'S ORDERED BY CITY NAME.
FROM CUSTOMER
ORDER BY CITY ASC;      -- ORDER BY ASCENDING

--2.3 INSERT INTO
--Task – Insert two new records into Genre table 
CREATE SEQUENCE GENRE_SEQ       -- USE SEQUENCE TO PREVENT DUPLICATE VALUE FOR THE PRIMARY KEY 'GENREID'
INCREMENT BY 1
START WITH 26;

INSERT INTO GENRE (GENREID, NAME) VALUES (GENRE_SEQ.NEXTVAL, 'GENRE_NAME_')  ;

--Task – Insert two new records into Employee table
CREATE SEQUENCE EMPLOYEE_SEQ       -- USE SEQUENCE TO PREVENT DUPLICATE VALUE FOR THE PRIMARY KEY 'EMPLOYEEID'
INCREMENT BY 1
START WITH 9;

INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL) 
VALUES (EMPLOYEE_SEQ.NEXTVAL, 'Kim', 'Jully', 'IT Manager',           -- USE 'EMPLOYEE_SEQ.NEXTVAL FOR PRIMARY KEY, SO NON-DUPLICATE KEY IS ALLOWED. 
-- REPORTSTO : is FK of EMPLOYEEID, so the value must already exist in the column 'EMPLOYEEID', and IT Manager 'Mitchell' already has '1' for REPORTSTO, so Tonny should have '1' as a IT Manager.
NULL,                
TO_DATE('1982-03-09 07:00:00','yyyy-mm-dd hh24:mi:ss'),                 --BirthDate : Switch varchar type to date type using 'format'
TO_DATE('2015-04-08 09:00:00','yyyy-mm-dd hh24:mi:ss'),                 --HireDate
'606 Jully Street', 'Houston', 'TX', 'USA', '25217', 
'+1 (214) 777-4445', '+1 (215) 777-3322', 'Jully@chinookcorp.com'); 

SELECT E.FIRSTNAME AS EMPLOYEE_NAME, M.FIRSTNAME AS MANAGER_NAME
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.REPORTSTO = M.EMPLOYEEID;
 
 
--Task – Insert two new records into Customer table
CREATE SEQUENCE CUSTOMER_SEQ       -- USE SEQUENCE TO PREVENT DUPLICATE VALUE FOR THE PRIMARY KEY 'EMPLOYEEID'
INCREMENT BY 1
START WITH 60;

INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (CUSTOMER_SEQ.NEXTVAL, 'Customer 60 F', 'Customer 60 L', '60th Company','60th Street', 'Reston', 'Virginia', 'USA', '61001-000', '+60 (12) 3923-5555', '+60 (12) 3923-5566', 'Sixty@embraer.com.br', null);
INSERT INTO Customer (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId) 
VALUES (CUSTOMER_SEQ.NEXTVAL, 'Customer 61 F', 'Customer 61 L', '61th Company','61th Street', 'Reston', 'Virginia', 'USA', '61001-000', '+61 (12) 3923-5555', '+61 (12) 3923-5566', 'SixtyOne@embraer.com.br', null);



--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert' , LASTNAME = 'Walter'
WHERE FIRSTNAME||' '||LASTNAME = 'Aaron Mitchell';

/*  test code below
SELECT *
FROM CUSTOMER
WHERE FIRSTNAME||' '||LASTNAME = 'Aaron Mitchell';
*/


--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';
/*  test code below
SELECT *
FROM ARTIST
WHERE NAME = 'Creedence Clearwater Revival';   */


--2.5 LIKE
--Task – Select all invoices with a billing address like “T%”
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT *
FROM INVOICE
WHERE TOTAL >= 15 AND TOTAL <=50;

--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT FIRSTNAME, HIREDATE
FROM EMPLOYEE
WHERE HIREDATE BETWEEN TO_DATE('2003-01-01', 'YYYY-MM-DD') AND TO_DATE('2004-03-01','YYYY-MM-DD');

--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
/*
SELECT customerID           -- (step1) get customerID 
FROM CUSTOMER
WHERE FIRSTNAME = 'Robert'
AND LASTNAME = 'Walter';

SELECT *                    -- (step2) check if invoice exist 
FROM INVOICE
WHERE CUSTOMERID = 32;

SELECT *                    -- (step3) if it has, get the list and check if invoiceline exist
FROM INVOICELINE
WHERE INVOICEID in (50, 61, 116, 342, 245, 268, 290);   -- (step4) delete all invoiceid>>customerid>>customer
*/ 




--3.	SQL Functions
--In this section you will be using the Oracle system functions, as well as your own functions, to perform various actions against the database
--3.1 System Defined Functions

--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_nowTime
    return DATE is nowTime DATE;    -- Assign the return type as 'date' data type.    
BEGIN
    SELECT SYSDATE INTO nowTime     -- put the result 'sysdate' into the variable 'get_nowTime' declared above
    FROM DUAL;
    RETURN nowTime;
END ;
/
select get_nowTime() from dual;     --get_nowTime function doesn't need an argument. function works in 'select' query.


--Task – create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION get_lengthOfName
    RETURN SYS_REFCURSOR AS l_cursor SYS_REFCURSOR;
BEGIN
    OPEN l_cursor FOR
        SELECT NAME, LENGTH(NAME) AS nameLength
        FROM MEDIATYPE;
    RETURN l_cursor;
END;
/
SELECT get_lengthOfName FROM DUAL;


--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION  avgTotal_of_invoices
    RETURN NUMBER IS avgTotal NUMBER;
BEGIN
    SELECT round(AVG(total),2) INTO avgTotal
    FROM invoice;
    
    RETURN avgTotal;
END;
/
SELECT avgTotal_of_invoices() FROM dual;     


--Task – Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION get_mostExpensiveTrack
    RETURN SYS_REFCURSOR AS e_cursor SYS_REFCURSOR;
BEGIN
    OPEN e_cursor FOR
        SELECT trackid, name, unitprice
        FROM track where unitprice >= (SELECT MAX(unitprice) FROM track);
    RETURN e_cursor;
END;
/
SELECT get_mostExpensiveTrack FROM DUAL;
 

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avgPrice_Invoiceline 
    RETURN NUMBER IS avgInvoicePrice NUMBER;
BEGIN
    select round(avg(unitprice), 2) INTO avgInvoicePrice 
    from invoiceline;   
    
    RETURN avgInvoicePrice;
END;
/
SELECT avgPrice_Invoiceline() from dual;


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
CREATE OR REPLACE FUNCTION get_EmployeeByBirth  
RETURN SYS_REFCURSOR IS e_cursor SYS_REFCURSOR;
BEGIN
    OPEN e_cursor FOR
    SELECT birthdate, firstname, lastname       -- !!! order is important!!! ---
    FROM employee
    WHERE birthdate > TO_DATE('1968-01-01', 'YYYY-MM-dd');
    RETURN e_cursor; 
END;
/            

--get the cursor and find all the results
DECLARE
    cs SYS_REFCURSOR;
    e_birthdate employee.birthdate%TYPE;
    e_firstname employee.firstname%TYPE;
    e_lastname employee.lastname%TYPE;
BEGIN
    cs := get_EmployeeByBirth();
    LOOP
        FETCH cs INTO e_birthdate, e_firstname, e_lastname; -- !!! order is important !!!!
        EXIT WHEN cs%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('name is:'||e_firstname||' '||e_lastname||'  /  birthYear is: '||TO_CHAR(e_birthdate,'YYYY'));
    END LOOP;
    CLOSE cs;
END;
/        
            
            
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE get_allEmployees(
    cs IN OUT SYS_REFCURSOR)
IS       
BEGIN
    OPEN cs FOR
    SELECT firstname, lastname FROM employee;
END;
/

 
DECLARE
    cs_result SYS_REFCURSOR;      -- execute the stored procedure
    firstname employee.firstname%TYPE;        -- declare variable
    lastname employee.lastname%TYPE;         
BEGIN
    get_allEmployees(cs_result);
    
    LOOP
        FETCH cs_result INTO firstname, lastname;
        EXIT WHEN cs_result%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(firstname);
    END LOOP;
    /* FOR cs_each IN cs_result     -- can't use for RefCursor?
        LOOP
            DBMS_OUTPUT.PUT_LINE(cs_each.firstname);
        END LOOP;             */
    CLOSE cs_result;
END;
/


--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE update_emp (
    e_employeeid  employee.employeeid%TYPE,
    e_city        employee.city%TYPE,
    e_state       employee.state%TYPE,
    e_country     employee.country%TYPE)
IS
BEGIN
    UPDATE employee
    SET city = e_city, 
        state = e_state,
        country = e_country
    WHERE employeeid = e_employeeid;
    COMMIT;         -- IF IT DOESEN'T COMMIT, CAN BE ROLLBACKED.
END;
/
BEGIN
update_emp(3, 'Dallas', 'TX', 'USA');
END;
/
 

--Task – Create a stored procedure that returns the managers of an employee.
--(step1) create the function   employee id >> (return) manager id   
SET SERVEROUTPUT ON; 
CREATE OR REPLACE FUNCTION get_managerId_byEmpId (
    empId IN employee.employeeID%TYPE)
    RETURN NUMBER as managerId NUMBER;
BEGIN
    SELECT NVL(e.reportsto, 0) as mngId INTO managerId
    FROM employee e left outer join employee r
    ON e.reportsto = r.employeeid
    WHERE e.employeeid = empId;       -- ID 3 EMPLOYEE'S MANAGER ID >> 
    RETURN managerId;
END;
/
--(step2) loop the function until all manager are stored
CREATE OR REPLACE PROCEDURE get_allManagers_byEmpId(
    empId IN employee.employeeID%TYPE)    
IS
    managerId employee.employeeID%TYPE;  
    managerName VARCHAR2(50);
BEGIN
    managerId := get_managerId_byEmpId(empId);      -- get managerId
    WHILE managerId > 0 LOOP                        -- loop only if managerId > 0 
        SELECT firstname||' '||lastname  into managerName           -- get manager name
        FROM employee 
        WHERE employeeid = managerId;
        DBMS_OUTPUT.PUT_LINE(managerName);          -- print manager name
        managerId := get_managerId_byEmpId(managerId);  -- get the id of manager's supervisor
    END LOOP;
END;
/
BEGIN
    get_allManagers_byEmpId(5);        
END;
/
   

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE get_customerInfo (
    cs IN OUT SYS_REFCURSOR,                    --cs is return values
    customer_id IN customer.customerid%TYPE)    --customer Id is parameter
IS
BEGIN
    OPEN cs FOR
    SELECT firstname, lastname, company
    FROM customer 
    WHERE customerId = customer_id;
END;

 
DECLARE
    cs          SYS_REFCURSOR;
    firstname   customer.firstname%TYPE;
    lastname    customer.lastname%TYPE;
    company     customer.company%TYPE;
BEGIN
    get_customerInfo(cs, 20);    -- refcursor with a customerId as input    
    LOOP
        FETCH cs INTO firstname, lastname, company;
        EXIT WHEN cs%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('name:'||firstname||' '||lastname||' / company : '|| NVL(company, 'None'));
    END LOOP;
    CLOSE cs;
END;
 

--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE delete_invoice_byId (
    d_invoiceId IN invoice.invoiceid%TYPE )
IS
BEGIN
    DELETE FROM invoiceline WHERE invoiceid = d_invoiceid;  -- delete from the table which has FK of Invoice table first
    DELETE FROM invoice WHERE invoiceid = d_invoiceid;      
    COMMIT;
END;
/
BEGIN
    delete_invoice_byId(53);
END;
/
 
--Task – Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE insert_customer (
    c_customerid  IN customer.customerid%TYPE,
    c_firstname   IN customer.firstname%TYPE,
    c_lastname    IN customer.lastname%TYPE,
    c_email       IN customer.email%TYPE
) AS
    ifRowExist  NUMBER;
BEGIN
    
    SELECT count(*) as cnt into ifRowExist
    FROM customer
    WHERE customerid = c_customerid;
    
    IF ifRowExist > 0           -- if already customer exist, doesn't insert.
    THEN DBMS_OUTPUT.PUT_LINE('The user already exist');
    ELSE    INSERT INTO Customer (CustomerId, FirstName, LastName, Email )
            VALUES (c_customerid, c_firstname, c_lastname, c_email);
            COMMIT;
    END IF;
END;
/
BEGIN
insert_customer(63, 'firstName63', 'lastname63',   '63daan_peeters@apple.be');
END;
/


CREATE SEQUENCE COMMON_SEQ
INCREMENT BY 1
START WITH 1100;




--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
 
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table. 
CREATE OR REPLACE TRIGGER trg_insertOnEmployee
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('new employee joins!');
END;
/
-- practice fire
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (COMMON_SEQ.NEXTVAL, 'test F name', 'test L name');
COMMIT;     -- triggers fire after committed.


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE OR REPLACE TRIGGER trg_updateOnAlbum
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('new album coming!');
END;
/
-- practice fire
UPDATE albom SET title = 'AudioSlave updated' WHERE albumid = 10;
COMMIT;


--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table. 
CREATE OR REPLACE TRIGGER trg_deleteOnCustomer
AFTER DELETE ON CUSTOMER
FOR EACH ROW
BEGIN
DBMS_OUTPUT.PUT_LINE('we just lost a customer..');
END;
/
INSERT INTO customer (customerid, firstname, lastname, email) values(common_seq.nextval, 'testfname', 'testlname','dd@test.com');
-- practice fire
DELETE FROM customer where customerid = 1108;
COMMIT;



 --7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT firstname, lastname, invoiceid
FROM customer c INNER JOIN invoice i
ON c.customerid = i.customerid;

 
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT  c.customerid, c.firstname, c.lastname, i.invoiceid, i.total, i.customerid
FROM customer c full outer join invoice i
ON c.customerid = i.customerid;


--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT name, title
FROM album A RIGHT JOIN artist p
ON a.artistid = p.artistid;


--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM album CROSS JOIN artist
ORDER BY artist.name ASC;


--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT *
FROM employee a JOIN employee b
ON a.reportsto = b.reportsto;


