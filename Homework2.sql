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
SELECT GENREID + 1,'LOFI' FROM GENRE WHERE ROWNUM <=1 ORDER BY GENREID DESC;

--instead of hard coding the genreid, i pulled the last found genre id and incremented
--it and used it to insert a new genre to the table
INSERT INTO GENRE (GENREID,NAME)
SELECT GENREID + 1,'K-pop' FROM GENRE WHERE ROWNUM <=1 ORDER BY GENREID DESC;

/*
2.3 TASK 2 - insert two new records into Employee table
*/

--instead of hard coding the employeeid, i pulled the last found employee id and incremented
--it and used it to insert a new genre to the table
INSERT INTO EMPLOYEE (EMPLOYEEID,LASTNAME,FIRSTNAME,TITLE,REPORTSTO,BIRTHDATE,HIREDATE,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL)
SELECT EMPLOYEEID + 1,'Jackson','Peter','Junior IT Staff',NULL,TO_DATE('1990-1-10 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '213 S Temple Drive', 'Milpitas', 'CA', 'United States of America',
   '95035', '(123) 456-7890', '+1 (403) 467-8772', 'pokemonMaster@gmail.com'
FROM EMPLOYEE WHERE ROWNUM <=1 ORDER BY EMPLOYEEID DESC;

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
SELECT EMPLOYEEID + 1,'Chan','Conan','Master of Cheese',NULL,TO_DATE('1993-9-16 00:00:00','yyyy-mm-dd hh24:mi:ss'),TO_DATE('2018-1-31 00:00:00','yyyy-mm-dd hh24:mi:ss'), '213 S Temple Drive', 'Milpitas', 'CA', 'United States of America',
   '95035', '(123) 456-7890', '+1 (403) 467-8772', 'conanIsReallyCool@gmail.com'
FROM EMPLOYEE WHERE ROWNUM <=1 ORDER BY EMPLOYEEID DESC;

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
SELECT CUSTOMERID + 1, 'Chan','Jackie','Dragon Fist Co.','777 Lucky Dragon Ln.','San Francisco','CA','United States of America','90210','(987) 654-3210','+1 (123) 456-7890','KungFu@master.com',NULL
FROM CUSTOMER WHERE ROWNUM <=1 ORDER BY CUSTOMERID DESC;

--instead of hard coding the supportrepid i updated the entry with a select to the IT Manager
UPDATE CUSTOMER
SET SUPPORTREPID = (SELECT EMPLOYEEID
                 FROM EMPLOYEE
                 WHERE TITLE = 'IT Manager')
WHERE FIRSTNAME = 'Jackie' AND LASTNAME = 'Chan';

--instead of hard coding the customerid, i pulled the last found customerid and incremented
--it and used it to insert a new genre to the table; the supportrepid is hard coded in this query
INSERT INTO CUSTOMER (CUSTOMERID,LASTNAME,FIRSTNAME,COMPANY,ADDRESS,CITY,STATE,COUNTRY,POSTALCODE,PHONE,FAX,EMAIL,SUPPORTREPID)
SELECT CUSTOMERID + 1, 'Duck','Donald',NULL,'Ducky Duck Dr.','Houston','TX','United States of America','77352','(936) 654-3210','+1 (484) 456-7890','DuckyMcDuck@DuckFace.com',4
FROM CUSTOMER WHERE ROWNUM <=1 ORDER BY CUSTOMERID DESC;

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