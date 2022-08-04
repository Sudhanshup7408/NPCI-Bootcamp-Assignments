create database NPCI;
use NPCI;
create table Category(
categoryid BIGINT primary key,
categoryname VARCHAR(255)
);

insert into Category values(101, "c1"),(102, "c2"),(103, "c3"),(104, "c4"),(105, "c5");
select * from Category;

create table Product(
id BIGINT primary key,
sku VARCHAR(255),
name VARCHAR(255),
description VARCHAR(255),
unitprice DECIMAL(13,2),
imageurl VARCHAR(255),
unitsinstock INT,
datecreated DATETIME(6),
lastupdated DATETIME(6),
categoryid BIGINT,
foreign key(categoryid) references Category(categoryid));
desc Product;
insert into Product values(1,"marvel","IronMan","description",25,"urlhai",400,"2016-04-12","2018-04-23",101);
insert into Product values(2,"DC","Superman","description",23,"urlhai",300,"2018-04-12","2019-04-23",101);
insert into Product values(3,"Bollywood","Akshay","description",45,"urlhai",500,"2013-04-12","2018-04-23",102);
insert into Product values(4,"series","Damon","description",55,"urlhai",465,"2012-04-12","2015-06-23",103);
insert into Product values(5,"Tollywood","MaheshBabu","description",65,"urlhai",443,"2014-05-16","2018-04-23",102);
insert into Product values(6,"marvel","THOR","description",25,"https://wallpaperaccess.com/thor",400,"2016-04-12","2018-04-23",101);
insert into Product values(7,"marvel","BANNER","description",25,"https://images.squarespace-cdn.com/content/v1/5aba88b389c172458a37fbce/1557177679361-1TDDJ6KEXDSX6B0VK1UX/IMG_0198.JPG?format=500w",400,"2016-04-12","2018-04-23",101);
select * from Product;