/****************************************************
* Author: Calvin Milliron
* Week 1 Chinook Lab
* chinook_lab.sql
****************************************************/

------------------------------------------------------------------------------------------------------------
-- 2.1.1 Select all records from the Employee table.
SELECT * 
FROM employee;

------------------------------------------------------------------------------------------------------------
-- 2.1.2 Select all records from the Employee table where last name is King.
SELECT * 
FROM employee 
WHERE lastname = 'King';

------------------------------------------------------------------------------------------------------------
-- 2.1.3 Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * 
FROM employee 
WHERE firstname = 'Andrew' AND reportsto IS NULL;

------------------------------------------------------------------------------------------------------------
-- 2.2.1 Select all albums in Album table and sort result set in descending order by title.
SELECT * 
FROM album 
ORDER BY title DESC;

------------------------------------------------------------------------------------------------------------
-- 2.2.2 Select first name from Customer and sort result set in ascending order by city
SELECT firstname 
FROM customer 
ORDER BY city ASC;

------------------------------------------------------------------------------------------------------------
-- 2.3.1 Insert two new records into Genre table
-- Create and Commit sequence for indexes
CREATE SEQUENCE genre_s1 START WITH 1001 INCREMENT BY 1;
-- Create trigger to insert next sequence value
CREATE OR REPLACE TRIGGER genre_t1_before_insert
BEFORE INSERT ON genre
FOR EACH ROW
 WHEN (new.genreid IS NULL) 
BEGIN
  SELECT genre_s1.NEXTVAL 
  INTO :new.genreid
  FROM dual;
END;
/
COMMIT;

-- Add Bebop
INSERT INTO genre (name)
VALUES ('Bebop');
-- Add Rocksteady
INSERT INTO genre (name)
VALUES ('Rocksteady');
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 2.3.2 Insert two new records into Employee table
-- Create and Commit sequence for indexes
CREATE SEQUENCE employee_s1 START WITH 1001 INCREMENT BY 1;
-- Create trigger to insert next sequence value
CREATE OR REPLACE TRIGGER employee_t1_before_insert
BEFORE INSERT ON employee
FOR EACH ROW
 WHEN (new.employeeid IS NULL) 
BEGIN
  SELECT employee_s1.NEXTVAL 
  INTO :new.employeeid
  FROM dual;
END;
/
COMMIT;

-- Insert Steve
INSERT INTO employee 
( lastname
, firstname
, title
, reportsto
, birthdate
, hiredate
, address
, city
, state
, country
, postalcode
, phone
, fax
, email)
VALUES
( 'Jobs'
, 'Steve'  
, 'Sales Support Agent'
, (SELECT employeeid
  FROM employee
  WHERE firstname = 'Nancy' AND lastname = 'Edwards')
, '24-FEB-55'
, '01-APR-04'
, '1 Infinite Loop'
, 'Cupertino'
, 'CA'
, 'United States of America'
, '95014'
, '+1 (408) 606-5775'
, '+1 (408) 606-5776'
, 'steve@chinookcorp.com');
-- Insert Bill
INSERT INTO employee
( lastname
, firstname
, title
, reportsto
, birthdate
, hiredate
, address
, city
, state
, country
, postalcode
, phone
, fax
, email)
VALUES
( 'Gates'
, 'Bill'
, 'Sales Support Agent'
, (SELECT employeeid
  FROM employee
  WHERE firstname = 'Nancy' AND lastname = 'Edwards')
, '28-OCT-55'
, '15-APR-04'
, '1 Microsoft Way'
, 'Redmond'
, 'WA'
, 'United States of America'
, '98052'
, '+1 (425) 882-8080'
, '+1 (425) 706-7929'
, 'bill@chinookcorp.com');
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 2.3.3 Insert two new records into Customer table
-- Create and Commit sequence for indexes
CREATE SEQUENCE customer_s1 START WITH 1001 INCREMENT BY 1;
-- Create trigger to insert next sequence value
CREATE OR REPLACE TRIGGER customer_t1_before_insert
BEFORE INSERT ON customer
FOR EACH ROW
 WHEN (new.customerid IS NULL) 
BEGIN
  SELECT customer_s1.NEXTVAL 
  INTO :new.customerid
  FROM dual;
END;
/

