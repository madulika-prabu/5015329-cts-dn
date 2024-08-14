CREATE OR REPLACE FUNCTION EmployeeManagement.CalculateAnnualSalary(
    p_employee_id INTEGER
) RETURNS NUMERIC(12, 2) AS $$
DECLARE
    v_salary NUMERIC(12, 2);
BEGIN
    SELECT Salary INTO v_salary
    FROM Employees
    WHERE EmployeeID = p_employee_id;
    
    IF NOT FOUND THEN
        RAISE NOTICE 'Employee ID % not found.', p_employee_id;
        RETURN NULL;
    END IF;
    
    RETURN v_salary * 12;
END;
$$ LANGUAGE plpgsql;


