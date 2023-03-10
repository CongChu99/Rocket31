-- Question 1
CREATE OR REPLACE VIEW view_01 AS 
SELECT `account`.*, department.department_name
FROM `account`
JOIN department USING (department_id)
WHERE department_name = 'Sale';

-- Question 2
CREATE OR REPLACE VIEW view_02 AS
SELECT `account`.account_id, `account`.username, COUNT(group_account.account_id)
FROM group_account
JOIN `account` ON `account`.account_id = group_account.account_id
GROUP BY group_account.account_id
HAVING COUNT(group_account.account_id) = (SELECT MAX(all_count) AS maxCount
									FROM (SELECT COUNT(account_id) AS all_count
										FROM group_account
										GROUP BY account_id) AS t1);

-- Question 3
CREATE OR REPLACE VIEW view_03 AS
SELECT *
FROM question
WHERE CHAR_LENGTH(content) > 300;

DELETE FROM view_03;

-- Question 4
CREATE OR REPLACE VIEW view_04 AS
SELECT department.department_name, COUNT(`account`.department_id)
FROM `account`
JOIN department USING (department_id)
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(total_count) AS max_depart
								FROM (SELECT COUNT(department_id) AS total_count
										FROM `account`
										GROUP BY department_id) AS t1);

-- Question 5
CREATE OR REPLACE VIEW view_05 AS
SELECT question.category_id, question.content, `account`.full_name
FROM question
JOIN `account` ON `account`.account_id = question.creator_id
WHERE substring_index(`account`.full_name,' ',1) = 'Nguyễn'; 
