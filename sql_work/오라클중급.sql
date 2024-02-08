select avg(신장),이름 as a from 학생 group by 이름;

select 소속, round(avg(신장),2) 신장 from 학생 group by 소속;

select 학번,avg(성적) from 수강 group by 학번;