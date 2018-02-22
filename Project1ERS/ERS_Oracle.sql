-- Create common lookup table.
CREATE TABLE common_lookup
( common_lookup_id NUMBER
, ref_key        VARCHAR2(30) CONSTRAINT nn_common_lookup_1 NOT NULL
, ref_value      VARCHAR2(30) CONSTRAINT nn_common_lookup_2 NOT NULL
, description    VARCHAR2(80)
, creation_date  DATE         DEFAULT SYSDATE 
                              CONSTRAINT nn_common_lookup_3 NOT NULL
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
END;
/
COMMIT;

-- Add common lookups for normal and super users
INSERT INTO common_lookup
( ref_key
, ref_value )
VALUES
( 'REQUEST_STATUS'
, 'Pending' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_STATUS'
, 'Approved'
, 'Manager Only' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_STATUS'
, 'Denied'
, 'Manager Only' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_STATUS'
, 'Cancelled'
, 'Author Only' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_STATUS'
, 'Reopened'
, 'Who closed it can reopen it' );

-- Add common lookups for checking and savings accounts
INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_TYPE'
, 'Medical'
, 'Request for reimbursement of medical expenses' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_TYPE'
, 'Travel'
, 'Request for reimbursement of travel expenses' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_TYPE'
, 'Food'
, 'Request for reimbursement of food expenses' );

INSERT INTO common_lookup
( ref_key
, ref_value
, description )
VALUES
( 'REQUEST_TYPE'
, 'Miscellaneous'
, 'Request for reimbursement of other expenses' );
COMMIT;

-- Create table with constraints.
CREATE TABLE employee
( employee_id   NUMBER
, firstname     VARCHAR2(40)  CONSTRAINT nn_employee_1 NOT NULL
, lastname      VARCHAR2(40)  CONSTRAINT nn_employee_2 NOT NULL
, email         VARCHAR2(40)  CONSTRAINT nn_employee_3 NOT NULL
, password      VARCHAR2(128) CONSTRAINT nn_employee_4 NOT NULL
, reports_to    NUMBER       
, job_title     VARCHAR2(60) CONSTRAINT nn_employee_5 NOT NULL
, creation_date DATE         DEFAULT SYSDATE 
							 CONSTRAINT nn_employee_6 NOT NULL
, CONSTRAINT pk_employee_1 PRIMARY KEY(employee_id)
, CONSTRAINT u_employee_1 UNIQUE(email)
, CONSTRAINT fk_employee_1 FOREIGN KEY(reports_to) REFERENCES employee(employee_id));
-- Create sequence.
CREATE SEQUENCE employee_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
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
COMMIT;

-- Add CEO
INSERT INTO employee
( firstname
, lastname
, email
, password
, job_title )
VALUES
( 'Bob'
, 'Ross'
, 'bob@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, 'CEO' );
COMMIT;

-- Add Manager
INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Bill'
, 'Gates'
, 'bill@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bob@company.com' )
, 'IT Manager' );
COMMIT;

-- Add IT Staff
INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Leonard'
, 'Blumberg'
, 'leonard@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bill@company.com' )
, 'Software Developer' );
COMMIT;

INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Eric'
, 'Carpizo'
, 'eric@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bill@company.com' )
, 'Web Designer' );
COMMIT;

INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'James'
, 'Whitten'
, 'james@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bill@company.com' )
, 'Network Administrator' );
COMMIT;

INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Joshua'
, 'Brandl'
, 'josh@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bill@company.com' )
, 'Server Engineer' );
COMMIT;

-- Add Manager
INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Steve'
, 'Jobs'
, 'steve@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'bob@company.com' )
, 'Sales Manager' );
COMMIT;

-- Add Sales Staff
INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Vince'
, 'Offer'
, 'vince@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'steve@company.com' )
, 'Sales Associate' );
COMMIT;

INSERT INTO employee
( firstname
, lastname
, email
, password
, reports_to
, job_title )
VALUES
( 'Billy'
, 'Mays'
, 'billy@company.com'
, '5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8'
, ( SELECT employee_id FROM employee WHERE email = 'steve@company.com' )
, 'Sales Associate' );
COMMIT;

