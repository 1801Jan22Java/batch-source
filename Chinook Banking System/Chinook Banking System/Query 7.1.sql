SELECT Customer.FirstName, Invoice.InvoiceId
FROM Customer 
INNER JOIN Invoice ON Customer.FirstName = Invoice.InvoiceId;