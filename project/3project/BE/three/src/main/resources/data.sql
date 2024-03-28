INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('김길동','aaa','01000000000','aaa@naver.com','약학과','12341234','N',null,'Y','2015/02/18 15:26:20','2023/1/26 10:56:26');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('감길동','aab','01011111111','aab@naver.com','경영학과','111111','Y','third','N','2020/02/18 15:26:20',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('Steve','steve','01011112222','steve1234@google.com','영어영문학과','111122','Y','second','N','2022/02/18 15:26:20',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('Karen','karen','01035642522','karen0000@google.com','국어국문학과','356425','Y','fourth','N','2019/02/20 13:46:10',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('김철수','chulsoo','01025662122','chulsoo0001@google.com','교육학과','212266','Y','first','N','2023/02/18 15:26:20',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('손길동','손길동','01015312564','손길동1234@naver.com','피아노전공','15312564','Y','third','Y','2019/02/18 15:26:20',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('황유나','yuna','01013412422','yuna1341@google.com','심리학과','134124','Y','first','N','2022/02/18 15:26:20',null);

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('권길동','권길동','01059182562','GGD1234@google.com','경찰행정학','591825','Y','fourth','Y','2018/02/18 15:26:20','2023/03/26 08:42:42');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('David','machine','01018592652','machine2256@google.com','기계공학','185926','N',null,'Y','2017/03/08 10:46:20','2023/03/15 13:56:48');

INSERT INTO user (NAME, nickname, phone_num, email, studies, PASSWORD, enrollment_status, grade, withdraw_status, create_date, modify_date)
VALUES('Cindy','cd','01018592655','m2256@google.com','유아교육학과','185956','N',null,'Y','2016/03/08 10:46:20','2023/03/15 13:56:48');

Insert into todo (user_id, todo) values (7,'신입생 OT');
Insert into todo (user_id, todo) values (3,'대학교 MT');
Insert into todo (user_id, todo) values (5,'중간고사 준비');
Insert into todo (user_id, todo) values (3,'기말고사 준비');
Insert into todo (user_id, todo) values (4,'기말고사 준비');
Insert into todo (user_id, todo) values (6,'기말고사 준비');
Insert into todo (user_id, todo) values (5,'축제 준비');
Insert into todo (user_id, todo) values (7,'동아리 활동 OT');
Insert into todo (user_id, todo) values (2,'동아리 MT');
Insert into todo (user_id, todo) values (4,'졸업');

Insert into memo (memo, user_id) values ('대학교 입학식',7);
Insert into memo (memo, user_id) values ('대학 MT 가는 날',3);
Insert into memo (memo, user_id) values ('4/19~ 4/23 1학기 중간고사',8);
Insert into memo (memo, user_id) values ('6/14~ 6/18 1학기 기말고사',6);
Insert into memo (memo, user_id) values ('10/18~ 10/22 2학기 기말고사',4);
Insert into memo (memo, user_id) values ('12/13~ 12/17 2학기 기말고사',4);
Insert into memo (memo, user_id) values ('대학교 축제',5);
Insert into memo (memo, user_id) values ('수업 끝나고 동아리 활동 OT',7);
Insert into memo (memo, user_id) values ('동아리 MT 가는 날',2);
Insert into memo (memo, user_id) values ('졸업',4);

Insert into term_memo (todo, time_table_id) values ('내일은 대학교 MT 가는 날, 바베큐 빨리 먹고파',3);
Insert into term_memo (todo, time_table_id) values ('중간고사 한 달 전, 열공모드 on',4);
Insert into term_memo (todo, time_table_id) values ('기말고사 한 달 전, 열공모드 on',4);
Insert into term_memo (todo, time_table_id) values ('성적이 A+!!!!',4);
Insert into term_memo (todo, time_table_id) values ('성적이 C+이 나오다니 절망 ㅠㅠㅠ',5);
Insert into term_memo (todo, time_table_id) values ('오늘은 대학교 축제',5);
Insert into term_memo (todo, time_table_id) values ('내일은 동아리 활동 첫 OT 어떤 사람들을 만날까?',7);
Insert into term_memo (todo, time_table_id) values ('내일은 동아리 MT',7);
Insert into term_memo (todo, time_table_id) values ('취준 시작',2);
Insert into term_memo (todo, time_table_id) values ('졸업, 학업의 끝 취준지옥 시작',9);