-- Create table with constraints.
CREATE TABLE request
( request_id         NUMBER
, request_author_id  NUMBER  CONSTRAINT nn_request_1 NOT NULL
, request_type_id    NUMBER  CONSTRAINT nn_request_2 NOT NULL
, current_status_id  NUMBER  CONSTRAINT nn_request_3 NOT NULL
, current_manager_id NUMBER
, amount			 FLOAT   CONSTRAINT nn_request_4 NOT NULL
, description        CLOB    CONSTRAINT nn_request_5 NOT NULL
, creation_date      DATE    DEFAULT SYSDATE
						     CONSTRAINT nn_request_6 NOT NULL
, CONSTRAINT pk_request_1 PRIMARY KEY(request_id)
, CONSTRAINT c_request_1 CHECK (amount > 0.0)
, CONSTRAINT fk_request_1 FOREIGN KEY(request_author_id) REFERENCES employee(employee_id)
, CONSTRAINT fk_request_2 FOREIGN KEY(request_type_id) REFERENCES common_lookup(common_lookup_id)
, CONSTRAINT fk_request_3 FOREIGN KEY(current_status_id) REFERENCES common_lookup(common_lookup_id)
, CONSTRAINT fk_request_4 FOREIGN KEY(current_manager_id) REFERENCES employee(employee_id) );
-- Create sequence.
CREATE SEQUENCE request_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger
CREATE OR REPLACE TRIGGER request_t1_before_insert
BEFORE INSERT ON request
FOR EACH ROW 
BEGIN
	IF :new.request_id IS NULL THEN
		SELECT request_s1.NEXTVAL INTO :new.request_id
		FROM dual;
	END IF;
	
	IF :new.current_status_id IS NULL THEN
		SELECT common_lookup_id INTO :new.current_status_id 
		FROM common_lookup WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Pending';
	END IF;
END;
/

-- Create junction table with constraints.
CREATE TABLE event
( event_id           NUMBER
, request_id         NUMBER CONSTRAINT nn_event_1 NOT NULL
, event_author_id    NUMBER CONSTRAINT nn_event_2 NOT NULL
, request_status_id  NUMBER CONSTRAINT nn_event_3 NOT NULL
, message            CLOB
, creation_date      DATE   DEFAULT SYSDATE
						    CONSTRAINT nn_event_4 NOT NULL
, CONSTRAINT pk_event_1 PRIMARY KEY(event_id)
, CONSTRAINT fk_event_1 FOREIGN KEY(request_id) REFERENCES request(request_id)
, CONSTRAINT fk_event_2 FOREIGN KEY(event_author_id) REFERENCES employee(employee_id)
, CONSTRAINT fk_event_3 FOREIGN KEY(request_status_id) REFERENCES common_lookup(common_lookup_id) );
-- Create sequence.
CREATE SEQUENCE event_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create trigger to copy request status to event status when null
CREATE OR REPLACE TRIGGER event_t1_before_insert
BEFORE INSERT ON event
FOR EACH ROW 
BEGIN
	IF :new.event_id IS NULL THEN
		SELECT event_s1.NEXTVAL INTO :new.event_id
		FROM dual;
	END IF;
	
	IF :new.request_status_id IS NULL OR :new.request_status_id = 0 THEN
		SELECT current_status_id INTO :new.request_status_id
		FROM request WHERE request_id = :new.request_id;
	END IF;
END;
/

-- Create trigger to update request status and manager with event status and author
CREATE OR REPLACE TRIGGER event_t2_after_insert
AFTER INSERT ON event
FOR EACH ROW 
DECLARE
	lv_approved NUMBER;
	lv_denied NUMBER;
	lv_reopened NUMBER;
	lv_pending NUMBER;
BEGIN
	SELECT common_lookup_id INTO lv_approved
	FROM common_lookup
	WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Approved';
	
	SELECT common_lookup_id INTO lv_denied
	FROM common_lookup
	WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Denied';
	
	SELECT common_lookup_id INTO lv_reopened
	FROM common_lookup
	WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Reopened';
	
	SELECT common_lookup_id INTO lv_pending
	FROM common_lookup
	WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Pending';
	
	-- If a manager has closed the request, record who closed it
	-- Else remove manager information
	IF :new.request_status_id = lv_approved OR :new.request_status_id = lv_denied THEN
		UPDATE request 
		SET current_status_id = :new.request_status_id
		  , current_manager_id = :new.event_author_id
		WHERE request_id = :new.request_id;
	ELSIF :new.request_status_id = lv_reopened THEN
		UPDATE request 
		SET current_status_id = lv_pending
		  , current_manager_id = NULL
		WHERE request_id = :new.request_id;
	ELSE
		UPDATE request 
		SET current_status_id = :new.request_status_id
		  , current_manager_id = NULL
		WHERE request_id = :new.request_id;
	END IF;
