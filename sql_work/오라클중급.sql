select avg(신장),이름 as a from 학생 group by 이름;

select 소속, round(avg(신장),2) 신장 from 학생 group by 소속;

select 학번,avg(성적) from 수강 group by 학번;

-- ex4) 교수번호 102인 교수가 설강한 과목을 수강하는 학생의 수를 계산하라.
select count(distinct 학번) from 수강 where 번호 = '102';
select count(학번) from 수강 where 번호 = '101';

select count(*) from 수강 ;

select * from (
    select 학번,count(*) as cnt from 수강 group by 학번
) a
where a.cnt >=3;

select 학번,min(성적) from 수강 group by 학번;

--  세과목 이상 수강하는 학생의 학번을 구하시오.
select 학번,count(*) from 수강 group by 학번;
select 학번,count(*) from 수강 group by 학번 having count(*)>=3;

select min(sal),max(sal) from emp;

-- 커미션을 받는 사원의 수를 구하시오. 
select count(*) from emp
where comm is not null;

-- 부서번호가 10인 사원중에 커미션을 받는 사원의 수를 구하시오
select count(*) from emp where deptno=10 and comm is not null;

-- ex9) 사원테이블에서 job의 종류는 몇 개인가?
select count(*) from (
    select job from emp group by job
);

-- ex10) 부서별로 급여의 최고액을 구한 후 급여가 많은 순서데로 정렬하시오.
select deptno, max(sal) from emp group by deptno
order by max(sal) desc;

-- ex11) 부서별 평균 급여가 2000이상인 부서들만 부서별 평균을 구하시오.
select deptno, round(avg(sal),2) from emp
group by deptno
having avg(sal)>=2000;

-- 급여가 1000이상인 사원들만 부서별 평균급여를 구한 후 부서별 평균 급여가 2000이상인 
-- 부서만 부서번호와 부서별 평균급여를 구하시오.
select deptno, avg(sal) from emp where sal>=1000
 group by deptno having avg(sal) >= 2000;

select * from departments;
select * from emp;

-- SMITH 속해 있는 부서이름를 출력해라...
select * from emp;
select deptno from emp where ename='SMITH';
select * from departments;
select department_name from departments where department_id = 20;

select department_name from emp
inner join departments on emp.deptno = departments.department_id
where ename='SMITH';

-- inner 있는 것만.... 
-- outer 없는 것도 합쳐준다...
   -- left right 



select * from emp e
inner join departments d
on e.deptno = d.department_id;

select * from departments d
inner join emp e
on d.department_id = e.deptno;

select * from emp e
right outer join departments d
on e.deptno = d.department_id;
select * from departments d
left outer join emp e
on d.department_id = e.deptno;







