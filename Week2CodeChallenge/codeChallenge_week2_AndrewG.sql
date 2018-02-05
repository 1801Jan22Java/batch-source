CREATE TABLE DEPARTMENTS (
    DEPARTMENT_ID NUMBER(10) PRIMARY KEY, 
    DEPARTMENT_NAME VARCHAR2(50)
)

CREATE TABLE EMPLOYEES (
    EMPLOYEE_ID NUMBER(10) PRIMARY KEY, 
    EMP_FIRSTNAME VARCHAR2 (50), 
    EMP_LASTNAME VARCHAR2(50), 
    DEPARTMENT_ID NUMBER(10), 
    SALARY NUMBER(20), 
    EMP_EMAIL VARCHAR2(100),
    CONSTRAINT BANKEMPLOYEES_FK FOREIGN KEY (DEPARTMENT_ID) REFERENCES DEPARTMENTS(DEPARTMENT_ID)
)




CREATE SEQUENCE CHALLENGE_SEQ 
START WITH 1
INCREMENT BY 1;

INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (CHALLENGE_SEQ.NEXTVAL, 'sales');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (CHALLENGE_SEQ.NEXTVAL, 'tech');
INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME) VALUES (CHALLENGE_SEQ.NEXTVAL, 'hr');

INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname1', 'lname1', 1, 8000, 'salesemployee1@gmail.com'); 
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname2', 'lname2', 1, 7000, 'salesemployee2@gmail.com'); 
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname3', 'lname3', 2, 5000, 'techemployee1@gmail.com'); 
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname4', 'lname4', 2, 2000, 'techemployee2@gmail.com'); 
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname5', 'lname5', 3, 4000, 'hremployee1@gmail.com'); 
INSERT INTO EMPLOYEES(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL) 
VALUES (CHALLENGE_SEQ.NEXTVAL, 'fname6', 'lname6', 3, 3000, 'hremployee2@gmail.com'); 

commit;
 
SET SERVEROUTPUT ON;
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE (
    V_DEPARTMENT_ID IN DEPARTMENTS.DEPARTMENT_ID%TYPE,
    V_SALARY_AVG IN OUT EMPLOYEES.SALARY%TYPE,
    IF_VALID_DEPT_ID IN OUT BOOLEAN)
IS
    CNT NUMBER;
BEGIN
-- 1. FIRST CHECK IF THE DEPT ID IS VALID
    SELECT COUNT(*) INTO CNT 
    FROM DEPARTMENTS
    WHERE DEPARTMENT_ID = V_DEPARTMENT_ID;
    --DBMS_OUTPUT.PUT_LINE(CNT);   
    IF CNT > 0
    THEN    --DBMS_OUTPUT.PUT_LINE('IT IS VALID DEPT_ID');
            IF_VALID_DEPT_ID := TRUE;
            
            SELECT AVG(E.SALARY*1.1) INTO V_SALARY_AVG 
            FROM DEPARTMENTS D, EMPLOYEES E
            WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
            AND D.DEPARTMENT_ID = V_DEPARTMENT_ID;
            
    ELSE    DBMS_OUTPUT.PUT_LINE('IT IS NOT VALID DEPT_ID');
            V_SALARY_AVG := 0;
    END IF;        
END;
/

DECLARE
V_SALARY_AVG EMPLOYEES.SALARY%TYPE := 0;
IF_VALID_DEPT_ID BOOLEAN := FALSE;
BEGIN
SP_GIVE_RAISE(3, V_SALARY_AVG, IF_VALID_DEPT_ID);
IF IF_VALID_DEPT_ID
THEN DBMS_OUTPUT.PUT_LINE('IT IS VALID DEPT. AVERAGE SALARY IS:'||V_SALARY_AVG); 
ELSE DBMS_OUTPUT.PUT_LINE('IT IS NOT VALID.');
END IF;

END;
/
 
 
 
 
-- BASIC SQL 
-- GET AVG SALARY WHICH IS 10% INCREASED BY A DEPT_ID
SELECT  AVG(E.SALARY*1.1)
FROM DEPARTMENTS D, EMPLOYEES E
WHERE D.DEPARTMENT_ID = E.DEPARTMENT_ID
AND D.DEPARTMENT_ID = 3;

-- CHECK IF THE DEPT ID IS VALID
SELECT COUNT(*)
FROM DEPARTMENTS
WHERE DEPARTMENT_ID = 3;