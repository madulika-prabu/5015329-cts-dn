CREATE OR REPLACE FUNCTION CustomerManagement.GetCustomerBalance(
    p_customer_id INTEGER
) RETURNS NUMERIC(12, 2) AS $$
DECLARE
    v_balance NUMERIC(12, 2);
BEGIN
    SELECT Balance INTO v_balance
    FROM Customers
    WHERE CustomerID = p_customer_id;
    
    IF NOT FOUND THEN
        RAISE NOTICE 'Customer ID % not found.', p_customer_id;
        RETURN NULL;
    END IF;
    
    RETURN v_balance;
END;
$$ LANGUAGE plpgsql;


