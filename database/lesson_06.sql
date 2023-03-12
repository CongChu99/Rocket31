-- STORE PROCEDURE: Thủ tục
-- IN: Đánh dấu tham số dùng để truyền vào
-- OUT: Đánh dấu tham số dùng để lấy ra
-- INOUT: Kết hợp IN và OUT
-- VD: Tạo thủ tục tìm kiếm phòng ban theo id
DROP PROCEDURE IF EXISTS sp_demo;
DELIMITER $$
CREATE PROCEDURE sp_demo (IN in_department_id TINYINT UNSIGNED)
BEGIN
-- Logic  truy vấn
	SELECT *
    FROM department
    WHERE department_id = in_department_id;
END $$
DELIMITER ;

-- Gọi thủ tục 
CALL sp_demo(2);

-- VD: Tạo thủ tục lấy ra tên phòng ban theo id
DROP PROCEDURE IF EXISTS sp_demo_02;
DELIMITER $$
CREATE PROCEDURE sp_demo_02 (
	IN in_department_id TINYINT UNSIGNED,
	OUT out_department_name VARCHAR(50)	
)
BEGIN
-- Logic  truy vấn
	SELECT department_name INTO out_department_name
    FROM department
    WHERE department_id = in_department_id;
END $$
DELIMITER ;

SET @department_name = '';
CALL sp_demo_02(1, @department_name);
SELECT @department_name;

-- VD: Tạo thủ tục trả về tổng 1 và 2
DROP PROCEDURE IF EXISTS sp_demo_03;
DELIMITER $$
CREATE PROCEDURE sp_demo_03 (OUT out_sum INT)
BEGIN
    DECLARE v_one INT DEFAULT 1;
    DECLARE v_two INT DEFAULT 2;
    SELECT v_one + v_two INTO out_sum;
END $$
DELIMITER ;

SET @sum = 0;
CALL sp_demo_03(@sum);
SELECT @sum;

-- FUNCTION: Hàm, chức năng
SELECT NOW();

-- VD tạo function trả về tên phòng ban theo id
-- Cấu hình cho phép tạo function
SET GLOBAL log_bin_trust_function_creators = 1;

DROP FUNCTION IF EXISTS function_demo;

DELIMITER $$
CREATE FUNCTION function_demo(
	in_department_id TINYINT UNSIGNED
) RETURNS VARCHAR(50)
BEGIN
	DECLARE v_department_name VARCHAR(50);

	SELECT department_name INTO v_department_name
    FROM department
    WHERE department_id = in_department_id;
    
    RETURN v_department_name;
END $$
DELIMITER ;

-- GỌi function
SELECT function_demo(2);
