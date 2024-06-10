CREATE TABLE member (
	id	varchar2(255)		NOT NULL,
	pw	varchar2(255)		NULL,
	name	varchar2(255)		NULL,
	role	varchar2(255)		NULL,
	resign	varchar2(255)		NULL
);

CREATE TABLE request (
	request_no	varchar2(255)		NOT NULL,
	process_division	varchar2(255)		NULL,
	request_division	varchar2(255)		NULL,
	request_content	varchar2(255)		NULL,
	request_date	varchar2(255)		NULL,
	reason	varchar2(255)		NULL,
	request_ryn	varchar2(255)		NULL,
	id	varchar2(255)		NOT NULL,
	word_no	varchar2(255)		NOT NULL
);

CREATE TABLE group_ (
	group_no	varchar2(255)		NOT NULL,
	group_name	varchar2(255)		NULL
);

CREATE TABLE group_detail (
	group_detail_no	varchar2(255)		NOT NULL,
	group_detail_name	varchar2(255)		NULL,
	group_no	varchar2(255)		NOT NULL
);

CREATE TABLE word (
	word_no	varchar2(255)		NOT NULL,
	word	varchar2(255)		NULL,
	word_mean	varchar2(255)		NULL,
	insert_date	varchar2(255)		NULL,
	delete_yn	varchar2(255)		NULL,
	category	varchar2(255)		NULL
);

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (
	id
);

ALTER TABLE request ADD CONSTRAINT PK_REQUEST PRIMARY KEY (
	request_no
);

ALTER TABLE group_ ADD CONSTRAINT PK_GROUP PRIMARY KEY (
	group_no
);

ALTER TABLE group_detail ADD CONSTRAINT PK_GROUP_DETAIL PRIMARY KEY (
	group_detail_no
);

ALTER TABLE word ADD CONSTRAINT PK_WORD PRIMARY KEY (
	word_no
);

ALTER TABLE request ADD CONSTRAINT FK_member_TO_request_1 FOREIGN KEY (
	id
)
REFERENCES member (
	id
);

ALTER TABLE request ADD CONSTRAINT FK_word_TO_request_1 FOREIGN KEY (
	word_no
)
REFERENCES word (
	word_no
);

ALTER TABLE group_detail ADD CONSTRAINT FK_group_TO_group_detail_1 FOREIGN KEY (
	group_no
)
REFERENCES group_ (
	group_no
);

commit;

INSERT INTO group_ (group_no, group_name) VALUES ('CT', '자격증 종류');
INSERT INTO group_ (group_no, group_name) VALUES ('RYN', '여부');
INSERT INTO group_ (group_no, group_name) VALUES ('RL', '권한');
INSERT INTO group_ (group_no, group_name) VALUES ('RR', '거절사유');
INSERT INTO group_ (group_no, group_name) VALUES ('CG', '카테고리');
INSERT INTO group_ (group_no, group_name) VALUES ('RQ', '요청');
INSERT INTO group_ (group_no, group_name) VALUES ('RC', '요청분류');
    commit;
    
    INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1', '정보처리기사', 'CT');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2', 'SQLD', 'CT');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('Y', '그러하다', 'RYN');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('R', '~중이다', 'RYN');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('N', '그러하지 않다', 'RYN');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('USER', '사용자', 'RL');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('ADMIN', '관리자', 'RL');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR1', '용어 부적격', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR2', '정의 부적격', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR3', '중복된 용어', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR4', '중복된 정의', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR5', '카테고리 부적격', 'RR');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG1', '소프트웨어 설계', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG2', '소프트웨어 개발', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG3', '데이터베이스 구축', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG4', '프로그래밍 언어활용', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG5', '정보시스템 구축관리', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2_CG1', '데이터모델링의 이해', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2_CG2', 'SQL 기본 및 활용', 'CG');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('UPDATE', '수정', 'RQ');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('DELETE', '삭제', 'RQ');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RC1', '용어', 'RC');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RC2', '정의', 'RC');
    
commit;    

