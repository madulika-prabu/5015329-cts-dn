CREATE OR REPLACE FUNCTION CalculateAge(p_dob DATE)
RETURNS INT
LANGUAGE plpgsql
AS $$
DECLARE
    v_age INT;
BEGIN
    -- Calculate the age based on the date of birth
    v_age := DATE_PART('year', AGE(CURRENT_DATE, p_dob));
    RETURN v_age;
END;
$$;
SELECT CalculateAge('1985-05-15');

