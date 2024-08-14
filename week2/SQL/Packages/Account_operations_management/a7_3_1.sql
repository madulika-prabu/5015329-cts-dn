CREATE SCHEMA AccountOperations;
CREATE OR REPLACE FUNCTION AccountOperations.OpenNewAccount(
    p_customer_id INTEGER,
    p_account_type VARCHAR,
    p_balance NUMERIC(12, 2)
) RETURNS VOID AS $$
BEGIN
    INSERT INTO Accounts (CustomerID, AccountType, Balance, LastModified)
    VALUES (p_customer_id, p_account_type, p_balance, CURRENT_TIMESTAMP);
EXCEPTION
    WHEN foreign_key_violation THEN
        RAISE NOTICE 'Customer ID % does not exist.', p_customer_id;
END;
$$ LANGUAGE plpgsql;


