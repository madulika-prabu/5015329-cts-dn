DO $$
DECLARE
    account_cursor CURSOR FOR 
        SELECT AccountID, Balance
        FROM Accounts;

    account_record RECORD;
    annual_fee NUMERIC := 50.00;  -- Example annual fee
BEGIN
    OPEN account_cursor;
    LOOP
        FETCH account_cursor INTO account_record;
        EXIT WHEN NOT FOUND;

        -- Deduct annual fee
        UPDATE Accounts
        SET Balance = Balance - annual_fee
        WHERE AccountID = account_record.AccountID;

        RAISE NOTICE 'Account ID %: Annual fee of % applied. New Balance: %',
                    account_record.AccountID, annual_fee, account_record.Balance - annual_fee;
    END LOOP;
    CLOSE account_cursor;
END;
$$ LANGUAGE plpgsql;