COMMIT;
-- Insert Fred
INSERT INTO customer 
( firstname
, lastname
, company
, address
, city
, state
, country
, postalcode
, phone
, fax
, email
, supportrepid)
VALUES
( 'Fred'
, 'Flintsone'
, 'Bedrock Quarrel and Gravel Company'
, '345 Cave Stone Road'
, 'Cupertino'
, 'CA'
, 'United States of America'
, '95014'
, '+1 (403) 524-6374'
, '+1 (403) 524-6375'
, 'fred@flintstones.com'
, (SELECT employeeid
  FROM employee
  WHERE firstname = 'Steve' AND lastname = 'Jobs'));
-- Insert Barney
INSERT INTO customer
( firstname
, lastname
, company
, address
, city
, state
, country
, postalcode
, phone
, fax
, email
, supportrepid)
VALUES
( 'Barney'
, 'Rubble'
, 'Bedrock Quarrel and Gravel Company'
, '347 Cave Stone Road'
, 'Cupertino'
, 'CA'
, 'United States of America'
, '95014'
, '+1 (403) 524-6378'
, '+1 (403) 524-6379'
, 'barney@flintsones.com'
, (SELECT employeeid
  FROM employee
  WHERE firstname = 'Bill' AND lastname = 'Gates'));
  COMMIT;

------------------------------------------------------------------------------------------------------------
-- 2.4.1 Update Aaron Mitchell in Customer table to Robert Walter
UPDATE customer 
SET firstname = 'Robert', lastname = 'Walter' 
WHERE firstname = 'Aaron' AND lastname = 'Mitchell';
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 2.4.2 Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
UPDATE artist
SET name = 'CCR'
WHERE name = 'Creedence Clearwater Revival';
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 2.5 Select all invoices with a billing address like “T%”
SELECT *
FROM invoice
WHERE billingaddress LIKE 'T%';

------------------------------------------------------------------------------------------------------------
-- 2.6.1 Select all invoices that have a total between 15 and 50
SELECT *
FROM invoice
WHERE total > 15 AND total < 50;

------------------------------------------------------------------------------------------------------------
-- 2.6.2 Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT *
FROM employee
WHERE hiredate > '01-JUN-03' AND hiredate < '01-MAR-04';

------------------------------------------------------------------------------------------------------------
-- 2.7 Delete a record in Customer table where the name is Robert Walter 
--       (There may be constraints that rely on this, find out how to resolve them).
-- Delete the invoice lines first
DELETE FROM invoiceline
WHERE invoiceid IN (SELECT invoiceid 
                    FROM invoice 
					WHERE customerid = (SELECT customerid
					                    FROM customer
										WHERE firstname = 'Robert' AND lastname = 'Walter'));
-- Delete the invoices second
DELETE FROM invoice
WHERE customerid = (SELECT customerid
					FROM customer
					WHERE firstname = 'Robert' AND lastname = 'Walter');
-- Delete the customer last
DELETE
FROM customer
WHERE firstname = 'Robert' AND lastname = 'Walter';
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 3.1.1 Create a function that returns the current time.
CREATE OR REPLACE FUNCTION get_time RETURN VARCHAR2 IS
    lv_date VARCHAR2(50);
BEGIN
    SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS')INTO lv_date FROM DUAL;
    RETURN lv_date;
END get_time;
/
-- Call function from DUAL
SELECT get_time FROM DUAL;

------------------------------------------------------------------------------------------------------------
-- 3.1.2 create a function that returns the length of name in MEDIATYPE table
CREATE OR REPLACE FUNCTION media_length (pv_media_type_id NUMBER) RETURN NUMBER IS
	lv_length NUMBER;
BEGIN
	SELECT LENGTH(name) INTO lv_length FROM mediatype WHERE mediatypeid = pv_media_type_id;
	RETURN lv_length;
END media_length;
/
-- Call function from DUAL
SELECT media_length(1) FROM DUAL;

------------------------------------------------------------------------------------------------------------
-- 3.2.1 Create a function that returns the average total of all invoices 
CREATE OR REPLACE FUNCTION avg_invoice RETURN FLOAT IS
	lv_avg FLOAT;
BEGIN
	SELECT AVG(total) INTO lv_avg FROM invoice;
	SELECT TO_CHAR(lv_avg, '000.00') INTO lv_avg FROM DUAL;
	RETURN lv_avg;
