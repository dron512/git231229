select * from departments
where manager_id is null;

select * from 학생
where 이름 like '__남%';

select * from 학생
where 학번 not in ('08001','06032','07033');

select * from 학생
where 학번 !='08001'
order by 학번 asc;

select * from 학생
where 학번 not BETWEEN 05014 and 07001
order by 학번 asc;

select * from 학생
where 학번='08001';

select * from 수강
where 학번='08001';

update 학생
set 이름='홍길남'
where 학번='08001';

delete from 학생
where 학번='08001';

commit;

select 이름,신장 from 학생;
select 학번,이름,소속 from 학생 where 학번='08001';
select * from 학생
where 학년='3' and 소속='ID';




