show databases;
create database syntaxDB;
use syntaxDB;
create table Syntax (
sid varchar(10),
name varchar (100));

desc Syntax;

insert into Syntax values("1","Syntax1");
commit;

select * from Syntax;
