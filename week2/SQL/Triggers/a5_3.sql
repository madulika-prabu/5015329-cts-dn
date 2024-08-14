CREATE OR REPLACE FUNCTION CheckTransactionRules()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
DECLARE
    v_balance NUMERIC(12, 2);
BEGIN
    -- Retrieve the balance of the account
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = NEW.AccountID;

    -- Check if the transaction is a withdrawal and if the balance is sufficient
    IF NEW.TransactionType = 'Withdrawal' AND NEW.Amount > v_balance THEN
        RAISE EXCEPTION 'Insufficient balance for withdrawal';
    END IF;

    -- Check if the transaction is a deposit and if the amount is positive
    IF NEW.TransactionType = 'Deposit' AND NEW.Amount <= 0 THEN
        RAISE EXCEPTION 'Deposit amount must be positive';
    END IF;

    RETURN NEW;
END;
$$;
CREATE TRIGGER trg_CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
EXECUTE FUNCTION CheckTransactionRules();

