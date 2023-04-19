DROP DATABASE IF EXISTS final_exam;
CREATE DATABASE final_exam;
USE final_exam;

DROP TABLE IF EXISTS users;
CREATE TABLE users (
    id          INT PRIMARY KEY AUTO_INCREMENT  NOT NULL,
    full_name   VARCHAR(50)                     NOT NULL,
    email       VARCHAR(50) UNIQUE KEY          NOT NULL,
    `password`  VARCHAR(50)                     NOT NULL,
    `role`      ENUM('EMPLOYEE', 'ADMIN')       NOT NULL,
    pro_skill   VARCHAR(50),
    exp_in_year INT
);

INSERT INTO users   (full_name        , email              , `password`, pro_skill, exp_in_year, `role`    )
VALUES              ('Nguyễn Văn Khoa', 'khoa.nv@gmail.com', '123456'  , 'Java'   , null       , 'EMPLOYEE'),
                    ('Nguyễn Ngọc Duy', 'duy.nn@gmail.com' , '654321'  , null     , 10         , 'ADMIN'   );