END;
/

-- Create transaction table for future use.
CREATE TABLE upload
( upload_id         NUMBER
, display_name      VARCHAR(100)
, filename          VARCHAR(20)
, request_id        NUMBER
, upload_author_id  NUMBER
, creation_date     DATE 		DEFAULT SYSDATE
							    CONSTRAINT nn_upload_1 NOT NULL
, CONSTRAINT pk_upload_1 PRIMARY KEY(upload_id)
, CONSTRAINT u_upload_1 UNIQUE(filename)
, CONSTRAINT fk_upload_1 FOREIGN KEY(request_id) REFERENCES request(request_id)
, CONSTRAINT fk_upload_2 FOREIGN KEY(upload_author_id) REFERENCES employee(employee_id) );
-- Create sequence.
CREATE SEQUENCE upload_s1 START WITH 1001 INCREMENT BY 1;
COMMIT;
-- Create triggers
CREATE OR REPLACE TRIGGER upload_t1_before_insert
BEFORE INSERT ON upload
FOR EACH ROW 
BEGIN
	IF :new.upload_id IS NULL THEN
		SELECT upload_s1.NEXTVAL INTO :new.upload_id
		FROM dual;
	END IF;
END;
/

CREATE OR REPLACE TRIGGER upload_t2_after_insert
AFTER INSERT ON upload
FOR EACH ROW 
BEGIN
	UPDATE request SET current_status_id = ( SELECT common_lookup_id 
											 FROM common_lookup 
											 WHERE ref_key = 'REQUEST_STATUS' AND ref_value = 'Pending' )
	WHERE request_id = :new.request_id;
END;
/

CREATE OR REPLACE PROCEDURE update_employee ( pv_employeeid  NUMBER
											, pv_firstname   VARCHAR2
											, pv_lastname    VARCHAR2
											, pv_email       VARCHAR2
											, pv_password    VARCHAR2
											, pv_job_title   VARCHAR2
											, pv_success OUT NUMBER ) IS
BEGIN
	pv_success := 1;
	SAVEPOINT before_update;
	-- If an firstname was passed, update firstname
	IF(pv_firstname IS NOT NULL) THEN
		UPDATE employee SET firstname = pv_firstname WHERE employee_id = pv_employeeid;
	END IF;
	-- If a lastname was passed, update lastname
	IF(pv_lastname IS NOT NULL) THEN
		UPDATE employee SET lastname = pv_lastname WHERE employee_id = pv_employeeid;
	END IF;
	-- If a email was passed, update email
	IF(pv_email IS NOT NULL) THEN
		UPDATE employee SET email = pv_email WHERE employee_id = pv_employeeid;
	END IF;
	-- If a password was passed, update password
	IF(pv_password IS NOT NULL) THEN
		UPDATE employee SET password = pv_password WHERE employee_id = pv_employeeid;
	END IF;
	-- If a job title was passed, update job title
	IF(pv_job_title IS NOT NULL) THEN
		UPDATE employee SET job_title = pv_job_title WHERE employee_id = pv_employeeid;
	END IF;
	COMMIT;
	
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO before_update;
		pv_success := 0;
END update_employee;
/



CREATE OR REPLACE PROCEDURE add_employee( pv_firstname     VARCHAR2
									    , pv_lastname      VARCHAR2
									    , pv_email         VARCHAR2
										, pv_password      VARCHAR2
										, pv_reports_to    NUMBER
										, job_title        VARCHAR
									    , pv_employee_id   OUT NUMBER
									    , pv_creation_date OUT DATE
										, pv_success       OUT NUMBER ) IS
