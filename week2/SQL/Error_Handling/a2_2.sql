CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_employee_id INTEGER,
    p_percentage NUMERIC(5, 2)
)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Attempt to update the salary
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    -- Check if the update was successful
    IF NOT FOUND THEN
        RAISE EXCEPTION 'Employee with ID % does not exist', p_employee_id;
    END IF;

    -- Commit the transaction
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Log the error and rollback
        ROLLBACK;
        RAISE NOTICE 'Error updating salary for Employee ID %: %', p_employee_id, SQLERRM;
END;
$$;

