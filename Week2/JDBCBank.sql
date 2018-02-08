/*******************************************************************************
   Bank Database - Version 0.1
   Script: Bank.sql
   Description: Creates and populates the Bank database.
   DB Server: Oracle
   Author: Eric Carpizo
********************************************************************************/


/*******************************************************************************
   Create Tables
********************************************************************************/
CREATE TABLE Users
(
    USER_ID NUMBER NOT NULL,
    FIRSTNAME VARCHAR2(160) NOT NULL,
    LASTNAME VARCHAR2(160) NOT NULL,
    USERNAME VARCHAR2(160) NOT NULL,
    USER_PASSWORD VARCHAR2(160) NOT NULL,
    USER_TYPE_ID NUMBER NOT NULL,
    CONSTRAINT PK_Users PRIMARY KEY  (USER_ID)
);

CREATE TABLE User_Types
(
    USER_TYPE_ID NUMBER NOT NULL,
    TYPE_NAME VARCHAR2(160) NOT NULL,
    CONSTRAINT PK_User_Type PRIMARY KEY  (USER_TYPE_ID)
);

CREATE TABLE Bank_Accounts
(
    BANK_ACCOUNT_ID NUMBER NOT NULL,
    USER_ID NUMBER NOT NULL,
    BALANCE FLOAT NOT NULL,
    BANK_ACCOUNT_TYPE_ID NUMBER NOT NULL,
    CONSTRAINT PK_Bank_Accounts PRIMARY KEY  (BANK_ACCOUNT_ID)
);

CREATE TABLE Bank_Account_Types
(
    BANK_ACCOUNT_TYPE_ID NUMBER NOT NULL,
    TYPE_NAME VARCHAR2(160) NOT NULL,
    CONSTRAINT PK_Bank_Account_Types PRIMARY KEY  (BANK_ACCOUNT_TYPE_ID)
);

CREATE TABLE Transactions
(
    TRANSACTION_ID NUMBER NOT NULL,
    BANK_ACCOUNT_ID NUMBER NOT NULL,
    TRANSACTION_DATE DATE NOT NULL,
    TRANSACTION_TYPE_ID NUMBER NOT NULL,
    AMOUNT FLOAT NOT NULL,
    BALANCE FLOAT NOT NULL,
    CONSTRAINT PK_Transactions PRIMARY KEY  (TRANSACTION_ID)
);

CREATE TABLE Transaction_Types
(
    TRANSACTION_TYPE_ID NUMBER NOT NULL,
    TYPE_NAME VARCHAR2(160) NOT NULL,
    CONSTRAINT PK_Transaction_Types PRIMARY KEY  (TRANSACTION_TYPE_ID)
);


/*******************************************************************************
   Create Primary Key Unique Indexes
********************************************************************************/

/*******************************************************************************
   Create Foreign Keys
********************************************************************************/
ALTER TABLE Users ADD CONSTRAINT FK_USERS_USER_TYPE_ID
    FOREIGN KEY (USER_TYPE_ID) REFERENCES User_Types (USER_TYPE_ID);

ALTER TABLE Bank_Accounts ADD CONSTRAINT FK_BANK_ACCOUNTS_USER_ID
    FOREIGN KEY (USER_ID) REFERENCES Users (USER_ID);
    
ALTER TABLE Bank_Accounts ADD CONSTRAINT FK_BANK_ACCOUNTS_TYPE_ID
    FOREIGN KEY (BANK_ACCOUNT_TYPE_ID) REFERENCES Bank_Account_Types (BANK_ACCOUNT_TYPE_ID);

ALTER TABLE Transactions ADD CONSTRAINT FK_TRANSACTIONS_ACCOUNT_ID
    FOREIGN KEY (BANK_ACCOUNT_ID) REFERENCES Bank_Accounts (BANK_ACCOUNT_ID);

ALTER TABLE Transactions ADD CONSTRAINT FK_TRANSACTION_TYPES__TYPE_ID
    FOREIGN KEY (TRANSACTION_TYPE_ID) REFERENCES Transaction_Types (TRANSACTION_TYPE_ID);

/*******************************************************************************
   Create Procedures
********************************************************************************/

CREATE OR REPLACE PROCEDURE update_user(pv_id NUMBER, N_FIRSTNAME VARCHAR2, N_LASTNAME VARCHAR2, N_USERNAME VARCHAR2, N_USER_PASSWORD VARCHAR2, N_USER_TYPE_ID NUMBER)
AS
BEGIN
    IF N_FIRSTNAME IS NOT NULL THEN
        UPDATE Users SET FIRSTNAME = N_FIRSTNAME WHERE USER_ID = pv_id;
    END IF;
    IF N_LASTNAME IS NOT NULL THEN
        UPDATE Users SET LASTNAME = N_LASTNAME WHERE USER_ID = pv_id;
    END IF;
    IF N_USERNAME IS NOT NULL THEN
        UPDATE Users SET USERNAME = N_USERNAME WHERE USER_ID = pv_id;
    END IF;
    IF N_USER_PASSWORD IS NOT NULL THEN
        UPDATE Users SET USER_PASSWORD = N_USER_PASSWORD WHERE USER_ID = pv_id;
    END IF;
    IF N_USER_TYPE_ID IS NOT NULL THEN
        UPDATE Users SET USER_TYPE_ID = N_USER_TYPE_ID WHERE USER_ID = pv_id;
    END IF;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UPDATE_BANKACCOUNT(id NUMBER, b_user_id NUMBER,b_balance FLOAT,b_type NUMBER)
