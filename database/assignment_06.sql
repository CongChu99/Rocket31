-- QUESTION 1
DROP PROCEDURE IF EXISTS sp_cau1;
DELIMITER $$
CREATE PROCEDURE sp_cau1 (IN in_department_name VARCHAR(50))
BEGIN
-- Logic  truy vấn
	SELECT department.department_name, `account`.*
    FROM department
    JOIN `account` USING (department_id)
    WHERE department_name = in_department_name;
END $$
DELIMITER ;

CALL sp_cau1('Sale');

-- Question 2
DROP PROCEDURE IF EXISTS sp_cau2;
DELIMITER $$
CREATE PROCEDURE sp_cau2 ()
BEGIN
-- Logic  truy vấn
	SELECT `group`.group_name, COUNT(account_id)
    FROM group_account
    RIGHT JOIN `group` USING (group_id)
    GROUP BY group_id;
END $$
DELIMITER ;

CALL sp_cau2();

-- Question 3
DROP PROCEDURE IF EXISTS sp_cau3;
DELIMITER $$
CREATE PROCEDURE sp_cau3()
BEGIN
-- Logic  truy vấn
	SELECT type_question.type_name, COUNT(question.type_id)
    FROM question
    JOIN type_question USING (type_id)
    WHERE month(question.created_date) = month(now()) AND year(question.created_date) = year(now())
    GROUP BY question.type_id;
END $$
DELIMITER ;

CALL sp_cau3();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_cau4;
DELIMITER $$
CREATE PROCEDURE sp_cau4(OUT in_id TINYINT UNSIGNED)
BEGIN
-- Logic  truy vấn
	SELECT question.type_id INTO in_id
    FROM question
    JOIN type_question ON question.type_id = type_question.type_id
    GROUP BY question.type_id
    HAVING COUNT(question.question_id) = (SELECT MAX(b)
							FROM (	SELECT COUNT(c.question_id) AS b
									FROM question c
                                    GROUP BY c.type_id) AS c);
END $$
DELIMITER ;

SET @typeID = 0;
CALL sp_cau4(@typeID);
SELECT @typeID;

DROP FUNCTION IF EXISTS fn_cau4;
DELIMITER $$
CREATE FUNCTION fn_cau4() RETURNS TINYINT UNSIGNED
BEGIN
	DECLARE v_type_id TINYINT UNSIGNED;
    
    WITH c1 AS (
		SELECT type_id, COUNT(question_id) AS total_question
        FROM type_question
        JOIN question USING (type_id)
        GROUP BY type_id
    )
    SELECT type_id INTO v_type_id
    FROM c1
    WHERE total_question = 
		(SELECT MAX(total_question)
        FROM c1);
        
	RETURN v_type_id;
END $$
DELIMITER ;

SELECT fn_cau4();

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
DROP PROCEDURE IF EXISTS sp_cau5;
DELIMITER $$
CREATE PROCEDURE sp_cau5()
BEGIN
-- Logic  truy vấn
	SELECT type_name
    FROM type_question
    WHERE type_id = fn_cau4();
END $$
DELIMITER ;

CALL sp_cau5();

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
 -- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
 -- chuỗi của người dùng nhập vào
 DROP PROCEDURE IF EXISTS sp_cau6;
DELIMITER $$
CREATE PROCEDURE sp_cau6(IN search VARCHAR(50))
BEGIN
-- Logic  truy vấn
	SELECT group_name AS `name`
    FROM `group`
    WHERE group_name LIKE CONCAT('%', search, '%')
    UNION
    SELECT username AS `name`
    FROM `account`
    WHERE username LIKE CONCAT('%', search, '%');
END $$
DELIMITER ;

CALL sp_cau6('g');
 
-- Question 7: Viết 1 store cho phép người dùng nhập vào thông tin fullName, email và 
 -- trong store sẽ tự động gán:
-- username sẽ giống email nhưng bỏ phần @..mail đi
-- positionID: sẽ có default là developer
-- departmentID: sẽ được cho vào 1 phòng chờ
--  Sau đó in ra kết quả tạo thành công
DROP PROCEDURE IF EXISTS sp_cau7;
DELIMITER $$
CREATE PROCEDURE sp_cau7(
	IN var_Email VARCHAR(50),
	IN var_fullname VARCHAR(50))
BEGIN
-- Logic  truy vấn
	DECLARE v_username VARCHAR(50) DEFAULT substring_index(var_Email, '@',1);
    DECLARE v_departmentID TINYINT UNSIGNED DEFAULT 11;
    DECLARE v_positionID TINYINT UNSIGNED DEFAULT 1;
    
	INSERT INTO `account`   (email        	, username      , full_name      	, department_id		, position_id	, created_date)
	VALUES                  (var_Email		, v_username   	, var_fullname   	, v_departmentID 	, v_positionID  	, '2020-03-05');
END $$
DELIMITER ;

CALL sp_cau7('khoa@asd.com.vn', 'khoa');
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
--  để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_cau9;
DELIMITER $$
CREATE PROCEDURE sp_cau9(IN in_exam_id TINYINT UNSIGNED)
BEGIN
-- Logic  truy vấn
	DELETE FROM exam
    WHERE exam_id = in_exam_id;
END $$
DELIMITER ;

CALL sp_cau9();

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử 
--  dụng store ở câu 9 để xóa)
--  Sau đó in số lượng record đã remove từ các table liên quan trong khi 
--  removing
DROP PROCEDURE IF EXISTS sp_cau10;
DELIMITER $$
CREATE PROCEDURE sp_cau10()
BEGIN
-- Logic  truy vấn
	DECLARE v_removed INT;
    DECLARE v_removed_exam INT;
    DECLARE v_removed_exam_question INT;
    
	SELECT COUNT(exam_id) INTO v_removed_exam
    FROM exam
    WHERE created_date < now() - INTERVAL 3 YEAR; 

	SELECT COUNT(exam_id) INTO v_removed_exam_question
    FROM exam_question
    JOIN exam USING (exam_id)
    WHERE created_date < now() - INTERVAL 3 YEAR; 
    
    SET v_removed = v_removed_exam + v_removed_exam_question;
    
    DELETE FROM exam
    WHERE created_date < NOW() - INTERVAL 3 YEAR;
    
    SELECT CONCAT('So ban ghi da bi xoa la: ', v_removed) AS message;
END $$
DELIMITER ;

CALL sp_cau10();

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng 
--  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được 
--  chuyển về phòng ban default là phòng ban chờ việc

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm 
--  nay
SELECT `month`, COUNT(question_id)
FROM(
	SELECT 1 AS `month`
	UNION
	SELECT 2 AS `month`
	UNION
	SELECT 3 AS `month`
	UNION
	SELECT 4 AS `month`
	UNION
	SELECT 5 AS `month`
	UNION
	SELECT 6 AS `month`
	UNION
	SELECT 7 AS `month`
	UNION
	SELECT 8 AS `month`
	UNION
	SELECT 9 AS `month`
	UNION
	SELECT 10 AS `month`
	UNION
	SELECT 11 AS `month`
	UNION
	SELECT 12 AS `month`) AS t1
LEFT JOIN
	(SELECT MONTH(created_date) AS `month`, question_id
	FROM question) AS t2 USING (`month`)
GROUP BY `month`;


-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 
--  tháng gần đây nhất
--  (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong 
-- tháng")