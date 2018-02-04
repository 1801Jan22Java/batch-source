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
    SSN VARCHAR2(40) NOT NULL,
    FIRSTNAME VARCHAR2(40),
    LASTNAME VARCHAR2(40),
    ADDRESS VARCHAR2(160),
    EMAIL VARCHAR2(60)
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
    TYPE INT DEFAULT (0) NOT NULL,
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
    TRANSACTIONAMOUNT DECIMAL(20,2) NOT NULL
);

/*
create a table called balance that has
balanceid - primary key to identify the balance - required
initialbalance - decimal to ensure precision and show how much is in the account before a transaction
*/
CREATE TABLE Balance
(
    BALANCEID INT NOT NULL,
    INITIALBALANCE DECIMAL(20,2) NOT NULL
);

/*******************************************************************************
   Create Primary Keys
********************************************************************************/

ALTER TABLE Account ADD CONSTRAINT PK_ACCOUNTID
PRIMARY KEY (ACCOUNTID);

ALTER TABLE Balance ADD CONSTRAINT PK_BALANCEID
PRIMARY KEY (BALANCEID);

ALTER TABLE Bankuser ADD CONSTRAINT PK_BANKUSERID
PRIMARY KEY (BANKUSERID);

ALTER TABLE Transaction ADD CONSTRAINT PK_TRANSACTIONID
PRIMARY KEY (TRANSACTIONID);

ALTER TABLE Userinfo ADD CONSTRAINT PK_USERINFOID
PRIMARY KEY (USERINFOID);

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
INTO :new.ACCOUNTID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BANK_ADD_ID
BEFORE INSERT ON Bankuser
FOR EACH ROW
BEGIN
SELECT BANK_SEQ.NEXTVAL
INTO :new.BANKUSERID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BANK_ADD_ID
BEFORE INSERT ON Bankuser
FOR EACH ROW
BEGIN
SELECT BANK_SEQ.NEXTVAL
INTO :new.BANKUSERID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER BAL_ADD_ID
BEFORE INSERT ON Balance
FOR EACH ROW
BEGIN
SELECT BAL_SEQ.NEXTVAL
INTO :new.BALANCEID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TRANS_ADD_ID
BEFORE INSERT ON Transaction
FOR EACH ROW
BEGIN
SELECT TRANS_SEQ.NEXTVAL
INTO :new.TRANSACTIONID
FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER INFO_ADD_ID
BEFORE INSERT ON Userinfo
FOR EACH ROW
BEGIN
SELECT INFO_SEQ.NEXTVAL
INTO :new.USERINFOID
FROM DUAL;
END;
/

/*******************************************************************************
   Create Stored Procedures
********************************************************************************/
CREATE OR REPLACE PROCEDURE NEW_TRANSACTION
(
    BALANCEID IN BALANCE.BALANCEID%TYPE,
    ACCOUNTID IN ACCOUNT.ACCOUNTID%TYPE,
    TYPE IN TRANSACTION.TYPE%TYPE,
    TRANSACTIONAMOUNT IN TRANSACTION.TRANSACTIONAMOUNT%TYPE
)
AS
BEGIN
    INSERT INTO TRANSACTION VALUES(0,BALANCEID,ACCOUNTID,TYPE,TRANSACTIONAMOUNT);
END;
/

CREATE OR REPLACE PROCEDURE NEW_USERINFO
(
    USERNAME IN BANKUSER.BANKUSER%TYPE,
    PASS IN BANKUSER.PASSWORD%TYPE,
    U_SSN IN USERINFO.SSN%TYPE,
    F_NAME IN USERINFO.FIRSTNAME%TYPE,
    L_NAME IN USERINFO.LASTNAME%TYPE,
    ADR IN USERINFO.ADDRESS%TYPE,
    EM IN USERINFO.EMAIL%TYPE
)
IS
B_USER_ID BANKUSER.BANKUSERID%TYPE;
BEGIN
    NEW_BANKUSER(USERNAME,PASS,B_USER_ID);
    INSERT INTO USERINFO VALUES(0,B_USER_ID,U_SSN,F_NAME,L_NAME,ADR,EM);
END;
/

CREATE OR REPLACE PROCEDURE NEW_BANKUSER
(
    BANKUSER_USER IN BANKUSER.BANKUSER%TYPE,
    BANKUSER_PASS IN BANKUSER.PASSWORD%TYPE,
    BANKUSER_ID OUT BANKUSER.BANKUSERID%TYPE
)
AS
BEGIN
    INSERT INTO BANKUSER VALUES(0,BANKUSER_USER,BANKUSER_PASS);
    SELECT MAX(BANKUSERID) INTO BANKUSER_ID FROM BANKUSER;
END;
/

CREATE OR REPLACE PROCEDURE NEW_ACCOUNT
(
    BANKUSER_ID IN BANKUSER.BANKUSERID%TYPE,
    TYPE IN INT,
    INITIAL_BALANCE IN BALANCE.INITIALBALANCE%TYPE
)
IS
B_ID BALANCE.BALANCEID%TYPE;
BEGIN
    NEW_BALANCE(INITIAL_BALANCE,B_ID);
    INSERT INTO ACCOUNT VALUES(0,BANKUSER_ID, TYPE, B_ID);
END;
/

CREATE OR REPLACE PROCEDURE NEW_BALANCE 
(
    INITIAL_BALANCE IN BALANCE.INITIALBALANCE%TYPE,
    BALANCE_ID OUT BALANCE.BALANCEID%TYPE
)
AS
BEGIN
    INSERT INTO Balance VALUES(0,INITIAL_BALANCE);
    SELECT MAX(BALANCEID) INTO BALANCE_ID FROM BALANCE;
END;
/