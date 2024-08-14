CREATE SCHEMA EmployeeManagement;
CREATE OR REPLACE FUNCTION EmployeeManagement.HireNewEmployee(
    p_name VARCHAR,
    p_position VARCHAR,
    p_salary NUMERIC(12, 2),
    p_department VARCHAR,
    p_hire_date DATE
) RETURNS VOID AS $$
BEGIN
    INSERT INTO Employees (Name, Position, Salary, Department, HireDate)
    VALUES (p_name, p_position, p_salary, p_department, p_hire_date);
EXCEPTION
    WHEN unique_violation THEN
        RAISE NOTICE 'Employee with the same name already exists.';
END;
$$ LANGUAGE plpgsql;


