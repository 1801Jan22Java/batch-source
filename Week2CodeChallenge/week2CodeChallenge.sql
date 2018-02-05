--Create a database with two tables:
--EMPLOYEE
--Columns: EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL
CREATE TABLE Employee (
    Employee_Id NUMBER NOT NULL,
    Emp_FirstName VARCHAR2(40) NOT NULL,
    Emp_LastName VARCHAR2(40) NOT NULL,
    Department_Id NUMBER NOT null,
    Salary NUMBER,
    Emp_Email VARCHAR2(60),
    CONSTRAINT PK_Employee PRIMARY KEY (Employee_Id)
);

--DEPARTMENT:
--Columns: DEPARTMENT_ID, DEPARTMENT_NAME
CREATE TABLE Department (
    Department_Id NUMBER NOT NULL,
    Department_Name VARCHAR2(120),
    CONSTRAINT PK_Department PRIMARY KEY (Department_Id)
);

--ALTER TABLE Employee ADD CONSTRAINT FK_EmployeeDepartment_Id
--    FOREIGN KEY (Department_Id) REFERENCES Department (Department_Id);
--ALTER TABLE Employee DROP CONSTRAINT FK_EmployeeDepartment_Id;
    
--Create a sequence and trigger to auto-generate primary key values for both tables. 
CREATE SEQUENCE EmployeeTableSeq
    MAXVALUE 100
    START WITH 1
    INCREMENT BY 1;
    
CREATE OR REPLACE TRIGGER AfterInsertEmployee  
    BEFORE INSERT 
    ON Employee
DECLARE newIndex NUMBER;
BEGIN
    CASE
        WHEN INSERTING THEN
            SELECT EmployeeTableSeq.NEXTVAL INTO newIndex FROM DUAL;
    END CASE;
END;
/

--Insert at least six employees and three departments. 
INSERT INTO Employee (Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(1, 'Johnny', 'Five', 10);
INSERT INTO Employee (Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(2, 'Sony', 'Vaio', 11);
INSERT INTO Employee (Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(3, 'Hello', 'Venus', 12);
INSERT INTO Employee ( Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(4, 'Boa', 'Kwon', 12);
INSERT INTO Employee (Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(5, 'Raymond', 'Genius', 11);
INSERT INTO Employee (Employee_Id, Emp_FirstName, Emp_LastName, Department_Id) VALUES(6, 'Revolver', 'Ocelot', 10);

INSERT INTO Department(Department_Id, Department_Name) VALUES(10, 'Monsters Inc.');
INSERT INTO Department(Department_Id, Department_Name) VALUES(11, 'Swamp Land');
INSERT INTO Department(Department_Id, Department_Name) VALUES(12, 'Farfar Away');

--Create a stored procedure SP_GIVE_RAISE which takes in a DEPARTMENT_ID and increases each 
--employee's salary within the department by 10%, and returns the new average salary for the 
--department, as well as a boolean value indicating whether the ID entered corresponds to a valid
--department. 
CREATE OR REPLACE PROCEDURE SP_GIVE_RAISE (
    MODSALARY IN NUMBER,
    MODDEPT VARCHAR2
    )  
AS
DECLARE 
    newEmployeeSalary NUMBER;
BEGIN
    newEmployeeSalary := (MODSALARY + (MODSALARY * .10));
    UPDATE employee 
    SET salary = newEmployeeSalary
    WHERE Department_Id = MODDEPT; 
END SP_GIVE_RAISE;
/

