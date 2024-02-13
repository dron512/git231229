select avg(����),�̸� as a from �л� group by �̸�;

select �Ҽ�, round(avg(����),2) ���� from �л� group by �Ҽ�;

select �й�,avg(����) from ���� group by �й�;

-- ex4) ������ȣ 102�� ������ ������ ������ �����ϴ� �л��� ���� ����϶�.
select count(distinct �й�) from ���� where ��ȣ = '102';
select count(�й�) from ���� where ��ȣ = '101';

select count(*) from ���� ;

select * from (
    select �й�,count(*) as cnt from ���� group by �й�
) a
where a.cnt >=3;

select �й�,min(����) from ���� group by �й�;

--  ������ �̻� �����ϴ� �л��� �й��� ���Ͻÿ�.
select �й�,count(*) from ���� group by �й�;
select �й�,count(*) from ���� group by �й� having count(*)>=3;

select min(sal),max(sal) from emp;

-- Ŀ�̼��� �޴� ����� ���� ���Ͻÿ�. 
select count(*) from emp
where comm is not null;

-- �μ���ȣ�� 10�� ����߿� Ŀ�̼��� �޴� ����� ���� ���Ͻÿ�
select count(*) from emp where deptno=10 and comm is not null;

-- ex9) ������̺��� job�� ������ �� ���ΰ�?
select count(*) from (
    select job from emp group by job
);

-- ex10) �μ����� �޿��� �ְ���� ���� �� �޿��� ���� �������� �����Ͻÿ�.
select deptno, max(sal) from emp group by deptno
order by max(sal) desc;

-- ex11) �μ��� ��� �޿��� 2000�̻��� �μ��鸸 �μ��� ����� ���Ͻÿ�.
select deptno, round(avg(sal),2) from emp
group by deptno
having avg(sal)>=2000;

-- �޿��� 1000�̻��� ����鸸 �μ��� ��ձ޿��� ���� �� �μ��� ��� �޿��� 2000�̻��� 
-- �μ��� �μ���ȣ�� �μ��� ��ձ޿��� ���Ͻÿ�.
select deptno, avg(sal) from emp where sal>=1000
 group by deptno having avg(sal) >= 2000;

select * from departments;
select * from emp;

-- SMITH ���� �ִ� �μ��̸��� ����ض�...
select * from emp;
select deptno from emp where ename='SMITH';
select * from departments;
select department_name from departments where department_id = 20;

select department_name from emp
inner join departments on emp.deptno = departments.department_id
where ename='SMITH';

-- inner �ִ� �͸�.... 
-- outer ���� �͵� �����ش�...
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







