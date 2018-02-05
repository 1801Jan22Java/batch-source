-- Create a database with two tables:
CREATE TABLE department
( department_id       NUMBER
, department_name     VARCHAR2(20) CONSTRAINT nn_department_1 NOT NULL
, CONSTRAINT pk_department_1 PRIMARY KEY(department_id)
, CONSTRAINT u_department_1 UNIQUE(department_name));

-- Create a sequence and trigger to auto-generate primary key values for both tables. 
CREATE SEQUENCE department_s1 START WITH 1001 INCREMENT BY 1;

-- Create a sequence and trigger to auto-generate primary key values for both tables. 
CREATE OR REPLACE TRIGGER department_t1_before_insert
BEFORE INSERT ON department
FOR EACH ROW 
BEGIN
	IF :new.department_id IS NULL THEN
		SELECT department_s1.NEXTVAL INTO :new.department_id
		FROM dual;
	END IF;
END;
/

-- Add departments
INSERT INTO department
( department_name )
VALUES
( 'Management' );

INSERT INTO department
( department_name )
VALUES
( 'IT' );

INSERT INTO department
( department_name )
VALUES
( 'Accounting' );
COMMIT;

-- Create a database with two tables:
CREATE TABLE employee
( employee_id       NUMBER
, emp_firstname     VARCHAR2(20) CONSTRAINT nn_employee_1 NOT NULL
, emp_lastname      VARCHAR2(20) CONSTRAINT nn_employee_2 NOT NULL
, department_id     NUMBER       CONSTRAINT nn_employee_3 NOT NULL
, salary            FLOAT        CONSTRAINT nn_employee_4 NOT NULL
, emp_email         VARCHAR2(60) CONSTRAINT nn_employee_5 NOT NULL
, CONSTRAINT pk_employee_1 PRIMARY KEY(employee_id)
, CONSTRAINT fk_employee_1 FOREIGN KEY(department_id) REFERENCES department(department_id));

-- Create a sequence and trigger to auto-generate primary key values for both tables. 
CREATE SEQUENCE employee_s1 START WITH 1001 INCREMENT BY 1;

-- Create a sequence and trigger to auto-generate primary key values for both tables. 
CREATE OR REPLACE TRIGGER employee_t1_before_insert
BEFORE INSERT ON employee
FOR EACH ROW 
BEGIN
	IF :new.employee_id IS NULL THEN
		SELECT employee_s1.NEXTVAL INTO :new.employee_id
		FROM dual;
	END IF;
END;
/

-- Insert at least six employees and three departments. 
INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Robert'
, 'Frost'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'Management' )
, 100000
, 'robert@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Charles'
, 'Dickens'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'Accounting' )
, 60000
, 'charles@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Ernest'
, 'Hemingway'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'Accounting' )
, 65000
, 'ernest@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Jane'
, 'Austin'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'Accounting' )
, 75000
, 'jane@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Stephen'
, 'King'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'IT' )
, 55000
, 'stephen@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Herman'
, 'Melville'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'IT' )
, 80000
, 'robert@company.com'	);

INSERT INTO employee
( emp_firstname
, emp_lastname
, department_id
, salary
, emp_email )
VALUES
( 'Dean'
, 'Koontz'
, ( SELECT department_id 
    FROM department
    WHERE department_name = 'IT' )
, 45000
, 'dean@company.com'	);
COMMIT;

-- Increase every employee's salary in a given department
CREATE OR REPLACE PROCEDURE sp_give_raise (pv_department_id NUMBER, pv_avg_salary OUT FLOAT) IS
    CURSOR employees_from_department IS SELECT employee_id FROM employee WHERE department_id = pv_department_id;
	lv_new_salary FLOAT;
	lv_old_salary FLOAT;
BEGIN
	SAVEPOINT before_raise;
	
	FOR i IN employees_from_department LOOP
		SELECT salary INTO lv_old_salary
		FROM employee
		WHERE employee_id = i.employee_id;
		
		lv_new_salary := (lv_old_salary + (lv_old_salary * .1));
		
		UPDATE employee
		SET salary = lv_new_salary
		WHERE employee_id = i.employee_id;
	END LOOP;
	
	SELECT AVG(salary) INTO pv_avg_salary 
	FROM employee 
	WHERE department_id = pv_department_id;
	
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO before_raise;
END;
/

