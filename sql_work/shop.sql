--1. 상품 등록 및 쇼핑몰 운영을 위한 테이블생성 SQL 구문 필수
create table item
(
    item_id          bigint                    not null        primary key auto_increment,
    reg_time         datetime(6)               null,
    update_time      datetime(6)               null,
    created_by       varchar(255)              null,
    modified_by      varchar(255)              null,
    item_detail      tinytext                  not null,
    item_nm          varchar(50)               not null,
    item_sell_status enum ('SELL', 'SOLD_OUT') null,
    price            int                       not null,
    stock_number     int                       not null
);

create table item_img
(
    item_img_id  bigint       not null primary key auto_increment,
    reg_time     datetime(6)  null,
    update_time  datetime(6)  null,
    created_by   varchar(255) null,
    modified_by  varchar(255) null,
    img_name     varchar(255) null,
    img_url      varchar(255) null,
    ori_img_name varchar(255) null,
    repimg_yn    varchar(255) null,
    item_id      bigint       null,
    constraint item_img_fk1 foreign key (item_id) references item (item_id)
);

create table member
(
    member_id   bigint                 not null primary key auto_increment,
    reg_time    datetime(6)            null,
    update_time datetime(6)            null,
    created_by  varchar(255)           null,
    modified_by varchar(255)           null,
    address     varchar(255)           null,
    email       varchar(255)           null,
    name        varchar(255)           null,
    password    varchar(255)           null,
    role        enum ('ADMIN', 'USER') null,
    constraint member_index1 unique (email)
);

create table cart
(
    cart_id     bigint       not null primary key auto_increment,
    reg_time    datetime(6)  null,
    update_time datetime(6)  null,
    created_by  varchar(255) null,
    modified_by varchar(255) null,
    member_id   bigint       null,
    constraint cart_member_index1 unique (member_id),
    constraint cart_member_fk1 foreign key (member_id) references member (member_id)
);

create table cart_item
(
    cart_item_id bigint       not null primary key auto_increment,
    reg_time     datetime(6)  null,
    update_time  datetime(6)  null,
    created_by   varchar(255) null,
    modified_by  varchar(255) null,
    count        int          not null,
    cart_id      bigint       null,
    item_id      bigint       null,
    constraint cart_item_cart_fk1 foreign key (cart_id) references cart (cart_id),
    constraint cart_item_item_fk2 foreign key (item_id) references item (item_id)
);

create table orders
(
    order_id     bigint                   not null primary key auto_increment,
    reg_time     datetime(6)              null,
    update_time  datetime(6)              null,
    created_by   varchar(255)             null,
    modified_by  varchar(255)             null,
    order_date   datetime(6)              null,
    order_status enum ('CANCEL', 'ORDER') null,
    member_id    bigint                   null,
    constraint order_member_fk1
        foreign key (member_id) references member (member_id)
);

create table order_item
(
    order_item_id bigint       not null primary key auto_increment,
    reg_time      datetime(6)  null,
    update_time   datetime(6)  null,
    created_by    varchar(255) null,
    modified_by   varchar(255) null,
    count         int          not null,
    order_price   int          not null,
    item_id       bigint       null,
    order_id      bigint       null,
    constraint order_item_fk1 foreign key (item_id) references item (item_id),
    constraint order_orders_fk1 foreign key (order_id) references orders (order_id)
);

-- 상품 검색을 위한 SQL 구문 필수
-- 회원가입 INSERT
insert into member
(reg_time, update_time, created_by, modified_by, address, email, name, password, role)
values
(now(),now(),'','','대구','dron512@naver.com','박명회','password','admin');

insert into member
(reg_time, update_time, created_by, modified_by, address, email, name, password, role)
values
(now(),now(),'','','대구','abc@naver.com','고찬우','password','user');

-- 상품 등록을 위한 INSERT
insert 
into
    item
    (created_by, item_detail, item_nm, item_sell_status, 
    modified_by, price, reg_time, stock_number, update_time, item_id) 
values
    ('만드는사람','사과맛있어요','사과','판매중',
    '수정하는사람',1000, now(), 1000, now(), 1);

insert 
into
    item
    (created_by, item_detail, item_nm, item_sell_status, 
    modified_by, price, reg_time, stock_number, update_time, item_id) 
values
    ('만드는사람','포토맛있어요','포토','판매중',
    '수정하는사람',1000, now(), 1000, now(), 2);

-- 장바구니 등록을 위한 INSERT
insert
into
    cart
    (cart_id, member_id, created_by, reg_time, update_time )
values
    (1,1,'박명회',now(),now());

-- 장바구니 안에 cart item 등록을 위한 INSERT
insert
into
    cart_item
    (cart_item_id, cart_id, item_id, count, created_by, modified_by, reg_time, update_time)
values
    (1,1,1,100, '박명회','박명회',now(),now());

-- 주문등록을 위한 insert
insert
into 
    orders
    (order_id, member_id, order_status, order_date, created_by, modified_by, reg_time, update_time)
values
    (1,1,'order',now(),'박명회','박명회',now(),now());
-- 주문등록안에 아이템 등록을 위한 insert
insert
into 
    order_item
    ( order_item_id, order_id, item_id, order_price, count, created_by, modified_by, reg_time, update_time)
values
    ( 1, 1, 1, 2000, 100, '박명회','박명회',now(),now());

-- 상품검색을 위한 SQL 구문
SELECT * FROM item;

-- 상품검색을 위한 SQL 구문( 상품 이름이 사과 인것 검색)
SELECT * FROM item i
WHERE i.item_nm LIKE '%사과%';

-- 장바구니 테이블과 Item 테이블 조회 join 적용
SELECT * FROM cart c
LEFT OUTER JOIN cart_item ci 
ON c.cart_id = ci.cart_id
LEFT OUTER JOIN item i
ON ci.item_id = i.item_id;

-- order 테이블과 Item 테이블 조회 join 적용
SELECT * FROM orders o
LEFT OUTER JOIN order_item oi 
ON o.order_id = oi.order_id
LEFT OUTER JOIN item i
ON oi.item_id = i.item_id;


-- 5번 사용자가 장바구니 확인..
SELECT c.cart_id, ci.item_id, ci.count,
	i.item_nm, i.item_detail, i.price,
	c.member_id
FROM cart c
LEFT OUTER JOIN cart_item ci
ON c.cart_id = ci.cart_id
LEFT OUTER JOIN item i
ON ci.item_id = i.item_id
WHERE c.member_id=5;