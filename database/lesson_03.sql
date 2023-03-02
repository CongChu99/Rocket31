USE testing_system_02;

-- Truy van du lieu
-- *: Ky tu dai dien cho tat ca cac cot
SELECT *
FROM department;

-- Truy van du lieu co dieu kien
SELECT * 
FROM department
WHERE department_id != 5;

-- AND, OR
SELECT *
FROM department
WHERE department_id != 5 AND department_id != 10;

-- IN / NOT IN
SELECT * 
FROM department
WHERE department_id IN (1,3,5,7,9,11,13);

-- BETWEEN ... AND...
SELECT *
FROM department
WHERE department_id BETWEEN 5 AND 8;

-- LIKE / NOT LIKE
-- %: Dai dien cho 0 hoac nhieu ky tu
-- _: Dai dien cho 1 ky tu
SELECT * 
FROM department
WHERE department_name LIKE 'B%';

-- IS NULL / IS NOT NULL : so sanh voi gia tri NULL
SELECT *
FROM department
WHERE department_name = '';




