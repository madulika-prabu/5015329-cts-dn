DO $$
DECLARE
    rec RECORD;
    v_current_date DATE := CURRENT_DATE;
    v_age INT;
BEGIN
    FOR rec IN 
        SELECT CustomerID, DOB 
        FROM Customers
    LOOP
        v_age := DATE_PART('year', AGE(v_current_date, rec.DOB));
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;

    COMMIT;
END;
$$ LANGUAGE plpgsql;



