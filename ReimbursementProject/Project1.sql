DROP TABLE EMPLOYEE CASCADE CONSTRAINTS;
DROP TABLE MANAGER CASCADE CONSTRAINTS;
DROP TABLE REQUEST_STATUS CASCADE CONSTRAINTS;
--DROP TABLE REQUEST_TYPE CASCADE CONSTRAINTS;
DROP TABLE REQUEST CASCADE CONSTRAINTS;
DROP TABLE RESOLVED_REQUEST CASCADE CONSTRAINTS;
DROP TABLE RECEIPT CASCADE CONSTRAINTS;
/


--CREATE TABLES
CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID INTEGER PRIMARY KEY,
    FIRST_NAME VARCHAR2(20) NOT NULL,
    LAST_NAME VARCHAR2(20) NOT NULL,
    ADDRESS VARCHAR2(100),
    CITY VARCHAR2(20),
    STATE VARCHAR2(20),
    PHONE_NUMBER VARCHAR2(20),
    EMAIL VARCHAR2(300) NOT NULL,
    E_PASSWORD VARCHAR2(300) NOT NULL
);

CREATE TABLE MANAGER (
    MANAGER_ID INTEGER PRIMARY KEY,
    FIRST_NAME VARCHAR2(20) NOT NULL,
    LAST_NAME VARCHAR2(20) NOT NULL,
    ADDRESS VARCHAR2(100),
    CITY VARCHAR2(20),
    STATE VARCHAR2(20),
    PHONE_NUMBER VARCHAR2(20),
    EMAIL VARCHAR2(300) NOT NULL,
    M_PASSWORD VARCHAR2(300) NOT NULL
);

CREATE TABLE REQUEST_STATUS (
    REQUEST_STATUS_ID INTEGER PRIMARY KEY,
    REQUEST_STATUS_NAME VARCHAR2(20) NOT NULL
);

--CREATE TABLE REQUEST_TYPE (                     --THIS TABLE IS MOSTLY FOR FRONT END CHOICES
--    REQUEST_TYPE_ID INTEGER PRIMARY KEY,
--    REQUEST_TYPE_NAME VARCHAR2(100) NOT NULL
--);

CREATE TABLE REQUEST (
    REQUEST_ID INTEGER PRIMARY KEY,
    EMPLOYEE_ID INTEGER,                --FK
    REQUEST_STATUS_ID INTEGER,          --FK
--    REQUEST_TYPE_ID INTEGER,            --FK
    REQUEST_AMOUNT NUMBER NOT NULL,
    REQUEST_COMMENT VARCHAR2(300) NOT NULL
);

CREATE TABLE RESOLVED_REQUEST (                 --THIS WILL BE IN DAOIMPL LOGIC FOR THE MANAGER APPROVE AND DENY METHODS,
    RESOLVED_REQUEST_ID INTEGER PRIMARY KEY,     --SINCE MANAGER_ID REQUIRED SO CANT BE DONE WITH TRIGGER
    MANAGER_ID INTEGER,                 --FK
    REQUEST_ID INTEGER,                 --FK
    EMPLOYEE_ID INTEGER,                --FK
    REQUEST_STATUS_ID INTEGER,          --FK
--    REQUEST_TYPE_ID INTEGER,            --FK
    REQUEST_AMOUNT NUMBER NOT NULL,     --FK
    REQUEST_COMMENT VARCHAR2(300) NOT NULL       --FK
);

CREATE TABLE RECEIPT (                  --UPDATE TABLE AFTER FIGURING OUT RECEIPT STUFF
    RECEIPT_ID INTEGER PRIMARY KEY,
    REQUEST_ID INTEGER
);
/

--ADD FOREIGN KEYS FOR REQUEST
ALTER TABLE REQUEST
ADD CONSTRAINT FK_REQUEST_EMPLOYEE
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);

ALTER TABLE REQUEST
ADD CONSTRAINT FK_REQUEST_REQUEST_STATUS
FOREIGN KEY (REQUEST_STATUS_ID) REFERENCES REQUEST_STATUS(REQUEST_STATUS_ID);

