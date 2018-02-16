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

INSERT INTO Staff (LastName, FirstName, Email, Pass, IsManager)
    VALUES ('Boo', 'John', 'jaja@gmail.com', 'jaja1', 1);
INSERT INTO Staff (LastName, FirstName, Email, Pass, ReportsTo)
    VALUES ('Doe', 'Jane', 'jaja2@gmail.com', 'jaja3', 1);
--UPDATE Staff SET ReportsTo = 1 WHERE EmployeeId = 2;
commit;
--DROP TABLE STAFF;
--DROP SEQUENCE STAFF_EMPLOYEEID_SEQ;
--DROP TRIGGER StaffTable_EmployeeId;

CREATE TABLE ReimbReq
(
    ReqId NUMBER NOT NULL,
    EmployeeId NUMBER NOT NULL,
    ModByManagerId NUMBER,
    ReqStatus VARCHAR2(20),
    Receipt BLOB,
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

INSERT INTO ReimbReq (EmployeeId, ReqStatus)
    VALUES (2, 'pending');
commit;