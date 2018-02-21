DROP TABLE EVENT;
DROP TABLE REQUEST;
DROP TABLE EMPLOYEE;

INSERT INTO EMPLOYEE (Email, Pword, IsManager, 
FirstName, LastName, Phone, JobTitle, ReportsTo, Active)
VALUES ('IssacAsmiov@Foundation.com', 'Trantor', 3, 'Issac', 'Asimov',
'111-555-1234', 'Chief Novelist', 212, 2);

INSERT INTO EMPLOYEE (Email, Pword, IsManager, 
FirstName, LastName, Phone, JobTitle, ReportsTo, Active)
VALUES ('bob@paint.com', 'love2paint', 3, 'Bob', 'Ross',
'111-555-1234', 'Director Of Empathy', 212, 2);

INSERT INTO EMPLOYEE (Email, Pword, IsManager, 
FirstName, LastName, Phone, JobTitle, ReportsTo, Active)
VALUES ('carl.Sagan@science.com', 'scienceRulz', 3, 'Carl', 'Sagan',
'111-555-1234', 'Chief Science Officer', 212, 2);

INSERT INTO EMPLOYEE (Email, Pword, IsManager, 
FirstName, LastName, Phone, JobTitle, ReportsTo, Active)
VALUES ('MartinLuther@protest.com', '95problems', 3, 'Martin', 'Luther',
'111-555-1234', 'VP of Religous Affaris', 212, 2);

INSERT INTO EMPLOYEE (Email, Pword, IsManager, 
FirstName, LastName, Phone, JobTitle, ReportsTo, Active)
VALUES ('JohnWick@email.com', 'ripdog', 3, 'John', 'Wick',
'111-555-1234', 'VP of Corporate Revenge', 212, 2);