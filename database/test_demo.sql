-- 1. Tạo table với các ràng buộc và kiểu dữ liệu 
-- Thêm ít nhất 3 bản ghi vào table
DROP DATABASE IF EXISTS test;

CREATE DATABASE IF NOT EXISTS test;

USE test;

DROP TABLE IF EXISTS GiangVien;
CREATE TABLE GiangVien(
	magv	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoten	VARCHAR(50),
    luong	INT
);

DROP TABLE IF EXISTS SinhVien;
CREATE TABLE SinhVien(
	masv	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    hoten	VARCHAR(50),
    namsinh	DATE,
    quequan	VARCHAR(50)
);

DROP TABLE IF EXISTS Detai;
CREATE TABLE Detai(
	madt	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    tendt	VARCHAR(50),
    kinhphi	INT,
    NoiThucTap	VARCHAR(50)
);

DROP TABLE IF EXISTS HuongDan;
CREATE TABLE HuongDan(
	id	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    masv	TINYINT UNSIGNED,
    madt 	TINYINT UNSIGNED,
    magv	TINYINT UNSIGNED,
    ketqua	VARCHAR(50),
    FOREIGN KEY(masv) REFERENCES SinhVien(masv),--  ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(madt) REFERENCES Detai(madt) ,-- ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(magv) REFERENCES GiangVien(magv)
    -- ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO GiangVien (hoten, luong)
VALUES	('Nguyen Van A', 1000000),
		('Tran Van B', 200000000),
        ('Le Thi C', 3000000);
        
INSERT INTO SinhVien 	(hoten, namsinh, quequan)
VALUES					('John', '1999-12-02', 'Ha Noi'),
						('Davit', '1998-02-03', 'Canada'),
						('Merry', '1980-11-10', 'Anh'),
                        ('Harry', '2000-12-09', 'Viet Nam');

INSERT INTO Detai 	(tendt, kinhphi, NoiThuctap)
VALUES					('AI', 250000, 'FPT'),
						('CONG NGHE SINH HOC', 300000, 'HUST'),
						('IC', 120000, 'MTA');
                        
INSERT INTO HuongDan 	(ketqua, masv, madt, magv)
VALUES					('good', 1, 1, 1),
						('bad', 2, 2, 2),
						('good', 3, 3, 3);

-- 2. Viết lệnh để
-- a) Lấy tất cả các sinh viên chưa có đề tài hướng dẫn
-- b) Lấy ra số sinh viên làm đề tài ‘CONG NGHE SINH HOC’                        
SELECT *
FROM SinhVien 
LEFT JOIN HuongDan USING (masv)
WHERE HuongDan.madt is NULL;

SELECT COUNT(*)
FROM SinhVien 
LEFT JOIN HuongDan USING (masv)
WHERE HuongDan.madt = (SELECT madt
						FROM Detai
						WHERE tendt = 'CONG NGHE SINH HOC');
                        
SELECT tendt, count(a.madt) AS sl
FROM 	HuongDan a
JOIN SinhVien b ON a.masv = b.masv
JOIN DeTai c ON c.madt = a.madt
GROUP BY a.madt
HAVING	tendt = 'Cong Nghe Sinh Hoc' ;
                        
-- 3. Tạo view có tên là "SinhVienInfo" lấy các thông tin về học sinh bao gồm: 
-- mã số, họ tên và tên đề tài
-- (Nếu sinh viên chưa có đề tài thì column tên đề tài sẽ in ra "Chưa có")
DROP VIEW IF EXISTS SinhVienInfo;
CREATE VIEW SinhVienInfo AS (
SELECT masv, hoten,
	(CASE
		WHEN Detai.tendt IS NULL THEN 'Chưa có'
        ELSE detai.tendt
	END) AS tendt
FROM HuongDan
JOIN Detai USING (madt)
RIGHT JOIN SinhVien USING (masv));

-- 4. Tạo trigger cho table SinhVien khi insert sinh viên có năm sinh <= 1900 
-- thì hiện ra thông báo "năm sinh phải > 1900"
DROP TRIGGER IF EXISTS trigger_1;
DELIMITER $$
CREATE TRIGGER trigger_1
BEFORE INSERT ON SinhVien
FOR EACH ROW
BEGIN
	IF YEAR(NEW.namsinh) <= 1900 THEN
		SIGNAL SQLSTATE '12345'
        SET MESSAGE_TEXT = "năm sinh phải > 1900";
	END IF;
    
END $$
DELIMITER ;

INSERT INTO sinhvien(hoten, namsinh, quequan)
VALUES				('Nam', '1850-02-02', 'My');

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông 
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi

DROP PROCEDURE IF EXISTS bai5;
DELIMITER $$
CREATE PROCEDURE bai5(IN in_masv TINYINT UNSIGNED)
BEGIN
	DELETE FROM SinhVien WHERE masv = in_masv;
END $$
DELIMITER ;

CALL bai5(2);

-- 5. Hãy cấu hình table sao cho khi xóa 1 sinh viên nào đó thì sẽ tất cả thông 
-- tin trong table HuongDan liên quan tới sinh viên đó sẽ bị xóa đi (khong su dung on delete cascade)
DROP TRIGGER IF EXISTS trigger_2;
DELIMITER $$
CREATE TRIGGER trigger_2
BEFORE DELETE ON SinhVien
FOR EACH ROW
BEGIN
	DELETE FROM HuongDan hd WHERE masv = OLD.masv;
END $$
DELIMITER ;

DELETE FROM SinhVien WHERE masv = 2;

