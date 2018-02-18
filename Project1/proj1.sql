DROP TABLE REIMB;
DROP TABLE EMPLOYEE;
DROP TABLE MANAGER;

CREATE TABLE MANAGER (
  MANAGER_ID INTEGER PRIMARY KEY,
  FIRST_NAME VARCHAR2(100) NOT NULL,
  LAST_NAME VARCHAR2(100) NOT NULL,
  USERNAME VARCHAR2(100) UNIQUE NOT NULL,
  PASS_WORD VARCHAR2(100) NOT NULL,
  CONSTRAINT PASS_LEN_CK CHECK (LENGTH(PASS_WORD) >= 8)
);
/

CREATE TABLE EMPLOYEE (
  EMPLOYEE_ID INTEGER PRIMARY KEY,
  FIRST_NAME VARCHAR2(100) NOT NULL,
  LAST_NAME VARCHAR2(100) NOT NULL,
  JOB_TITLE VARCHAR2(100) NOT NULL,
  USERNAME VARCHAR2(100) UNIQUE NOT NULL,
  PASS_WORD VARCHAR2(100) NOT NULL,
  CONSTRAINT PASS_LEN_CK2 CHECK (LENGTH(PASS_WORD) >= 8)
);
/

CREATE TABLE REIMB (
    REIMB_ID INTEGER PRIMARY KEY,
    EMPLOYEE_ID INTEGER NOT NULL,
    MANAGER_ID INTEGER,
    AMOUNT DOUBLE PRECISION NOT NULL,
    STATUS INTEGER NOT NULL,
    IMAGE BLOB NOT NULL,
    DOC DATE NOT NULL,
    DOAD DATE,
    CONSTRAINT AMT_CK CHECK (AMOUNT > 0.01),
    CONSTRAINT EMP_FK
    FOREIGN KEY (EMPLOYEE_ID)
    REFERENCES EMPLOYEE (EMPLOYEE_ID),
    CONSTRAINT MGR_FK
    FOREIGN KEY (MANAGER_ID)
    REFERENCES MANAGER (MANAGER_ID)
);
/

CREATE SEQUENCE SQ_MGR_PK
START WITH 6
INCREMENT BY 2;
/

CREATE SEQUENCE SQ_EMP_PK
START WITH 5
INCREMENT BY 3;
/

CREATE SEQUENCE SQ_REIMB_PK
START WITH 4
INCREMENT BY 4;
/

CREATE OR REPLACE TRIGGER TR_INSERT_MGR
BEFORE INSERT ON MANAGER
FOR EACH ROW
BEGIN
  SELECT SQ_MGR_PK.NEXTVAL INTO :NEW.MANAGER_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_EMP
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
  SELECT SQ_EMP_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_REIMB
BEFORE INSERT ON REIMB
FOR EACH ROW
BEGIN
  SELECT SQ_REIMB_PK.NEXTVAL INTO :NEW.REIMB_ID FROM DUAL;
END;
/

CREATE OR REPLACE PROCEDURE CREATE_REIMB (
EMP_ID IN REIMB.EMPLOYEE_ID%TYPE,
AMT IN REIMB.AMOUNT%TYPE,
STS IN REIMB.STATUS%TYPE,
IMG IN REIMB.IMAGE%TYPE,
DC IN REIMB.DOC%TYPE
)
AS
BEGIN
    INSERT INTO REIMB (EMPLOYEE_ID, AMOUNT, STATUS, IMAGE, DOC)
    VALUES (EMP_ID, AMT, STS, IMG, DC);
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UPDATE_REIMB (
R_ID IN REIMB.REIMB_ID%TYPE,
MGR_ID IN MANAGER.MANAGER_ID%TYPE,
STS IN REIMB.STATUS%TYPE
)
AS
BEGIN
    UPDATE REIMB SET MANAGER_ID=MGR_ID, STATUS=STS WHERE REIMB_ID=R_ID;
    COMMIT;
END;
/

CREATE OR REPLACE PROCEDURE UPDATE_EMP (
EMP_ID IN EMPLOYEE.EMPLOYEE_ID%TYPE,
JOB_T IN EMPLOYEE.JOB_TITLE%TYPE,
PASS IN EMPLOYEE.PASS_WORD%TYPE
)
AS
BEGIN
    UPDATE EMPLOYEE SET JOB_TITLE=JOB_T, PASS_WORD=PASS WHERE EMPLOYEE_ID=EMP_ID;
    COMMIT;
END;
/

INSERT INTO EMPLOYEE(FIRST_NAME, LAST_NAME, JOB_TITLE, USERNAME, PASS_WORD)
VALUES('Chuck', 'Norris', 'Fitness Trainer', 'username', 'password');

SELECT * FROM EMPLOYEE;
truncate TABLE REIMB;
SELECT * FROM REIMB;

SELECT * FROM EMPLOYEE WHERE USERNAME='username' AND PASS_WORD='password';