GO
CREATE TRIGGER tr_album1 ON Album1
AFTER UPDATE
AS
BEGIN
INSERT INTO [dbo].[Album1] ([Album1Id], [Title], [ArtistId]) VALUES (139, N' Mariah Carey', 41);
END
GO

