create database e_action;
use  e_action;

create table person(
 id bigint not null,
 fName varchar(50),
 lName varchar(50),
 address varchar(100),
 city varchar(50),
 state varchar(50),
 pincode varchar(10),
 phone varchar(12),
 email varchar(100),
 personType varchar(50),
 primary key(id)
);
select * from person;

create table product_category(
id bigint not null,
name varchar(100),
primary key (id)
);
select * from product_category;



create table product(
id bigint,
`name` varchar(50),
shortDescription varchar(150),
detailedDescription text(500),
categoryId bigint,
startingPrice decimal(10,2),
bidEndDate TIMESTAMP,
sellerId bigInt,
isDeleted boolean,
primary key (Id),
 foreign key(categoryId) REFERENCES product_category(id),
 foreign key(sellerId)REFERENCES person(id)
);

select * from product;