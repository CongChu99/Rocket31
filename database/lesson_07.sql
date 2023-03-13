-- VARIABLES
-- LOCAL SCOPE: CÓ phạm vi trong khối lệnh BEGIN...END
-- SESION SCOPE: Có phạm vi trong session đó
SET @department_name = 'Giám đốc';
SELECT @department_name;

-- GLOBAL SCOPE: Có phạm vi trong toàn bộ connections 
SHOW VARIABLES;
SET GLOBAL connect_timeout = 5;
SET @@global.connect_timeout = 7;
SELECT @@connect_timeout;

-- TRIGGER
-- NEW / OLD
-- VD1: Tạo trigger kiểm tra ngày tạo, Đặt về hiện tại nếu nó lớn hơn hiện tại 
DROP TRIGGER IF EXISTS trigger_demo_01;
DELIMITER $$
CREATE TRIGGER trigger_demo_01
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
	IF NEW.created_date > NOW() THEN
		-- SET NEW.created_date = NOW();
        SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = 'error time';
    END IF;
END $$
DELIMITER ;