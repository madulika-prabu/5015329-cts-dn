CREATE OR REPLACE FUNCTION UpdateCustomerLastModified()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN
    -- Update the LastModified column to the current timestamp
    NEW.LastModified := CURRENT_TIMESTAMP;
    RETURN NEW;
END;
$$;
CREATE TRIGGER trg_UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
EXECUTE FUNCTION UpdateCustomerLastModified();

