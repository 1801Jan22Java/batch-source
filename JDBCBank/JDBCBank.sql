--Create tables/constraints

/*******************************************************************************
   Reset Tables
********************************************************************************/

DROP TABLE Transaction;
DROP TABLE Account;
DROP TABLE Balance;
DROP TABLE Userinfo;
DROP TABLE Bankuser;

/*******************************************************************************
   Create Tables
********************************************************************************/

/*
create a table called bankuser that has
bankuserid - primary key that identifies the bankuser - requierd
bankuser - username to login - required
password - password to login - requierd
*/

CREATE TABLE Bankuser
(
    BANKUSERID INT NOT NULL,
    BANKUSER VARCHAR2(60) NOT NULL,
    PASSWORD VARCHAR2(100) NOT NULL
);
/*
create a table called userinfo that has:
userid - pirmary key to identify the account - required
firstname - varchar2 for the first name of the user - required
lastname - varchar2 for the last name of the user - required
ssn - varchar2 for the social security number of user - required
address - varchar2 for the address of the user
email - varchar2 for the email address of the user
*/
CREATE TABLE Userinfo 
(
    USERINFOID INT NOT NULL,
    BANKUSERID INT NOT NULL,
    SSN VARCHAR2(20) NOT NULL,
    FIRSTNAME VARCHAR2(40) NOT NULL,
    LASTNAME VARCHAR2(40) NOT NULL,
    ADDRESS VARCHAR2(160),
    EMAIL VARCHAR2(60) NOT NULL
);

/*
create a table called account that has:
accountid - primary key to identify the account - requried
userid - foreign key to identify who owns the account - requried
type - number to identify whether the account is checking(0) or savings(1) - default value is checking(0)
balanceid - decimal (precision) to tell how much money is in the account - default value is 0.0
*/
CREATE TABLE Account
(
    ACCOUNTID INT NOT NULL,
    BANKUSERID INT NOT NULL,
    TYPE INT DEFAULT (0),
    BALANCEID INT NOT NULL
);

/* 
create a table called transaction that has
transactionid - primary key to identify transactions - requierd
accountid - foreign key to identify which account the transaction belongs to - requried
type - number to identify if the transaction is widthrawal (0) or deposit (1) - required
*/
CREATE TABLE Transaction
(
    TRANSACTIONID INT NOT NULL,
    BALANCEID INT NOT NULL,
    ACCOUNTID INT NOT NULL,
    TYPE INT NOT NULL,
    TRANSACTIONAMOUNT DECIMAL NOT NULL
);

/*
create a table called balance that has
balanceid - primary key to identify the balance - required
initialbalance - decimal to ensure precision and show how much is in the account before a transaction
*/
CREATE TABLE Balance
(
    BALANCEID INT NOT NULL,
    INITIALBALANCE DECIMAL DEFAULT 0.0
);

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/

ALTER TABLE Account ADD CONSTRAINT FK_ACC_USERID
FOREIGN KEY (BANKUSERID) REFERENCES Bankuser (BANKUSERID);

ALTER TABLE Account ADD CONSTRAINT FK_ACC_BALANCEID
FOREIGN KEY (BALANCEID) REFERENCES Balance (BALANCEID);

ALTER TABLE Transaction ADD CONSTRAINT FK_TRANS_ACCOUNTID
FOREIGN KEY (ACCOUNTID) REFERENCES Account (ACCOUNTID);

ALTER TABLE Transaction ADD CONSTRAINT FK_TRANS_BALANCEID
FOREIGN KEY (BALANCEID) REFERENCES Balance (BALANCEID);

ALTER TABLE Userinfo ADD CONSTRAINT FK_INFO_BANKUSER
FOREIGN KEY (BANKUSERID) REFERENCES Bankuser (BANKUSERID);

/*******************************************************************************
   Create Other Constraints
********************************************************************************/

ALTER TABLE Account ADD CONSTRAINT ACC_TYPE
CHECK (TYPE >= 0 AND TYPE < 2);

ALTER TABLE Transaction ADD CONSTRAINT TRANS_TYPE
CHECK (TYPE >= 0 AND TYPE < 2);

/*******************************************************************************
   Create Sequences
********************************************************************************/

CREATE SEQUENCE ACC_SEQ
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE BANK_SEQ
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE BAL_SEQ
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE TRANS_SEQ
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

CREATE SEQUENCE INFO_SEQ
START WITH 1000
INCREMENT BY 1
NOCACHE
NOCYCLE;

/*******************************************************************************
   Create Triggers
********************************************************************************/

CREATE OR REPLACE TRIGGER ACC_ADD_ID
BEFORE INSERT ON Account
FOR EACH ROW
BEGIN
SELECT ACC_SEQ.NEXTVAL 
INTO :NEW:ACCOUNTID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BANK_ADD_ID
BEFORE INSERT ON Bankuser
FOR EACH ROW
BEGIN
SELECT BANK_SEQ.NEXTVAL
INTO :new.id
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BANK_ADD_ID
BEFORE INSERT ON BANKUSER
FOR EACH ROW
BEGIN
SELECT BANK_SEQ.NEXTVAL
INTO :new.id
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BAL_ADD_ID
BEFORE INSERT ON BALANCE
FOR EACH ROW
BEGIN
SELECT BAL_SEQ.NEXTVAL
INTO :new.id
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TRANS_ADD_ID
BEFORE INSERT ON TRANSACTION
FOR EACH ROW
BEGIN
SELECT TRANS_SEQ.NEXTVAL
INTO :new.id
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER INFO_ADD_ID
BEFORE INSERT ON USERINFO
FOR EACH ROW
BEGIN
SELECT INFO_SEQ.NEXTVAL
INTO :new.id
FROM DUAL;
END;
/