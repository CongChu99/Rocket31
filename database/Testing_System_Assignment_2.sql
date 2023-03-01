DROP DATABASE IF EXISTS testing_system_assignment_1;

CREATE DATABASE IF NOT EXISTS testing_system_assignment_1;

USE testing_system_assignment_1;

/*	Cau 01	*/
DROP TABLE IF EXISTS Department;
CREATE TABLE Department(
	DepartmentID TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    DepartmentName VARCHAR(50),
    PRIMARY KEY (DepartmentID)
);

/*	Cau 02	*/
DROP TABLE IF EXISTS `Position`;
CREATE TABLE `Position`(
	PositionID TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    PositionName ENUM('Dev', 'Test', 'Scrum', 'Master', 'PM'),
    PRIMARY KEY(PositionID)
);

/*	Cau 03	*/
DROP TABLE IF EXISTS `Account`;
CREATE TABLE `Account`(
	AccountID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    Email	CHAR(20),
    Username	VARBINARY(20),
    FullName	VARCHAR(20),
    DepartmentID	TINYINT UNSIGNED NOT NULL,
    PositionID	TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(AccountID),
    FOREIGN KEY (DepartmentID) REFERENCES Department(DepartmentID),
    FOREIGN KEY(PositionID) REFERENCES `Position`(PositionID)
);

/*	Cau 04	*/
DROP TABLE IF EXISTS `Group`;
CREATE TABLE `Group`(
	GroupID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT,
    GroupName	VARCHAR(50),
    CreatorID	TINYINT UNSIGNED NOT NULL,
    CreateDate DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT ID PRIMARY KEY(GroupID, CreatorID),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

/*  Cau 05 */
DROP TABLE IF EXISTS GroupAccount;
CREATE TABLE GroupAccount(
	GroupID 	TINYINT UNSIGNED NOT NULL,
    AccountID	TINYINT UNSIGNED NOT NULL,
    JoinDate	DATETIME DEFAULT NOW(),
    PRIMARY KEY(GroupID, AccountID),
    FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID),
    FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID)
);

/*	Cau 06 */
DROP TABLE IF EXISTS TypeQuestion;
CREATE TABLE TypeQuestion(
	TypeID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TypeName	ENUM('Essay', 'Multiple-Choice')
);

/* Cau 07 */
DROP TABLE IF EXISTS CategoryQuestion;
CREATE TABLE CategoryQuestion(
	CategoryID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    CategoryName	VARCHAR(50) NOT NULL UNIQUE KEY
);

/* Cau 08 */
DROP TABLE IF EXISTS Question;
CREATE TABLE Question(
	QuestionID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Content		VARCHAR(100) NOT NULL,
    CategoryID	TINYINT UNSIGNED NOT NULL,
    TypeID		TINYINT UNSIGNED NOT NULL,
    CreatorID	TINYINT UNSIGNED NOT NULL,
    CreateDate	DATETIME DEFAULT NOW(),
    FOREIGN KEY(TypeID)	REFERENCES TypeQuestion(TypeID),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

/* Cau 09 */
DROP TABLE IF EXISTS Answer;
CREATE TABLE Answer(
	AnswerID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    Content		VARCHAR(100) NOT NULL,
    QuestionID	TINYINT UNSIGNED NOT NULL,
    isCorrect	BOOLEAN,
    FOREIGN KEY (QuestionID) REFERENCES Question(QuestionID)
);

/* Cau 10 */
DROP TABLE IF EXISTS Exam;
CREATE TABLE Exam(
	ExamID	TINYINT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `Code`	VARCHAR(5) NOT NULL,
    Title	VARCHAR(20) NOT NULL,
    CategoryID TINYINT UNSIGNED NOT NULL,
    Duration	TIME,
    CreatorID	TINYINT UNSIGNED NOT NULL,
    CreateDate	DATETIME DEFAULT NOW(),
    FOREIGN KEY(CategoryID) REFERENCES CategoryQuestion(CategoryID),
    FOREIGN KEY(CreatorID) REFERENCES `Account`(AccountID)
);

/* Cau 11 */
DROP TABLE IF EXISTS ExamQuestion;
CREATE TABLE ExamQuestion(
	ExamID	TINYINT UNSIGNED NOT NULL,
    QuestionID	TINYINT UNSIGNED NOT NULL,
    FOREIGN KEY(ExamID) REFERENCES Exam(ExamID),
    FOREIGN KEY(QuestionID) REFERENCES Question(QuestionID)
);