--ALTER TABLE REQUEST
--ADD CONSTRAINT FK_REQUEST_REQUEST_TYPE
--FOREIGN KEY (REQUEST_TYPE_ID) REFERENCES REQUEST_TYPE(REQUEST_TYPE_ID);

--ADD FOREIGN KEYS FOR RESOLVED_REQUEST
ALTER TABLE RESOLVED_REQUEST
ADD CONSTRAINT FK_RESOLVED_REQUEST_MANAGER
FOREIGN KEY (MANAGER_ID) REFERENCES MANAGER(MANAGER_ID);

--ALTER TABLE RESOLVED_REQUEST
--ADD CONSTRAINT FK_RESOLVED_REQUEST_AMOUNT
--FOREIGN KEY (REQUEST_AMOUNT) REFERENCES REQUEST(REQUEST_AMOUNT);
--
--ALTER TABLE RESOLVED_REQUEST
--ADD CONSTRAINT FK_RESOLVED_REQUEST_COMMENT
--FOREIGN KEY (REQUEST_COMMENT) REFERENCES REQUEST(REQUEST_COMMENT);
--
ALTER TABLE RESOLVED_REQUEST
ADD CONSTRAINT FK_RESOVLED_REQUEST_EMPLOYEE
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);

ALTER TABLE RESOLVED_REQUEST
ADD CONSTRAINT FK_RESOVLED_REQUEST_STATUS
FOREIGN KEY (REQUEST_STATUS_ID) REFERENCES REQUEST_STATUS(REQUEST_STATUS_ID);

--ALTER TABLE RESOLVED_REQUEST
--ADD CONSTRAINT FK_RESOVLED_REQUEST_TYPE
--FOREIGN KEY (REQUEST_TYPE_ID) REFERENCES REQUEST_TYPE(REQUEST_TYPE_ID);

ALTER TABLE RECEIPT
ADD CONSTRAINT FK_RECEIPT_REQUEST
FOREIGN KEY (REQUEST_ID) REFERENCES REQUEST(REQUEST_ID);
/


--SEQUENCES 
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_MANAGER_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_REQUEST_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_RESOLVED_REQUEST_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_RECEIPT_PK
START WITH 1
INCREMENT BY 1;
/

--DROP TR_INSERT_EMPLOYEE;
--CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
--BEFORE INSERT ON EMPLOYEE
--FOR EACH ROW
--BEGIN
--  SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
--END;
--/

CREATE OR REPLACE TRIGGER TR_INSERT_MANAGER
BEFORE INSERT ON MANAGER
FOR EACH ROW
BEGIN
  SELECT SQ_MANAGER_PK.NEXTVAL INTO :NEW.MANAGER_ID FROM DUAL;
END;
/


--CREATE OR REPLACE TRIGGER TR_INSERT_REQUEST_TYPE
--BEFORE INSERT ON REQUEST_TYPE
--FOR EACH ROW
--BEGIN
--  SELECT SQ_REQUEST_TYPE_PK.NEXTVAL INTO :NEW.REQUEST_TYPE_ID FROM DUAL;
--END;
--/

CREATE OR REPLACE TRIGGER TR_INSERT_REQUEST
BEFORE INSERT ON REQUEST
FOR EACH ROW
BEGIN
  SELECT SQ_REQUEST_PK.NEXTVAL INTO :NEW.REQUEST_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_RESOLVED_REQUEST
BEFORE INSERT ON RESOLVED_REQUEST
FOR EACH ROW
BEGIN
  SELECT SQ_RESOLVED_REQUEST_PK.NEXTVAL INTO :NEW.RESOLVED_REQUEST_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_RECEIPT
BEFORE INSERT ON RECEIPT
FOR EACH ROW
BEGIN
  SELECT SQ_RECEIPT_PK.NEXTVAL INTO :NEW.RECEIPT_ID FROM DUAL;
END;
/

