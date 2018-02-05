SELECT Customer.CustomerId, Customer.CustomerId, Customer.LastName, Invoice.InvoiceId, Invoice.Total
FROM Customer
LEFT JOIN Invoice ON Customer.CustomerId = Invoice.InvoiceId;