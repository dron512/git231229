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

INSERT INTO group_ (group_no, group_name) VALUES ('CT', '�ڰ��� ����');
INSERT INTO group_ (group_no, group_name) VALUES ('RYN', '����');
INSERT INTO group_ (group_no, group_name) VALUES ('RL', '����');
INSERT INTO group_ (group_no, group_name) VALUES ('RR', '��������');
INSERT INTO group_ (group_no, group_name) VALUES ('CG', 'ī�װ�');
INSERT INTO group_ (group_no, group_name) VALUES ('RQ', '��û');
INSERT INTO group_ (group_no, group_name) VALUES ('RC', '��û�з�');
    commit;
    
    INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1', '����ó�����', 'CT');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2', 'SQLD', 'CT');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('Y', '�׷��ϴ�', 'RYN');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('R', '~���̴�', 'RYN');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('N', '�׷����� �ʴ�', 'RYN');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('USER', '�����', 'RL');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('ADMIN', '������', 'RL');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR1', '��� ������', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR2', '���� ������', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR3', '�ߺ��� ���', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR4', '�ߺ��� ����', 'RR');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RR5', 'ī�װ� ������', 'RR');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG1', '����Ʈ���� ����', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG2', '����Ʈ���� ����', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG3', '�����ͺ��̽� ����', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG4', '���α׷��� ���Ȱ��', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT1_CG5', '�����ý��� �������', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2_CG1', '�����͸𵨸��� ����', 'CG');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('CT2_CG2', 'SQL �⺻ �� Ȱ��', 'CG');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('UPDATE', '����', 'RQ');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('DELETE', '����', 'RQ');

INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RC1', '���', 'RC');
INSERT INTO group_detail (group_detail_no, group_detail_name, group_no) VALUES ('RC2', '����', 'RC');
    
commit;    