--INSERT DATA INTO TABLES
INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (61, 'Miss', 'Valencia', '2400 Flower St', 'Baltimore', 'MD', '+1 (410) 555-5555', 'mvalencia@ecorp.com', 'Valencia18');

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (62, 'Bob', 'Jones', '3200 Jackson St', 'Baltimore', 'MD', '+1 (410) 222-2222', 'bjones@ecorp.com', 'Jones18');

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (63, 'Tim', 'Jefferson', '4600 Limo St', 'Baltimore', 'MD', '+1 (410) 333-3333', 'tjefferson@ecorp.com', 'Jefferson18');

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (64, 'Joe', 'Sanders', '8590 Sampson St', 'Baltimore', 'MD', '+1 (410) 111-1111', 'jsanders@ecorp.com', 'Sanders18');

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (65, 'Jim', 'Peters', '3802 East St', 'Baltimore', 'MD', '+1 (410) 666-6666', 'jpeters@ecorp.com', 'Peters18');

INSERT INTO EMPLOYEE (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, E_PASSWORD) 
VALUES (66, 'Jessica', 'Peterson', '3402 West St', 'Baltimore', 'MD', '+1 (410) 444-4444', 'jpeterson@ecorp.com', 'Peterson18');

INSERT INTO MANAGER (FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, M_PASSWORD) 
VALUES ('Sam', 'Jackson', '3904 North St', 'Baltimore', 'MD', '+1 (410) 777-7777', 'sjackson@ecorp.com', 'Jackson18');

INSERT INTO MANAGER (FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, M_PASSWORD) 
VALUES ('Sandra', 'Smith', '8201 South St', 'Baltimore', 'MD', '+1 (410) 888-8888', 'ssmith@ecorp.com', 'Smith18');

INSERT INTO MANAGER (FIRST_NAME, LAST_NAME, ADDRESS, CITY, STATE, PHONE_NUMBER, EMAIL, M_PASSWORD) 
VALUES ('Dan', 'Doogan', '516 Swim St', 'Baltimore', 'MD', '+1 (410) 999-9999', 'ddoogan@ecorp.com', 'Doogan18');

INSERT INTO REQUEST_STATUS (REQUEST_STATUS_ID, REQUEST_STATUS_NAME) 
VALUES (1, 'PENDING');

INSERT INTO REQUEST_STATUS (REQUEST_STATUS_ID, REQUEST_STATUS_NAME) 
VALUES (2, 'APPROVED');

INSERT INTO REQUEST_STATUS (REQUEST_STATUS_ID, REQUEST_STATUS_NAME) 
VALUES (3, 'DENIED');
/


--    REQUEST_ID INTEGER PRIMARY KEY,
--    EMPLOYEE_ID INTEGER,                --FK
--    REQUEST_STATUS_ID INTEGER,          --FK
--    REQUEST_AMOUNT NUMBER NOT NULL,
--    REQUEST_COMMENT VARCHAR2(300) NOT NULL

--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('AIRFARE');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('HOTEL');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('RENTAL');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('FOOD');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('EXAM PREP');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('RELOCATION');
--
--INSERT INTO REQUEST_TYPE (REQUEST_TYPE_NAME) 
--VALUES ('OTHER');


--APPROVE A PENDING REQUEST
CREATE OR REPLACE PROCEDURE SP_APPROVE_PENDING_REQUEST(REQ_ID IN NUMBER, MAN_ID IN NUMBER)
IS 
REQUEST_EXISTS INTEGER;
MANAGER_EXISTS INTEGER;
BEGIN
--SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
--CHECK THAT THE REQUEST CORRESPONDING TO THE REQ_ID IN PARAMETER, EXISTS
SELECT COUNT(REQUEST.REQUEST_ID) INTO REQUEST_EXISTS FROM REQUEST
WHERE REQUEST.REQUEST_ID = REQ_ID AND REQUEST.REQUEST_STATUS_ID = 1;
DBMS_OUTPUT.PUT_LINE(REQUEST_EXISTS);
--CHECK THAT THE MANAGER CORRESPONDING TO THE MAN_ID IN PARAMETER, EXISTS
SELECT COUNT(MANAGER.MANAGER_ID) INTO MANAGER_EXISTS FROM MANAGER
WHERE MANAGER.MANAGER_ID = MAN_ID;
DBMS_OUTPUT.PUT_LINE(MANAGER_EXISTS);
IF REQUEST_EXISTS > 0 AND MANAGER_EXISTS > 0 THEN
  --UPDATE THE REQUEST_STATUS_ID VALUE IN THE REQUEST TABLE TO 2, APPROVED
  UPDATE REQUEST 
  SET REQUEST.REQUEST_STATUS_ID = 2
  WHERE REQUEST.REQUEST_ID = REQ_ID;
  DBMS_OUTPUT.PUT_LINE('REQUEST_STATUS UPDATED');
  --INSERT INTO RESOLVED_REQUEST
  INSERT INTO RESOLVED_REQUEST(MANAGER_ID, REQUEST_ID, EMPLOYEE_ID, REQUEST_STATUS_ID, REQUEST_AMOUNT, REQUEST_COMMENT)
  SELECT MAN_ID, REQ_ID, REQUEST.EMPLOYEE_ID, 2, REQUEST.REQUEST_AMOUNT, REQUEST.REQUEST_COMMENT
  FROM REQUEST
  WHERE REQUEST.REQUEST_ID = REQ_ID;
  DBMS_OUTPUT.PUT_LINE('INSERTED INTO RESOLVED_REQUEST');
