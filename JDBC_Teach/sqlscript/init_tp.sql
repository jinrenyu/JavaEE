-- 删除球队序列
drop sequence sen_tbl_team_id;
-- 删除球员序列
drop sequence sen_tbl_palyer_id;
-- 创建球队序列
create sequence sen_tbl_team_id start with 7;
-- 创建球员序列
create sequence sen_tbl_palyer_id start with 20;
-- 删除球员表
drop table tbl_player;
-- 删除球队表
drop table tbl_team;
-- 创建球队表
create table tbl_team(
    id number(7),
    name varchar2(50),
    city varchar2(50)
);
-- 创建球员表
create table tbl_player(
    id number(7),
    name varchar2(50),
    salary number(12, 2),
    join_date date,
    position varchar2(30),
    team_id number(7)
);
-- 为球队表添加约束
alter table tbl_team 
add constraint con_tbl_team_id_pk primary key(id);
alter table tbl_team 
add constraint con_tbl_team_name_ck check(name is not null);
alter table tbl_team 
add constraint con_tbl_team_city_ck check(city is not null);
-- 为球员表添加约束
alter table tbl_player 
add constraint con_tbl_player_id_pk primary key(id);
alter table tbl_player 
add constraint con_tbl_player_name_ck check(name is not null);
alter table tbl_player 
add constraint con_tbl_player_salary_ck check(salary >= 0);
alter table tbl_player 
add constraint con_tbl_player_position_ck check(position in ('得分后卫','组织后卫','小前锋','大前锋','中锋'));
alter table tbl_player 
add constraint con_tbl_player_tid_fk foreign key(team_id) references tbl_team(id);
-- 为球队表添加初始化数据
insert into tbl_team values(1, '小飞马', '佛罗里达');
insert into tbl_team values(2, '清洁工', '纽约');
insert into tbl_team values(3, '帽子', '夏威夷');
insert into tbl_team values(4, '辣条', '华盛顿');
insert into tbl_team values(5, '麻瓜', '旧金山');
insert into tbl_team values(6, '天智', '苏州');
-- 为球员表添加初始化数据
insert into tbl_player values(1, '詹姆斯王二', 44000, to_date('2000-10-2', 'yyyy-mm-dd'), '组织后卫', 1);
insert into tbl_player values(2, '尼古拉斯赵四', 10300.75, to_date('2004-10-2', 'yyyy-mm-dd'), '得分后卫', 1);
insert into tbl_player values(3, '保罗张三', 23153, to_date('2011-11-2', 'yyyy-mm-dd'), '大前锋', 2);
insert into tbl_player values(4, '怀特王五', 5432.3, to_date('2010-4-2', 'yyyy-mm-dd'), '小前锋', 2);
insert into tbl_player values(5, '格林赵六', 4423.3, to_date('2000-5-2', 'yyyy-mm-dd'), '小前锋', 3);
insert into tbl_player values(6, '默罕默德锤子', 5324.65, to_date('1995-10-24', 'yyyy-mm-dd'), '得分后卫', 3);
insert into tbl_player values(7, '柴科夫剪刀', 6345.76, to_date('2011-11-11', 'yyyy-mm-dd'), '中锋', 3);
insert into tbl_player values(8, '布兰恩小麦', 342732.8, to_date('2010-12-12', 'yyyy-mm-dd'), '组织后卫', 4);
insert into tbl_player values(9, '玛丽翠花', 4324.54, to_date('2008-11-2', 'yyyy-mm-dd'), '大前锋', 4);
insert into tbl_player values(10, '路易斯豆豆', 64323.5, to_date('2007-3-22', 'yyyy-mm-dd'), '中锋', 4);
insert into tbl_player values(11, '布鲁斯小七', 45256.64, to_date('2008-1-21', 'yyyy-mm-dd'), '组织后卫', 5);
insert into tbl_player values(12, '布朗小黄', 3423.34, to_date('2000-3-2', 'yyyy-mm-dd'), '小前锋', 5);
insert into tbl_player values(13, '阿基米德大饼', 7456.45, to_date('2006-11-4', 'yyyy-mm-dd'), '得分后卫', 5);
insert into tbl_player values(14, '欧莱雅飞饼', 2134.54, to_date('2005-10-7', 'yyyy-mm-dd'), '组织后卫', 1);
insert into tbl_player values(15, '马哈西小二', 2314.34, to_date('2012-10-4', 'yyyy-mm-dd'), '得分后卫', 1);
insert into tbl_player values(16, '德莱索大三', 54332.5, to_date('2011-10-25', 'yyyy-mm-dd'), '小前锋', 2);
insert into tbl_player values(17, '布什中四', 2312.34, to_date('2007-10-22', 'yyyy-mm-dd'), '得分后卫', 3);
insert into tbl_player values(18, '沃顿张八', 4323.34, to_date('2005-10-12', 'yyyy-mm-dd'), '大前锋', 4);
insert into tbl_player values(19, '马克稻花', 8674.32, to_date('2003-12-3', 'yyyy-mm-dd'), '中锋', 5);

-- 提交添加操作
-- commit