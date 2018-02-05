GO
CREATE TRIGGER tr_employee1 ON Employee1
AFTER INSERT
AS
BEGIN
INSERT INTO [dbo].[Employee1] ([Employee1Id], [LastName], [FirstName], [Title], [BirthDate], [HireDate], [Address], [City], [State], [Country], [PostalCode], [Phone], [Fax], [Email]) VALUES (8, N'John', N'Andrew', N' Vice President', '1962/3/19', '2002/9/15', N'11120 Casper Ave NW', N'Edmonton', N'AY', N'Canada', N'T5K 8N1', N'+1 (780) 458-9582', N'+1 (780) 438-3567', N'John@chinookcorp.com');
END
GO