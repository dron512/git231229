create table member (
    create_date_time datetime(6),
    id bigint not null auto_increment,
    update_date_time datetime(6) ,
    email varchar(50) not null,
    username varchar(50) not null,
    password varchar(255),
    role enum ('USER','ADMIN'),
    primary key (id)
);
create table todo (
    id bigint not null auto_increment,
    member_id bigint,
    todo varchar(255),
    primary key (id)
);
alter table todo
add constraint todo_member_id_fk
foreign key (member_id)
references member (id);