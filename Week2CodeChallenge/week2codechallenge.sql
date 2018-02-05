CREATE TABLE EMPLOYEE (
EMPLOYEE_ID NUMBER, 
EMP_FIRSTNAME VARCHAR(20), 
EMP_LASTNAME VARCHAR(20), 
DEPARTMENT_ID NUMBER, 
SALARY NUMBER, 
EMP_EMAIL VARCHAR(20),
CONSTRAINT PK_EMPL_ID PRIMARY KEY (EMPLOYEE_ID)
);

CREATE TABLE DEPARTMENT (
DEPARTMENT_ID NUMBER, 
DEPARTMENT_NAME VARCHAR(20),
CONSTRAINT PK_DEPT_ID PRIMARY KEY (DEPARTMENT_ID)
);

--CONSTRAINTS
ALTER TABLE EMPLOYEE ADD CONSTRAINT FK_DEPTID
    FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENT (DEPARTMENT_ID)
    ON DELETE CASCADE;

--SEQUENCES
CREATE SEQUENCE SQ_EMPLOYEE_PK
START WITH 1
INCREMENT BY 1;
/

CREATE SEQUENCE SQ_DEPARTMENT_PK
START WITH 1
INCREMENT BY 1;
/

--TRIGGERS
CREATE OR REPLACE TRIGGER TR_INSERT_EMPL
BEFORE INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    SELECT SQ_EMPLOYEE_PK.NEXTVAL INTO :NEW.EMPLOYEE_ID FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER TR_INSERT_DEPT
BEFORE INSERT ON DEPARTMENT
FOR EACH ROW
BEGIN
    SELECT SQ_DEPARTMENT_PK.NEXTVAL INTO :NEW.DEPARTMENT_ID FROM DUAL;
END;
/

INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('ACCOUNTING');

INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('SHIPPING');

INSERT INTO DEPARTMENT(DEPARTMENT_NAME) VALUES('CUSTOMER SERVICE');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('Joe', 'Piscopo', 1, 40000, 'piscopo@trench.com');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('Tony', 'Reali', 1, 45000, 'reali@trench.com');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('Mike', 'Bike', 2, 50000, 'bike@trench.com');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('Fred', 'Flint', 2, 45000, 'flint@trench.com');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('King', 'Lear', 3, 60000, 'Lear@trench.com');

INSERT INTO EMPLOYEE(EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES('Jed', 'Clampett', 1, 30000, 'clampett@trench.com');

COMMIT;

--STORED PROCEDURES
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(PERCENT IN NUMBER, DEPARTMENT_ID IN NUMBER, AVERAGE OUT NUMBER)
AS
BEGIN
    UPDATE EMPLOYEE SET SALARY = (SALARY+SALARY*(PERCENT/100))
    WHERE EMPLOYEE.DEPARTMENT_ID = DEPARTMENT_ID;
    SELECT AVG(SALARY) INTO AVERAGE FROM EMPLOYEE E
    WHERE E.DEPARTMENT_ID = DEPARTMENT_ID;
END;
/

SELECT DISTINCT DEPARTMENT_NAME, AVG(SALARY) FROM DEPARTMENT D, EMPLOYEE E 
WHERE E.DEPARTMENT_ID = D.DEPARTMENT_ID
GROUP BY DEPARTMENT_NAME;