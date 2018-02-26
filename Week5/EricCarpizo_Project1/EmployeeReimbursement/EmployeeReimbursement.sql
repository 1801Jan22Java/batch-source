/**********************************************************
TABLES
**********************************************************/
--DROP TABLE Employee CASCADE CONSTRAINTS;
CREATE TABLE Employee
(
    Employee_Id INT NOT NULL,
    Emp_FirstName VARCHAR2(30),
    Emp_LastName VARCHAR2(30),
    Emp_Email VARCHAR2(255),
    Emp_Password VARCHAR2(25),
--    Emp_Phone VARCHAR2(10),
--    Emp_Address VARCHAR2(40),
--    Emp_City VARCHAR2(40),
--    Emp_State VARCHAR2(40),
--    Emp_ZipCode INT,
--    Emp_Country VARCHAR2(2)
    Manager_Id INT,
    IsManager INT,
    CONSTRAINT PK_Employee PRIMARY KEY  (Employee_Id)
);

--DROP TABLE Common_Lookup CASCADE CONSTRAINTS;
CREATE TABLE Common_Lookup
(
    Common_Lookup_Id INT NOT NULL,
    Table_Name VARCHAR2(30),
    Column_Name VARCHAR2(30),
    Keyword VARCHAR2(30),
    CONSTRAINT PK_Common_Lookup PRIMARY KEY  (Common_Lookup_Id)
);

--DROP TABLE Request CASCADE CONSTRAINTS;
CREATE TABLE Request
(
    Request_Id INT NOT NULL,
    Employee_Id INT NOT NULL,
    Created Date,
    Amount NUMBER,
    Status_Id INT NOT NULL,
    Purpose VARCHAR2(255),
    Employee_Notes CLOB,
    Manager_Id INT,
    Manager_Notes CLOB,
    CONSTRAINT PK_Request PRIMARY KEY  (Request_Id),
    CONSTRAINT FK_Request_Employee_Id FOREIGN KEY (Employee_Id) REFERENCES Employee (Employee_Id),
    CONSTRAINT FK_Request_Status_Id FOREIGN KEY (Status_Id) REFERENCES Common_Lookup (Common_Lookup_Id),
    CONSTRAINT FK_Request_Manager_Id FOREIGN KEY (Manager_Id) REFERENCES Employee (Employee_Id)
);

DROP TABLE Upload CASCADE CONSTRAINTS;
CREATE TABLE Upload
(
    Upload_Id INT NOT NULL,
    Filename VARCHAR(70),
    Request_Id INT NOT NULL,
    CONSTRAINT PK_Upload PRIMARY KEY (Upload_Id),
    CONSTRAINT FK_Upload_Request_Id FOREIGN KEY (Request_Id) REFERENCES Request (Request_Id)
);

/**********************************************************
TRIGGERS
**********************************************************/
/****Employee Trigger****/
CREATE SEQUENCE employee_s1 START WITH 1000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_employee
BEFORE INSERT ON Employee
FOR EACH ROW
BEGIN
    SELECT employee_s1.nextVal INTO :new.Employee_Id FROM DUAL;
END;
/

/****Request Trigger****/
CREATE SEQUENCE request_s1 START WITH 1000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_request
BEFORE INSERT ON Request
FOR EACH ROW
BEGIN
    SELECT request_s1.nextVal INTO :new.Request_Id FROM DUAL;
END;
/

/****Common_Lookup Trigger****/
CREATE SEQUENCE common_lookup_s1 START WITH 1000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_lookup
BEFORE INSERT ON Common_Lookup
FOR EACH ROW
BEGIN
    SELECT common_lookup_s1.nextVal INTO :new.Common_Lookup_Id FROM DUAL;
END;
/

/****Upload Trigger****/
CREATE SEQUENCE upload_s1 START WITH 1000 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER before_insert_upload
BEFORE INSERT ON Upload
FOR EACH ROW
BEGIN
    SELECT upload_s1.nextVal INTO :new.Upload_Id FROM DUAL;
END;
/
/**********************************************************
SETUP || TESTING
**********************************************************/

--INSERT INTO Common_Lookup (Table_Name, Column_Name, Keyword) VALUES('Request','Status_Id','Pending');
--INSERT INTO Common_Lookup (Table_Name, Column_Name, Keyword) VALUES('Request','Status_Id','Approved');
--INSERT INTO Common_Lookup (Table_Name, Column_Name, Keyword) VALUES('Request','Status_Id','Declined');
--commit;

--INSERT INTO Request (Employee_Id, Created, Amount, Status_Id, Purpose, Employee_Notes, Manager_Id, Manager_Notes) VALUES(1000,SYSDATE,9.00,1003,'test', 'employee notes test', null,'manager test notes');
--SELECT * FROM Request INNER JOIN Common_Lookup ON Common_Lookup.Common_Lookup_Id = Request.Status_Id;

--SELECT Common_Lookup_Id FROM Common_Lookup WHERE Keyword = 'Pending';

--INSERT INTO Employee (Emp_FirstName, Emp_LastName, Emp_Email, Emp_Password, Manager_Id, IsManager) VALUES ('Paul', 'Pizo', 'pauly@gmail.com', 'p', 1060, 0);
--INSERT INTO Employee (Emp_FirstName, Emp_LastName, Emp_Email, Emp_Password, Manager_Id, IsManager) VALUES ('John', 'Pizo', 'johnny@gmail.com', 'pass2', 0, 1);
--INSERT INTO Employee (Emp_FirstName, Emp_LastName, Emp_Email, Emp_Password, Manager_Id, IsManager) VALUES ('Eric', 'Pizo', 'ep@gmail.com', 'p', 1060, 1);
--commit;