END avg_invoice;
/
-- Call function from DUAL
SELECT avg_invoice FROM DUAL;

------------------------------------------------------------------------------------------------------------
-- 3.2.2 Create a function that returns the most expensive track
CREATE OR REPLACE FUNCTION max_price RETURN FLOAT IS
	lv_max FLOAT;
BEGIN
	SELECT MAX(unitprice) INTO lv_max FROM track;
	SELECT TO_CHAR(lv_max, '000.00') INTO lv_max FROM DUAL;
	RETURN lv_max;
END max_price;
/
-- Call function from DUAL
SELECT max_price FROM DUAL;

------------------------------------------------------------------------------------------------------------
-- 3.3 Create a function that returns the average price of invoiceline items in the invoiceline table
CREATE OR REPLACE FUNCTION avg_invoice_line RETURN FLOAT IS
	lv_avg FLOAT;
BEGIN
	SELECT AVG(unitprice) INTO lv_avg FROM invoiceline;
	SELECT TO_CHAR(lv_avg, '000.00') INTO lv_avg FROM DUAL;
	RETURN lv_avg;
END avg_invoice_line;
/
-- Call function from DUAL
SELECT avg_invoice_line FROM DUAL;

------------------------------------------------------------------------------------------------------------
-- 3.4.a Create a function that returns all employees who are born after 1968.
-- Create Type with fields that match the fields from the employee table
----------------------------------------HEAVY BACKEND WITH TYPE CREATION
----------------------------------------RETURNS UNFORMATTED TABLE
-- Create structure of pertinent information
CREATE OR REPLACE TYPE employee_type IS OBJECT
  ( firstname  VARCHAR2(20)
  , lastname   VARCHAR2(20)
  , title      VARCHAR2(30)
  , birthdate  DATE
  , email      VARCHAR2(60) );
/
 
-- Create the collection of a employees.
CREATE OR REPLACE
  TYPE employee_list IS TABLE OF employee_type;
/
-- Create function
CREATE OR REPLACE FUNCTION get_employees_table_born_after(pv_date VARCHAR2) RETURN EMPLOYEE_LIST IS
	lv_employees EMPLOYEE_LIST;
	-- Create cursor to store info from database sorted by youngest first
    CURSOR employee_cursor IS SELECT * 
							  FROM employee 
							  WHERE birthdate > TO_DATE(pv_date, 'DD-MON-YYYY') 
							  ORDER BY birthdate DESC;
BEGIN
	-- Call Collection constructor
    lv_employees := EMPLOYEE_LIST();
	-- Step through each row in the cursor
    FOR i IN EMPLOYEE_CURSOR LOOP
		-- Make the collection bigger
        lv_employees.EXTEND;
		-- Add new employee to collection with values pulled from the current element of the cursor
        lv_employees(lv_employees.LAST) := EMPLOYEE_TYPE( i.firstname
                                                        , i.lastname
                                                        , i.title
                                                        , i.birthdate
                                                        , i.email);
    END LOOP;
	-- Return collection
	RETURN lv_employees;
END get_employees_table_born_after;
/
-- Call function with formatted string,
-- Display info returned from function in table format
SELECT * FROM TABLE(get_employees_table_born_after('01-JAN-1968'));


-- 3.4.b Create a function that returns all employees who are born after 1968
----------------------------------------RETURNS FORMATTED LIST
----------------------------------------USES FORMATTING WITHOUT TYPE CREATION
-- procedure accepts a cursor and expects certain fields it will iterate through for formatting
CREATE OR REPLACE PROCEDURE get_employees_born_after(pv_date VARCHAR2, employee_cursor OUT SYS_REFCURSOR) IS
BEGIN
    OPEN employee_cursor FOR
		SELECT firstname, lastname, title, birthdate 
		FROM employee 
		WHERE birthdate > TO_DATE(pv_date, 'DD-MON-YYYY') 
		ORDER BY birthdate DESC;
END get_employees_born_after;
/
-- Procedure displays info returned by other procedure
CREATE OR REPLACE PROCEDURE get_employees_list_born_after(pv_date VARCHAR2) IS
employee_cursor SYS_REFCURSOR;
firstname  employee.firstname%TYPE;
lastname   employee.lastname%TYPE;
title      employee.title%TYPE;
birthdate  employee.birthdate%TYPE;
BEGIN
    get_employees_born_after(pv_date, employee_cursor);
    LOOP
        FETCH employee_cursor INTO firstname
								 , lastname
								 , title
								 , birthdate ;
        EXIT WHEN employee_cursor%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(firstname||' '||lastname||' is a '||title||' and was born on '||birthdate||'.');
    END LOOP;
    CLOSE employee_cursor;
