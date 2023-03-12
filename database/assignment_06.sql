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

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question

-- Question 6: Viết 1 store cho phép người dùng nhập vào 1 chuỗi và trả về group có tên 
 -- chứa chuỗi của người dùng nhập vào hoặc trả về user có username chứa 
 -- chuỗi của người dùng nhập vào
 
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
    DECLARE v_departmentID TINYINT UNSIGNED;
    DECLARE v_positionID TINYINT UNSIGNED DEFAULT 1;
    
    INSERT INTO `account`('email', 'username', 'fullname', 'department_id', 'position_id')
    VALUES(var_Email, v_username, var_fulname, v_departmentID, v_positionID);
END $$
DELIMITER ;

CALL sp_cau7('asdsadas@asd.com.vn', 'asdsaff asdf')
-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice
--  để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất

-- Question 9: Viết 1 store cho phép người dùng xóa exam dựa vào ID

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử 
--  dụng store ở câu 9 để xóa)
--  Sau đó in số lượng record đã remove từ các table liên quan trong khi 
--  removing

-- Question 11: Viết store cho phép người dùng xóa phòng ban bằng cách người dùng 
--  nhập vào tên phòng ban và các account thuộc phòng ban đó sẽ được 
--  chuyển về phòng ban default là phòng ban chờ việc

-- Question 12: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm 
--  nay
	
-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 
--  tháng gần đây nhất
--  (Nếu tháng nào không có thì sẽ in ra là "không có câu hỏi nào trong 
-- tháng")