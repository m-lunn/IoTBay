-- CREATE table customers (
-- 	customer_id int NOT NULL auto_increment,
--     customer_fname varchar(20),
--     customer_lname varchar(20),
--     customer_email varchar(100) not null,
--     customer_password varchar(50) not null,
--     customer_phone_no int,
--     customer_street varchar(30),
--     customer_suburb varchar(20),
--     customer_state varchar (3),
--     customer_postcode int,
-- 	primary key (customer_id));

CREATE DATABASE iotbay;
USE iotbay;

CREATE TABLE Users (
    user_id INT NOT NULL AUTO_INCREMENT,
	user_email VARCHAR(255) NOT NULL,
    user_password VARCHAR(50),
    user_fname VARCHAR(50),
	user_surname VARCHAR(50),
    PRIMARY KEY (user_id));
    
CREATE TABLE AccessLogs (
    user_id INT NOT NULL,
    date_accessed DATE NOT NULL,
    time_accessed TIME NOT NULL,
    activity_type VARCHAR(255),
    PRIMARY KEY (user_id, date_accessed, time_accessed),
    FOREIGN KEY (user_id) REFERENCES Users(user_id));
    
    
INSERT INTO Users (user_email, user_password, user_fname, user_surname) VALUES
("m.lunn54@gmail.com","123", "Michael", "Lunn"),
("mickeymouse@gmail.com","123", "Mickey", "Mouse"),
("donaldduck@gmail.com","123", "Donald", "Duck");


-- create table product (
-- product_id int not null auto_increment,
-- product_name varchar(50),
-- product_description varchar(500),
-- primary key (product_id)
-- );