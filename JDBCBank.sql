package com.revature.JDBCBank;


CREATE TABLE ID(
  USER_ID INT PRIMARY KEY,
  USERNAME VARCHAR2,
  );

CREATE TABLE ACCOUNT(
  ACCOUNT_ID INT PRIMARY KEY,
  USERNAME VARCHAR2, 
  BALANCE NUMBER,
  );

CREATE TABLE USER(
  USERNAME VARCHAR2 PRIMARY KEY,
  PASSWORD VARCHAR2,
  SUPERUSER BOOLEAN,
  );

  
ALTER TABLE ID
ADD CONSTRAINT FK_ID_USERNAME
FOREIGN KEY (USERNAME) REFERENCES USER(USERNAME);

ALTER TABLE ACCOUNT
ADD CONSTRAINT FK_ACCOUNT_USERNAME
FOREIGN KEY (USERNAME) REFERENCES USER(USERNAME);

CREATE OR REPLACE SEQUENCE USER_ID_SEQ
MINVALUE 1001;

CREATE OR REPLACE SEQUENCE BANK_ACCOUNT_ID
MINVALUE 1001;

CREATE TRIGGER ID_PK
BEFORE INSERT ON ID
FOR EACH ROW
BEGIN
SELECT EMPLOYEE_ID_SEQ.NEXTVAL INTO:NEW.C_ID FROM DUAL;
END;

CREATE TRIGGER DEPARTMENT_PK
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
SELECT DEPARTMENT_ID_SEQ.NEXTVAL INTO:NEW.C_ID FROM DUAL;
END;
 