-- ɾ���������
drop sequence sen_tbl_team_id;
-- ɾ����Ա����
drop sequence sen_tbl_palyer_id;
-- �����������
create sequence sen_tbl_team_id start with 7;
-- ������Ա����
create sequence sen_tbl_palyer_id start with 20;
-- ɾ����Ա��
drop table tbl_player;
-- ɾ����ӱ�
drop table tbl_team;
-- ������ӱ�
create table tbl_team(
    id number(7),
    name varchar2(50),
    city varchar2(50)
);
-- ������Ա��
create table tbl_player(
    id number(7),
    name varchar2(50),
    salary number(12, 2),
    join_date date,
    position varchar2(30),
    team_id number(7)
);
-- Ϊ��ӱ����Լ��
alter table tbl_team 
add constraint con_tbl_team_id_pk primary key(id);
alter table tbl_team 
add constraint con_tbl_team_name_ck check(name is not null);
alter table tbl_team 
add constraint con_tbl_team_city_ck check(city is not null);
-- Ϊ��Ա�����Լ��
alter table tbl_player 
add constraint con_tbl_player_id_pk primary key(id);
alter table tbl_player 
add constraint con_tbl_player_name_ck check(name is not null);
alter table tbl_player 
add constraint con_tbl_player_salary_ck check(salary >= 0);
alter table tbl_player 
add constraint con_tbl_player_position_ck check(position in ('�÷ֺ���','��֯����','Сǰ��','��ǰ��','�з�'));
alter table tbl_player 
add constraint con_tbl_player_tid_fk foreign key(team_id) references tbl_team(id);
-- Ϊ��ӱ���ӳ�ʼ������
insert into tbl_team values(1, 'С����', '�������');
insert into tbl_team values(2, '��๤', 'ŦԼ');
insert into tbl_team values(3, 'ñ��', '������');
insert into tbl_team values(4, '����', '��ʢ��');
insert into tbl_team values(5, '���', '�ɽ�ɽ');
insert into tbl_team values(6, '����', '����');
-- Ϊ��Ա����ӳ�ʼ������
insert into tbl_player values(1, 'ղķ˹����', 44000, to_date('2000-10-2', 'yyyy-mm-dd'), '��֯����', 1);
insert into tbl_player values(2, '�����˹����', 10300.75, to_date('2004-10-2', 'yyyy-mm-dd'), '�÷ֺ���', 1);
insert into tbl_player values(3, '��������', 23153, to_date('2011-11-2', 'yyyy-mm-dd'), '��ǰ��', 2);
insert into tbl_player values(4, '��������', 5432.3, to_date('2010-4-2', 'yyyy-mm-dd'), 'Сǰ��', 2);
insert into tbl_player values(5, '��������', 4423.3, to_date('2000-5-2', 'yyyy-mm-dd'), 'Сǰ��', 3);
insert into tbl_player values(6, 'Ĭ��Ĭ�´���', 5324.65, to_date('1995-10-24', 'yyyy-mm-dd'), '�÷ֺ���', 3);
insert into tbl_player values(7, '��Ʒ����', 6345.76, to_date('2011-11-11', 'yyyy-mm-dd'), '�з�', 3);
insert into tbl_player values(8, '������С��', 342732.8, to_date('2010-12-12', 'yyyy-mm-dd'), '��֯����', 4);
insert into tbl_player values(9, '�����仨', 4324.54, to_date('2008-11-2', 'yyyy-mm-dd'), '��ǰ��', 4);
insert into tbl_player values(10, '·��˹����', 64323.5, to_date('2007-3-22', 'yyyy-mm-dd'), '�з�', 4);
insert into tbl_player values(11, '��³˹С��', 45256.64, to_date('2008-1-21', 'yyyy-mm-dd'), '��֯����', 5);
insert into tbl_player values(12, '����С��', 3423.34, to_date('2000-3-2', 'yyyy-mm-dd'), 'Сǰ��', 5);
insert into tbl_player values(13, '�����׵´��', 7456.45, to_date('2006-11-4', 'yyyy-mm-dd'), '�÷ֺ���', 5);
insert into tbl_player values(14, 'ŷ���ŷɱ�', 2134.54, to_date('2005-10-7', 'yyyy-mm-dd'), '��֯����', 1);
insert into tbl_player values(15, '�����С��', 2314.34, to_date('2012-10-4', 'yyyy-mm-dd'), '�÷ֺ���', 1);
insert into tbl_player values(16, '����������', 54332.5, to_date('2011-10-25', 'yyyy-mm-dd'), 'Сǰ��', 2);
insert into tbl_player values(17, '��ʲ����', 2312.34, to_date('2007-10-22', 'yyyy-mm-dd'), '�÷ֺ���', 3);
insert into tbl_player values(18, '�ֶ��Ű�', 4323.34, to_date('2005-10-12', 'yyyy-mm-dd'), '��ǰ��', 4);
insert into tbl_player values(19, '��˵���', 8674.32, to_date('2003-12-3', 'yyyy-mm-dd'), '�з�', 5);

-- �ύ��Ӳ���
-- commit