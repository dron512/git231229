select * from ���;
select * from ����;

-- Q1) �̱浿 �л��� ������ ������� ������ ���Ͻÿ�.
select a.�й�, b.����, c.������ from �л� a
inner join ���� b on a.�й� = b.�й�
inner join ���� c on b.��ȣ = c.��ȣ;

select * from ����;
select * from ����;

select a.�й�, b.����, c.������ from �л� a,���� b,���� c 
where a.�й� = b.�й� and b.��ȣ = c.��ȣ;


where �̸�='�̱浿';
select * from ����;
select * from ����;

 select ������,���� from �л�,����,���� 
 where �л�.�̸� = '�̱浿' and �л�.�й� = ����.�й� and ����.��ȣ = ����.��ȣ;
 
-- Q2  �־����� ���� �л��� ��� ������ ���϶�.
select * from  �л�,����,���� 
 where 
 �л�.�й� = ����.�й� and ����.��ȣ = ����.��ȣ;
 where �̸� like '��%';
 
 select * from �л�;
 select * from ����;
 
select * from �л� a
inner join ���� b on a.�й� = b.�й�
inner join ���� c on b.��ȣ = c.��ȣ
where �̸� like '��%';

--Q3) �ֱ浿 �л��� �г�,�̸�,�����ȣ,������ ���Ͻÿ�.
select �г�,�̸�,c.��ȣ,���� from �л� a
inner join ���� b on a.�й� = b.�й�
inner join ���� c on b.��ȣ = c.��ȣ
where �̸� ='�ֱ浿';

-- Q1) ������ ����� ������ ���� ����� ����Ͻÿ�.(����̸�,����,��޼����� ���)
-- Q2) ������� job�� �μ����� ���Ͻÿ�. (�̸�,job, �μ�������� ���)
select job, department_name from emp
inner join departments on emp.deptno = departments.DEPARTMENT_ID;



 
 
 