AS
BEGIN
    IF b_user_id IS NOT NULL THEN
        UPDATE BANK_ACCOUNTS SET USER_ID=b_user_id WHERE USER_ID=id;
    END IF;
    IF b_balance IS NOT NULL THEN
        UPDATE BANK_ACCOUNTS SET BALANCE=b_balance WHERE USER_ID=id;
    END IF;
    IF b_type IS NOT NULL THEN
        UPDATE BANK_ACCOUNTS SET BANK_ACCOUNT_TYPE_ID=b_type WHERE USER_ID=id;
    END IF;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE delete_user(id NUMBER)
IS
    CURSOR c_accounts IS (SELECT BANK_ACCOUNT_ID FROM BANK_ACCOUNTS WHERE USER_ID=id);
BEGIN
    FOR i IN c_accounts LOOP
        DELETE FROM TRANSACTIONS WHERE BANK_ACCOUNT_ID=i.BANK_ACCOUNT_ID;
    END LOOP;
    DELETE FROM BANK_ACCOUNTS WHERE USER_ID=id;
    DELETE FROM USERS WHERE USER_ID=id;
    COMMIT;
END;
/   

CREATE OR REPLACE PROCEDURE delete_bank_account(id NUMBER) 
IS
    -- Use sysrefcursor when you have an out parameter
    -- User this version when you are just iterating without sending anything out
    CURSOR c_transactions  IS (SELECT TRANSACTION_ID FROM TRANSACTIONS WHERE BANK_ACCOUNT_ID=id);
BEGIN
    FOR i IN c_transactions LOOP
        DELETE FROM TRANSACTIONS WHERE TRANSACTION_ID=i.TRANSACTION_ID;
    END LOOP;
    DELETE FROM BANK_ACCOUNTS WHERE BANK_ACCOUNT_ID=id;
    COMMIT;
END;
/  

CREATE SEQUENCE user_types_s1 START WITH 1 INCREMENT BY 1;
--INSERT INTO USER_TYPES (USER_TYPE_ID, TYPE_NAME) VALUES (user_types_s1.nextVal, 'Super');
--INSERT INTO USER_TYPES (USER_TYPE_ID, TYPE_NAME) VALUES (user_types_s1.nextVal, 'General');

CREATE SEQUENCE bank_account_type_s1 START WITH 1 INCREMENT BY 1;
--INSERT INTO BANK_ACCOUNT_TYPES (BANK_ACCOUNT_TYPE_ID, TYPE_NAME) VALUES (bank_account_type_s1.nextVal, 'Deposit');
--INSERT INTO BANK_ACCOUNT_TYPES (BANK_ACCOUNT_TYPE_ID, TYPE_NAME) VALUES (bank_account_type_s1.nextVal, 'Withdrawal');

CREATE SEQUENCE transaction_type_s1 START WITH 1 INCREMENT BY 1;
--INSERT INTO TRANSACTION_TYPES (TRANSACTION_TYPE_ID, TYPE_NAME) VALUES (transaction_type_s1.nextVal, 'Deposit');
--INSERT INTO TRANSACTION_TYPES (TRANSACTION_TYPE_ID, TYPE_NAME) VALUES (transaction_type_s1.nextVal, 'Withdrawal');
--DELETE FROM TRANSACTION_TYPES WHERE TRANSACTION_TYPE_ID=22;
CREATE SEQUENCE user_s1 START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_users
BEFORE INSERT ON USERS
FOR EACH ROW
BEGIN
    SELECT user_s1.nextVal INTO :new.USER_ID FROM DUAL;
END;
/

CREATE SEQUENCE transaction_s1 START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_transaction
BEFORE INSERT ON TRANSACTIONS
FOR EACH ROW
BEGIN
    SELECT transaction_s1.nextVal INTO :new.TRANSACTION_ID FROM DUAL;
END;
/

CREATE SEQUENCE bank_accounts_s1 START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_bank_account
BEFORE INSERT ON BANK_ACCOUNTS
FOR EACH ROW
BEGIN
    SELECT bank_accounts_s1.nextVal INTO :new.BANK_ACCOUNT_ID FROM DUAL;
END;
/

DELETE FROM USERS WHERE USER_ID=10;








