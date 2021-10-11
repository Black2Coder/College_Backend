drop database if exists college;
create database college;
use college;

CREATE TABLE Users(
	user_id INT auto_increment ,
	user_name VARCHAR(20) NOT NULL,
	email_id VARCHAR(30) NOT NULL,
	contact VARCHAR(10) NOT NULL UNIQUE,
	password VARCHAR(70) NOT NULL,
	roles VARCHAR(20) NOT NULL,
	active BOOLEAN,
	constraint pk_id primary key(user_id)
);

CREATE TABLE POST(
	POST_ID INT AUTO_INCREMENT,
	TITLE VARCHAR(50) NOT NULL,
	DESCRIPTION VARCHAR(150), 
	POSTED_ON datetime default now(),
	constraint pk_id primary key(POST_ID)
);
DOC_NAME VARCHAR(100) NOT NULL,
	CONTENT MEDIUMBLOB,
	SIZE BIGINT(20) NOT NULL,
	POSTED_ON datetime default now(),
	--user_id INT,
	--constraint fk_id foriegn key(user_id) references Users (user_id),


SELECT * FROM USERS;
SELECT * FROM POST;
