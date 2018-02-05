//Chinook Lab
--2.1 SELECT
SELECT * FROM EMPLOYEE;

SELECT * FROM EMPLOYEE
WHERE LASTNAME= 'King'

SELECT * FROM EMPLOYEE 
WHERE LASTNAME= 'ANDREW' AND REPORTSTO= NULL;

--2.2 ORDER BY
SELECT * ALBUMS 
FROM ALBUM
ORDER BY TITLE DESC;

SELECT FIRSTNAME
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3 INSERT INTO
INSERT INTO GENRE(GENREID, NAME)
VALUES(26, 'Baby Metal');

INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9, 'Doe', 'John', 'Human Resources', 1, 31-FEB-99, 01-JAN-01, '312 Wilshire RD', 'Edmonton', 'AB', 'Canada', 'T5 2N1', '+ (780) 597-1659', '+1 (780) 597-1658','john@chinookcorp.org');

INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, PHONE, FAX, EMAIL, SUPPORTEPID)
VALUES(60, 'Bill', 'Gates', 'Microsoft', '1543 technology way', 'Silicon Valley', 'CA', 'United States', 92785, '+1 (782) 875-1685', '+1 (782) 875-1686', 'bgates@yahoo.com', 4);

--2.4 UPDATE
UPDATE CUSTOMER
SET FIRSTNAME= 'Robert', LASTNAME= 'Walter'
WHERE FIRSTNAME= 'Aaron' AND LASTNAME= 'Mitchell'; 

UPDATE ARTIST
SET 'CCR'
WHERE NAME= 'Creedence Clearwater Revival';

--2.5 LIKE
SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

--2.6 BETWEEN
SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-2003' AND '01-MAR-2004'


--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints
--that rely on this, find out how to resolve them).
DELETE FROM CUSTOMER
WHERE FIRSTNAME= 'Robert' AND LASTNAME= 'Walter';


--3.1 System Defined Functions
--Task – Create a function that returns the current time.
CREATE OR REPLACE FUNCTION SEND_DATE RETURN VARCHAR IS
OUR_DATE VARCHAR (30);
BEGIN
SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS') INTO OUR_DATE FROM DUAL;
RETURN OUR_DATE;
END SEND_DATE;

SELECT OUR_DATE FROM DUAL;

--Task – create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME)
FROM MEDIATYPE;

--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices
SELECT AVG(TOTAL)
	FROM INVOICE;
	
--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE)
	FROM TRACK;

--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table	
SELECT AVG(UNITPRICE)
	FROM INVOICELINE;


--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.
SELECT FIRSTNAME, LASTNAME, BIRTHDATE
	FROM EMPLOYEE
	WHERE BIRTHDATE > date '1968-01-01';

--4.0 Stored Procedures
--In this section you will be creating and executing stored procedures. You will be creating various types
--of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.
CREATE OR REPLACE PROCEDURE GET_ALL_EMPLOYEES (T OUT SYS_REFCURSOR)
IS
BEGIN
OPEN T FOR
SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
END;
/
DECLARE
T SYS_REFCURSOR; 
EMPLOYEE_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE; 
EMPLOYEE_LASTNAME EMPLOYEE.LASTNAME%TYPE;

BEGIN
    GET_ALL_EMPLOYEES(T);
    LOOP
        FETCH T INTO EMPLOYEE_FIRSTNAME, EMPLOYEE_LASTNAME;
        EXIT WHEN T%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE(EMPLOYEE_FIRSTNAME|| ' ' ||EMPLOYEE_LASTNAME);
    END LOOP;
    CLOSE T;
END;	

