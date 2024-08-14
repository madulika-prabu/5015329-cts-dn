CREATE OR REPLACE FUNCTION CustomerManagement.UpdateCustomer(
    p_customer_id INTEGER,
    p_name VARCHAR,
    p_dob DATE,
    p_balance NUMERIC(12, 2)
) RETURNS VOID AS $$
BEGIN
    UPDATE Customers
    SET Name = p_name,
        DOB = p_dob,
        Balance = p_balance,
        LastModified = CURRENT_TIMESTAMP
    WHERE CustomerID = p_customer_id;
EXCEPTION
    WHEN no_data_found THEN
        RAISE NOTICE 'Customer ID % not found.', p_customer_id;
END;
$$ LANGUAGE plpgsql;