INSERT INTO member (id, pw, name, role, resign) VALUES ('admin', 'admin', '관리자', 'admin', 'n');
INSERT INTO member (id, pw, name, role, resign) VALUES ('yyy', '1234', '유저', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('test', '1111', 'name', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('green', '2222', 'haha', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('bonobono', 'test', 'hoho', 'user', 'n');
INSERT INTO member (id, pw, name, role, resign) VALUES ('pporori', 'test1234', 'ral', 'user', 'n');
commit;

INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF001', '팬인', '어떤 모듈을 제어(호출)하는 모듈의 수', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF002', '팬아웃', '어떤 모듈을 의해 제어(호출)되는 모듈의 수', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF003', '생성패턴', '추상 팩토리(Abstract Factory), 빌더(Builder), 팩토리 메소드(Factory Method), 프로토타입(Prototype), 싱글톤(Singleton)', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF004', '구조패턴', '어댑터(Adapter), 브리지(Bridge), 컴포지트(Composite), 데코레이터(Decorator), 퍼싸드(Facade), 플라이웨이트(Flyweight), 프록시(Proxy)', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF005', '행위패턴', '책임 연쇄(Chain of Responsibility), 커맨드(Command), 인터프리터(Interpreter), 반복자(Iterator), 중재자(Mediator), 메멘토(Memento), 옵서버(Observer), 상태(State), 전략(Strategy), 템플릿 메소드(Templete Method), 방문자(Visitor)', SYSDATE, 'y', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF006', '강도(Stress)테스트', '시스템에 과도한 정보량이나 빈도 등을 부과하여 과부화시에도 소프트웨어가 정상적으로 실행되는지를 확인하는 테스트이다.', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF007', '화이트박스 테스트 종류', '기초 경로 검사, 제어 구조 검사(조건 검사, 루프 검사, 데이터 흐름 검사)', SYSDATE, 'y', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF008', '블색박스 테스트 종류', '동치 분할 검사, 경계값 분석, 원인-효과 그래프 검사, 오류 예측 검사, 비교 검사', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF009', '단위 테스트(Unit Test)', '코딩 직후 소프트웨어 설계의 최소 단위인 모듈이나 컴포넌트에 초점을 맞춰 테스트하는 것이다.', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF010', '트랜잭션', '영속성(Durablility) ,일관성(Consistency) ,원자성(Atomicity), 격리성(Isolation)', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF011', '참조 무결성', 'CASCADE, RESTRICTED, SET NULL, SET DEFAULT', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF012', 'DDL', 'CREATE, ALTER, DROP', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF013', '응집도', '기능(Functional) > 순차(Sequential) > 교환(Communication) > 절차(Procedural) > 시간(Temporal) > 논리(Logical) > 우연(Coincidental)', SYSDATE, 'y', 'CT1_CG4');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF014', '정보보안의 3대 요소', '기밀성, 무결성, 가용성', SYSDATE, 'n', 'CT1_CG5');

INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD001', '데이터 모델링의 중요성 및 유의점', '파급효과, 간결한 표현, 데이터 품질', SYSDATE, 'n', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD002', '데이터 모델링의 3단계', '1. 개념적 데이터 모델링 2. Key, 속성, 관계 등을 정확하게 표현, 재사용성이 높다. 3. 물리적 데이터 모델링', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD003', '엔티티 구성방식에 따른 분류', 'PK 속성, FK 속성, 일반속성', SYSDATE, 'n', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD004', '모델링의 설명', '복잡한 현실세계를 단순화시켜 표현하는 것을 말한다.', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD005', '모델링의 특징', '추상화, 단순화, 명확화', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD006', 'INNER JOIN', 'JOIN 조건에서 동일한 값이 있는 행만 반환, USING이나 ON 절을 필수적으로 사용', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD007', 'NATURAL JOIN', '두 테이블 간의 동일한 이름을 갖는 모든 칼럼들에 대해 EQUI JOIN 수행', SYSDATE, 'y', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD008', 'EQUAL JOIN', 'EQUAL JOIN은 두 개의 테이블 간에 컬럼 값이 일치하는 걸 조인, 두 개의 테이블에서 교집합을 찾음', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD009', 'NON EQUAL JOIN', 'NON EQUAL JOIN은 <, >, <=, >=을 사용', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD010', 'SELF JOIN', '한 테이블에서 두 개의 컬럼이 연관 관계를 가지고 있는 경우에 사용', SYSDATE, 'y', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD011', 'CROSS JOIN', '양쪽 집합의 M*N건의 데이터 조합이 발생', SYSDATE, 'n', 'CT2_CG2');

commit;	

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE01', 'DELETE', 'SD008', SYSDATE, 'test', 'RC1', NULL, NULL, 'r');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE02', 'DELETE', 'ELF007', SYSDATE, 'pporori', 'RC1', NULL, NULL, 'r');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE03', 'UPDATE', 'ELF013', SYSDATE, 'RR3', 'test', 'RC2', '이거 이름 이상해요', 'n');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE04', 'UPDATE', 'ELF002', SYSDATE, 'test', 'RC1', 'r', '완료되면 y', NULL);

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE05', 'DELETE', 'SD010', SYSDATE, 'green', 'RC2', NULL, NULL, 'y');

commit;


