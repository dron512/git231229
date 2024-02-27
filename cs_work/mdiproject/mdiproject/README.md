
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

ALTER TABLE users
ADD CONSTRAINT aaa PRIMARY KEY (idx);

ALTER TABLE todo
ADD CONSTRAINT bbb PRIMARY KEY (idx);

ALTER TABLE todo
ADD CONSTRAINT ccc FOREIGN KEY (users_idx) REFERENCES users (idx);
