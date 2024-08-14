CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    p_loan_amount NUMERIC(12, 2),
    p_interest_rate NUMERIC(5, 2),
    p_duration_years INT
)
RETURNS NUMERIC(12, 2)
LANGUAGE plpgsql
AS $$
DECLARE
    v_monthly_rate NUMERIC(5, 4);
    v_number_of_payments INT;
    v_monthly_installment NUMERIC(12, 2);
BEGIN
    -- Calculate the monthly interest rate
    v_monthly_rate := p_interest_rate / 100 / 12;

    -- Calculate the total number of payments
    v_number_of_payments := p_duration_years * 12;

    -- Calculate the monthly installment using the formula:
    -- Installment = [P * r * (1 + r)^n] / [(1 + r)^n - 1]
    v_monthly_installment := (p_loan_amount * v_monthly_rate * 
                             POWER(1 + v_monthly_rate, v_number_of_payments)) / 
                             (POWER(1 + v_monthly_rate, v_number_of_payments) - 1);

    RETURN v_monthly_installment;
END;
$$;
SELECT CalculateMonthlyInstallment(10000, 5, 5);

