-- 2.1
-- Selecting All records in Employee TABLE
SELECT *
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King';


SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'King' AND REPORTSTO = NULL;

-- 2.2 ORDER BY

SELECT *
  FROM "Album"
ORDER BY "Title" DESC 

SELECT FIRSTNAME
  FROM CUSTOMER
ORDER BY CITY

-- 2.3 Insert Into

INSERT INTO GENRE (GenreID, Name) VALUES (26, 'Electro-Swing');
INSERT INTO GENRE (GenreID, Name), VALUE (27, 'Polkka Rap');

INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (1, 'Blumberg', 'Leonard', 'IT Staff', 1, TO_DATE('1994-3-3 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2017-9-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '13025 Silver Creek Drive', 'Austin', 'TX', 'United States', 'T5K 2N1', '+1 (512) 111-2222', '+1 (780) 428-3485', 'Leonard@chinookcorp.com');
INSERT INTO Employee (EmployeeId, LastName, FirstName, Title, ReportsTo, BirthDate, HireDate, Address, City, State, Country, PostalCode, Phone, Fax, Email) VALUES (1, 'Jackson', 'Michael', 'Live Performer', 1, TO_DATE('1953-8-29 00:00:00','yyyy-mm-dd hh24:mi:ss'), TO_DATE('2017-9-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '10000 Pop Music Dr', 'Hollywood', 'CA', 'United States', 'T5K 2N1', '+1 (222) 333-4444', '+1 (780) 428-3867', 'MichaelJ@chinookcorp.com');

INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId), VALUES (1001, 'Johnny', 'Cash', 'Folsom Prison', '123 Cocaine Blues Dr', 'Ciudad Juarez', 'Cihuahua', 'Mexico', '123456', '+2 211-985-6665', '2+ 265-556-6235', 'manInBlack@folsom.prison.com', 5);
INSERT INTO CUSTOMER (CustomerId, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId), VALUES (1001, 'George', 'Washington', 'United States Military', '234 Arlington Cemetary', 'Washington DC', 'District of Columbia', '20160', '123456', '+1 555-555-6666', '+1 888-555-6235', 'GeorgeWashington@whathehellisemail.com', 5);

-- 2.4 Update

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE ARTIST
SET Name = 'CCR'
WHERE Name = 'Creedence Clearwater Revival';

-- 2.5 LIKE

SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

-- 2.6 BETWEEN

SELECT * 
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

-- 2.7 DELETE
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID
                    FROM INVOICE
                    WHERE CUSTOMERID= (SELECT CUSTOMERID
                                        FROM CUSTOMER
                                        WHERE FIRSTNAME= 'Robert' AND LASTNAME= 'Walter'));
                                        
DELETE FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID 
                    FROM CUSTOMER
                    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
                    
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

-- 3.1 System Defined Functions

CREATE OR REPLACE FUNCTION cur_time
RETURN VARCHAR2
IS
  now VARCHAR2(20);
BEGIN
  SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') INTO now FROM DUAL;
  RETURN now;
END;
/

CREATE OR REPLACE FUNCTION name_length
RETURN NUMBER
IS
  len NUMBER;
BEGIN
  SELECT LENGTH(NAME) INTO len FROM MEDIATYPE
  WHERE NAME='MPEG Audio File';
  RETURN len;
END;
/

-- 3.2 System Defined Aggregate functions 
SELECT AVG (TOTAL) 
FROM INVOICE;

SELECT MAX (UNITPRICE) 
FROM TRACK;


--3.3 USER DEFINED SCALAR FUNCTIONS 

SELECT AVG(UNITPRICE)
FROM INVOICELINE;

-- 4.1 USER DEFINED TABLE VALUED FUNCTIONS 

CREATE OR REPLACE PROCEDURE EMPLOYEE_NAMES AS
fName VARCHAR(20);
lName VARCHAR(20);
BEGIN
  SELECT FirstName, LastName INTO fName, LName
  FROM EMPLOYEE;
END EMPLOYEE_NAMES;
/

-- 4.2 STORED PROCEDURE INPUT PARAMETERS

CREATE OR REPLACE PROCEDURE peacock_peahen AS
BEGIN
  UPDATE EMPLOYEE
  SET LastName = 'Peahen'
  WHERE LastName = 'Peacock';
END peacock_peahen;
/
-- Ms. Peacock is now Ms. Peahen 

CREATE OR REPLACE PROCEDURE manager_of
(emp_id NUMBER)
AS
f_name VARCHAR(20); -- MANAGER'S FIRST / LAST NAME
l_name VARCHAR(20);
m_id NUMBER; -- MANAGER'S ID
BEGIN
  SELECT FirstName, LastName, EmployeeID INTO f_name, l_name, m_id
  FROM EMPLOYEE
  WHERE EmployeeID IN (SELECT ReportsTo
                        FROM EMPLOYEE
                        WHERE EmployeeId = emp_id);
END manager_of;
/

-- 4.3 STORED PROCEDURE OUTPUT PARAMETERS

CREATE OR REPLACE PROCEDURE name_and_company
(CId NUMBER)
AS
cust_first_name VARCHAR(20);
cust_last_name VARCHAR(20);
cust_company VARCHAR(20);
BEGIN
  SELECT FirstName, LastName, Company INTO cust_first_name, 
  cust_last_name, cust_company
  FROM CUSTOMER
  WHERE CustomerId = CId;
END name_and_company;
/

-- 5.0 TRANSACTIONS





