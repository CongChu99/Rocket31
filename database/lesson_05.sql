-- SUBQUERY: Truy van con
-- IN
SELECT *
FROM department
WHERE department_id IN (SELECT department_id
						FROM department);
                        
-- ALL / ANY
SELECT *
FROM department
WHERE department_id >= ALL (SELECT department_id
							FROM department);
                            
SELECT *
FROM department
WHERE department_id = ALL (SELECT MAX(department_id)
							FROM department);
                            
SELECT *
FROM department
ORDER BY department_id DESC
LIMIT 1;

-- EXISTS : Trả về True nếu truy vấn có kết quả
SELECT *
FROM department
WHERE EXISTS (SELECT NULL)