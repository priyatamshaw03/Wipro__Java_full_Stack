ACCEPT salary_value NUMBER PROMPT 'Enter salary value: '
SELECT last_name, salary
FROM employees
WHERE salary > &salary_value;