--4.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EMPLOYEE_INFO_UPDATE(
								emp_id IN EMPLOYEE.EMPLOYEEID%TYPE,
								emp_first IN EMPLOYEE.FIRSTNAME%TYPE,
								emp_last IN EMPLOYEE.LASTNAME%TYPE,
								emp_title IN EMPLOYEE.TITLE%TYPE,
								emp_reportsto IN EMPLOYEE.REPORTSTO%TYPE,
								emp_birthdate IN EMPLOYEE.BIRTHDATE%TYPE,
								emp_hiredate IN EMPLOYEE.HIREDATE%TYPE,
								emp_address IN EMPLOYEE.ADDRESS%TYPE,
								emp_city IN EMPLOYEE.CITY%TYPE,
								emp_state IN EMPLOYEE.STATE%TYPE,
								emp_country IN EMPLOYEE.COUNTRY%TYPE,
								emp_postalcode IN EMPLOYEE.POSTALCODE%TYPE,
								emp_phone IN EMPLOYEE.PHONE%TYPE,
								emp_fax IN EMPLOYEE.FAX%TYPE,
								emp_email IN EMPLOYEE.EMAIL%TYPE)
													
IS
BEGIN
	INSERT INTO EMPLOYEE(
		"EMPLOYEEID", "FIRSTNAME", "LASTNAME", "TITLE", "REPORTSTO", "BIRTHDATE",
		"HIREDATE", "ADDRESS", "CITY", "STATE", "COUNTRY", "POSTALCODE", "PHONE", "FAX", "EMAIL")
		VALUES(emp_id, emp_first, emp_last, emp_title, emp_reportsto, emp_birthdate, emp_hiredate, emp_address,
				emp_city, emp_state, emp_country, emp_postalcode, emp_phone, emp_fax, emp_email);
COMMIT;

END;
/

--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE GET_EMPLOYEE_MANAGER (S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME, REPORTSTO FROM EMPLOYEE;
END;
/

DECLARE
S SYS_REFCURSOR;
FIRST_NAME EMPLOYEE.FIRSTNAME%TYPE;
LAST_NAME EMPLOYEE.LASTNAME%TYPE;
REPORTS_TO EMPLOYEE.REPORTSTO%TYPE;

BEGIN
    GET_EMPLOYEE_MANAGER(S);
    LOOP
        FETCH S INTO FIRST_NAME, LAST_NAME, REPORTS_TO;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE(FIRST_NAME || ' ' ||LAST_NAME|| ' REPORTS TO ' ||REPORTS_TO); 
    END LOOP;
    CLOSE S;
END;

--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE GET_CUSTOMER_COMPANY (S OUT SYS_REFCURSOR)
IS
BEGIN
OPEN S FOR
SELECT FIRSTNAME, LASTNAME, COMPANY FROM CUSTOMER;
END;
/

DECLARE
S SYS_REFCURSOR;
FIRST_NAME CUSTOMER.FIRSTNAME%TYPE;
LAST_NAME CUSTOMER.LASTNAME%TYPE;
COMPANY CUSTOMER.COMPANY%TYPE;

BEGIN
    GET_CUSTOMER_COMPANY(S);
    LOOP
        FETCH S INTO FIRST_NAME, LAST_NAME, COMPANY;
        EXIT WHEN S%NOTFOUND;
        DBMS_OUTPUT.PUT_LINE('Name: ' || FIRST_NAME || ' ' ||LAST_NAME|| ' Company: ' ||COMPANY); 
    END LOOP;
    CLOSE S;
END;

--5.0 Transactions
--In this section you will be working with transactions. 
--Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that
--rely on this, find out how to resolve them).
CREATE OR REPLACE PROCEDURE DELETE_INVOICE (INVOICE_ID NUMBER)
AS 
tot_inv NUMBER;
	BEGIN
		DELETE FROM INVOICE
		WHERE INVOICE.INVOICEID = DELETE_INVOICE.INVOICE_ID;
tot_inv := tot_inv -1;
END;

--Task – Create a transaction nested within a stored procedure 
--that inserts a new record in the Customer table

