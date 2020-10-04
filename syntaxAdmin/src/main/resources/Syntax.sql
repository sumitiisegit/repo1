show databases;
create database syntaxDB;
use syntaxDB;

drop table Language;

create table Language (
lang_id integer  primary key,
lang_name varchar (30));

insert into Language values(1,"Java");
commit;

desc Language;
select * from Language;

drop table Language_Version;
desc Language_Version;
create table Language_Version (
lang_version_id integer primary key,
lang_id integer references lang_id,
version_name varchar (30),
foreign key (lang_id) references Language(lang_id)
);

insert into Language_Version values(1,1,"8");
commit;

select * from Language_Version;

drop table Construct;
create table Construct (
construct_id integer primary key,
construct_name varchar (50));

insert into Construct values(1,"String Constant");
commit;

select * from Construct;

drop table Language_Construct_Mapping;
create table Language_Construct_Mapping (
lang_construct_mapping_id integer primary key,
lang_version_id integer,
construct_id integer,
foreign key (lang_version_id) references Language_Version(lang_version_id),
foreign key (construct_id) references Construct(construct_id)
);

insert into Language_Construct_Mapping values(1,1,1);
commit;

select * from Language_Construct_Mapping;

drop table Syntax;

create table Syntax (
syntax_id integer primary key,
lang_version_id integer,
lang_construct_mapping_id integer,
syntax_data text(65535),
foreign key (lang_version_id) references Language_Version(lang_version_id),
foreign key (lang_construct_mapping_id) references Language_Construct_Mapping(lang_construct_mapping_id)
);

desc Syntax;

insert into Syntax values(1,1,1, '\" \" ');
commit;

select * from Syntax;

create or replace view Show_Data_View as
select 1 as id, l.lang_name, lv.version_name, lcm.lang_construct_mapping_id, c.construct_name, s.syntax_data
from Language l inner join Language_Version lv
on l.lang_id=lv.lang_id
join Language_Construct_Mapping lcm
on lcm.lang_version_id = lv.lang_version_id
join Construct c
on lcm.construct_id =c.construct_id
join Syntax s
on s.lang_construct_mapping_id=c.construct_id;

select * from Show_Data_View;




