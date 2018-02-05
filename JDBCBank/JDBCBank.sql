--DROP TABLE ACCOUNTS CASCADE CONSTRAINTS;
--DROP TABLE BANK_USERS CASCADE CONSTRAINTS;
--DROP TABLE ROLES CASCADE CONSTRAINTS;
--DROP TABLE ACCOUNT_TYPE CASCADE CONSTRAINTS;
--DROP SEQUENCE SEQ_BANK_USER_ID;
--DROP SEQUENCE SEQ_ROLE_ID;
--DROP SEQUENCE SEQ_ACCOUNT_ID;
--DROP SEQUENCE SEQ_ACCOUNT_TYPE_ID;

CREATE TABLE BANK_USERS (USER_ID NUMBER, ROLE_ID NUMBER, USERNAME VARCHAR2(30), PASSWORD VARCHAR2(50), LOGGED NUMBER(1), CONSTRAINT BANK_USER_ID_PK PRIMARY KEY(USER_ID));
CREATE TABLE ROLES(ROLE_ID NUMBER, ROLE VARCHAR2(20), CONSTRAINT ROLE_ID_PK PRIMARY KEY(ROLE_ID));
CREATE TABLE ACCOUNTS(ACCOUNT_ID NUMBER, ACCOUNT_TYPE NUMBER, USER_ID NUMBER, BALANCE NUMBER(*,2), CONSTRAINT ACCOUNT_ID_PK PRIMARY KEY(ACCOUNT_ID));
CREATE TABLE ACCOUNT_TYPE(ACCOUNT_TYPE_ID NUMBER, TYPE VARCHAR2(30), CONSTRAINT ACCOUNT_TYPE_ID_PK PRIMARY KEY(ACCOUNT_TYPE_ID));
/z
-- Add constraints for foreign keys
-- ON DELETE CASCADE
ALTER TABLE BANK_USERS
ADD CONSTRAINT FK_CACADE_ROLE_ID FOREIGN KEY (ROLE_ID)
REFERENCES ROLES (ROLE_ID);

ALTER TABLE ACCOUNTS
ADD CONSTRAINT FK_CASCADE_ACCOUNT_ID FOREIGN KEY (USER_ID)
REFERENCES BANK_USERS (USER_ID);

ALTER TABLE ACCOUNTS
ADD CONSTRAINT FK_CASCADE_ACCOUNT_TYPE_ID FOREIGN KEY (ACCOUNT_TYPE)
REFERENCES ACCOUNT_TYPE (ACCOUNT_TYPE_ID);

-- Add default value for logged, balance
ALTER TABLE BANK_USERS
MODIFY (LOGGED DEFAULT 0);
ALTER TABLE ACCOUNTS
MODIFY (BALANCE DEFAULT 0);

CREATE SEQUENCE SEQ_BANK_USER_ID START WITH 1 increment by 1;
/
CREATE SEQUENCE SEQ_ROLE_ID START WITH 1 increment by 1;
/
CREATE SEQUENCE SEQ_ACCOUNT_ID START WITH 1 increment by 1;
/
CREATE SEQUENCE SEQ_ACCOUNT_TYPE_ID START WITH 1 increment by 1;
/

-- Triggers to auto increment pk 
CREATE OR REPLACE TRIGGER TRG_USR_ID_AUTO BEFORE INSERT ON BANK_USERS
FOR EACH ROW

BEGIN
SELECT SEQ_BANK_USER_ID.nextval into :NEW.USER_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TRG_ROL_ID_AUTO BEFORE INSERT ON ROLES
FOR EACH ROW
BEGIN
SELECT SEQ_ROLE_ID.nextval into :NEW.ROLE_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TRG_ACC_ID_AUTO BEFORE INSERT ON ACCOUNTS
FOR EACH ROW
BEGIN
SELECT SEQ_ACCOUNT_ID.nextval into :NEW.ACCOUNT_ID FROM DUAL;
END;
/
CREATE OR REPLACE TRIGGER TRG_ACC_TYPE_ID_AUTO BEFORE INSERT ON ACCOUNT_TYPE
FOR EACH ROW
BEGIN
SELECT SEQ_ACCOUNT_TYPE_ID.nextval into :NEW.ACCOUNT_TYPE_ID FROM DUAL;
END;
/
-- Support only two roles
INSERT INTO ROLES(role)
VALUES('Admin');
INSERT INTO ROLES(role)
VALUES('User');
/
-- Pre make admins
INSERT INTO BANK_USERS(ROLE_ID, USERNAME, PASSWORD, LOGGED)
VALUES(1, 'sungkwon','password',0);
/

-- Make fictional BANK_USERS
INSERT INTO BANK_USERS(ROLE_ID, USERNAME, PASSWORD, LOGGED)
VALUES(2, 'Johnny','pw',0);
INSERT INTO BANK_USERS(ROLE_ID, USERNAME, PASSWORD, LOGGED)
VALUES(2, 'Smith','pass',0);
INSERT INTO BANK_USERS(ROLE_ID, USERNAME, PASSWORD, LOGGED)
VALUES(2, 'Jane','word',0);
INSERT INTO BANK_USERS(ROLE_ID, USERNAME, PASSWORD, LOGGED)
VALUES(2, 'Doe','password',0);

-- Account types, Checking and Savings to keep it simple
INSERT INTO ACCOUNT_TYPE(TYPE)
VALUES('Checking');
INSERT INTO ACCOUNT_TYPE(TYPE)
VALUES('Savings');

-- Create multiple accounts per user, one for some.
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(1,1,100000);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(2,1,100000);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(1,2,302.12);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(2,2,1000);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(1,3,21);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(1,4,500.33);
INSERT INTO ACCOUNTS(account_type, USER_ID, balance)
VALUES(2,4,100000);
