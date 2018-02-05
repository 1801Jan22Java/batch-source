/*Chinook Lab Assignment for Revature Week 2
By James Whitten
Due: 2-5-18
*/

--MISC STUFF
SET SERVEROUTPUT ON; 


--SECTIONS 1 and 2

/*Section 2.1  - Select all records from the Employee table.
-Select all records from the Employee table where last name is King.
-Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
*/

SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

/*Section 2.2  – Select all albums in Album table and sort result set in descending order by title.
– Select first name from Customer and sort result set in ascending order by city
*/

SELECT * FROM ALBUM ORDER BY TITLE DESC; 
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY;

/*Section 2.3 - Insert two new records into Genre table 
– Insert two new records into Employee table
– Insert two new records into Customer table
*/

INSERT INTO GENRE (GENREID, NAME)
VALUES (26, 'Country');
INSERT INTO GENRE (GENREID, NAME)
VALUES (27, '8-bit');


INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY,
POSTALCODE, PHONE, FAX, EMAIL)
VALUES (9, 'Wilkinson', 'Tamra', 'Sales Support Agent', 2, '23-MAY-66', '22-OCT-04', '5210 Random Street','Calgary','AB', 'Canada',
'T2P 5G6', '+1 (403) 742-2218', '+1 (403) 742-3318', 'tamra@chinookcorp.com')
INSERT INTO EMPLOYEE (EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY,
POSTALCODE, PHONE, FAX, EMAIL)
VALUES (10, 'Noble', 'Aaron', 'IT Staff', 6, '02-NOV-62', '10-SEP-03', '111 Orange Street','LethBridge','AB', 'Canada',
'T1R 5B4', '+1 (403) 651-1821', '+1 (403) 156-3814', 'aaron@chinookcorp.com');

INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, 
EMAIL, SUPPORTREPID)
VALUES (60, 'TOM', 'ROM', null, '444 Nice Place', 'Santiago', null, 'Chile', null, '+56 0(2) 113 9988', null, 
'namewonder222@gmail.com', 4);
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, 
EMAIL, SUPPORTREPID)
VALUES (61, 'Christina', 'Martinez', null, '666 Bad Place', 'London', null, 'United Kingdom', 'A5 L7K', '+44 020 1131 4286', null, 
'thelasthurrah@yahoo.com', 3);

/* Section 2.4 – Update Aaron Mitchell in Customer table to Robert Walter
– Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”
*/

UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME = 'Walter'
WHERE CUSTOMERID = 32;

UPDATE ARTIST
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

/* Section 2.5 - Select all invoices with a billing address like “T%”
*/

SELECT *
FROM INVOICE
WHERE BILLINGADDRESS LIKE 'T%';

/* Section 2.6 - Select all invoices that have a total between 15 and 50
– Select all employees hired between 1st of June 2003 and 1st of March 2004
*/

SELECT *
FROM INVOICE
WHERE TOTAL BETWEEN 15 AND 50;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

/*Section 2.7 - Delete a record in Customer table where the name is Robert Walter 
(There may be constraints that rely on this, find out how to resolve them).
*/

DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID
                    FROM INVOICE
                    WHERE CUSTOMERID = (SELECT CUSTOMERID
                                        FROM CUSTOMER
                                        WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter'));
                                        
DELETE FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID
                    FROM CUSTOMER
                    WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter');
                    
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walter';

--SECTION 3

/*Section 3.1 - Create a function that returns the current time.
-Create a function that returns the length of name in MEDIATYPE table
*/

CREATE OR REPLACE FUNCTION sendDATE RETURN VARCHAR2 IS 
OUR_DATE VARCHAR2(30);
BEGIN
SELECT TO_CHAR(CURRENT_TIMESTAMP, 'HH:MI:SS') INTO OUR_DATE FROM DUAL;
RETURN OUR_DATE;
END sendDATE;
/

SELECT sendDATE FROM DUAL;

CREATE OR REPLACE FUNCTION mediaNameLength(MID NUMBER) RETURN NUMBER IS
medLength NUMBER;
BEGIN
SELECT LENGTH(NAME) INTO medLength FROM MEDIATYPE WHERE MEDIATYPE.MEDIATYPEID = MID; 
RETURN medLength;
END mediaNameLength;
/

SELECT mediaNameLength(2) FROM DUAL;

/*Section 3.2 – Create a function that returns the average total of all invoices 
– Create a function that returns the most expensive track
*/

CREATE OR REPLACE FUNCTION invoiceTotAverage RETURN NUMBER IS
avTot Float;
BEGIN
SELECT AVG(TOTAL) INTO avTot
FROM INVOICE;
RETURN avTot;
End invoiceTotAverage;
/

SELECT invoiceTotAverage FROM DUAL;

CREATE OR REPLACE FUNCTION expensiveTrack RETURN NUMBER IS
theBigTrack NUMBER;
BEGIN
SELECT MAX(UNITPRICE) INTO theBigTrack
FROM TRACK;
RETURN theBigTrack;
End expensiveTrack;
/

SELECT expensiveTrack FROM DUAL;


/*Section 3.3 – Create a function that returns the average price of invoiceline items in the invoiceline table
*/

CREATE OR REPLACE FUNCTION invoiceLineAv RETURN NUMBER IS
av Float;
BEGIN
SELECT AVG(UNITPRICE) INTO av
FROM INVOICELINE;
RETURN av;
End invoiceLineAv;
/

SELECT invoiceLineAv FROM DUAL;

/*Section 3.4 – Create a function that returns all employees who are born after 1968.
*/

CREATE OR REPLACE FUNCTION getEmpDate(inDate DATE)
RETURN SYS_REFCURSOR AS S SYS_REFCURSOR;
BEGIN
   OPEN S FOR
   SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE WHERE(BIRTHDATE>inDate);  
   RETURN(S);
END;
/

DECLARE
   S SYS_REFCURSOR;
   EMP_FNAME EMPLOYEE.FIRSTNAME%TYPE;
   EMP_LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
   S := getEmpDate('01-JAN-68');
       LOOP
       FETCH S INTO EMP_FNAME, EMP_LNAME;
       EXIT WHEN S%NOTFOUND;
       DBMS_OUTPUT.PUT_LINE(EMP_FNAME|| ', ' || EMP_LNAME);
       END LOOP;
   CLOSE S;
END;
/



--SECTION 4

/*Section 4.1 - – Create a stored procedure that selects the first and last names of all the employees.
*/

CREATE OR REPLACE PROCEDURE nameEmployees (E OUT SYS_REFCURSOR) IS
BEGIN
OPEN E FOR
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE;
END nameEmployees;
/
 
DECLARE
E SYS_REFCURSOR; 
EMP_FNAME EMPLOYEE.FIRSTNAME%TYPE;  
EMP_LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    nameEmployees(E);
    LOOP
        FETCH E INTO EMP_FNAME, EMP_LNAME;
        EXIT WHEN E%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE(EMP_FNAME||' '||EMP_LNAME);
    END LOOP;
    CLOSE E;
END;  
/


/*Section 4.2 – Create a stored procedure that updates the personal information of an employee.
– Create a stored procedure that returns the managers of an employee.
*/

CREATE OR REPLACE PROCEDURE updateEmpInfo(emp NUMBER, pho VARCHAR2, fa VARCHAR2, ema VARCHAR2) AS
BEGIN
UPDATE EMPLOYEE
SET PHONE = pho, FAX = fa, EMAIL = ema
WHERE EMPLOYEEID = emp;
END updateEMPInfo;
/

EXECUTE updateEmpInfo(2, '333-444-5555', '666-777-8888', 'NancyNow@gmail.com');

CREATE OR REPLACE PROCEDURE management(empID NUMBER, M OUT SYS_REFCURSOR) IS
BEGIN
OPEN M FOR
SELECT FIRSTNAME, LASTNAME
FROM EMPLOYEE
WHERE EMPLOYEEID = (SELECT REPORTSTO
                    FROM EMPLOYEE
                    WHERE EMPLOYEEID = empID);
END;
/

DECLARE
M SYS_REFCURSOR; 
EMP_NUMBER EMPLOYEE.EMPLOYEEID%TYPE;
EMP_FNAME EMPLOYEE.FIRSTNAME%TYPE;  
EMP_LNAME EMPLOYEE.LASTNAME%TYPE;
BEGIN
    EMP_NUMBER := 7;
    management(EMP_NUMBER , M);
    LOOP
        FETCH M INTO EMP_FNAME, EMP_LNAME;
        EXIT WHEN M%NOTFOUND; 
        DBMS_OUTPUT.PUT_LINE(EMP_FNAME||' '||EMP_LNAME);
    END LOOP;
    CLOSE M;
END;  
/

/*Section 4.3 – Create a stored procedure that returns the name and company of a customer.
*/

CREATE OR REPLACE PROCEDURE custCompany(cusID NUMBER) IS
CUS_FNAME CUSTOMER.FIRSTNAME%TYPE;
CUS_LNAME CUSTOMER.LASTNAME%TYPE;
CUS_COMP CUSTOMER.COMPANY%TYPE;
BEGIN
SELECT CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, CUSTOMER.COMPANY INTO CUS_FNAME, CUS_LNAME, CUS_COMP
FROM CUSTOMER
WHERE CUSTOMERID = cusID;
DBMS_OUTPUT.PUT_LINE('Customer '||CUS_FNAME||' '||CUS_LNAME||' Works at '||CUS_COMP);
END custCompany;
/

EXECUTE custCompany(15);


--SECTION 5

/* Section 5.0 -Create a transaction that given a invoiceId will delete that invoice 
(There may be constraints that rely on this, find out how to resolve them).
– Create a transaction nested within a stored procedure that inserts a new record in the Customer table
*/

CREATE OR REPLACE PROCEDURE delInvoice(invID NUMBER) IS
BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID
                    FROM INVOICE
                    WHERE INVOICEID = invID);
