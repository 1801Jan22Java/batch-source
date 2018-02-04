--Tables
CREATE TABLE USERS
(
    USER_ID NUMBER,
    USER_FIRST_NAME VARCHAR2(120),
    USER_LAST_NAME VARCHAR2(120),
    SUPER_USER NUMBER NOT NULL, 
    ADDRESS VARCHAR2(120),
    STATE VARCHAR(120),
    ZIP VARCHAR2(20),
    BIRTH_DATE DATE,
    SSN VARCHAR2 NOT NULL,
    CONSTRAINT CHECK_SUPER_USER
    CHECK (SUPER_USER BETWEEN 0 AND 1),
    CONSTRAINT PK_USER_ID 
    PRIMARY KEY (USER_ID)
);
CREATE TABLE ACCOUNT_TYPE
(
    ACCOUNT_TYPE_NAME VARCHAR2(20) NOT NULL,
    TYPE_ID NUMBER,
    CONSTRAINT PK_TYPE_ID 
    PRIMARY KEY (TYPE_ID)
);
CREATE TABLE ACCOUNT
(
    ACCOUNT_ID NUMBER,
    USER_ID NUMBER,
    ACCOUNT_TYPE NUMBER,
    BALANCE_CHANGE FLOAT,
    TRANSACTION_DATE DATE,
    TRANSACTION_ID NUMBER,
    CONSTRAINT PK_ACCOUNT_ID 
    PRIMARY KEY (ACCOUNT_ID)
);
CREATE TABLE TRANSACTION_HISTORY
(
    ACCOUNT_ID NUMBER,
    BALANCE_CHANGE FLOAT,
    TRANSATION_DATE DATE,
    TRANSACTION_ID NUMBER,
    CONSTRAINT PK_TRANSACTION_ID 
    PRIMARY KEY (TRANSACTION_ID)
);
--FOREIGN KEYS
ALTER TABLE ACCOUNT ADD CONSTRAINT FK_USER_ID
FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID);

ALTER TABLE ACCOUNT ADD CONSTRAINT FK_ACCOUNT_TYPE_ID
FOREIGN KEY (ACCOUNT_TYPE) REFERENCES ACCOUNT_TYPE(TYPE_ID);

ALTER TABLE TRANSACTION_HISTORY ADD CONSTRAINT FK_ACCOUNT_TRANSACTION
FOREIGN KEY (ACCOUNT_ID) REFERENCES ACCOUNT(ACCOUNT_ID);

ALTER TABLE USER_INFO ADD CONSTRAINT FK_USER_INFO
FOREIGN KEY (USER_ID) REFERENCES USER_INFO(USER_ID);
--SEQUENCES
CREATE SEQUENCE ACCOUNT_ID_SEQUENCE
MINVALUE 1001
MAXVALUE 9999
START WITH 1001
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE USER_ID_SEQUENCE
MINVALUE 1001
MAXVALUE 9999
START WITH 1001
INCREMENT BY 1
CACHE 20;

CREATE SEQUENCE TRANSACTION_ID_SEQUENCE
MINVALUE 1001
MAXVALUE 9999
START WITH 1001
INCREMENT BY 1
CACHE 20;
--TRIGGERS
CREATE OR REPLACE TRIGGER USERS_ID_TRIGGER
BEFORE INSERT ON USERS
FOR EACH ROW
DECLARE 
NEW_USER_ID NUMBER;
BEGIN
    NEW_USER_ID := USER_ID_SEQUENCE.NEXTVAL;
    SELECT NEW_USER_ID INTO :NEW.USER_ID
    FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER ACCOUNT_ID_TRIGGER
BEFORE INSERT ON ACCOUNT
FOR EACH ROW
DECLARE 
NEW_ACCOUNT_ID NUMBER;
BEGIN
    NEW_ACCOUNT_ID := USER_ID_SEQUENCE.NEXTVAL;
    SELECT NEW_ACCOUNT_ID INTO :NEW.ACCOUNT_ID
    FROM DUAL;
END;
/
--INSERT INTO USERS(USER_ID,SUPER_USER) VALUES(42,0);
--POPULATE TABLES