END get_employees_list_born_after;
/
-- Execute Procedure
SET SERVEROUTPUT ON
EXECUTE get_employees_list_born_after('01-JAN-1968');

------------------------------------------------------------------------------------------------------------
-- 4.1 Create a stored procedure that selects the first and last names of all the employees.
-- Allow SQL Developer to display DBMS_OUTPUT
SET SERVEROUTPUT ON
-- Create Procedure
CREATE OR REPLACE PROCEDURE get_employee_names IS
	-- Save info to cursor
    CURSOR employee_cursor IS SELECT CONCAT(CONCAT(firstname, ' '), lastname) AS name FROM employee;
BEGIN
	-- Step through cursor and display each name
	FOR i IN EMPLOYEE_CURSOR LOOP
        DBMS_OUTPUT.put_line('Name = '||i.name);
    END LOOP;
END get_employee_names;
/
-- Execute procedure
EXECUTE get_employee_names;

------------------------------------------------------------------------------------------------------------
-- 4.2.1 Create a stored procedure that updates the personal information of an employee
CREATE OR REPLACE PROCEDURE update_employee ( pv_employeeid NUMBER
											, pv_address    VARCHAR2
											, pv_city       VARCHAR2
											, pv_state      VARCHAR2
											, pv_country    VARCHAR2
											, pv_postalcode VARCHAR2
											, pv_phone      VARCHAR2
											, pv_fax        VARCHAR2
											, pv_email      VARCHAR2 ) IS
BEGIN
	-- If an address was passed, update address
	IF(pv_address IS NOT NULL) THEN
		UPDATE employee SET address = pv_address WHERE employeeid = pv_employeeid;
	END IF;
	-- If a city was passed, update city
	IF(pv_city IS NOT NULL) THEN
		UPDATE employee SET city = pv_city WHERE employeeid = pv_employeeid;
	END IF;
	-- If a state was passed, update state
	IF(pv_state IS NOT NULL) THEN
		UPDATE employee SET state = pv_state WHERE employeeid = pv_employeeid;
	END IF;
	-- If a country was passed, update country
	IF(pv_country IS NOT NULL) THEN
		UPDATE employee SET country = pv_country WHERE employeeid = pv_employeeid;
	END IF;
	-- If a postal code was passed, update the postal code
	IF(pv_postalcode IS NOT NULL) THEN
		UPDATE employee SET postalcode = pv_postalcode WHERE employeeid = pv_employeeid;
	END IF;
	-- If a phone number was passed, update the phone number
	IF(pv_phone IS NOT NULL) THEN
		UPDATE employee SET phone = pv_phone WHERE employeeid = pv_employeeid;
	END IF;
	-- If a fax number was passed, update the fax number
	IF(pv_fax IS NOT NULL) THEN
		UPDATE employee SET fax = pv_fax WHERE employeeid = pv_employeeid;
	END IF;
	-- If an email was passed, update the email address
	IF(pv_email IS NOT NULL) THEN
		UPDATE employee SET email = pv_email WHERE employeeid = pv_employeeid;
	END IF;
END update_employee;
/
-- Execute procedure
--      update_employee(employeeid, address, city, state, country, postalcode, phone, fax, email)
EXECUTE update_employee(1         , NULL   , NULL, NULL , 'USA'  , NULL      , NULL , NULL, NULL);
COMMIT;

------------------------------------------------------------------------------------------------------------
-- 4.2.2 Create a stored procedure that returns the managers of an employee.
SET SERVEROUTPUT ON
CREATE OR REPLACE PROCEDURE get_managers(pv_employeeid NUMBER) IS
	lv_name VARCHAR2(30);
	lv_reportsto NUMBER;
    lv_employeeid NUMBER;
    lv_firstname VARCHAR2(20);
    lv_lastname VARCHAR2(20);
