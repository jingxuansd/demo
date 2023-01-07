create table demo_user
(
    id   int(20) unsigned auto_increment
        primary key,
    name varchar(20) default '' null,
    uid  bigint unsigned        null
);