INSERT INTO member (id, pw, name, role, resign) VALUES ('admin', 'admin', '������', 'admin', 'n');
INSERT INTO member (id, pw, name, role, resign) VALUES ('yyy', '1234', '����', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('test', '1111', 'name', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('green', '2222', 'haha', 'user', 'y');
INSERT INTO member (id, pw, name, role, resign) VALUES ('bonobono', 'test', 'hoho', 'user', 'n');
INSERT INTO member (id, pw, name, role, resign) VALUES ('pporori', 'test1234', 'ral', 'user', 'n');
commit;

INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF001', '����', '� ����� ����(ȣ��)�ϴ� ����� ��', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF002', '�Ҿƿ�', '� ����� ���� ����(ȣ��)�Ǵ� ����� ��', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF003', '��������', '�߻� ���丮(Abstract Factory), ����(Builder), ���丮 �޼ҵ�(Factory Method), ������Ÿ��(Prototype), �̱���(Singleton)', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF004', '��������', '�����(Adapter), �긮��(Bridge), ������Ʈ(Composite), ���ڷ�����(Decorator), �۽ε�(Facade), �ö��̿���Ʈ(Flyweight), ���Ͻ�(Proxy)', SYSDATE, 'n', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF005', '��������', 'å�� ����(Chain of Responsibility), Ŀ�ǵ�(Command), ����������(Interpreter), �ݺ���(Iterator), ������(Mediator), �޸���(Memento), �ɼ���(Observer), ����(State), ����(Strategy), ���ø� �޼ҵ�(Templete Method), �湮��(Visitor)', SYSDATE, 'y', 'CT1_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF006', '����(Stress)�׽�Ʈ', '�ý��ۿ� ������ �������̳� �� ���� �ΰ��Ͽ� ����ȭ�ÿ��� ����Ʈ��� ���������� ����Ǵ����� Ȯ���ϴ� �׽�Ʈ�̴�.', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF007', 'ȭ��Ʈ�ڽ� �׽�Ʈ ����', '���� ��� �˻�, ���� ���� �˻�(���� �˻�, ���� �˻�, ������ �帧 �˻�)', SYSDATE, 'y', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF008', '����ڽ� �׽�Ʈ ����', '��ġ ���� �˻�, ��谪 �м�, ����-ȿ�� �׷��� �˻�, ���� ���� �˻�, �� �˻�', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF009', '���� �׽�Ʈ(Unit Test)', '�ڵ� ���� ����Ʈ���� ������ �ּ� ������ ����̳� ������Ʈ�� ������ ���� �׽�Ʈ�ϴ� ���̴�.', SYSDATE, 'n', 'CT1_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF010', 'Ʈ�����', '���Ӽ�(Durablility) ,�ϰ���(Consistency) ,���ڼ�(Atomicity), �ݸ���(Isolation)', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF011', '���� ���Ἲ', 'CASCADE, RESTRICTED, SET NULL, SET DEFAULT', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF012', 'DDL', 'CREATE, ALTER, DROP', SYSDATE, 'n', 'CT1_CG3');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF013', '������', '���(Functional) > ����(Sequential) > ��ȯ(Communication) > ����(Procedural) > �ð�(Temporal) > ��(Logical) > �쿬(Coincidental)', SYSDATE, 'y', 'CT1_CG4');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('ELF014', '���������� 3�� ���', '��м�, ���Ἲ, ���뼺', SYSDATE, 'n', 'CT1_CG5');

INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD001', '������ �𵨸��� �߿伺 �� ������', '�ı�ȿ��, ������ ǥ��, ������ ǰ��', SYSDATE, 'n', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD002', '������ �𵨸��� 3�ܰ�', '1. ������ ������ �𵨸� 2. Key, �Ӽ�, ���� ���� ��Ȯ�ϰ� ǥ��, ���뼺�� ����. 3. ������ ������ �𵨸�', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD003', '��ƼƼ ������Ŀ� ���� �з�', 'PK �Ӽ�, FK �Ӽ�, �ϹݼӼ�', SYSDATE, 'n', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD004', '�𵨸��� ����', '������ ���Ǽ��踦 �ܼ�ȭ���� ǥ���ϴ� ���� ���Ѵ�.', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD005', '�𵨸��� Ư¡', '�߻�ȭ, �ܼ�ȭ, ��Ȯȭ', SYSDATE, 'y', 'CT2_CG1');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD006', 'INNER JOIN', 'JOIN ���ǿ��� ������ ���� �ִ� �ุ ��ȯ, USING�̳� ON ���� �ʼ������� ���', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD007', 'NATURAL JOIN', '�� ���̺� ���� ������ �̸��� ���� ��� Į���鿡 ���� EQUI JOIN ����', SYSDATE, 'y', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD008', 'EQUAL JOIN', 'EQUAL JOIN�� �� ���� ���̺� ���� �÷� ���� ��ġ�ϴ� �� ����, �� ���� ���̺��� �������� ã��', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD009', 'NON EQUAL JOIN', 'NON EQUAL JOIN�� <, >, <=, >=�� ���', SYSDATE, 'n', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD010', 'SELF JOIN', '�� ���̺��� �� ���� �÷��� ���� ���踦 ������ �ִ� ��쿡 ���', SYSDATE, 'y', 'CT2_CG2');
INSERT INTO word (word_no, word, word_mean, insert_date, delete_yn, category) VALUES ('SD011', 'CROSS JOIN', '���� ������ M*N���� ������ ������ �߻�', SYSDATE, 'n', 'CT2_CG2');

commit;	

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE01', 'DELETE', 'SD008', SYSDATE, 'test', 'RC1', NULL, NULL, 'r');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE02', 'DELETE', 'ELF007', SYSDATE, 'pporori', 'RC1', NULL, NULL, 'r');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE03', 'UPDATE', 'ELF013', SYSDATE, 'RR3', 'test', 'RC2', '�̰� �̸� �̻��ؿ�', 'n');

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE04', 'UPDATE', 'ELF002', SYSDATE, 'test', 'RC1', 'r', '�Ϸ�Ǹ� y', NULL);

INSERT INTO request (request_no, process_division, word_no, request_date, reason, id, request_division, request_content, request_ryn)
VALUES ('RE05', 'DELETE', 'SD010', SYSDATE, 'green', 'RC2', NULL, NULL, 'y');

commit;


