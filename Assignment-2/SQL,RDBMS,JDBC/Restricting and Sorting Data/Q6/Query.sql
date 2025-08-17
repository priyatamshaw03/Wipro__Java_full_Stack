SELECT last_name AS Employee, salary AS "Monthly Salary"
FROM employees
WHERE salary BETWEEN 5000 AND 12000
  AND department_id IN (20, 50);
