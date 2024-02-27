SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD HH24:MI:SS') AS CURRENT_DATE_TIME FROM DUAL;


drop table 사원;
drop table 대출;
create table 사원 (사번 varchar2(10), 이름 varchar2(10));
create table 대출 (사번 varchar2(10), 도서 varchar2(10));
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0001', '홍길동')
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0002', '김치국')
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0003', '안경태')
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0004', '박호순')
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0005', '한국인')
INSERT INTO "HR"."사원" ("사번", "이름") VALUES ('A0006', '이호빵')

INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0301')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0002', 'T0302')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0203')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0401')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0005', 'T0501')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0001', 'T0201')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0204')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0003', 'T0306')
INSERT INTO "HR"."대출" ("사번", "도서") VALUES ('A0008', 'T0404')
