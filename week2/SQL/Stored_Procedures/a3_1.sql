CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest()
LANGUAGE plpgsql
AS $$
BEGIN
    -- Update the balance of all savings accounts by applying 1% interest
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of an error
        ROLLBACK;
        RAISE NOTICE 'Error processing monthly interest: %', SQLERRM;
END;
$$;

