CREATE OR REPLACE FUNCTION AccountOperations.GetTotalBalance(
    p_customer_id INTEGER
) RETURNS NUMERIC(12, 2) AS $$
DECLARE
    v_total_balance NUMERIC(12, 2);
BEGIN
    SELECT COALESCE(SUM(Balance), 0) INTO v_total_balance
    FROM Accounts
    WHERE CustomerID = p_customer_id;
    
    IF NOT FOUND THEN
        RAISE NOTICE 'Customer ID % not found.', p_customer_id;
        RETURN NULL;
    END IF;
    
    RETURN v_total_balance;
END;
$$ LANGUAGE plpgsql;


