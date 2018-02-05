CREATE TABLE EMPLOYEE 
(EMPLOYEE_ID INTEGER PRIMARY KEY NOT NULL, 
EMP_FIRSTNAME VARCHAR2(20),
EMP_LASTNAME VARCHAR2(20),
DEPARTMENT_ID INTEGER,
SALARY INTEGER,
EMP_EMAIL VARCHAR2(30)
);

CREATE TABLE DEPARTMENT 
( DEPARTMENT_ID INTEGER NOT NULL,
DEPARTMENT_NAME VARCHAR2(30));

ALTER TABLE EMPLOYEE
ADD CONSTRAINT FK_DEPT_ID
FOREIGN KEY (DEPARTMENT_ID) 
REFERENCES DEPARTMENT(DEPARTMENT_ID);

-- CREATE SEQUENCES

CREATE SEQUENCE EMP_ID
START WITH 1002
MINVALUE 1002
MAXVALUE 10000000002
INCREMENT BY 2
CACHE 20;

CREATE SEQUENCE DEPT_ID
START WITH 1001
MINVALUE 1001
MAXVALUE 10000001
INCREMENT BY 2
CACHE 20;

-- EVEN ID -> EMPLOYEE
-- ODD ID -> DEPARTMENT


-- CREATE TRIGGERS 

SET DEFINE OFF
CREATE TRIGGER before_insert_employee
BEFORE INSERT
ON EMPLOYEE
FOR EACH ROW
BEGIN
  IF  :new.EMPLOYEE_ID IS NULL THEN
      SELECT EMP_ID.NEXTVAL INTO :new.EMPLOYEE_ID
      FROM DUAL;
  END IF;
END before_insert_employee;
/


SET DEFINE OFF
CREATE TRIGGER before_insert_department
BEFORE INSERT
ON DEPARTMENT
FOR EACH ROW
BEGIN
  IF  :new.DEPARTMENT_ID IS NULL THEN
      SELECT DEPT_ID.NEXTVAL INTO :new.DEPARTMENT_ID
      FROM DUAL;
  END IF;
END before_insert_department;
/


-- Stored Procedures
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE
(did INTEGER)
AS

BEGIN
  
  UPDATE EMPLOYEE SET SALARY = SALARY * 1.1
  WHERE DEPARTMENT_ID = did;
END SP_GIVE_RAISE;
/




-- Inserting Employees & Departments

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Corporate');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Entertainment');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Human Resources');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Nonhuman Resources');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Culinary');

INSERT INTO DEPARTMENT (DEPARTMENT_NAME) VALUES ('Hospitality');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Kvothe', 'Rothfuss', '1003', '40000', 'Kvoth@Arcanum.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Patrick', 'Rothfuss', '1003', '400000', 'Patrick@Arcanum.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Denna', 'MysteryWoman', '1003', '4000', 'MissD@Arcanum.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Mario', 'Churchill', '1007', '400000', 'MarioC@England.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('George', 'Harrison', '1007', '25000', 'GeorgeH@HR.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Micky', 'Mouse', '1009', '400000', 'LordVader@Starwars.com');

INSERT INTO EMPLOYEE (EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL)
VALUES ('Kylo', 'Skywalker', '1007', '100000', 'LordSkywalkder@Starwars.com');