CREATE OR REPLACE PROCEDURE NEW_CUSTOMER(
	   c_customerid IN CUSTOMER.CUSTOMERID%TYPE,
	   c_firstname IN CUSTOMER.FIRSTNAME%TYPE,
	   c_lastname IN CUSTOMER.LASTNAME%TYPE,
	   c_company IN CUSTOMER.COMPANY%TYPE,
	   c_address IN CUSTOMER.ADDRESS%TYPE,
	   c_city IN CUSTOMER.CITY%TYPE,
	   c_state IN CUSTOMER.STATE%TYPE,
	   c_country IN CUSTOMER.COUNTRY%TYPE,
	   c_postalcode IN CUSTOMER.POSTALCODE%TYPE,
	   c_phone IN CUSTOMER.PHONE%TYPE,
	   c_fax IN CUSTOMER.FAX%TYPE,
	   c_email IN CUSTOMER.EMAIL%TYPE,
	   c_supportrepid IN CUSTOMER.SUPPORTREPID%TYPE)
IS
	BEGIN
		INSERT INTO CUSTOMER(
		"CUSTOMERID", "FIRSTNAME", "LASTNAME", "COMPANY", "ADDRESS", "CITY",
		"STATE", "COUNTRY", "POSTALCODE", "PHONE", "FAX", "EMAIL", "SUPPORTREPID")
		VALUES(c_customerid, c_firstname, c_lastname, c_company, c_address,
		c_city, c_state, c_country, c_postalcode, c_phone, c_fax, c_email, c_supportrepid);

		ALTER TABLE CUSTOMER
		ADD REFFERED_BY VARCHAR2; 
		
		COMMIT;
END;
/

--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired 
--after a new record is inserted into the table.
CREATE OR REPLACE TRIGGER FOLLOW_INSERT
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
	UPDATE EMPLOYEE
	SET TITLE = 'IT Staff'
	WHERE REPORTSTO= 6;
END;

--Task – Create an after update trigger on the album table that fires 
--after a row is inserted in the table
CREATE OR REPLACE TRIGGER HIREDATE_UPDATE
AFTER UPDATE ON EMPLOYEE
FOR EACH ROW
WHEN(NEW.REPORTSTO = NULL)
BEGIN
	UPDATE EMPLOYEE
	SET TITLE = 'Sales Support Agent'
	WHERE REPORTSTO= 2;
END;

--Task – Create an after delete trigger on the customer table
--That fires after a row is deleted from the
CREATE OR REPLACE TRIGGER trigger_name
AFTER DELETE ON CUSTOMER
FOR EACH ROW 
DECLARE
	username VARCHAR2(10);
BEGIN
	SELECT user INTO username FROM DUAL;
	INSERT INTO CUSTOMER VALUES(:OLD.CUSTOMERID, :OLD.FIRSTNAME, :OLD.LASTNAME, :OLD.COMPANY, :OLD.ADDRESS, :OLD.CITY, 
	:OLD.STATE, :OLD.COUNTRY, :OLD.POSTALCODE, :OLD.PHONE, :OLD.FAX, :OLD.EMAIL, :OLD.SUPPORTREPID);	
END;

--7.0 Joins
--7.1 Inner
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and
--the invoiceId.
SELECT INVOICE.INVOICEID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME
FROM (INVOICE
INNER JOIN CUSTOMER ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID);

--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId,
--firstname, lastname, invoiceId, and total.
SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM CUSTOMER
FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.INVOICEID
ORDER BY CUSTOMER.CUSTOMERID;

--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT ARTIST.NAME, ALBUM.TITLE
FROM ARTIST
RIGHT JOIN ALBUM
ON ALBUM.ALBUMID = ARTIST.ARTISTID
ORDER BY ARTIST.ARTISTID;

--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT *
FROM ALBUM
CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT e1.FIRSTNAME|| ' reports to ' ||e2.REPORTSTO
FROM EMPLOYEE e1, EMPLOYEE e2
WHERE e1.EMPLOYEEID = e2.REPORTSTO;




