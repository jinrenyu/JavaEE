drop sequence seq_room_id;
drop sequence seq_record_id;

create sequence seq_room_id start with 5;
create sequence seq_record_id start with 5;

drop table exam_record;
drop table exam_room;

create table exam_room(
  id number(10),
  code varchar2(10),
  rType varchar2(15),
  price number(6, 2),
  status varchar2(10)
);

create table exam_record(
  id number(10),
  startDate date,
  endDate date,
  total number(10, 2),
  roomId number(10)
);

alter table exam_room add constraint room_id_pk primary key(id);
alter table exam_room add constraint room_code_uk unique(code);
alter table exam_room add constraint room_type_nn check(rType is not null);
alter table exam_room add constraint room_status_ck check(status in ('未入住', '已入住', '已退房'));

alter table exam_record add constraint record_id_pk primary key(id);
alter table exam_record add constraint record_sDate_nn check(startDate is not null);
alter table exam_record add constraint record_roomid_fk 
foreign key(roomId) references exam_room(id);

insert into exam_room values(1, '0001', '单人间', 10.0, '已入住');
insert into exam_room values(2, '0002', '标准间', 20.0, '已退房');
insert into exam_room values(3, '0003', '商务间', 30.0, '已退房');
insert into exam_room values(4, '0004', '总统套房', 40.0, '已退房');

insert into exam_record 
values(1, to_date('2008-12-17 22:22', 'yyyy-mm-dd hh24:mi'), to_date('2008-12-22 10:41', 'yyyy-mm-dd hh24:mi'), 3840, 4);
insert into exam_record 
values(2, to_date('2008-12-15 9:01', 'yyyy-mm-dd hh24:mi'), to_date('2008-12-15 21:49', 'yyyy-mm-dd hh24:mi'), 360, 3);
insert into exam_record 
values(3, to_date('2008-12-1 12:18', 'yyyy-mm-dd hh24:mi'), to_date('2008-12-2 9:17', 'yyyy-mm-dd hh24:mi'), 420, 2);
insert into exam_record 
values(4, to_date('2008-1-1 11:22', 'yyyy-mm-dd hh24:mi'), null, null, 1);

commit;