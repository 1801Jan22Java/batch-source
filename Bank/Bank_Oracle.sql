-- Create common lookup table.
CREATE TABLE common_lookup
( common_lookup_id NUMBER
, ref_table            VARCHAR2(30) CONSTRAINT nn_common_lookup_1 NOT NULL
, ref_column           VARCHAR2(30) CONSTRAINT nn_common_lookup_2 NOT NULL
, keyword          VARCHAR2(30) CONSTRAINT nn_common_lookup_3 NOT NULL
, description      VARCHAR2(80)
, creation_date    DATE         CONSTRAINT nn_common_lookup_4 NOT NULL
, CONSTRAINT pk_common_lookup_1    PRIMARY KEY(common_lookup_id));
-- Create sequence.
CREATE SEQUENCE common_lookup_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER common_lookup_t1_before_insert
BEFORE INSERT ON common_lookup
FOR EACH ROW 
BEGIN
	IF :new.common_lookup_id IS NULL THEN
		SELECT common_lookup_s1.NEXTVAL INTO :new.common_lookup_id
		FROM dual;
	END IF;
	IF :new.creation_date IS NULL THEN
		SELECT SYSDATE INTO :new.creation_date
		FROM dual;
	END IF;
END;
/
COMMIT;

-- Add common lookups for normal and super users
INSERT INTO common_lookup
( ref_table
, ref_column
, keyword
, description )
VALUES
( 'users'
, 'user_type'
, 'USER'
, 'Normal user can only modify an account owned by them' );

INSERT INTO common_lookup
( ref_table
, ref_column
, keyword
, description )
VALUES
( 'users'
, 'user_type'
, 'SUPERUSER'
, 'Super user can modify any account' );

-- Add common lookups for checking and savings accounts
INSERT INTO common_lookup
( ref_table
, ref_column
, keyword )
VALUES
( 'accounts'
, 'account_type'
, 'CHECKING' );

INSERT INTO common_lookup
( ref_table
, ref_column
, keyword )
VALUES
( 'accounts'
, 'account_type'
, 'SAVINGS' );

-- Add common lookups for deposits and withdraws for future use
INSERT INTO common_lookup
( ref_table
, ref_column
, keyword )
VALUES
( 'transactions'
, 'transaction_type'
, 'DEPOSIT' );

INSERT INTO common_lookup
( ref_table
, ref_column
, keyword )
VALUES
( 'transactions'
, 'transaction_type'
, 'WITHDRAW' );
COMMIT;

-- Create table with constraints.
CREATE TABLE users
( userid        NUMBER
, username      VARCHAR2(20) CONSTRAINT nn_users_1 NOT NULL
, password      VARCHAR2(20)
, user_type     NUMBER       CONSTRAINT nn_users_2 NOT NULL
, firstname     VARCHAR2(20)
, lastname      VARCHAR2(20)
, creation_date DATE         CONSTRAINT nn_users_3 NOT NULL
, CONSTRAINT pk_users_1 PRIMARY KEY(userid)
, CONSTRAINT u_users_1 UNIQUE(username)
, CONSTRAINT fk_users_1 FOREIGN KEY(user_type) REFERENCES common_lookup(common_lookup_id));
-- Create sequence.
CREATE SEQUENCE users_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER users_t1_before_insert
BEFORE INSERT ON users
FOR EACH ROW 
BEGIN
	IF :new.userid IS NULL THEN
		SELECT users_s1.NEXTVAL INTO :new.userid
		FROM dual;
	END IF;
	IF :new.user_type IS NULL THEN
		SELECT common_lookup_id INTO :new.user_type
		FROM common_lookup
		WHERE ref_table = 'users' AND ref_column = 'user_type' AND keyword = 'USER';
	END IF;
	IF :new.creation_date IS NULL THEN
		SELECT SYSDATE INTO :new.creation_date
		FROM dual;
	END IF;
END;
/

-- Add super user
INSERT INTO users
( username
, password
, user_type )
VALUES
( 'admin'
, 'cangetin'
, ( SELECT common_lookup_id 
    FROM common_lookup
    WHERE ref_table = 'users' AND ref_column = 'user_type' AND keyword = 'SUPERUSER') );
COMMIT;

-- Create table with constraints.
CREATE TABLE accounts
( accountid     NUMBER
, account_type  NUMBER       CONSTRAINT nn_accounts_1 NOT NULL
, balance       FLOAT        CONSTRAINT nn_accounts_2 NOT NULL
, name          VARCHAR2(20)
, creation_date DATE         CONSTRAINT nn_accounts_3 NOT NULL
, CONSTRAINT pk_accounts_1 PRIMARY KEY(accountid)
, CONSTRAINT fk_accounts_1 FOREIGN KEY(account_type) REFERENCES common_lookup(common_lookup_id));
-- Create sequence.
CREATE SEQUENCE accounts_s1 START WITH 111111111 INCREMENT BY 7;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER accounts_t1_before_insert
BEFORE INSERT ON accounts
FOR EACH ROW 
BEGIN
	IF :new.accountid IS NULL THEN
		SELECT accounts_s1.NEXTVAL INTO :new.accountid
		FROM dual;
	END IF;
	IF :new.balance IS NULL THEN
		:new.balance := 0.00;
	END IF;
	IF :new.creation_date IS NULL THEN
		SELECT SYSDATE INTO :new.creation_date
		FROM dual;
	END IF;
END;
/

