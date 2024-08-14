CREATE SCHEMA CustomerManagement;
CREATE OR REPLACE FUNCTION CustomerManagement.AddNewCustomer(
    p_name VARCHAR,
    p_dob DATE,
    p_balance NUMERIC(12, 2)
) RETURNS VOID AS $$
BEGIN
    INSERT INTO Customers (Name, DOB, Balance, LastModified)
    VALUES (p_name, p_dob, p_balance, CURRENT_TIMESTAMP);
EXCEPTION
    WHEN unique_violation THEN
        RAISE NOTICE 'Customer with the same name already exists.';
END;
$$ LANGUAGE plpgsql;


