--BURN EVERYTHING
DROP TABLE BANKTRANSACTION;
DROP TABLE BANK_S_USER;
DROP TABLE BANKACCOUNT;
DROP TABLE BANKUSER;
DROP SEQUENCE new_user_id;
DROP SEQUENCE new_bank_account_id;
DROP SEQUENCE new_transaction_id;

--Defines the bank user table.
CREATE TABLE BANKUSER (
    USERID          INTEGER PRIMARY KEY,
    FIRSTNAME       VARCHAR2(20 BYTE),
    LASTNAME        VARCHAR2(20 BYTE),
    USERNAME        VARCHAR2(50 BYTE),
    PASSWORD        VARCHAR2(80 BYTE)
);

--Defines the superuser table.
CREATE TABLE BANK_S_USER (
    USERID          INTEGER PRIMARY KEY,
    CONSTRAINT      fk_bankuser_id FOREIGN KEY (USERID) REFERENCES BANKUSER(USERID)
);

--Defines the bank account table
CREATE TABLE BANKACCOUNT (
    ACCOUNTID       INTEGER PRIMARY KEY,
    BALANCE         DOUBLE PRECISION,
    USERID          INTEGER,
    CONSTRAINT      fk_bank_account_user FOREIGN KEY (USERID) REFERENCES BANKUSER(USERID),
    ACCOUNT_TYPE    VARCHAR2(10 BYTE) CHECK(ACCOUNT_TYPE IN('Savings', 'Checking')),
    CONSTRAINT      one_account_type_per_user UNIQUE(USERID, ACCOUNT_TYPE)
);

--Defines the bank transaction table.
CREATE TABLE BANKTRANSACTION(
    TRANSACTIONID   INTEGER PRIMARY KEY,
    AMOUNT          DOUBLE PRECISION,
    TRANSACTIONDATE DATE,
    ACCOUNTID       INTEGER,
    TRANSACTIONTYPE VARCHAR2 (10 BYTE) CHECK(TRANSACTIONTYPE IN ('Transfer', 'Withdrawal', 'Deposit')),
    CONSTRAINT      fk_account_id FOREIGN KEY (ACCOUNTID) REFERENCES BANKACCOUNT(ACCOUNTID)
);

--Checks if a user is in the database or not.
CREATE OR REPLACE PROCEDURE user_in_database(v_username   VARCHAR2,
                                             v_pass       VARCHAR2,
                                             v_valid_user OUT BOOLEAN)
AS
    num_rows INTEGER;
BEGIN
    SELECT COUNT(*) INTO num_rows FROM BANKUSER WHERE USERNAME = v_username AND PASSWORD = v_pass;
    IF num_rows = 1 THEN
        v_valid_user := TRUE;
    ELSE
        v_valid_user := FALSE;
    END IF;
END;
/

--Checks whether a user is present in the superuser table or not.
CREATE OR REPLACE PROCEDURE is_Superuser(p_userid INTEGER, 
                                         v_valid_superuser OUT BOOLEAN)
AS
    num_rows INTEGER;
BEGIN
    SELECT COUNT(*) INTO num_rows FROM BANKUSER WHERE USERID = p_userid;
    IF num_rows = 1 THEN
        v_valid_superuser := TRUE;
    ELSE
        v_valid_superuser := FALSE;
    END IF;
END;
/

CREATE OR REPLACE PROCEDURE deposit_funds(deposit DOUBLE PRECISION, 
                                          user_id INTEGER, 
                                          accounttype VARCHAR2)
AS
    old_balance DOUBLE PRECISION;
    new_balance DOUBLE PRECISION;
BEGIN
    SELECT BALANCE INTO old_balance FROM BANKACCOUNT WHERE USERID = user_id AND ACCOUNT_TYPE = accounttype;
    new_balance := old_balance + deposit;
    UPDATE BANKACCOUNT SET BALANCE = new_balance WHERE USERID = user_id AND ACCOUNT_TYPE = accounttype;
