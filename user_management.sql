create database user_management;
use user_management;

CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100),
    country VARCHAR(100)
);

INSERT INTO users (name, email, country) VALUES
('Nguyen Van A', 'a@gmail.com', 'Vietnam'),
('Tran Thi B', 'b@gmail.com', 'Vietnam'),
('Le Van C', 'c@gmail.com', 'Vietnam'),
('Pham Thi D', 'd@gmail.com', 'Vietnam'),
('Hoang Van E', 'e@gmail.com', 'Vietnam'),
('John Doe', 'john@example.com', 'USA'),
('Jane Smith', 'jane@example.com', 'UK'),
('Carlos Garcia', 'carlos@example.com', 'Spain'),
('Yuki Tanaka', 'yuki@example.com', 'Japan'),
('Kim Min Soo', 'kim@example.com', 'Korea');

select * from users;