BEGIN
    lv_employeeid := pv_employeeid;
	-- Initialize lv_reportsto in order to enter the loop
    lv_reportsto := 0;
    WHILE lv_reportsto IS NOT NULL LOOP
		-- Get the name of this person and the id of who they report to
        SELECT firstname, lastname, reportsto INTO lv_firstname, lv_lastname, lv_reportsto
            FROM employee 
            WHERE employeeid = lv_employeeid;
		-- If they don't report to anyone display that info
        IF lv_reportsto IS NULL THEN
            DBMS_OUTPUT.PUT_LINE(lv_firstname||' '||lv_lastname||' has no managers.');
		-- If they do report to someone display who that is
        ELSE
            DBMS_OUTPUT.PUT_LINE(lv_firstname||' '||lv_lastname||' reports to:');
            lv_employeeid := lv_reportsto;
        END IF;
    END LOOP;
	-- If an invalid employeeid was entered let them know that
	EXCEPTION
		WHEN OTHERS THEN
		DBMS_OUTPUT.PUT_LINE('No Employee Found.');
END;
/
-- Execute Procedure
EXECUTE get_managers(7);

------------------------------------------------------------------------------------------------------------
-- 4.3 Create a stored procedure that returns the name and company of a customer.
-- Create procedure to return formatted name and company name or null
CREATE OR REPLACE PROCEDURE get_name_company(pv_customerid NUMBER, pv_name OUT VARCHAR2, pv_company OUT VARCHAR2) IS
BEGIN
	SELECT CONCAT(CONCAT(firstname,' '), lastname) AS name, company INTO pv_name, pv_company 
	FROM customer 
	WHERE customerid = pv_customerid;
END get_name_company;
/
-- Create procedure to display name and company or no company found message
CREATE OR REPLACE PROCEDURE get_customer_company(pv_customerid NUMBER) IS
lv_name VARCHAR2(60);
lv_company VARCHAR2(80);
BEGIN
	get_name_company(pv_customerid, lv_name, lv_company);
	IF lv_company IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('No Company was found for '||lv_name);
	ELSE
		DBMS_OUTPUT.PUT_LINE(lv_name||' works at '||lv_company||'.');
    END IF;
END get_customer_company;
/
-- Execute procedure
SET SERVEROUTPUT ON
EXECUTE get_customer_company(24);

------------------------------------------------------------------------------------------------------------
-- 5.1 Create a transaction that given a invoiceId will delete that invoice 
CREATE OR REPLACE PROCEDURE delete_invoice(pv_invoiceid NUMBER) IS
BEGIN
	SAVEPOINT remove_invoice;
	-- Delete the invoice lines first
	DELETE FROM invoiceline 
	WHERE invoiceid = pv_invoiceid;
	-- Delete the invoices second
	DELETE FROM invoice
	WHERE invoiceid = pv_invoiceid;
	COMMIT;
	DBMS_OUTPUT.PUT_LINE('Deletion has been committed.');
	-- If one of the deletions failed roll back to the beginning of the transaction
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO remove_invoice;
		DBMS_OUTPUT.PUT_LINE('Deletion has been rolled back.');
END delete_invoice;
/

SET SERVEROUTPUT ON
EXECUTE delete_invoice(129);

------------------------------------------------------------------------------------------------------------
-- 5.2 Create a transaction nested within a stored procedure that inserts a new record in the Customer table
CREATE OR REPLACE PROCEDURE new_customer( pv_customerid NUMBER
										, pv_firstname VARCHAR2
										, pv_lastname VARCHAR2
										, pv_company VARCHAR2
										, pv_address VARCHAR2
										, pv_city VARCHAR2
										, pv_state VARCHAR2
										, pv_country VARCHAR2
										, pv_postalcode VARCHAR2
										, pv_phone VARCHAR2
										, pv_fax VARCHAR2
										, pv_email VARCHAR2
										, pv_supportrepid NUMBER) IS
BEGIN
	SAVEPOINT add_customer;
	INSERT INTO customer VALUES( pv_customerid
							   , pv_firstname
							   , pv_lastname
							   , pv_company
							   , pv_address
							   , pv_city
							   , pv_state
							   , pv_country
							   , pv_postalcode
							   , pv_phone
							   , pv_fax
							   , pv_email
							   , pv_supportrepid );
	COMMIT;
	DBMS_OUTPUT.PUT_LINE('Addition has been committed.');
	-- If the addition failed, roll back to the beginning of the transaction
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO remove_invoice;
		DBMS_OUTPUT.PUT_LINE('Addition has been rolled back.');
