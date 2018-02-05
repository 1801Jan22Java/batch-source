--Emergency drop
DROP TABLE EMPLOYEECC;
DROP TABLE DEPARTMENTCC;
DROP SEQUENCE department_id_seq;
DROP SEQUENCE employee_id_seq;

CREATE TABLE DEPARTMENTCC (
    DEPARTMENT_ID   NUMBER(6) PRIMARY KEY,
    DEPARTMENT_NAME VARCHAR2(80 BYTE)
);

CREATE TABLE EMPLOYEECC (
    EMPLOYEE_ID   NUMBER(6) PRIMARY KEY,
    EMP_FIRSTNAME VARCHAR2(30 BYTE),
    EMP_LASTNAME  VARCHAR2(30 BYTE),
    SALARY        NUMBER(20),
    EMP_EMAIL     VARCHAR2(80 BYTE),
    DEPARTMENT_ID CONSTRAINT fk_department_id
                  REFERENCES DEPARTMENTCC(DEPARTMENT_ID)
);

CREATE SEQUENCE department_id_seq
INCREMENT BY 1
MINVALUE 100000;

CREATE SEQUENCE employee_id_seq
INCREMENT BY 1
MINVALUE 500000;

CREATE OR REPLACE PROCEDURE add_new_department(p_department_name VARCHAR2)
AS
BEGIN
    INSERT INTO DEPARTMENTCC(DEPARTMENT_ID, DEPARTMENT_NAME)
    VALUES(department_id_seq.nextval, p_department_name);
END;
/

CREATE OR REPLACE PROCEDURE add_new_employee(p_first VARCHAR2, p_last VARCHAR2, p_salary VARCHAR2, p_email VARCHAR2, p_dept_id NUMBER)
AS
BEGIN
    INSERT INTO EMPLOYEECC(EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, SALARY, EMP_EMAIL, DEPARTMENT_ID)
    VALUES(employee_id_seq.nextval, p_first, p_last, p_salary, p_email, p_dept_id);
END;
/

BEGIN
    add_new_department('Management');
    add_new_department('Development Resources');
    add_new_department('Human Resources');
    
    --Just a bunch of code monkeys...
    add_new_employee('Neil', 'Bateman', 100000, 'neil.bateman@example.co', 100000);
    add_new_employee('Curious', 'George', 55000, 'curious.george@example.co', 100001);
    add_new_employee('Koko', 'Gorilla', 60000, 'koko.gorilla@example.co', 100001);
    add_new_employee('King', 'Kong', 80000, 'king.kong@example.co', 100001);
    add_new_employee('Tarzan', 'Englishman', 45000, 'tarzan.englishman@example.co', 100002);
    add_new_employee('Jane', 'Goodall', 50000, 'jane.goodall@example.co', 100002);
END;
/

CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE(p_dept_id NUMBER, v_valid_dept_id OUT BOOLEAN, v_new_avg OUT NUMBER)
AS
BEGIN
    FOR emp IN (SELECT * FROM EMPLOYEECC WHERE DEPARTMENT_ID = p_dept_id) LOOP
        UPDATE EMPLOYEECC SET SALARY = emp.SALARY*1.1 WHERE EMPLOYEE_ID = emp.EMPLOYEE_ID;
    END LOOP;
    SELECT AVG(SALARY) INTO v_new_avg FROM EMPLOYEECC WHERE DEPARTMENT_ID = p_dept_id;
    
    --Forgot how to catch exceptions
END;
/