ELSE 
  DBMS_OUTPUT.PUT_LINE('FAILED TO APPROVE REQUEST');
END IF;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('FAILED TO APPROVE REQUEST');
--https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm 
ROLLBACK;
END;
/

--DENY A PENDING REQUEST
CREATE OR REPLACE PROCEDURE SP_DENY_PENDING_REQUEST(REQ_ID IN NUMBER, MAN_ID IN NUMBER)
IS 
REQUEST_EXISTS INTEGER;
MANAGER_EXISTS INTEGER;
BEGIN
--SET TRANSACTION ISOLATION LEVEL SERIALIZABLE;
--CHECK THAT THE REQUEST CORRESPONDING TO THE REQ_ID IN PARAMETER, EXISTS
SELECT COUNT(REQUEST.REQUEST_ID) INTO REQUEST_EXISTS FROM REQUEST
WHERE REQUEST.REQUEST_ID = REQ_ID AND REQUEST.REQUEST_STATUS_ID = 1;
DBMS_OUTPUT.PUT_LINE(REQUEST_EXISTS);
--CHECK THAT THE MANAGER CORRESPONDING TO THE MAN_ID IN PARAMETER, EXISTS
SELECT COUNT(MANAGER.MANAGER_ID) INTO MANAGER_EXISTS FROM MANAGER
WHERE MANAGER.MANAGER_ID = MAN_ID;
DBMS_OUTPUT.PUT_LINE(MANAGER_EXISTS);
IF REQUEST_EXISTS > 0 AND MANAGER_EXISTS > 0 THEN
  --UPDATE THE REQUEST_STATUS_ID VALUE IN THE REQUEST TABLE TO 3, DENIED
  UPDATE REQUEST 
  SET REQUEST.REQUEST_STATUS_ID = 3
  WHERE REQUEST.REQUEST_ID = REQ_ID;
  DBMS_OUTPUT.PUT_LINE('REQUEST_STATUS UPDATED');
  --INSERT INTO RESOLVED_REQUEST
  INSERT INTO RESOLVED_REQUEST(MANAGER_ID, REQUEST_ID, EMPLOYEE_ID, REQUEST_STATUS_ID, REQUEST_AMOUNT, REQUEST_COMMENT)
  SELECT MAN_ID, REQ_ID, REQUEST.EMPLOYEE_ID, 3, REQUEST.REQUEST_AMOUNT, REQUEST.REQUEST_COMMENT
  FROM REQUEST
  WHERE REQUEST.REQUEST_ID = REQ_ID;
  DBMS_OUTPUT.PUT_LINE('INSERTED INTO RESOLVED_REQUEST');
ELSE 
  DBMS_OUTPUT.PUT_LINE('FAILED TO APPROVE REQUEST');
END IF;
COMMIT;
EXCEPTION
WHEN OTHERS THEN
DBMS_OUTPUT.PUT_LINE('FAILED TO APPROVE REQUEST');
--https://docs.oracle.com/cd/B10501_01/appdev.920/a96624/07_errs.htm 
ROLLBACK;
END;
/

