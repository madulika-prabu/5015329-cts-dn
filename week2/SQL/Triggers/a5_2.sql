CREATE TABLE AuditLog (
    AuditID SERIAL PRIMARY KEY,
    TransactionID INT,
    AccountID INT,
    TransactionDate TIMESTAMP,
    Amount NUMERIC(12, 2),
    TransactionType VARCHAR(10),
    LogTimestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE OR REPLACE FUNCTION LogTransaction()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    -- Insert a record into the AuditLog table
    INSERT INTO AuditLog (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
    VALUES (NEW.TransactionID, NEW.AccountID, NEW.TransactionDate, NEW.Amount, NEW.TransactionType);

    RETURN NEW;
END;
$$;
CREATE TRIGGER trg_LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
EXECUTE FUNCTION LogTransaction();
