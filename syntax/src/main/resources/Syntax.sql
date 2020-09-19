show databases;
create database syntaxDB;
use syntaxDB;
drop table Syntax;

create table Syntax (
syntax_id varchar(10),
lang_version_id varchar(5),
lang_construct_mapping_id varchar(4),
syntax_data blob);

desc Syntax;

insert into Syntax values("1","1","1", "ABC");
commit;

select * from Syntax;

create table Language (
lang_id varchar(3),
lang_name varchar (30));
insert into Language values("1","Java");

drop table LanguageVersion;
create table Language_Version (
lang_version_id varchar(5),
lang_id varchar(3),
version_name varchar (30));

insert into Language_Version values("1","1","8");

create table Construct (
construct_id varchar(2),
construct_name varchar (50));

insert into Construct values("1","String Constant");

create table Language_Construct_Mapping (
lang_construct_mapping_id varchar(4),
lang_version_id varchar(5),
construct_id varchar(2));


insert into Language_Construct_Mapping values("1","1","1");

