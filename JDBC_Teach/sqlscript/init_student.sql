-- É¾³ıÑ§ÉúĞòÁĞ
drop sequence seq_student_id;
        

    create sequence seq_student_id 
start with 4;     


drop table t_student;

create table t_student(
    id number(30),
    name varchar2(30),
    age number(3),
    birth date,
    gender varchar2(6)
);

alter table t_student add constraint 
student_id_pk primary key(id);
alter table t_student add constraint student_name_nn check(name is not null);alter table t_student 
add constraint student_age_ck check(age > 0 and age < 160);
alter table t_student add constraint student_gender_ck check(gender in ('ÄĞ', 'Å®'));

insert into t_student values(1, 'Jack', 25, to_date('1992-06-2', 'yyyy-mm-dd'), 'ÄĞ');
insert into t_student values(2, 'Rose', 27, to_date('1990-11-11', 'yyyy-mm-dd'), 'Å®');
insert into t_student values(3, 'Tom', 26, to_date('1991-03-8', 'yyyy-mm-dd'), 'ÄĞ');
commit;