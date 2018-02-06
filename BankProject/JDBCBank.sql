DROP TABLE USERS CASCADE CONSTRAINTS;
DROP TABLE CHECKINGS CASCADE CONSTRAINTS;
DROP TABLE SAVINGS CASCADE CONSTRAINTS;

--CREATE TABLES
CREATE TABLE USERS (
    USER_ID INTEGER PRIMARY KEY,
    USER_USERNAME VARCHAR2(100) NOT NULL,
    USER_PASSWORD VARCHAR2(100) NOT NULL
);        --SHOULD THIS HAVE FOREIGN KEYS AS WELL SINCE 1 TO 1?
/

CREATE TABLE CHECKINGS (
    CHECKINGS_ID INTEGER PRIMARY KEY,
    CHECKINGS_BALANCE NUMBER(8,2),
    USER_ID INTEGER);
/

CREATE TABLE SAVINGS (
    SAVINGS_ID INTEGER PRIMARY KEY,
    SAVINGS_BALANCE NUMBER(8,2),
    USER_ID INTEGER);
/

--ADD FOREIGN KEYS
ALTER TABLE CHECKINGS
ADD CONSTRAINT FK_CHECKINGS_USER
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID);
/

ALTER TABLE SAVINGS
ADD CONSTRAINT FK_SAVINGS_USER
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID);
/

--ADD CHECK CONSTRAINT FOR BALANCES
ALTER TABLE CHECKINGS
ADD CONSTRAINT CK_CHECKINGS_BALANCE_POSITIVE CHECK (CHECKINGS_BALANCE >= 0);
/

ALTER TABLE SAVINGS
ADD CONSTRAINT CK_SAVINGS_BALANCE_POSITIVE CHECK (SAVINGS_BALANCE >= 0);   
/

--SEQUENCES
CREATE SEQUENCE SQ_USERS_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_CHECKINGS_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_SAVINGS_PK
START WITH 1
INCREMENT BY 1;
/

--CREATE BEFORE INSERT TRIGGERS
CREATE OR REPLACE TRIGGER TR_INSERT_USERS
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
  SELECT SQ_USERS_PK.NEXTVAL INTO :NEW.USER_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_CHECKINGS
BEFORE INSERT ON CHECKINGS
FOR EACH ROW
BEGIN
  SELECT SQ_CHECKINGS_PK.NEXTVAL INTO :NEW.CHECKINGS_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_SAVINGS
BEFORE INSERT ON SAVINGS
FOR EACH ROW
BEGIN
  SELECT SQ_SAVINGS_PK.NEXTVAL INTO :NEW.SAVINGS_ID FROM DUAL;
END;
/

--AFTER AN USER IS INSERTED AUTOMATICALLY CREATE A CHECKINGS AND SAVINGS WITH 0 BALANGE FOR THAT USER
CREATE OR REPLACE TRIGGER TR_USERS_AFTER_INSERT --TRIGGER for AFTER INSERT on USERS table
AFTER INSERT ON USERS
FOR EACH ROW
BEGIN
    INSERT INTO CHECKINGS(CHECKINGS_BALANCE, USER_ID) VALUES (0, :NEW.USER_ID);
    INSERT INTO SAVINGS(SAVINGS_BALANCE, USER_ID) VALUES (0, :NEW.USER_ID);
END;
/
  