DELETE FROM INVOICE
WHERE INVOICEID = invID;
COMMIT;
END delInvoice;
/

EXECUTE delInvoice(80);


CREATE OR REPLACE PROCEDURE addCustomer(cusID NUMBER, cusFN VARCHAR2, cusLN VARCHAR2, comp VARCHAR2, addr VARCHAR2,
city VARCHAR2, state VARCHAR2, coun VARCHAR2, post VARCHAR2,phone VARCHAR2,fax VARCHAR2, email VARCHAR2, SUPPORTREPID NUMBER ) 
IS BEGIN
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, 
EMAIL, SUPPORTREPID)
VALUES (cusID, cusFN, cusLN, comp, addr, city, state, coun, post,phone, fax, email, supportrepid);
COMMIT;
END addCustomer;
/

EXECUTE addCustomer(5555, 'Jose', 'Gonzalez', 'Amazon','2222 Neverland Way', 'San Diego', 'California', 'USA', '92121','542723424', '542364622', 'IDoNotKnowAGoodName@yahoo.com', 2);


--SECTION 6

/*Section 6.1 - Create an after insert trigger on the employee table fired after a new record is inserted into the table.
– Create an after update trigger on the album table that fires after a row is inserted in the table
– Create an after delete trigger on the customer table that fires after a row is deleted from the table.
*/

CREATE OR REPLACE TRIGGER empTableFired AFTER 
INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('NEW EMPLOYEE ADDED');
END empTableFired;
/

BEGIN
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY,
POSTALCODE, PHONE, FAX, EMAIL)
VALUES (11, 'Caring', 'Knot', 'IT Staff', 6, '25-JUL-58', '17-SEP-03', '12486 Another Road','LethBridge','AB', 'Canada',
'T1N 5K2', '+1 (403) 602-5193', '+1 (403) 602-5194', 'caring@chinookcorp.com');
END

CREATE OR REPLACE TRIGGER albTabFired AFTER 
UPDATE ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('ALBUM HAS BEEN UPDATED');
END altTabFired;
/

BEGIN
UPDATE ALBUM
SET TITLE = 'A Whole New World'
WHERE ALBUMID = 275;
END

CREATE OR REPLACE TRIGGER delCustFired AFTER 
DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('CUSTOMER HAS BEEN DELETED');
END delCustFired;
/

BEGIN
DELETE FROM INVOICELINE
WHERE INVOICEID IN (SELECT INVOICEID
                    FROM INVOICE
                    WHERE CUSTOMERID = (SELECT CUSTOMERID
                                        FROM CUSTOMER
                                        WHERE FIRSTNAME = 'Jack' AND LASTNAME = 'Smith'));
                                        
DELETE FROM INVOICE
WHERE CUSTOMERID = (SELECT CUSTOMERID
                    FROM CUSTOMER
                    WHERE FIRSTNAME = 'Jack' AND LASTNAME = 'Smith');
                    
DELETE FROM CUSTOMER
WHERE FIRSTNAME = 'Jack' AND LASTNAME = 'Smith';
END


--SECTION 7

/* Section 7.1– Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
*/

SELECT c.FIRSTNAME, c.LASTNAME, i.INVOICEID
FROM CUSTOMER c INNER JOIN INVOICE i
ON c.CUSTOMERID = i.CUSTOMERID;

/*Section 7.2 - Create an outer join that joins the customer and invoice table, 
specifying the CustomerId, firstname, lastname, invoiceId, and total.
*/

SELECT c.CUSTOMERID, c.FIRSTNAME, c.LASTNAME, i.INVOICEID, i.TOTAL
FROM CUSTOMER c FULL OUTER JOIN INVOICE i
ON c.CUSTOMERID = i.CUSTOMERID;

/* Section 7.3 - Create a right join that joins album and artist specifying artist name and title.
*/

SELECT r.NAME, a.TITLE
FROM ALBUM a RIGHT OUTER JOIN ARTIST r
ON a.ARTISTID = r.ARTISTID;

/* Section 7.4 - Create a cross join that joins album and artist and sorts by artist name in ascending order.
*/

SELECT *
FROM ALBUM CROSS JOIN ARTIST
ORDER BY ARTIST.NAME;

/* Section 7.5 -Perform a self-join on the employee table, joining on the reportsto column.
*/

SELECT *
FROM EMPLOYEE A, EMPLOYEE B
WHERE A.REPORTSTO = B.EMPLOYEEID;





