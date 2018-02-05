CREATE PROCEDURE insertCust
AS
BEGIN TRANSACTION
INSERT INTO [dbo].[Customer1] ([Customer1Id], [FirstName], [LastName], [Address], [City], [Country], [PostalCode], [Phone], [Email], [SupportRepId]) VALUES (8, N'Helen', N'Hollý', N'Rilská 3174/6', N'Prague', N'Czech Republic', N'14300', N'+420 2 4177 0449', N'hholy@gmail.com', 9);
COMMIT;