USE edu;

CREATE TABLE USER (
	`no`	INT				NOT NULL	AUTO_INCREMENT	PRIMARY KEY,
	`name`	VARCHAR(100)	NOT NULL,
	`email`	VARCHAR(200)	NOT NULL,
	`pwd`	VARCHAR(100)	NOT NULL
);

INSERT INTO USER
	(name,email,pwd)
VALUE
	('폴더','folder@email.com','1234');

INSERT INTO USER
	(name,email,pwd)
VALUE
	('사용자','user@email.com','1234');

SELECT * FROM USER;

commit;