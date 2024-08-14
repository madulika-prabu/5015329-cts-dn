DO $$
DECLARE
    rec RECORD;
BEGIN
    FOR rec IN 
        SELECT CustomerID, Balance 
        FROM Customers
    LOOP
        IF rec.Balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = rec.CustomerID;
        END IF;
    END LOOP;
END;
$$ LANGUAGE plpgsql;

