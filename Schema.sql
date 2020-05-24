
-- BEFORE RUNNING THIS SCRIPT, If you would like to have dummie data for userInfo and reservation
-- please uncomment the inserts in those sections. (Lines 18-22 & 73-77)


-- START

create database national_park_java;

use national_park_java;

create table userInfo (
	id INT not null auto_increment primary key,
    username varchar(40) not null,
    password varchar(50) not null
);

-- insert into userInfo(username, password) values('frank', 'Test123!');
-- insert into userInfo(username, password) values('john', 'Test123!');
-- insert into userInfo(username, password) values('bill', 'Test123!');
-- insert into userInfo(username, password) values('ken', 'Test123!');
-- insert into userInfo(username, password) values('bob', 'Test123!');


create table park (
	id int not null auto_increment primary key,
    name varchar(100) not null,
    location varchar(200) not null
);

insert into park( name, location) values('Mohican State Park', 'Loudenville, OH');
insert into park( name, location) values('Grand Canyon National Park', 'Big Valley, AZ');
insert into park( name, location) values('Arcadia National Park', 'Portland, ME');
insert into park( name, location) values('Arches National Park', 'Sand Hole, NM');

create table site(
	id int not null auto_increment primary key,
    parkId int not null,
    siteNumber int not null,
    pricePerNight double(6,2) not null,
    isUtils bit not null 
);

insert into site(parkId, siteNumber, pricePerNight, isUtils) values(1 , 1, 29.32, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(1 , 2, 18.33, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(1 , 3, 48.12, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(1 , 4, 93.18, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(1 , 5, 44.00, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(2, 1, 82.47, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(2 , 2, 33.99, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(2 , 3, 42.87, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(2 , 4, 38.12, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(2 , 5, 10.13, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(3 , 1, 49.48, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(3 , 2, 18.88, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(3 , 3, 199.23, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(3 , 4, 45.19, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(3 , 5, 89.19, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(4 , 1, 90.09, 0);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(4 , 2, 66.66, 1);
insert into site(parkId, siteNumber, pricePerNight, isUtils) values(4 , 3, 50.00, 1);

create table reservation(
	id int not null auto_increment primary key,
    userId int not null,
    siteId int not null,
    parkId int not null,
    startDate date not null,
    endDate date not null,
    amountDue double(7,2) not null
);

-- insert into reservation(userId, siteId, parkId, startDate, endDate, amountDue) Values(1, 1, 1, '2020-06-13', '2020-06-15', 63.73);
-- insert into reservation(userId, siteId, parkId, startDate, endDate, amountDue) Values(1, 6, 2, '2020-07-20', '2020-07-25', 164.43);
-- insert into reservation(userId, siteId, parkId, startDate, endDate, amountDue) Values(1, 12, 3, '2020-08-12', '2020-08-16', 233.16);
-- insert into reservation(userId, siteId, parkId, startDate, endDate, amountDue) Values(2, 17, 4, '2020-09-01', '2020-09-06', 327.22);
-- insert into reservation(userId, siteId, parkId, startDate, endDate, amountDue) Values(3, 1, 1, '2020-06-30', '2020-07-04', 632.21);


-- END

-- drop table reservation;
-- drop table site;
-- drop table park;
-- drop table userInfo;