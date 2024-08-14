DO $$
DECLARE
    rec RECORD;
    v_message TEXT;
BEGIN
    FOR rec IN 
        SELECT l.CustomerID, c.Name, l.LoanAmount, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN CURRENT_DATE AND CURRENT_DATE + INTERVAL '30 days'
    LOOP
        v_message := 'Reminder: Dear ' || rec.Name ||
                     ', your loan of amount ' || rec.LoanAmount ||
                     ' is due on ' || TO_CHAR(rec.EndDate, 'YYYY-MM-DD') ||
                     '. Please make the necessary arrangements.';

        RAISE NOTICE '%', v_message;
    END LOOP;
END;
$$ LANGUAGE plpgsql;
