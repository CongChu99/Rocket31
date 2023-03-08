use testing_system_02;

-- Question 1:
SELECT *
FROM `account`
INNER JOIN department USING (department_id);

-- Question 2:
SELECT *
FROM `account`
JOIN department USING (department_id)
JOIN `position` USING (position_id)
WHERE created_date > '2010-12-20';

-- Question 3:
SELECT *
FROM `account`
JOIN `position` USING (position_id)
WHERE position_name = "DEVELOPER";

-- Question 4
SELECT department.*, COUNT(account_id) AS total_accounts
FROM `account`
JOIN department USING (department_id)
GROUP BY department_id
HAVING total_accounts > 3;

-- Question 5
SELECT question.*
FROM question
JOIN exam_question USING (question_id)
GROUP BY question_id
HAVING COUNT(exam_id) = (SELECT MAX(total_exams)
						FROM 	(SELECT COUNT(exam_id) AS total_exams
								FROM question
								JOIN exam_question USING (question_id)
								GROUP BY question_id) AS t1);

-- Question 6
SELECT cq.*, COUNT(question_id)
FROM category_question AS cq
LEFT JOIN question USING (category_id)
GROUP BY category_id;


-- Question 7 ( ve chua )
SELECT question.*, COUNT(exam_id) AS total_exams
FROM question
LEFT JOIN exam_question USING(question_id)
GROUP BY question_id;

-- Question 8
SELECT question.*
FROM answer
JOIN question USING(question_id)
GROUP BY question_id
HAVING COUNT(answer_id) =  (SELECT MAX(total_answers)
							FROM (SELECT COUNT(answer_id) AS total_answers
									FROM answer
									GROUP BY question_id) AS t1);

-- Question 9 (ve chua)
SELECT `group`.*, COUNT(account_id) AS total_accounts
FROM `group`
LEFT JOIN `group_account` USING (group_id)
GROUP BY group_id;

-- Question

-- Question 14,15
SELECT `group`.*
FROM `group`
LEFT JOIN group_account USING (group_id)
WHERE account_id IS NULL;

-- Question 16 ( ve lam)
SELECT question.*
FROM question
LEFT JOIN answer USING (question_id)
WHERE answer_id is NULL;



