DROP TABLE TUNING_EVENT;

CREATE TABLE TUNING_EVENT (
ID BIGINT NOT NULL AUTO_INCREMENT,
NAME VARCHAR2(64) NOT NULL,
COUNTRY VARCHAR2(64) NOT NULL,
CITY VARCHAR2(64) NOT NULL,
POSTER BLOB DEFAULT NULL,
LATITUDE FLOAT NOT NULL,
LONGITUDE FLOAT NOT NULL,
DESCRIPTION VARCHAR2(255) DEFAULT NULL,
TIMESTAMP BIGINT DEFAULT NULL,
STREET VARCHAR2(64) DEFAULT NULL,
PRIMARY KEY (ID));

# Spring security tables
#CREATE TABLE USER_ROLE (
#	ROLE_ID BIGINT NOT NULL,
#	LABEL VARCHAR(25) NOT NULL,
#	PRIMARY KEY (ROLE_ID)
#);

#CREATE TABLE APPLICATION_USER (
#	ID BIGINT NOT NULL AUTO_INCREMENT,
#	USERNAME VARCHAR(50) NOT NULL UNIQUE,
#	PASSWORD VARCHAR(50) NOT NULL,
#	ENABLED	SMALLINT NOT NULL,
#	ROLE_ID BIGINT NOT NULL,
#	PRIMARY KEY (ID),
#	FOREIGN KEY (ROLE_ID) REFERENCES USERROLE
#	);
	
#CREATE TABLE AUTHORITIES (
#	USERNAME VARCHAR(50) NOT NULL, 
#	AUTHORITY VARCHAR(50) NOT NULL, 
#	FOREIGN KEY (USERNAME) REFERENCES USERS);


CREATE TABLE app_role (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  description varchar(255) DEFAULT NULL,
  role_name varchar(255) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE app_user (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(255) NOT NULL,
  last_name varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  username varchar(255) NOT NULL,
  email varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE user_role (
  user_id bigint(20) NOT NULL,
  role_id bigint(20) NOT NULL,
  FOREIGN KEY (user_id) REFERENCES app_user (id),
  FOREIGN KEY (role_id) REFERENCES app_role (id)
);
