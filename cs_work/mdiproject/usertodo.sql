

# 오라클 계정 생성 방법
CREATE USER usertodo IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO usertodo;

CREATE USER usertodo IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO usertodo;
--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------
DROP TABLE USERS;
CREATE TABLE USERS 
(	IDX NUMBER, 
    EMAIL VARCHAR2(20), 
    ADDR VARCHAR2(20), 
    PASSWORD VARCHAR2(20), 
    NAME VARCHAR2(20)
) ;

--------------------------------------------------------
--  DDL for Table TODO
--------------------------------------------------------
drop table TODO;
CREATE TABLE TODO 
(	IDX NUMBER, 
    USERS_IDX VARCHAR2(20), 
    TITLE VARCHAR2(20), 
    "CONTENT" VARCHAR2(20), 
    FINISHDATE DATE
);

ALTER TABLE 테이블이름
ADD CONSTRAINT PK_기본키필드 PRIMARY KEY (기본키필드);


ALTER TABLE 테이블1
ADD CONSTRAINT FK_참조키필드
FOREIGN KEY (참조키필드)
REFERENCES 다른테이블이름 (기본키필드);