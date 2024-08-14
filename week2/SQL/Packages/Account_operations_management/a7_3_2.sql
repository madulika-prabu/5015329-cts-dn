CREATE OR REPLACE FUNCTION AccountOperations.CloseAccount(
    p_account_id INTEGER
) RETURNS VOID AS $$
BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_account_id;
EXCEPTION
    WHEN no_data_found THEN
        RAISE NOTICE 'Account ID % not found.', p_account_id;
END;
$$ LANGUAGE plpgsql;


