
CREATE TABLE [dbo].[Album1]
(
    [Album1Id] INT NOT NULL,
    [Title] NVARCHAR(160) NOT NULL,
    [ArtistId] INT NOT NULL,
    CONSTRAINT [PK_Album1] PRIMARY KEY CLUSTERED ([Album1Id])
);

INSERT INTO [dbo].[Album1] ([Album1Id], [Title], [ArtistId]) VALUES (1, N'For Those About To Rock We Salute You', 1);
INSERT INTO [dbo].[Album1] ([Album1Id], [Title], [ArtistId]) VALUES (2, N'Balls to the Wall', 2);
INSERT INTO [dbo].[Album1] ([Album1Id], [Title], [ArtistId]) VALUES (3, N'Restless and Wild', 2);

SELECT * FROM Album1 ORDER BY Title DESC;