-- 1. Create Database
CREATE DATABASE jdbc_demo;
USE jdbc_demo;

-- 2. Create Table
CREATE TABLE Users (
    UserID VARCHAR(200) PRIMARY KEY,
    Password VARCHAR(200),
    Name VARCHAR(200),
    IncorrectAttempts INT(2),
    LockStatus INT(2),
    UserType VARCHAR(200)
);

-- 3. Insert Sample Data
INSERT INTO Users (UserID, Password, Name, IncorrectAttempts, LockStatus, UserType) VALUES
('AB1001', 'AB1001', 'Hari', 0, 0, 'Admin'),
('TA1002', 'TA1002', 'Prasath', 0, 0, 'Employee'),
('RS1003', 'RS1003', 'Ganesh', 0, 0, 'Employee');
