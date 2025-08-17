ACCEPT manager_id NUMBER PROMPT 'Enter manager ID: '
ACCEPT sort_col CHAR PROMPT 'Enter column to sort by: '
SELECT employee_id, last_name, salary, department_id
FROM employees
WHERE manager_id = &manager_id
ORDER BY &sort_col;
