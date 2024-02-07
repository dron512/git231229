--4. 
select 이름,신장,소속 from 학생
where 신장>=170;

--5 
select 학번,성적 from 수강
where 성적 BETWEEN 80 and 90;

select 학번,성적 from 수강
where 성적 >= 80 and 성적 <= 90;

--6
select * from 학생
where 소속 != 'CD';

--7 설강테이블에서 교수명이 김으로 시작하는 정보의 교수명, 과목명을 구하시오.
select 교수명,과목명 from 설강
where 교수명 like '김%';






