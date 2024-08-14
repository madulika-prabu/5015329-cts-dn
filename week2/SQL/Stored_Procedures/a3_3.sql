CREATE OR REPLACE PROCEDURE TransferFunds(
    p_from_account_id INTEGER,
    p_to_account_id INTEGER,
    p_amount NUMERIC(12, 2)
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_from_balance NUMERIC(12, 2);
BEGIN
    -- Get the balance of the from account
    SELECT Balance INTO v_from_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    -- Check if the from account has sufficient funds
    IF v_from_balance < p_amount THEN
        RAISE EXCEPTION 'Insufficient funds in account %', p_from_account_id;
    END IF;

    -- Deduct from the from account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    -- Add to the to account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of an error
        ROLLBACK;
        RAISE NOTICE 'Error transferring funds: %', SQLERRM;
END;
$$;

