CREATE TABLE Accounts
(
    AccountID NUMBER NOT NULL,
    Balance NUMBER NOT NULL,
    UserID NUMBER NOT NULL,
    CONSTRAINT PK_Accounts PRIMARY KEY (AccountID)
);

CREATE TABLE Users
(
    UserID NUMBER NOT NULL,
    UserName Varchar2(20) NOT NULL,
    Password Varchar2(20) NOT NULL,
    CONSTRAINT PK_Users PRIMARY KEY (UserID)
);

ALTER TABLE Accounts ADD CONSTRAINT FK_AccountsUserID
    FOREIGN KEY (UserID) REFERENCES Users (UserID);
    
CREATE SEQUENCE accounts_sequence
  START WITH 1
  INCREMENT BY 1;
  
CREATE OR REPLACE TRIGGER accounts_on_insert
  BEFORE INSERT ON Accounts
  FOR EACH ROW
BEGIN
  SELECT accounts_sequence.nextval
  INTO :new.AccountID
  FROM dual;
END;
/

CREATE SEQUENCE users_sequence
  START WITH 1
  INCREMENT BY 1;
  
CREATE OR REPLACE TRIGGER users_on_insert
  BEFORE INSERT ON Users
  FOR EACH ROW
BEGIN
  SELECT users_sequence.nextval
  INTO :new.UserID
  FROM dual;
END;
/

CREATE OR REPLACE PROCEDURE update_user 
    (Ref_ID IN NUMBER,
    New_Username IN Users.UserName%TYPE,
    New_Password IN Users.Password%TYPE)
    AS
    BEGIN
        UPDATE Users
        SET UserName = New_Username, Password = New_Password
        WHERE UserID = Ref_ID;
    End;
/

CREATE OR REPLACE PROCEDURE delete_user 
    (Ref_ID IN NUMBER)
    AS
    BEGIN
        DELETE FROM Users
        WHERE UserID = Ref_ID;
    END;
/

INSERT INTO Users (UserName, Password) VALUES ('ADMIN', 'PASSWORD');
INSERT INTO Users (UserName, Password) VALUES ('Evan', 'Camp');
