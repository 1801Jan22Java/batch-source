
CREATE TABLE EMPLOYEE (EMPLOYEE_ID NUMBER, EMP_FIRSTNAME varchar2(20), EMP_LASTNAME varchar(20), DEPARTMENT_ID NUMBER, SALARY NUMBER, EMP_EMAIL varchar2(40), CONSTRAINT EMPLOYEE_ID_PK PRIMARY KEY(EMPLOYEE_ID));
CREATE TABLE DEPARTMENT(DEPARTMENT_ID NUMBER, DEPARTMENT_NAME VARCHAR2(20), CONSTRAINT DEPARTMENT_ID_PK PRIMARY KEY(DEPARTMENT_ID));
/
-- Add constraints for foreign keys
-- ON DELETE CASCADE
ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_DEPARTMENT_ID FOREIGN KEY (DEPARTMENT_ID)
REFERENCES DEPARTMENT (DEPARTMENT_ID);


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
