# 1、搭建实验数据库
create database if not exists exercise;

use exercise;

create table if not exists user(
  id int(20) not null ,
  name varchar(30) default null,
  pwd varchar(30) default null,
  primary key (id)
);

insert into user(id, name, pwd)
values (1, 'ziming', '123456'),
       (2, 'zhangsan', 'asdfasf'),
       (3,'李四','987654');
