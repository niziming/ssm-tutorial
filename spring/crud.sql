-- 创建数据库
create database excercise;
-- 使用数据库
use excercise;
-- 创建账户表
create table account(
  id int primary key auto_increment,
  name varchar(40),
  money float
)character set utf8 collate utf8_general_ci;
-- 插入一条记录
insert into account(name, money) values('aaa', 1000);
insert into account(name, money) values('bbb', 2000);