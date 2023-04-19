DROP DATABASE IF EXISTS final_exam;
CREATE DATABASE final_exam;
USE final_exam;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id          INT PRIMARY KEY AUTO_INCREMENT  NOT NULL,
    full_name   VARCHAR(50)                     NOT NULL,
    email       VARCHAR(50) UNIQUE KEY          NOT NULL,
    password    VARCHAR(50)                     NOT NULL DEFAULT '123456Q',
    role        ENUM('EMPLOYEE', 'ADMIN')       NOT NULL DEFAULT 'EMPLOYEE',
    pro_skill   VARCHAR(50),
    exp_in_year INT
);

INSERT INTO users (full_name        , email              , password  , role		 , pro_skill, exp_in_year)
VALUES            ('Nguyễn Văn Khoa', 'khoa.nv@gmail.com', '123456Q' , 'EMPLOYEE', 'Java'   , NULL       ),
				  ('Nguyễn Ngọc Duy', 'duy.nn@gmail.com' , '123456Q' , 'ADMIN'   , NULL     , 10         );

DROP PROCEDURE IF EXISTS sp_create_user;
DELIMITER $$
CREATE PROCEDURE sp_create_user (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50)
)
BEGIN
	INSERT INTO users (full_name   , email   , password	, role      , pro_skill, exp_in_year)
    VALUES 			  (in_full_name, in_email, '123456Q', 'EMPLOYEE', NULL	   , NULL       );
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_user;
DELIMITER $$
CREATE PROCEDURE sp_update_user (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50),
    IN in_password 		VARCHAR(50),
    IN in_role       	ENUM('EMPLOYEE', 'ADMIN'),
    IN in_id			INT
)
BEGIN
	UPDATE users
    SET full_name = in_full_name,
		email = in_email,
		password = in_password,
        role = in_role
	WHERE id = in_id;
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_create_admin;
DELIMITER $$
CREATE PROCEDURE sp_create_admin (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50),
    IN in_password 		VARCHAR(50),
    IN in_exp_in_year 	INT
)
BEGIN
	INSERT INTO users (full_name   , email   , password	  , role   , pro_skill, exp_in_year   )
    VALUES 			  (in_full_name, in_email, in_password, 'ADMIN', NULL	  , in_exp_in_year);
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_admin;
DELIMITER $$
CREATE PROCEDURE sp_update_admin (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50),
    IN in_password 		VARCHAR(50),
    IN in_exp_in_year 	INT,
    IN in_id			INT
)
BEGIN
	UPDATE users
    SET full_name = in_full_name,
		email = in_email,
		password = in_password,
        exp_in_year = in_exp_in_year
	WHERE id = in_id AND role = 'ADMIN';
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_create_employee;
DELIMITER $$
CREATE PROCEDURE sp_create_employee (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50),
    IN in_password 		VARCHAR(50),
    IN in_pro_skill 	VARCHAR(50)
)
BEGIN
	INSERT INTO users (full_name   , email   , password   , role	  , pro_skill   , exp_in_year)
    VALUES 			  (in_full_name, in_email, in_password, 'EMPLOYEE', in_pro_skill, NULL		 );
END $$
DELIMITER ;

DROP PROCEDURE IF EXISTS sp_update_employee;
DELIMITER $$
CREATE PROCEDURE sp_update_employee (
	IN in_full_name		VARCHAR(50),
    IN in_email 		VARCHAR(50),
    IN in_password 		VARCHAR(50),
    IN in_pro_skill 	VARCHAR(50),
    IN in_id			INT
)
BEGIN
	UPDATE users
    SET full_name = in_full_name,
		email = in_email,
		password = in_password,
        pro_skill = in_pro_skill
	WHERE id = in_id AND role = 'EMPLOYEE';
END $$
DELIMITER ;
