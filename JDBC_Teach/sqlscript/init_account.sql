drop sequence account_id;

create sequence account_id start with 3;

drop table t_account;

create table t_account(
id number(15),
username varchar2(35),
password varchar2(35),
balance number(20, 2)
);

insert into t_account values(1, 'Jack', '123456', 100000.0);
insert into t_account values(2, 'Rose', '654321', 100000.0);
commit;