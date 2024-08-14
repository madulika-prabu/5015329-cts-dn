CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account_id INTEGER,
    p_to_account_id INTEGER,
    p_amount NUMERIC(12, 2)
)
LANGUAGE plpgsql
AS $$
DECLARE
    v_from_balance NUMERIC(12, 2);
BEGIN
    BEGIN
        SELECT Balance INTO v_from_balance
        FROM Accounts
        WHERE AccountID = p_from_account_id
        FOR UPDATE;

        -- Check if there are sufficient funds
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
            -- Rollback the transaction and log the error
            ROLLBACK;
            RAISE NOTICE 'Transfer failed: %', SQLERRM;
    END;
END;
$$;
