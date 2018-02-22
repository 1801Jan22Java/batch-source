CREATE TABLE Employee
(
    EmployeeID NUMBER NOT NULL,
    UserName Varchar2(20) NOT NULL,
    Password Varchar2(20) NOT NULL,
    FName Varchar2(20),
    LName Varchar2(20),
    Email Varchar2(40),
    IsManager NUMBER,
    CONSTRAINT PK_Employee PRIMARY KEY (EmployeeID)
);

CREATE TABLE Request
(
    RequestID NUMBER NOT NULL,
    EmployeeID NUMBER NOT NULL,
    Amount NUMBER NOT NULL,
    Description Varchar2(140),
    FileName Varchar2(40),
    DateOf Date DEFAULT SYSDATE,
    Status Varchar2(8) DEFAULT 'Pending',
    ManagerID NUMBER DEFAULT NULL,
    CONSTRAINT PK_Request PRIMARY KEY (RequestID),
    CONSTRAINT FK_EmployeeID FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID),
    CONSTRAINT FK_ManagerID FOREIGN KEY (ManagerID) REFERENCES Employee (EmployeeID)
);

CREATE SEQUENCE Request_Sequence
  START WITH 1
  INCREMENT BY 1;
  
CREATE OR REPLACE TRIGGER Request_On_Insert
  BEFORE INSERT ON Request
  FOR EACH ROW
BEGIN
  SELECT Request_Sequence.nextval
  INTO :new.RequestID
  FROM dual;
END;
/
    
CREATE SEQUENCE Employee_Sequence
  START WITH 1
  INCREMENT BY 1;
  
CREATE OR REPLACE TRIGGER Employee_On_Insert
  BEFORE INSERT ON Employee
  FOR EACH ROW
BEGIN
  SELECT Employee_Sequence.nextval
  INTO :new.EmployeeID
  FROM dual;
END;
/

drop table Employee;
drop table Request;
drop sequence request_sequence;

insert into Employee 
(UserName, Password, FName, LName, Email, IsManager)
VALUES
('E349', 'password', 'Evan', 'Camp', 'camp.evan@gmail.com', 1); 

insert into Employee 
(UserName, Password, FName, LName, Email, IsManager)
VALUES
('greedy', 'disco', 'Dustin', 'Mai', 'dMoney@gmail.com', 0);

insert into Employee 
(UserName, Password, FName, LName, Email, IsManager)
VALUES
('moneyBagz', 'gimmeallurmoney', 'Scrooge', 'McDuck', 'loadsamoney@gmail.com', 1);