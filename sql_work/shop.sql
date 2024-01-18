-- 상품 등록 및 쇼핑몰 운영을 위한 테이블생성 SQL 구문 필수

create table cart_item_seq
(
    next_val bigint null
);

create table cart_seq
(
    next_val bigint null
);

create table item
(
    item_id          bigint                    not null        primary key,
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
    item_img_id  bigint       not null
        primary key,
    reg_time     datetime(6)  null,
    update_time  datetime(6)  null,
    created_by   varchar(255) null,
    modified_by  varchar(255) null,
    img_name     varchar(255) null,
    img_url      varchar(255) null,
    ori_img_name varchar(255) null,
    repimg_yn    varchar(255) null,
    item_id      bigint       null,
    constraint item_img_fk1
        foreign key (item_id) references item (item_id)
);

create table item_img_seq
(
    next_val bigint null
);

create table item_seq
(
    next_val bigint null
);

create table member
(
    member_id   bigint                 not null
        primary key,
    reg_time    datetime(6)            null,
    update_time datetime(6)            null,
    created_by  varchar(255)           null,
    modified_by varchar(255)           null,
    address     varchar(255)           null,
    email       varchar(255)           null,
    name        varchar(255)           null,
    password    varchar(255)           null,
    role        enum ('ADMIN', 'USER') null,
    constraint member_index1
        unique (email)
);

create table cart
(
    cart_id     bigint       not null
        primary key,
    reg_time    datetime(6)  null,
    update_time datetime(6)  null,
    created_by  varchar(255) null,
    modified_by varchar(255) null,
    member_id   bigint       null,
    constraint cart_member_index1
        unique (member_id),
    constraint cart_member_fk1
        foreign key (member_id) references member (member_id)
);

create table cart_item
(
    cart_item_id bigint       not null
        primary key,
    reg_time     datetime(6)  null,
    update_time  datetime(6)  null,
    created_by   varchar(255) null,
    modified_by  varchar(255) null,
    count        int          not null,
    cart_id      bigint       null,
    item_id      bigint       null,
    constraint cart_item_cart_fk1
        foreign key (cart_id) references cart (cart_id),
    constraint cart_item_item_fk2
        foreign key (item_id) references item (item_id)
);

create table member_seq
(
    next_val bigint null
);

create table order_item_seq
(
    next_val bigint null
);

create table orders
(
    order_id     bigint                   not null
        primary key,
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
    order_item_id bigint       not null
        primary key,
    reg_time      datetime(6)  null,
    update_time   datetime(6)  null,
    created_by    varchar(255) null,
    modified_by   varchar(255) null,
    count         int          not null,
    order_price   int          not null,
    item_id       bigint       null,
    order_id      bigint       null,
    constraint order_item_fk1
        foreign key (item_id) references item (item_id),
    constraint order_orders_fk1
        foreign key (order_id) references orders (order_id)
);

create table orders_seq
(
    next_val bigint null
);

-- 상품 검색을 위한 SQL 구문 필수