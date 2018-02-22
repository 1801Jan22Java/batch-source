-- If the employee is a manager value is 1 else 0
CREATE TABLE Staff
(
    EmployeeId NUMBER NOT NULL,
    LastName VARCHAR2(20) NOT NULL,
    FirstName VARCHAR2(20) NOT NULL,
    Email VARCHAR2(60) NOT NULL,
    Pass VARCHAR2(20) NOT NULL,
    Username VARCHAR2(20),
    IsManager NUMBER,
    ReportsTo NUMBER,
    CONSTRAINT PK_Staff PRIMARY KEY (EmployeeId)
);

CREATE SEQUENCE STAFF_EMPLOYEEID_SEQ
    MINVALUE 1
    MAXVALUE 999
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
-- Increment Staff -> EmployeeId
CREATE OR REPLACE TRIGGER StaffTable_EmployeeId
BEFORE INSERT ON Staff
FOR EACH ROW
BEGIN
    SELECT STAFF_EMPLOYEEID_SEQ.NEXTVAL
    INTO :NEW.EmployeeId FROM DUAL;
END;
/

INSERT INTO Staff (LastName, FirstName, Email, Pass, IsManager, ReportsTo)
    VALUES ('Boo', 'John', 'jaja@gmail.com', 'jaja1', 1, 0);
INSERT INTO Staff (LastName, FirstName, Email, Pass, IsManager, ReportsTo)
    VALUES ('Doe', 'Jane', 'jaja2@gmail.com', 'jaja3', 0, 1);
INSERT INTO Staff (LastName, FirstName, Email, Pass, IsManager, ReportsTo)
    VALUES ('Revolver', 'Ocelot', 'caliber38@gmail.com', 'caliber1', 1, 0);
INSERT INTO Staff (LastName, FirstName, Email, Pass, IsManager, ReportsTo)
    VALUES ('Code', 'Boss', 'iAreBoss@gmail.com', 'boss1', 0, 3);
--UPDATE Staff SET ReportsTo = 1 WHERE EmployeeId = 2;
commit;
--DROP TABLE STAFF;
--DROP SEQUENCE STAFF_EMPLOYEEID_SEQ;
--DROP TRIGGER StaffTable_EmployeeId;

CREATE TABLE ReimbReq
(
    ReqId NUMBER NOT NULL,
    ReqName VARCHAR2(20) NOT NULL,
    Amount NUMBER NOT NULL,
    EmployeeId NUMBER NOT NULL,
    ReqStatus VARCHAR2(20),
    Receipt VARCHAR(100),
    ModByManagerId NUMBER,
    CONSTRAINT PK_ReimbReq PRIMARY KEY (ReqId)
);

--DROP TABLE ReimbReq;
--commit;

CREATE SEQUENCE REIMBREQ_REQID_SEQ
    MINVALUE 1
    MAXVALUE 999
    START WITH 1
    INCREMENT BY 1
    NOCACHE;
    
--DROP SEQUENCE REIMBREQ_REQID_SEQ;

-- Increment ReimbReq -> ReqId
CREATE OR REPLACE TRIGGER ReimbReqTable_ReqId
BEFORE INSERT ON ReimbReq
FOR EACH ROW
BEGIN
    SELECT REIMBREQ_REQID_SEQ.NEXTVAL
    INTO :NEW.ReqId FROM DUAL;
END;
/

--DROP TRIGGER ReimbReqTable_ReqId;
--COMMIT;

--ReqId NUMBER NOT NULL, ReqName VARCHAR2(20) NOT NULL, Amount NUMBER NOT NULL, EmployeeId NUMBER NOT NULL, ReqStatus VARCHAR2(20),
--Receipt VARCHAR(100), ModByManagerId NUMBER
INSERT INTO ReimbReq (ReqName, Amount, EmployeeId, ReqStatus)
    VALUES ('Gas', 10.56, 2, 'pending');
commit;