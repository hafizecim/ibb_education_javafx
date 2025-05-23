-- Database Create
CREATE DATABASE user_management;

-- Oluşturulmuş database seçmek
USE user_management;

-- user adında bir tablo oluştur
CREATE TABLE  IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

-- ###################################################################################################################

-- Insert
INSERT INTO users(username,password,email) VALUES ("Hafize","123456","hfz.snyl@gmail.com");

-- Select
select * FROM users;

-- Find User
SELECT  *  FROM users WHERE username="Hafize" AND "123456";

-- Update
UPDATE users SET username="Hafize44", password="12345644", email="hfz.snyl@gmail.com44" WHERE id=1;

-- delete
DELETE FROM users  WHERE id=1;