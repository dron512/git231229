create table �л� (�й� char(5) not null, �̸� char(20) , �г� char(5),  ���� number(3), �Ҽ� char(10));
create table ���� (�й� char(5) not null, ��ȣ char(3) not null, ���� number(3));
create table ���� (��ȣ char(3) not null, ������ char(10) not null, ����� char(5), �Ҽ� char(10)); 

select * from �л�;
select * from ����;
select * from ����;

select * from tab;

-- �������� 
ALTER TABLE "�л�" ADD CONSTRAINT �л�pk PRIMARY KEY ("�й�");
ALTER TABLE "����" ADD CONSTRAINT ����PK PRIMARY KEY ("��ȣ");
ALTER TABLE "����" ADD FOREIGN KEY ("�й�") REFERENCES "�л�" ("�й�");
ALTER TABLE "����" ADD FOREIGN KEY ("��ȣ") REFERENCES "����" ("��ȣ");

select * from �л�;
select * from ����;
select * from ����;

commit;

INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('08001', 'ȫ�浿', '2', '170', 'CD');
INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('07002', '��浿', '4', '168', 'CD');
INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('07012', '�ڱ浿', '2', '180', 'CD');
INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('07033', '�̱浿', '3', '175', 'ID');
INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('05014', '�ֱ浿', '4', '183', 'ED');
INSERT INTO 
"HR"."�л�" ("�й�", "�̸�", "�г�", "����", "�Ҽ�") 
VALUES 
('06032', '���浿', '3', '165', 'ED');

insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('08001','ȫ�浿','2',170,'CD');
insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('07002','��浿','4',168,'CD');
insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('07012','�ڱ浿','2',180,'CD');
insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('07033','�̱浿','3',175,'ID');
insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('05014','�ֱ浿','4',183,'ED');
insert into �л�(�й�,�̸�,�г�,����,�Ҽ�) values ('06032','���浿','3',165,'ED');

insert into ����(�й�,��ȣ,����) values ('08001','101','95');
insert into ����(�й�,��ȣ,����) values ('08001','102','80');
insert into ����(�й�,��ȣ,����) values ('08001','103','60');
insert into ����(�й�,��ȣ,����) values ('08001','104','80');
insert into ����(�й�,��ȣ,����) values ('08001','105','85');
insert into ����(�й�,��ȣ,����) values ('07002','101','80');

insert into ����(�й�,��ȣ,����) values ('07002','104','95');
insert into ����(�й�,��ȣ,����) values ('07012','102','70');
insert into ����(�й�,��ȣ,����) values ('07012','103','80');
insert into ����(�й�,��ȣ,����) values ('07033','102','85');
insert into ����(�й�,��ȣ,����) values ('05014','104','90');


insert into ���� (��ȣ, ������, �����, �Ҽ�) values ('101', '���ϻ�', 'SE', 'CD');
insert into ���� (��ȣ, ������, �����, �Ҽ�) values ('102', '�ǿ���', 'DB', 'CD');
insert into ���� (��ȣ, ������, �����, �Ҽ�) values ('103', '��ҿ�', 'DG', 'MD');
insert into ���� (��ȣ, ������, �����, �Ҽ�) values ('104', '�̻�', 'FP', 'CD');
insert into ���� (��ȣ, ������, �����, �Ҽ�) values ('105', '�̼���', 'CS', 'ED');

set linesize 120;



