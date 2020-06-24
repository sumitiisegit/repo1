show databases;
create database schoolDB;
use schoolDB;
create table School (
sid varchar (10), 
name varchar (10),
zipcode varchar (10),
address varchar (250),
city varchar (10));

desc School;

insert into School values("1","Schoool1","560046","blr","blr");
commit;