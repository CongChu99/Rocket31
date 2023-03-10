USE testing_system_02;

/*	Bai 02 */
SELECT *
FROM department;

/* Bai  03 */
SELECT *
FROM department
WHERE department_name = 'Sale';

/* Bai 04 */
SELECT *
FROM `account`
WHERE char_length(full_name) >= ALL(SELECT CHAR_LENGTH(full_name) FROM `account`);

/* Bai 05 */
SELECT *
FROM `account`
WHERE department_id = 3 AND char_length(full_name) >= ALL(SELECT CHAR_LENGTH(full_name) FROM `account` WHERE department_id = 3);

/* Bai 06	*/
SELECT group_name
FROM `group`
WHERE created_date < '2019-12-20';

/*	Bai 08	*/
SELECT *
FROM exam
WHERE duration >= 60 AND created_date < '2019-12-20';

/*	Bai 11 */
SELECT *
FROM `account`
WHERE full_name LIKE 'D%' AND full_name like '%o';


