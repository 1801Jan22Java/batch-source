alter session set current_schema = CHINOOK;

--2.0 SQL Queries

--2.1
SELECT *
FROM EMPLOYEE;

SELECT *
FROM EMPLOYEE
WHERE LASTNAME = 'KING';

SELECT *
FROM EMPLOYEE
WHERE FIRSTNAME = 'ANDREW' and REPORTSTO = NULL;

--2.2
SELECT *
FROM ALBUM 
ORDER BY TITLE DESC;

SELECT *
FROM CUSTOMER
ORDER BY CITY ASC;

--2.3
INSERT INTO Genre
VALUES (26, 'Hair Metal');

INSERT INTO Genre
VALUES (27, 'Math Rock');

INSERT INTO Employee
VALUES (777, 'Bridges', 'Jeff', 'The Boss', NULL, TO_DATE('1985-2-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
        TO_DATE('2001-2-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '777 Lucky Street', 'Las Vegas', 'Nevada', 'USA', '777', '777-777-7777', 
        '777', 'JeffBridges@myspace.com');
        
INSERT INTO Employee
VALUES (778, 'Bridges', 'Jeff', 'The Boss', NULL, TO_DATE('1985-2-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), 
        TO_DATE('2001-2-14 00:00:00','yyyy-mm-dd hh24:mi:ss'), '777 Lucky Street', 'Las Vegas', 'Nevada', 'USA', '777', '777-777-7777', 
        '777', 'JeffBridges@myspace.com');
        
INSERT INTO Customer
VALUES (88, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 
        'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
        
INSERT INTO Customer
VALUES (89, 'Luís', 'Gonçalves', 'Embraer - Empresa Brasileira de Aeronáutica S.A.', 'Av. Brigadeiro Faria Lima, 2170', 
        'São José dos Campos', 'SP', 'Brazil', '12227-000', '+55 (12) 3923-5555', '+55 (12) 3923-5566', 'luisg@embraer.com.br', 3);
        
--2.4
UPDATE Customer
SET FIRSTNAME = 'Robert', LASTNAME = 'Walker'
WHERE FIRSTNAME = 'Aaron' AND LASTNAME = 'Mitchell';

UPDATE Artist
SET NAME = 'CCR'
WHERE NAME = 'Creedence Clearwater Revival';

--2.5
SELECT *
FROM INVOICE
WHERE BillingAddress LIKE 'T%';

--2.6
SELECT *
FROM INVOICE
WHERE 15 <= TOTAL AND TOTAL <= 50;

SELECT *
FROM EMPLOYEE
WHERE HIREDATE >= TO_DATE('2003-6-1 00:00:00','yyyy-mm-dd hh24:mi:ss') AND HIREDATE <= TO_DATE('2004-3-1 23:59:59','yyyy-mm-dd hh24:mi:ss');

--2.7
DELETE CUSTOMER
WHERE FIRSTNAME = 'Robert' AND LASTNAME = 'Walker';

--3.1
CREATE OR REPLACE FUNCTION getCurrentTime
  RETURN TIMESTAMP
  IS
  BEGIN
  RETURN LOCALTIMESTAMP;
  END;
 /

CREATE OR REPLACE FUNCTION getMediaTypeLength(ID IN INT)
  RETURN INT
  IS 
  MEDIATYPENAME VARCHAR2(120);
  BEGIN 
  SELECT NAME
  INTO MEDIATYPENAME
  FROM MEDIATYPE M
  WHERE M.MEDIATYPEID = ID;
  RETURN LENGTH(MEDIATYPENAME);
  END;
  /
  
--3.2
CREATE OR REPLACE FUNCTION averageInvoiceTotal
  RETURN NUMBER
  IS
  AVGINVOICETOTAL NUMBER;
  BEGIN
  SELECT AVG(Total)
  INTO AVGINVOICETOTAL
  FROM INVOICE;
  RETURN AVGINVOICETOTAL;
  END;
  /


CREATE OR REPLACE FUNCTION mostExpensiveTrack(trackType Track.TrackId%
   RETURN trackType
   IS
   trackType Track.TrackId%ROWTYPE;
   BEGIN
   SELECT *
   INTO trackType
   FROM TRACK t
   WHERE t.UnitPrice = (SELECT MAX(UnitPrice)
                        FROM Track t
                        );
   RETURN trackType;
   END;
  /
END  
--3.3
CREATE OR REPLACE FUNCTION averageInvoicelinePrice
  RETURN NUMBER
  IS
  AVGINVOICEPRICE NUMBER;
  BEGIN
  SELECT AVG(UnitPrice)
  INTO AVGINVOICEPRICE
  FROM INVOICELINE;
  RETURN AVGINVOICEPRICE;
  END;
  /

--3.4

--4.1
CREATE OR REPLACE PROCEDURE getEmployeeNames(LN OUT VARCHAR2, FN OUT VARCHAR2)
  AS
  BEGIN
  SELECT FirstName, LastName
  FROM Employee;
  COMMIT;
  END;
/

--4.2
CREATE OR REPLACE PROCEDURE updateEmpInfo(LN IN VARCHAR2, FN IN VARCHAR2, 
                                        TI IN VARCHAR2, RT IN NUMBER, BD IN DATE, HD IN DATE,
                                        AD IN VARCHAR2, CI IN VARCHAR2, ST IN VARCHAR2,
                                        CO IN VARCHAR2, PC IN VARCHAR2, PH IN VARCHAR2, 
                                        FA IN VARCHAR2, EM IN VARCHAR2)
AS
BEGIN
UPDATE EMPLOYEE
SET LASTNAME = LN,
    FIRSTNAME = FN,
    TITLE = TI,
    REPORTSTO = RT,
    BIRTHDATE = BD,
    HIREDATE = HD,
    ADDRESS = AD,
    CITY = CI,
    STATE = ST,
    COUNTRY = CO,
    POSTALCODE = PC,
    PHONE = PH,
    FAX = FA,
    EMAIL = EM;
COMMIT;
END updateEmpInfo;
/

--CREATE OR REPLACE PROCEDURE returnEmpsManagers(EID IN NUMBER)
--AS
--BEGIN

--4.3
CREATE OR REPLACE PROCEDURE getCustomerNameAndCompany(CID IN NUMBER, FN OUT VARCHAR2, LN OUT VARCHAR2, COMP OUT VARCHAR2)
AS
BEGIN
SELECT FirstName, LastName, Company
INTO FN, LN, COMP
FROM Customer C
WHERE C.CustomerId = CID;
COMMIT;
END;
/

--5.0
CREATE OR REPLACE PROCEDURE deleteInvoice(IID IN NUMBER)
AS
BEGIN
DELETE FROM INVOICE
WHERE INVOICE.INVOICEID = IID;
COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE insertCustomer(CID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2, CO IN VARCHAR2, AD IN VARCHAR2,
                                           CITY IN VARCHAR2, ST IN VARCHAR2, COU IN VARCHAR2, PC IN VARCHAR2, PH IN VARCHAR2,
                                           FA IN VARCHAR2, EML IN VARCHAR2, SRI IN NUMBER)
AS
BEGIN
INSERT INTO CUSTOMER
(CustomerID, FirstName, LastName, Company, Address, City, State, Country, PostalCode, Phone, Fax, Email, SupportRepId)
VALUES
(CID, FN, LN, CO, AD, CITY, ST, COU, PC, PH, FA, EML, SRI);
COMMIT;
END;
/

--6.1
CREATE OR REPLACE TRIGGER NEWEMPLOYEERECORD
AFTER INSERT ON EMPLOYEE
BEGIN
DBMS_OUTPUT.PUT_LINE('New Employee Record added');
END;
/

CREATE OR REPLACE TRIGGER NEWALBUMROW
AFTER INSERT ON ALBUM
BEGIN
DBMS_OUTPUT.PUT_LINE('New Row Added to Album Table');
END;
/

CREATE OR REPLACE TRIGGER CUSTOMERROWDELETED
AFTER DELETE ON CUSTOMER
BEGIN
DBMS_OUTPUT.PUT_LINE('Row Deleted From Customer');
END;
/

--7.1
SELECT C.FirstName, C.LastName, I.InvoiceId
FROM Customer C, Invoice I 
WHERE C.CustomerId = I.CustomerId;

--7.2 
SELECT C.CustomerId, C.FirstName, C.LastName, I.InvoiceId, I.Total
FROM Customer C
FULL OUTER JOIN Invoice I ON C.CustomerId = I.CustomerId;

--7.3
SELECT Ar.Name, Al.Title
FROM Artist Ar
RIGHT JOIN Album Al ON Ar.ArtistId = Al.ArtistId;

--7.4
SELECT Artist.Name
FROM Artist 
CROSS JOIN Album
ORDER BY Artist.Name ASC;

--7.5
SELECT *
FROM Employee e1, Employee e2
WHERE e1.REPORTSTO = e2.REPORTSTO;