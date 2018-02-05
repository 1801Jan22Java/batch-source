--SELECT Statements
--2.1.1 Ok.
SELECT * FROM EMPLOYEE;
--2.1.2 Ok.
SELECT * FROM EMPLOYEE WHERE LASTNAME = 'King';
--2.1.3 Ok.
SELECT * FROM EMPLOYEE WHERE FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL;

--ORDER BY Statements
--2.2.1 Ok.
SELECT * FROM ALBUM ORDER BY TITLE DESC;
--2.2.2 Ok.
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY ASC;

--INSERT INTO
--2.3.1 Ok.
INSERT INTO GENRE(GENREID, NAME) VALUES (26, 'Natural');
INSERT INTO GENRE VALUES (27, 'J-Pop');
SELECT * FROM GENRE WHERE GENREID = 26 OR GENREID = 27;

--2.3.2 Ok.
INSERT INTO EMPLOYEE(EMPLOYEEID, FIRSTNAME, LASTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(9, 'Mack', 'Snider', 'IT Staff', 6, '23-OCT-75', '06-JAN-06', '1234 Example St', 'Rando', 'AB', 'Canada', 'T3J 8T4', '+1 (555) 555-5555', '+1 (403) 555-5555', 'mack@chinookcorp.com');
INSERT INTO EMPLOYEE 
VALUES(10, 'George', 'Bateman', 'Assistant General Manager', 1, '03-DEC-82', '11-JUL-05', '6453 Example St', 'Rando', 'AB', 'Canada', 'T1R 5A4', '+1 123 (456)-7890', '+1 (098) 765-4321', 'george@chinookcorp.com');
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID BETWEEN 9 AND 10;

--2.3.3 Ok.
INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
VALUES(60, 'John', 'Smith', '!', '2521 Lala Dr', 'Boring', 'MA', 'US', '67432', '+1 (342) 233-4352', NULL, 'johnS@bang.com', 5);
INSERT INTO CUSTOMER
VALUES(61, 'Albert', 'Spiegel', 'Bees?', '7455 Honey Lane', 'Queen', 'WA', 'US', '13455', '+1 (364) 394-1359', NULL, 'sAlbert@bees.com', 3);
SELECT * FROM CUSTOMER WHERE CUSTOMERID BETWEEN 60 AND 61;

--UPDATE
--2.4.1 Ok.
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 32;
UPDATE CUSTOMER SET FIRSTNAME = 'Robert', LASTNAME='Walter' WHERE FIRSTNAME='Aaron' AND LASTNAME='Mitchell';
SELECT * FROM CUSTOMER WHERE CUSTOMERID = 32;
--2.4.2 Ok.
SELECT * FROM ARTIST WHERE ARTISTID = 76;
UPDATE ARTIST SET NAME = 'CCR' WHERE NAME='Creedence Clearwater Revival';
SELECT * FROM ARTIST WHERE ARTISTID = 76;

--LIKE
--2.5.1 Ok.
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--BETWEEN
--2.6.1 Ok.
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--2.6.2 Ok.
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04';

--DELETE
--2.7.1 Ok. NOTE: To delete the entry Robert Walter, we must also delete all entries that rely on this entry, hence the
-- DELETE statements for INVOICELINE and INVOICE.
SELECT * FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
DELETE FROM INVOICELINE WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN 
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter'));
DELETE FROM INVOICE WHERE CUSTOMERID IN 
(SELECT CUSTOMERID AS cID FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter');
DELETE FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';
SELECT * FROM CUSTOMER WHERE FIRSTNAME='Robert' AND LASTNAME='Walter';

--Fun W/ Functions!
--System Defined Functions
--3.3.1 Ok. NOTE: To call a function like what follows, you must SELECT [function] FROM DUAL. DUAL is a dummy table provided
-- specifically for things like this.
CREATE OR REPLACE FUNCTION WHATS_MY_DATE 
RETURN DATE 
IS BEGIN 
RETURN CURRENT_DATE; 
END;
/
SELECT WHATS_MY_DATE FROM DUAL;

--3.3.2 Ok.
CREATE OR REPLACE FUNCTION NAME_LENGTH_MEDIATYPE 
RETURN NUMBER 
IS 
length_media_type NUMBER;
BEGIN 
SELECT MAX(LENGTH(M.NAME)) INTO length_media_type FROM MEDIATYPE M;
RETURN length_media_type;
END;
/
SELECT NAME_LENGTH_MEDIATYPE FROM DUAL;

--System Defined Aggregate Functions
--3.2.1 Ok.
CREATE OR REPLACE FUNCTION avg_Invoice 
RETURN NUMBER
IS 
avgTotal NUMBER;
BEGIN
SELECT AVG(TOTAL) INTO avgTotal FROM INVOICE;
RETURN avgTotal; 
END;
/
SELECT avg_Invoice FROM DUAL;

--3.2.2 Ok.
CREATE OR REPLACE FUNCTION max_Price_Track 
RETURN NUMBER
IS 
mUNITPRICE NUMBER;
BEGIN 
SELECT MAX(UNITPRICE) INTO mUNITPRICE FROM TRACK;
RETURN mUNITPRICE; 
END;
/
SELECT max_Price_Track FROM DUAL;

--User Defined Aggregate Scalar Functions
--3.3.1 Ok.
CREATE OR REPLACE FUNCTION avg_InvoiceLine_Price 
RETURN NUMBER
IS
avg_price NUMBER;
BEGIN SELECT AVG(UNITPRICE) INTO avg_price FROM INVOICELINE;
RETURN avg_price;
END;
/
SELECT avg_InvoiceLine_Price FROM DUAL;

--User Defined Table Functions
--3.4.1 Not ok. Could not get this to work. Not sure if I wasn't declaring types correctly, or if I was supposed to be using a cursor.
--CREATE TYPE why_though AS TABLE OF EMPLOYEE%ROWTYPE;
--/
--CREATE OR REPLACE FUNCTION after_1968 
--RETURN why_though
--AS 
--results why_though;
--BEGIN  
--SELECT * INTO results FROM EMPLOYEE WHERE YEAR(BIRTHDATE) > 1968;
--RETURN results;
--END after_1968;
--/
--SELECT after_1968 FROM DUAL;

--Stored Procedures
--Basic Stored Procedure
--4.1.1 Ok. However, I should have known to turn on the DBMS output and enable it for the session.
CREATE OR REPLACE PROCEDURE getFirstAndLast
AS
BEGIN
 FOR flrow IN (SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE) LOOP
    dbms_output.put_line(flrow.FIRSTNAME || ' ' || flrow.LASTNAME);
 END LOOP;
END getFirstAndLast;
/
EXECUTE getFirstAndLast();

--4.2.1 Personal details was a little vague, so I interpreted it as a choice of what details to update
-- It makes sense to create a procedure that deals with specific updates, such as change of address or last name.
-- Also, the Hungarian notation, probably not preferable, but I'm using it anyways.
-- Ok.
CREATE OR REPLACE PROCEDURE updateEmployeeAddress(p_employeeid NUMBER,
                                                  p_address    VARCHAR2,
                                                  p_city       VARCHAR2,
                                                  p_state      VARCHAR2,
                                                  p_country    VARCHAR2,
                                                  p_postal     VARCHAR2)
AS
BEGIN
    UPDATE EMPLOYEE SET ADDRESS = p_address, CITY = p_city, STATE = p_state, COUNTRY =  p_country, POSTALCODE =  p_postal WHERE EMPLOYEEID = p_employeeid;
END;
/
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 10;
EXECUTE updateEmployeeAddress(10, '1213 Poor Lane', 'Decision', 'VA', 'USA', '00000');
SELECT * FROM EMPLOYEE WHERE EMPLOYEEID = 10;
                                           
--4.2.2
CREATE OR REPLACE PROCEDURE whoManages( p_employeeid NUMBER, p_out_first OUT VARCHAR2, p_out_last OUT VARCHAR2) AS
BEGIN
    SELECT FIRSTNAME, LASTNAME INTO p_out_first, p_out_last FROM EMPLOYEE WHERE EMPLOYEEID = 
        (SELECT REPORTSTO FROM EMPLOYEE WHERE EMPLOYEEID = p_employeeid);
END;
/
-- Outputs Michael Mitchell, the correct manager.
DECLARE
    v_first VARCHAR2(20 BYTE);
    v_last  VARCHAR2(20 BYTE);
BEGIN
    whoManages(9, v_first, v_last);
    dbms_output.put_line(v_first || ' ' || v_last);
END;
/

--4.3.1
CREATE OR REPLACE PROCEDURE nameAndCompany(p_customerid NUMBER, p_out_first OUT VARCHAR2, p_out_last OUT VARCHAR2, p_out_company OUT VARCHAR2)
AS
BEGIN
    SELECT FIRSTNAME, LASTNAME, COMPANY INTO p_out_first, p_out_last, p_out_company FROM CUSTOMER WHERE CUSTOMERID = p_customerid;
END;
/

DECLARE
    v_first   VARCHAR2(20 BYTE);
    v_last    VARCHAR2(20 BYTE);
    v_company VARCHAR2(80 BYTE);
BEGIN
    nameAndCompany(60, v_first, v_last, v_company);
    dbms_output.put_line('Name: ' || v_first || ' ' || v_last || ' Company: ' || v_company);
END;
/

--Transactions
--5.1.1
CREATE OR REPLACE PROCEDURE deleteInvoice(p_invoiceid NUMBER)
AS
BEGIN
    DELETE FROM INVOICELINE WHERE INVOICEID = p_invoiceid;
    DELETE FROM INVOICE WHERE INVOICEID = p_invoiceid;
END;
/

SELECT * FROM INVOICE WHERE INVOICEID = 216;
EXECUTE deleteInvoice(216);
SELECT * FROM INVOICE WHERE INVOICEID = 216;

--5.1.2
-- NOTE: For this one and the previous, I am omitting the commit statement that would save these changes to the database.
CREATE OR REPLACE PROCEDURE createNewCustomer(p_customerid NUMBER,
                                    p_first       VARCHAR2,
                                    p_last        VARCHAR2,
                                    p_company     VARCHAR2,
                                    p_address     VARCHAR2,
                                    p_city        VARCHAR2,
                                    p_state       VARCHAR2,
                                    p_country     VARCHAR2,
                                    p_postal      VARCHAR2,
                                    p_phone       VARCHAR2,
                                    p_fax         VARCHAR2,
                                    p_email       VARCHAR2,
                                    p_support     NUMBER)
AS
BEGIN
    INSERT INTO CUSTOMER(CUSTOMERID, FIRSTNAME, LASTNAME, COMPANY, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL, SUPPORTREPID)
    VALUES(p_customerid, p_first, p_last, p_company, p_address, p_city, p_state, p_country, p_postal, p_phone, p_fax, p_email, p_support);
END;
/

--Could use a sequence here.
EXECUTE createNewCustomer(84, 'Tired', 'Late', 'Up@Night', '5142 Oops Drive', 'Boring', 'CA', 'USA', '01230', '+1 (253) 342-9438', '+1 (423) 543-6894', 'example@UpNights.com', 4);

--Triggers
--6.1.1
CREATE OR REPLACE TRIGGER afterEmployeeInsert AFTER INSERT ON EMPLOYEE
BEGIN
    dbms_output.put_line('And verily did the user insert upon ye table of employee.');
END;
/
--Triggers only fire after commits! That was not in my notes.
INSERT INTO EMPLOYEE(EMPLOYEEID, LASTNAME, FIRSTNAME, TITLE, REPORTSTO, BIRTHDATE, HIREDATE, ADDRESS, CITY, STATE, COUNTRY, POSTALCODE, PHONE, FAX, EMAIL)
VALUES(100, 'Grand', 'Poobah', 'Gamu', NULL, '01-JAN-1962', '01-JAN-1980', 'Everywhere', 'Nowhere', 'WC', 'GB', '55555', NULL, NULL, 'gamu@gamu.com');
commit;

--6.1.2
CREATE OR REPLACE TRIGGER afterAlbumUpdate AFTER UPDATE ON ALBUM
BEGIN
    dbms_output.put_line('When you update, I trigger.');
END;
/

UPDATE ALBUM SET TITLE = 'LiftFace' WHERE ALBUMID = 7;
commit;

--6.1.3
CREATE OR REPLACE TRIGGER afterCustomerDelete AFTER DELETE ON CUSTOMER
BEGIN
    dbms_output.put_line('Goodbye forever!');
END;
/

SELECT * FROM CUSTOMER WHERE FIRSTNAME='Kara' AND LASTNAME='Nielson';
DELETE FROM INVOICELINE WHERE INVOICEID IN (SELECT INVOICEID FROM INVOICE WHERE CUSTOMERID IN 
(SELECT CUSTOMERID FROM CUSTOMER WHERE FIRSTNAME='Kara' AND LASTNAME='Nielson'));
DELETE FROM INVOICE WHERE CUSTOMERID IN 
(SELECT CUSTOMERID AS cID FROM CUSTOMER WHERE FIRSTNAME='Kara' AND LASTNAME='Nielson');
DELETE FROM CUSTOMER WHERE FIRSTNAME='Kara' AND LASTNAME='Nielson';
commit;

--Joyful Joins
--Inner Join
--7.1.1
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--Outer Join
--7.2.1
SELECT CUSTOMER.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID;

--Right Join
--7.3.1
SELECT NAME, TITLE FROM ARTIST RIGHT JOIN ALBUM ON ARTIST.ARTISTID = ALBUM.ARTISTID;

--Cross Join
--7.4.1
SELECT * FROM ARTIST CROSS JOIN ALBUM ORDER BY ARTIST.NAME ASC;

--Self Join
--7.5.1
SELECT * FROM EMPLOYEE x, EMPLOYEE y WHERE x.REPORTSTO = y.EMPLOYEEID;