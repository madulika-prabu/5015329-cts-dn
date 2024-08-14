DO $$
DECLARE
    loan_cursor CURSOR FOR 
        SELECT LoanID, InterestRate
        FROM Loans;

    loan_record RECORD;
    new_interest_rate NUMERIC;
BEGIN
    OPEN loan_cursor;
    LOOP
        FETCH loan_cursor INTO loan_record;
        EXIT WHEN NOT FOUND;

        -- Update interest rate based on new policy
        -- Example new policy: Increase interest rate by 0.5%
        new_interest_rate := loan_record.InterestRate + 0.5;

        UPDATE Loans
        SET InterestRate = new_interest_rate
        WHERE LoanID = loan_record.LoanID;

        RAISE NOTICE 'Loan ID %: Interest rate updated from % to %',
                    loan_record.LoanID, loan_record.InterestRate, new_interest_rate;
    END LOOP;
    CLOSE loan_cursor;
END;
$$ LANGUAGE plpgsql;


