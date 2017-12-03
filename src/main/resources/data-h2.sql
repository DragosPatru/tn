insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event MAZDA','Romania','Timisoara',45.7183505,21.2435825,'best event MAZDA ever', 1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event MINI','Romania','Timisoara',45.7283505,21.2305825,'best event MINI ever',1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event BMW','Romania','Timisoara',45.7583505,22.2375825,'best event BMW ever',1513972800);		
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event AUDI','Romania','Timisoara',45.7083505,20.2035825,'best event AUDI ever',1513972800);
	
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event OPEL','Romania','Timisoara',45.413007,22.2164115 ,'best event OPEL ever',1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event MAZDA','Romania','Timisoara',45.413007,22.2264115,'best event ever',1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event CHEVROLET','Romania','Timisoara',45.222,22.2164115,'best event ever',1513972800);		
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event KIA','Romania','Timisoara',45.413007,22.2064115,'best event KIA ever',1513972800);
	

insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event MUSTANG','Romania','Timisoara',46.7710907,23.5950544,'best event ever',1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event DACIA','Romania','Timisoara',46.5668965,26.9139257,'best event ever',1513972800);
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event CIELO','Romania','Timisoara',44.4263287,26.1998268,'best event ever',1513972800);		
insert into TUNING_EVENT(NAME,COUNTRY,CITY,LATITUDE,LONGITUDE,DESCRIPTION,TIMESTAMP) VALUES ('Event MATIZ','Romania','Timisoara',45.32,24.43,'best event ever',1513972800);


INSERT INTO app_role (id, role_name, description) VALUES (1, 'STANDARD_USER', 'Standard User - Has no admin rights');
INSERT INTO app_role (id, role_name, description) VALUES (2, 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');

-- USER
-- non-encrypted password: jwtpass
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (1, 'John', 'Doe', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'john.doe');
INSERT INTO app_user (id, first_name, last_name, password, username) VALUES (2, 'Admin', 'Admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin.admin');


INSERT INTO user_role(user_id, role_id) VALUES(1,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,1);
INSERT INTO user_role(user_id, role_id) VALUES(2,2);
