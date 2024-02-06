create table 학생 (학번 char(5) not null, 이름 char(20) , 학년 char(5),  신장 number(3), 소속 char(10));
create table 수강 (학번 char(5) not null, 번호 char(3) not null, 성적 number(3));
create table 설강 (번호 char(3) not null, 교수명 char(10) not null, 과목명 char(5), 소속 char(10)); 

select * from 학생;
select * from 수강;
select * from 설강;

select * from tab;

-- 제약조건 
ALTER TABLE "학생" ADD CONSTRAINT 학생pk PRIMARY KEY ("학번");
ALTER TABLE "설강" ADD CONSTRAINT 설강PK PRIMARY KEY ("번호");
ALTER TABLE "수강" ADD FOREIGN KEY ("학번") REFERENCES "학생" ("학번");
ALTER TABLE "수강" ADD FOREIGN KEY ("번호") REFERENCES "설강" ("번호");

select * from 학생;
select * from 수강;
select * from 설강;

commit;

INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('08001', '홍길동', '2', '170', 'CD');
INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('07002', '김길동', '4', '168', 'CD');
INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('07012', '박길동', '2', '180', 'CD');
INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('07033', '이길동', '3', '175', 'ID');
INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('05014', '최길동', '4', '183', 'ED');
INSERT INTO 
"HR"."학생" ("학번", "이름", "학년", "신장", "소속") 
VALUES 
('06032', '정길동', '3', '165', 'ED');

insert into 학생(학번,이름,학년,신장,소속) values ('08001','홍길동','2',170,'CD');
insert into 학생(학번,이름,학년,신장,소속) values ('07002','김길동','4',168,'CD');
insert into 학생(학번,이름,학년,신장,소속) values ('07012','박길동','2',180,'CD');
insert into 학생(학번,이름,학년,신장,소속) values ('07033','이길동','3',175,'ID');
insert into 학생(학번,이름,학년,신장,소속) values ('05014','최길동','4',183,'ED');
insert into 학생(학번,이름,학년,신장,소속) values ('06032','정길동','3',165,'ED');

insert into 수강(학번,번호,성적) values ('08001','101','95');
insert into 수강(학번,번호,성적) values ('08001','102','80');
insert into 수강(학번,번호,성적) values ('08001','103','60');
insert into 수강(학번,번호,성적) values ('08001','104','80');
insert into 수강(학번,번호,성적) values ('08001','105','85');
insert into 수강(학번,번호,성적) values ('07002','101','80');

insert into 수강(학번,번호,성적) values ('07002','104','95');
insert into 수강(학번,번호,성적) values ('07012','102','70');
insert into 수강(학번,번호,성적) values ('07012','103','80');
insert into 수강(학번,번호,성적) values ('07033','102','85');
insert into 수강(학번,번호,성적) values ('05014','104','90');


insert into 설강 (번호, 교수명, 과목명, 소속) values ('101', '김일삼', 'SE', 'CD');
insert into 설강 (번호, 교수명, 과목명, 소속) values ('102', '권오영', 'DB', 'CD');
insert into 설강 (번호, 교수명, 과목명, 소속) values ('103', '김소월', 'DG', 'MD');
insert into 설강 (번호, 교수명, 과목명, 소속) values ('104', '이상', 'FP', 'CD');
insert into 설강 (번호, 교수명, 과목명, 소속) values ('105', '이석영', 'CS', 'ED');

set linesize 120;