END;
/
    
CREATE OR REPLACE PROCEDURE withdraw_funds( withdrawal  DOUBLE PRECISION,
                                        user_id     INTEGER,
                                        accountType VARCHAR2)
AS
    old_balance DOUBLE PRECISION;
    new_balance DOUBLE PRECISION;
BEGIN
    SELECT BALANCE INTO old_balance FROM BANKACCOUNT WHERE USERID = user_id AND ACCOUNT_TYPE = accountType;
    new_balance := old_balance - withdrawal;
    UPDATE BANKACCOUNT SET BALANCE = new_balance WHERE USERID = user_id AND ACCOUNT_TYPE = accountType;
END;
/

--Sequences for providing surrogate keys
--Surrogate key sequence for userid
CREATE SEQUENCE new_user_id
INCREMENT BY 1
START WITH 10000000;

--Surrogate key sequence for accountid
CREATE SEQUENCE new_bank_account_id
INCREMENT BY 1
START WITH 20000000;

--Surrogate key sequence for transactionid
CREATE SEQUENCE new_transaction_id
INCREMENT BY 1
START WITH 50000000;

--Before an insert on bank user, adds the surrogate key from sequence new_user_id.
CREATE OR REPLACE TRIGGER before_create_user BEFORE INSERT ON BANKUSER 
FOR EACH ROW
BEGIN
    SELECT new_user_id.nextval
    INTO :new.USERID
    FROM DUAL;
END;
/

--Before an insert on bank user, adds the surrogate key from sequences new_bank_account.
CREATE OR REPLACE TRIGGER before_create_account BEFORE INSERT ON BANKACCOUNT
FOR EACH ROW
BEGIN
    SELECT new_bank_account_id.nextval
    INTO :new.ACCOUNTID
    FROM DUAL;
END;
/

--Before an insert on transaction, adds the surrogate key from sequences before_create_transaction.
CREATE OR REPLACE TRIGGER before_create_transaction BEFORE INSERT ON BANKTRANSACTION
FOR EACH ROW
BEGIN
    SELECT new_transaction_id.nextval
    INTO :new.TRANSACTIONID
    FROM DUAL;
END;
/

CREATE OR REPLACE TRIGGER before_create_delete BEFORE DELETE ON BANKACCOUNT
FOR EACH ROW
BEGIN
    IF :new.BALANCE > 0 THEN
        raise_application_error(-21000, 'Account must be emptied first.');
    END IF;
END;
/

CREATE OR REPLACE TRIGGER before_withdrawal BEFORE UPDATE ON BANKACCOUNT
FOR EACH ROW
BEGIN
    IF :new.BALANCE < 0 THEN
        raise_application_error(-21000, 'Account overdrawn');
    END IF;
END;
/

BEGIN
    INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES(1, 'George', 'Bateman', 'account1', 'pass1');
    INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES(2, 'Zoe', 'Deschutes', 'account2', 'pass2');
    INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES(3, 'Jeff', 'Jeffries', 'account3', 'pass3');
    INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES(4, 'Jim', 'James', 'account4', 'pass4');
    INSERT INTO BANKUSER(USERID, FIRSTNAME, LASTNAME, USERNAME, PASSWORD) VALUES(5, 'Sara','Packett', 'account5','pass5');
    
    INSERT INTO BANK_S_USER(USERID) VALUES(10000000);
    
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(1, 2000.00, 10000000, 'Checking');
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(2, 60000.00, 10000000, 'Savings');
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(3, 1500.00, 10000001, 'Checking');
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(4, 20000000.00, 10000002, 'Checking');
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(5, 40.00, 10000003, 'Savings');
    INSERT INTO BANKACCOUNT(ACCOUNTID, BALANCE, USERID, ACCOUNT_TYPE) VALUES(6, 500.00, 10000004, 'Savings');
    commit;
END;
/