END new_customer;
/
SET SERVEROUTPUT ON
--------------------( customerid, firstname*, lastname*, company, address, city, state, country, postalcode, phone, fax, email*, supportrepid )
EXECUTE new_customer( NULL      , 'John'    , 'Doe'    , NULL   , NULL   , NULL, NULL , NULL   , NULL      , NULL , NULL, 'john@doe.com', NULL );

------------------------------------------------------------------------------------------------------------
-- 6.1.1 Create an after insert trigger on the employee table fired after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER employee_t2_after_insert
AFTER INSERT ON employee
FOR EACH ROW
BEGIN
	IF INSERTING THEN
		DBMS_OUTPUT.PUT_LINE(:new.firstname||' '||:new.lastname||' has been added.');
	END IF;
END;
/

-- Add employee to view success message from trigger
SET SERVEROUTPUT ON
BEGIN
	INSERT INTO employee
	( lastname
	, firstname
	, title
	, reportsto
	, birthdate
	, hiredate
	, address
	, city
	, state
	, country
	, postalcode
	, phone
	, fax
	, email)
	VALUES
	( 'Gates'
	, 'Melinda'
	, 'Sales Support Agent'
	, (SELECT employeeid
	  FROM employee
	  WHERE firstname = 'Nancy' AND lastname = 'Edwards')
	, '15-AUG-64'
	, '15-APR-04'
	, '1 Microsoft Way'
	, 'Redmond'
	, 'WA'
	, 'United States of America'
	, '98052'
	, '+1 (425) 882-8080'
	, '+1 (425) 706-7929'
	, 'melinda@chinookcorp.com');
	COMMIT;
END;
/

------------------------------------------------------------------------------------------------------------
-- 6.1.2 Create an after update trigger on the album table that fires after a row is updated in the table
CREATE OR REPLACE TRIGGER album_t2_after_update
AFTER UPDATE ON album
FOR EACH ROW
BEGIN
	IF UPDATING THEN
		DBMS_OUTPUT.PUT_LINE(:old.title||' has been updated.');
	END IF;
END;
/

-- Update album
SET SERVEROUTPUT ON
BEGIN
	UPDATE album SET title = 'Chemical Funeral' WHERE title = 'Chemical Wedding';
END;
/
	
------------------------------------------------------------------------------------------------------------
-- 6.1.3 Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE OR REPLACE TRIGGER album_t2_after_delete
AFTER DELETE ON customer
FOR EACH ROW
BEGIN
	IF DELETING THEN
		DBMS_OUTPUT.PUT_LINE(:old.firstname||' '||:old.lastname||' has been deleted.');
	END IF;
END;
/

-- Update album
SET SERVEROUTPUT ON
BEGIN
	DELETE FROM customer WHERE firstname = 'Fred' AND lastname = 'Flintsone';
END;
/

------------------------------------------------------------------------------------------------------------
-- 7.1 Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT c.firstname, c.lastname, i.invoiceid, i.total 
FROM invoice i INNER JOIN customer c ON i.customerid = c.customerid 
ORDER BY c.lastname ASC, c.firstname ASC;

------------------------------------------------------------------------------------------------------------
-- 7.2 Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT c.customerid, c.firstname, c.lastname, i.invoiceid, i.total 
FROM invoice i FULL OUTER JOIN customer c ON i.customerid = c.customerid 
ORDER BY c.lastname ASC, c.firstname ASC;

------------------------------------------------------------------------------------------------------------
-- 7.3 Create a right join that joins album and artist specifying artist name and title.
SELECT artist.name, album.title 
FROM album RIGHT JOIN artist ON album.artistid = artist.artistid 
ORDER BY artist.name ASC;

------------------------------------------------------------------------------------------------------------
-- 7.4 Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT artist.name, album.title 
FROM artist CROSS JOIN album 
ORDER BY artist.name ASC;

------------------------------------------------------------------------------------------------------------
-- 7.5 Perform a self-join on the employee table, joining on the reportsto column.
SELECT sub.firstname, sub.lastname, super.firstname, super.lastname 
FROM employee sub JOIN employee super ON sub.reportsto = super.employeeid 
ORDER BY super.lastname ASC, super.firstname ASC, sub.lastname ASC, sub.firstname ASC;