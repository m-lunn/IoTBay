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
    
-- create table product (
-- product_id int not null auto_increment,
-- product_name varchar(50),
-- product_description varchar(500),
-- primary key (product_id)
-- );

CREATE DATABASE iotbay;
USE iotbay;

CREATE TABLE Users (
    user_id INT NOT NULL auto_increment,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50),
    fname VARCHAR(50),
	surname VARCHAR(50),
    phoneno VARCHAR(10),
    isactive BOOLEAN,
    PRIMARY KEY (user_id));
    

CREATE TABLE Customers (
    customer_id INT NOT NULL,
    PRIMARY KEY (customer_id),
    FOREIGN KEY (customer_id) REFERENCES Users(user_id) ON DELETE CASCADE);

CREATE TABLE Staff (
    staff_id INT NOT NULL,
    PRIMARY KEY (staff_id),
    FOREIGN KEY (staff_id) REFERENCES Users(user_id) ON DELETE CASCADE);

INSERT INTO Users (email, password, fname, surname, phoneno, isactive) VALUES
    ("m.lunn54@gmail.com","1234", "Michael", "Lunn", "0412345645", 1);
INSERT INTO Customers (customer_id) VALUES (last_insert_id());
INSERT INTO Users (email, password, fname, surname, phoneno, isactive) VALUES
    ("mickeymouse@gmail.com","1234", "Mickey", "Mouse", "0424121232", 1);
INSERT INTO Customers (customer_id) VALUES (last_insert_id());
INSERT INTO Users (email, password, fname, surname, phoneno, isactive) VALUES
    ("donaldduck@gmail.com","1234", "Donald", "Duck", "0421554266", 1);
INSERT INTO Customers (customer_id) VALUES (last_insert_id());
INSERT INTO Users (email, password, fname, surname, phoneno, isactive) VALUES
    ("staff@gmail.com","staff", "StaffFName", "StaffSurname", "0485412321", 1);
INSERT INTO Staff (staff_id) VALUES (last_insert_id());

CREATE TABLE AccessLogs (
    user_id INT NOT NULL,
    date_accessed DATE NOT NULL,
    time_accessed TIME NOT NULL,
    activity_type VARCHAR(255),
    PRIMARY KEY (user_id, date_accessed, time_accessed),
    FOREIGN KEY (user_id) REFERENCES Users(user_id) ON DELETE CASCADE);