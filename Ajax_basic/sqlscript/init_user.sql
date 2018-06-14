drop sequence ajax_seq_user_id;

create sequence ajax_seq_user_id start with 3;

drop table ajax_user;

create table ajax_user(
	id number(10),
	uname varchar2(20),
	pwd varchar2(20)
);

alter table ajax_user 
add constraint ajax_uid_pk primary key(id);
alter table ajax_user 
add constraint ajax_uname_uk unique(uname);
alter table ajax_user 
add constraint ajax_pwd_nn check(pwd is not null);

insert into ajax_user values(1, 'tom', '123');
insert into ajax_user values(2, 'jack', '321');

commit;