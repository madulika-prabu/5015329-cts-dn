CREATE OR REPLACE FUNCTION EmployeeManagement.UpdateEmployee(
    p_employee_id INTEGER,
    p_name VARCHAR,
    p_position VARCHAR,
    p_salary NUMERIC(12, 2),
    p_department VARCHAR,
    p_hire_date DATE
) RETURNS VOID AS $$
BEGIN
    UPDATE Employees
    SET Name = p_name,
        Position = p_position,
        Salary = p_salary,
        Department = p_department,
        HireDate = p_hire_date
    WHERE EmployeeID = p_employee_id;
EXCEPTION
    WHEN no_data_found THEN
        RAISE NOTICE 'Employee ID % not found.', p_employee_id;
END;
$$ LANGUAGE plpgsql;


