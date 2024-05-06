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
    
create table product (
product_id int not null auto_increment,
product_name varchar(50),
product_description varchar(500),
primary key (product_id)
);
    
/*create table users (
    user_id int NOT NULL auto_increment,
	user_email varchar(50) not null,
    user_password varchar(50),
    user_fname varchar(50),
	user_surname varchar(50),
    primary key (user_id));
    
insert into users (user_email, user_password, user_fname, user_surname) values
("m.lunn54@gmail.com","123", "Michael", "Lunn"),
("mickeymouse@gmail.com","123", "Mickey", "Mouse"),
("donaldduck@gmail.com","123", "Donald", "Duck");*/

create table Staff (
    staff_id int NOT NULL auto_increment,
    staff_email varchar(50) not null,
    staff_password varchar(50),
    staff_fname varchar(50),
	staff_surname varchar(50),
    primary key (staff_id));

insert into Staff (staff_email, staff_password, staff_fname, staff_surname) values
("staff@gmail.com","staff", "StaffFName", "StaffSurname");

create table Customers (
    customer_id int NOT NULL auto_increment,
    customer_email varchar(50) not null,
    customer_password varchar(50),
    customer_fname varchar(50),
	customer_surname varchar(50),
    primary key (customer_id));

insert into customers (customer_email, customer_password, customer_fname, customer_surname) values
("m.lunn54@gmail.com","123", "Michael", "Lunn"),
("mickeymouse@gmail.com","123", "Mickey", "Mouse"),
("donaldduck@gmail.com","123", "Donald", "Duck");

