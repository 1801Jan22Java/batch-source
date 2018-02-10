CREATE TABLE EMPLOYEE (
    EMPLOYEE_ID NUMBER,
    FIRST_NAME VARCHAR2(50),
    LAST_NAME VARCHAR2(50),
    EMAIL VARCHAR2(100),
    PASS VARCHAR2(50),
    CONSTRAINT PK_EMPLOYEE_ID PRIMARY KEY (EMPLOYEE_ID)
);
/

CREATE TABLE MANAGER (
    MANAGER_ID NUMBER,
    EMPLOYEE_ID NUMBER,
    CONSTRAINT PK_MANAGER_ID PRIMARY KEY (MANAGER_ID)
);
/

CREATE TABLE REQUEST (
    REQUEST_ID NUMBER,
    EMPLOYEE_ID NUMBER,
    DATE_SUBMITTED DATE,
    STATUS_ID NUMBER,
    DESCRIPTION VARCHAR2(500),
    AMOUNT NUMBER,
    CONSTRAINT PK_REQUEST_ID PRIMARY KEY (REQUEST_ID)
);
/

CREATE TABLE STATUS (
    STATUS_ID NUMBER,
    STATUS_NAME VARCHAR2(50),
    CONSTRAINT PK_STATUS_ID PRIMARY KEY (STATUS_ID)
);
/

CREATE TABLE STORED_FILE (
    FILE_ID NUMBER,
    FILE_NAME VARCHAR2(150),
    REQUEST_ID NUMBER,
    CONSTRAINT PK_FILE_ID PRIMARY KEY (FILE_ID)
);
/

CREATE TABLE REQUEST_LOG (
    LOG_ID NUMBER,
    REQUEST_ID NUMBER,
    RESPONSE VARCHAR2(500),
    MANAGER_ID NUMBER,
    STATUS_ID NUMBER,
    CONSTRAINT PK_LOG_ID PRIMARY KEY (LOG_ID)
);
/

ALTER TABLE MANAGER
ADD CONSTRAINT FK_MANAGER_EMPLOYEE_ID
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);

ALTER TABLE REQUEST
ADD CONSTRAINT FK_REQUEST_EMPLOYEE_ID
FOREIGN KEY (EMPLOYEE_ID) REFERENCES EMPLOYEE(EMPLOYEE_ID);

ALTER TABLE REQUEST
ADD CONSTRAINT FK_REQUEST_STATUS_ID
FOREIGN KEY (STATUS_ID) REFERENCES STATUS(STATUS_ID);

ALTER TABLE STORED_FILE
ADD CONSTRAINT FK_STORED_FILE_REQUEST_ID
FOREIGN KEY (REQUEST_ID) REFERENCES REQUEST(REQUEST_ID);

ALTER TABLE REQUEST_LOG
ADD CONSTRAINT FK_REQUEST_LOG_REQUEST_ID
FOREIGN KEY (REQUEST_ID) REFERENCES REQUEST(REQUEST_ID);

ALTER TABLE REQUEST_LOG
ADD CONSTRAINT FK_REQUEST_LOG_MANAGER_ID
FOREIGN KEY (MANAGER_ID) REFERENCES MANAGER(MANAGER_ID);

ALTER TABLE REQUEST_LOG
ADD CONSTRAINT FK_REQUEST_LOG_STATUS_ID
FOREIGN KEY (STATUS_ID) REFERENCES STATUS(STATUS_ID);