BEGIN
	pv_success := 1;
	SAVEPOINT before_add_employee;
	INSERT INTO employee
	( firstname
	, lastname
	, email
	, password
	, reports_to
	, job_title )
	VALUES
	( pv_firstname
	, pv_lastname
	, pv_email
	, pv_password
	, pv_reports_to
	, job_title );

	pv_employee_id := employee_s1.CURRVAL;
	pv_creation_date := SYSDATE;
	COMMIT;
	
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO before_add_employee;
		pv_success := 0;
END add_employee;
/


CREATE OR REPLACE PROCEDURE add_request( pv_request_author_id      NUMBER
									   , pv_request_type_id        NUMBER
									   , pv_amount                 FLOAT
									   , pv_description            CLOB
									   , pv_request_type_name  OUT VARCHAR2
									   , pv_request_id         OUT NUMBER
									   , pv_creation_date      OUT DATE
									   , pv_success            OUT NUMBER ) IS
BEGIN
	pv_success := 1;
	SAVEPOINT before_add_request;
	
	INSERT INTO request
	( request_author_id
	, request_type_id
	, amount
	, description )
	VALUES
	( pv_request_author_id
	, pv_request_type_id
	, pv_amount
	, pv_description );

	pv_request_id := request_s1.CURRVAL;
	pv_creation_date := SYSDATE;
	COMMIT;
	
	SELECT ref_value INTO pv_request_type_name 
	FROM common_lookup 
	WHERE common_lookup_id = pv_request_type_id;
	
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO before_add_request;
		pv_success := 0;
END add_request;
/

CREATE OR REPLACE PROCEDURE add_upload( pv_display_name          VARCHAR2
									  , pv_extension             VARCHAR2
									  , pv_request_id            NUMBER
									  , pv_upload_author_id      NUMBER
									  , pv_filename_length       NUMBER
									  , pv_filename          OUT VARCHAR2
									  , pv_upload_id         OUT NUMBER
									  , pv_creation_date     OUT DATE
									  , pv_success           OUT NUMBER ) IS
	lv_rows_found NUMBER;
BEGIN
	pv_success := 1;
	SAVEPOINT before_add_upload;

	LOOP
		lv_rows_found := 0;
		pv_filename := CONCAT(LOWER(DBMS_RANDOM.STRING('x',pv_filename_length)), LOWER(pv_extension));
		
		SELECT COUNT(*) INTO lv_rows_found
		FROM upload WHERE filename = pv_filename;
		EXIT WHEN lv_rows_found = 0;
	END LOOP;
	
	
	INSERT INTO upload
	( display_name
	, filename
	, request_id
	, upload_author_id  )
	VALUES
	( pv_display_name
	, pv_filename
	, pv_request_id
	, pv_upload_author_id );

	pv_upload_id := upload_s1.CURRVAL;
	pv_creation_date := SYSDATE;
	COMMIT;
	
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO before_add_upload;
		pv_success := 0;
END add_upload;
/

CREATE OR REPLACE PROCEDURE add_event( pv_request_status_id        NUMBER
									 , pv_message                  CLOB
									 , pv_request_id               NUMBER
									 , pv_event_author_id          NUMBER
									 , pv_event_status_string  OUT VARCHAR2
									 , pv_event_id             OUT NUMBER
									 , pv_creation_date        OUT DATE
									 , pv_success              OUT NUMBER ) IS
	lv_request_status_id  NUMBER;
BEGIN
	pv_success := 1;
	SAVEPOINT before_add_event;
	
	lv_request_status_id := pv_request_status_id;
	
	IF pv_request_status_id = 0 THEN
		SELECT current_status_id INTO lv_request_status_id
		FROM request WHERE request_id = pv_request_id;
	END IF;
		
	SELECT ref_value INTO pv_event_status_string
	FROM common_lookup WHERE common_lookup_id = lv_request_status_id;

	INSERT INTO event
	( request_id
	, event_author_id
	, request_status_id
	, message )
	VALUES
	( pv_request_id 
	, pv_event_author_id
	, lv_request_status_id
	, pv_message );

	pv_event_id := event_s1.CURRVAL;
	pv_creation_date := SYSDATE;
	COMMIT;
	
	EXCEPTION
		WHEN OTHERS THEN
		ROLLBACK TO before_add_event;
		pv_success := 0;
END add_event;
/
