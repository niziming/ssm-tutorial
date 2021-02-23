# drop database if exists exercise;
# create database if not exists exercise ;

# use exercise;

# 创建用户表
# create table account (
                                               #     id int primary key auto_increment,
                                               #     name varchar(40),
                                               #     money float
                                                   # ) character set utf8 collate utf8_general_ci;

# insert into account(name, money) values ('ziming', 10000);
# insert into account(name, money) values ('ziming', 10000);
# insert into account(name, money) values ('ziming', 10000);

# select * from account;


# insert into account(name, money) values ('zasd', 153.0);

# select * from user limit 1;

# create table teacher (
                           #     id int(10) not null,
                           #     name varchar(30) default null,
                           #     primary key(id)
                               # )engine=innodb default charset=utf8;

# insert into teacher(id, name) values (1, '倪子铭');
# select * from teacher;
# create table student(
                          #     id int(10) not null,
                          #     name varchar(30) default null,
                          #     tid int(10) default null,
                          #     primary key (id),
                          #     key fktid (tid),
                          #     constraint fktid foreign key (tid) references teacher (id)
                              # )engine=innodb default charset=utf8;

# insert into student (id, name, tid) values (1, '小雪', 1);
# insert into student (id, name, tid) values (2, '小红', 1);
# insert into student (id, name, tid) values (3, '小张', 1);
# insert into student (id, name, tid) values (4, '小李', 1);
# insert into student (id, name, tid) values (5, '小王', 1);
