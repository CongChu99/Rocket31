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
WHERE EXISTS (SELECT NULL);

-- VIEW
-- Xoa view
DROP VIEW IF EXISTS view_01;

-- Tao view 
CREATE OR REPLACE VIEW view_01 AS
SELECT * 
FROM department;

SELECT *
FROM view_01;

-- CTE: Common Table Expression
-- Question 8
SELECT question.*
FROM answer
JOIN question USING(question_id)
GROUP BY question_id
HAVING COUNT(answer_id) =  (SELECT MAX(total_answers)
							FROM (SELECT COUNT(answer_id) AS total_answers
									FROM answer
									GROUP BY question_id) AS t1);
                                    
-- Dem so cau tra loi / moi cau tra loi : 1
-- Tim so max: 5
-- Dem so cau tra loi/ moi cau hoi : 1

WITH cte_01 AS (
	SELECT question.content, COUNT(answer_id) AS total_answers
    FROM answer
    JOIN question USING (question_id)
    GROUP BY question_id
)
SELECT *
FROM cte_01
WHERE total_answers = 
	(SELECT MAX(total_answers)
		FROM cte_01);



