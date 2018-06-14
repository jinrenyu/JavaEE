drop sequence seq_file_id;
create sequence seq_file_id;

drop table t_file;

create table t_file(
id number(30),
name varchar2(25),
create_date date,
content blob
);