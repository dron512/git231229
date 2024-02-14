select * from 사원;
select * from 대출;

-- Q1) 이길동 학생이 수강한 교수명과 성적을 구하시오.
select a.학번, b.성적, c.교수명 from 학생 a
inner join 수강 b on a.학번 = b.학번
inner join 설강 c on b.번호 = c.번호;

select * from 수강;
select * from 설강;

select a.학번, b.성적, c.교수명 from 학생 a,수강 b,설강 c 
where a.학번 = b.학번 and b.번호 = c.번호;


where 이름='이길동';
select * from 수강;
select * from 설강;

 select 교수명,성적 from 학생,수강,설강 
 where 학생.이름 = '이길동' and 학생.학번 = 수강.학번 and 수강.번호 = 설강.번호;
 
-- Q2  최씨성을 갖는 학생의 모든 정보를 구하라.
select * from  학생,수강,설강 
 where 
 학생.학번 = 수강.학번 and 수강.번호 = 설강.번호;
 where 이름 like '최%';
 
 select * from 학생;
 select * from 수강;
 
select * from 학생 a
inner join 수강 b on a.학번 = b.학번
inner join 설강 c on b.번호 = c.번호
where 이름 like '최%';

--Q3) 최길동 학생의 학년,이름,과목번호,성적을 구하시오.
select 학년,이름,c.번호,성적 from 학생 a
inner join 수강 b on a.학번 = b.학번
inner join 설강 c on b.번호 = c.번호
where 이름 ='최길동';

-- Q1) 각각의 사원의 연봉에 따른 등급을 출력하시오.(사원이름,연봉,등급순으로 출력)
-- Q2) 사원들의 job과 부서명을 구하시오. (이름,job, 부서명순으로 출력)
select job, department_name from emp
inner join departments on emp.deptno = departments.DEPARTMENT_ID;



 
 
 