show databases;
create database syntaxDB;
use syntaxDB;

drop table Syntax;

create table Syntax (
syntax_id varchar(10),
lang_version_id varchar(5),
lang_construct_mapping_id varchar(4),
syntax_data text(65535));

desc Syntax;

insert into Syntax values("1","1","1", '\" \" ');
commit;

delete from Syntax where syntax_id=1;

select * from Syntax;

create table Language (
lang_id varchar(3),
lang_name varchar (30));

insert into Language values("1","Java");
commit;
delete from Language where lang_id="1" and lang_name="Java";

drop table Language;

truncate Language;

create table Language_Version (
lang_version_id varchar(5),
lang_id varchar(3),
version_name varchar (30));

insert into Language_Version values("1","1","8");

create table Construct (
construct_id varchar(2),
construct_name varchar (50));

insert into Construct values("1","String Constant");
select * from Construct;

create table Language_Construct_Mapping (
lang_construct_mapping_id varchar(4),
lang_version_id varchar(5),
construct_id varchar(2));


insert into Language_Construct_Mapping values("1","1","1");
select * from Language_Construct_Mapping;

select l.lang_name, lv.version_name, lcm.lang_construct_mapping_id from Language l,Language_Version lv, Language_Construct_Mapping lcm
where l.lang_id =1 and l.lang_id=lv.lang_id
and lcm.lang_version_id = lv.lang_version_id;

select l.lang_name, lv.version_name, lcm.lang_construct_mapping_id, c.construct_name, s.syntax_data
from Language l join Language_Version lv
on l.lang_id=lv.lang_id
join Language_Construct_Mapping lcm
on lcm.lang_version_id = lv.lang_version_id
join Construct c
on lcm.construct_id =c.construct_id
join Syntax s
on s.lang_construct_mapping_id=c.construct_id
where l.lang_id =1;



select * from Show_Data_View;

select row_num from dual;


create or replace view Show_Data_View as
select 1 as id, l.lang_name, lv.version_name, lcm.lang_construct_mapping_id, c.construct_name, s.syntax_data
from Language l join Language_Version lv
on l.lang_id=lv.lang_id
join Language_Construct_Mapping lcm
on lcm.lang_version_id = lv.lang_version_id
join Construct c
on lcm.construct_id =c.construct_id
join Syntax s
on s.lang_construct_mapping_id=c.construct_id
where l.lang_id =1;



 create or replace view Show_Data_View as
select 1 as id, l.lang_name, lv.version_name,  c.construct_name, s.syntax_data
from Language l join Language_Version lv
on l.lang_id=lv.lang_id
join Language_Construct_Mapping lcm
on lcm.lang_version_id = lv.lang_version_id
join Construct c
on lcm.construct_id =c.construct_id
join Syntax s
on s.lang_construct_mapping_id=c.construct_id
where l.lang_id =1;