-- Create junction table with constraints.
CREATE TABLE user_account
( userid          NUMBER
, accountid       NUMBER
, add_date        DATE    CONSTRAINT nn_user_account_1 NOT NULL
, CONSTRAINT pk_user_account_1 PRIMARY KEY(userid, accountid)
, CONSTRAINT fk_user_account_1 FOREIGN KEY(userid) REFERENCES users(userid)
, CONSTRAINT fk_user_account_2 FOREIGN KEY(accountid) REFERENCES accounts(accountid));
-- Create sequence.
CREATE SEQUENCE user_account_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER user_account_t1_before_insert
BEFORE INSERT ON user_account
FOR EACH ROW 
BEGIN
	IF :new.add_date IS NULL THEN
		SELECT SYSDATE INTO :new.add_date
		FROM dual;
	END IF;
END;
/

-- Create transaction table for future use.
CREATE TABLE transactions
( transactionid    NUMBER
, transaction_type NUMBER  CONSTRAINT nn_transactions_1 NOT NULL
, amount           FLOAT   CONSTRAINT nn_transactions_2 NOT NULL
, userid           NUMBER  CONSTRAINT nn_transactions_3 NOT NULL
, accountid        NUMBER  CONSTRAINT nn_transactions_4 NOT NULL
, balance          FLOAT   CONSTRAINT nn_transactions_5 NOT NULL
, event_date       DATE    CONSTRAINT nn_transactions_6 NOT NULL
, CONSTRAINT pk_transactions_1 PRIMARY KEY(transactionid)
, CONSTRAINT fk_transactions_1 FOREIGN KEY(userid) REFERENCES users(userid)
, CONSTRAINT fk_transactions_2 FOREIGN KEY(accountid) REFERENCES accounts(accountid)
, CONSTRAINT fk_transactions_3 FOREIGN KEY(transaction_type) REFERENCES common_lookup(common_lookup_id));
-- Create sequence.
CREATE SEQUENCE transactions_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER transactions_t1_before_insert
BEFORE INSERT ON transactions
FOR EACH ROW 
BEGIN
	IF :new.transactionid IS NULL THEN
		SELECT transactions_s1.NEXTVAL INTO :new.transactionid
		FROM dual;
	END IF;
	IF :new.event_date IS NULL THEN
		SELECT SYSDATE INTO :new.event_date
		FROM dual;
	END IF;
END;
/

-- Adds new bank account, adds new entry in the junction table with the userid
CREATE OR REPLACE PROCEDURE add_account( pv_account_type VARCHAR2
									   , pv_account_name VARCHAR2
									   , pv_userid NUMBER
									   , pv_accountid OUT NUMBER
									   , pv_creation_date OUT DATE) IS
BEGIN
	INSERT INTO accounts (name, account_type) 
	VALUES ( pv_account_name
	       , ( SELECT common_lookup_id 
			   FROM common_lookup
			   WHERE ref_table = 'accounts' AND ref_column = 'account_type' AND keyword = pv_account_type) );
	INSERT INTO user_account(userid, accountid)
	VALUES(pv_userid, accounts_s1.CURRVAL);
	pv_accountid := accounts_s1.CURRVAL;
	pv_creation_date := SYSDATE;
END;
/

-- Accepts the deposit amount, Calculates the new balance, saves balance to account, and logs the transaction
CREATE OR REPLACE PROCEDURE deposit (pv_userid NUMBER, pv_accountid NUMBER, pv_deposit FLOAT, pv_balance OUT FLOAT) IS
    lv_balance FLOAT;
BEGIN
    SELECT balance INTO lv_balance 
    FROM accounts 
    WHERE accountid = pv_accountid;
    
    pv_balance := lv_balance;
    
    SAVEPOINT before_deposit;
    
    pv_balance := (lv_balance + pv_deposit);
    
    UPDATE accounts 
    SET balance = pv_balance 
    WHERE accountid = pv_accountid;
    
    INSERT INTO transactions 
    ( transaction_type
    , amount
    , userid
    , accountid
	, balance )
    VALUES
    ( (SELECT common_lookup_id
       FROM common_lookup
       WHERE ref_table = 'transactions' AND ref_column = 'transaction_type' AND keyword = 'DEPOSIT')
    , pv_deposit
    , pv_userid
    , pv_accountid
	, pv_balance );
    
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO before_deposit;
END;
/

-- Accepts the withdraw amount, Calculates the new balance, saves balance to account, and logs the transaction
CREATE OR REPLACE PROCEDURE withdraw (pv_userid NUMBER, pv_accountid NUMBER, pv_withdraw FLOAT, pv_balance OUT FLOAT) IS
    lv_balance FLOAT;
BEGIN
    SELECT balance INTO lv_balance 
    FROM accounts 
    WHERE accountid = pv_accountid;
    
    pv_balance := lv_balance;
    
    SAVEPOINT before_withdraw;
    
    pv_balance := (lv_balance - pv_withdraw);
    
    UPDATE accounts 
    SET balance = pv_balance 
    WHERE accountid = pv_accountid;
    
    INSERT INTO transactions 
    ( transaction_type
    , amount
    , userid
    , accountid
	, balance )
    VALUES
    ( (SELECT common_lookup_id
       FROM common_lookup
       WHERE ref_table = 'transactions' AND ref_column = 'transaction_type' AND keyword = 'WITHDRAW')
    , pv_withdraw
    , pv_userid
    , pv_accountid
	, pv_balance );
    
    COMMIT;
    EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK TO before_deposit;
END;
/

COMMIT