CREATE OR REPLACE FUNCTION HasSufficientBalance(
    p_account_id INT,
    p_amount NUMERIC(12, 2)
)
RETURNS BOOLEAN
LANGUAGE plpgsql
AS $$
DECLARE
    v_balance NUMERIC(12, 2);
BEGIN
    -- Retrieve the balance for the given account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_account_id;

    -- Check if the balance is sufficient
    IF v_balance >= p_amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;
END;
$$;
SELECT HasSufficientBalance(1, 500);

