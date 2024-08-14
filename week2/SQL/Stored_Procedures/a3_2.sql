CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
    p_department VARCHAR(50),
    p_bonus_percentage NUMERIC(5, 2)
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Update the salary of employees in the specified department by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonus_percentage / 100)
    WHERE Department = p_department;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback in case of an error
        ROLLBACK;
        RAISE NOTICE 'Error updating employee bonus: %', SQLERRM;
END;
$$;

