DO $$
DECLARE
    customer_cursor CURSOR FOR 
        SELECT DISTINCT c.CustomerID, c.Name
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE DATE_TRUNC('month', t.TransactionDate) = DATE_TRUNC('month', CURRENT_DATE);

    transaction_cursor CURSOR FOR 
        SELECT t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE a.CustomerID = customer_id
        AND DATE_TRUNC('month', t.TransactionDate) = DATE_TRUNC('month', CURRENT_DATE);

    customer_record RECORD;
    transaction_record RECORD;
    statement TEXT;
    customer_id INT;
BEGIN
    OPEN customer_cursor;
    LOOP
        FETCH customer_cursor INTO customer_record;
        EXIT WHEN NOT FOUND;

        -- Initialize statement for the customer
        statement := 'Statement for Customer ID: ' || customer_record.CustomerID || E'\n';
        statement := statement || 'Customer Name: ' || customer_record.Name || E'\n';
        statement := statement || 'Transactions:\n';

        -- Set customer_id for use in the transaction cursor
        customer_id := customer_record.CustomerID;
        
        -- Open and fetch transactions for the specific customer
        FOR transaction_record IN
            SELECT t.TransactionID, t.TransactionDate, t.Amount, t.TransactionType
            FROM Transactions t
            JOIN Accounts a ON t.AccountID = a.AccountID
            WHERE a.CustomerID = customer_id
            AND DATE_TRUNC('month', t.TransactionDate) = DATE_TRUNC('month', CURRENT_DATE)
        LOOP
            statement := statement || 'Transaction ID: ' || transaction_record.TransactionID || ', ' ||
                        'Date: ' || transaction_record.TransactionDate || ', ' ||
                        'Amount: ' || transaction_record.Amount || ', ' ||
                        'Type: ' || transaction_record.TransactionType || E'\n';
        END LOOP;

        RAISE NOTICE '%', statement;
    END LOOP;
    CLOSE customer_cursor;
END;
$$ LANGUAGE plpgsql;


