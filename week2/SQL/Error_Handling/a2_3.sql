CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id INTEGER,
    p_name VARCHAR(100),
    p_dob DATE,
    p_balance NUMERIC(12, 2)
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Attempt to insert a new customer
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customer_id, p_name, p_dob, p_balance, CURRENT_TIMESTAMP);

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN unique_violation THEN
        -- Handle duplicate customer ID
        RAISE NOTICE 'Customer with ID % already exists.', p_customer_id;
        ROLLBACK;
    WHEN OTHERS THEN
        -- Handle any other errors
        RAISE NOTICE 'Error adding customer: %', SQLERRM;
        ROLLBACK;
END;
$$;

