GO
CREATE TRIGGER tr_customer1 On Customer1
AFTER DELETE
AS
BEGIN
DELETE FROM Customer1
WHERE Customer1.Customer1Id = 58;
END
GO
