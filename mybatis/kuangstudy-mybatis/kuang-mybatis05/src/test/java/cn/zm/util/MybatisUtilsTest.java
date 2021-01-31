package cn.zm.util;

import cn.zm.domain.User;
import cn.zm.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class MybatisUtilsTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MybatisUtilsTest.class);
    @Test
    public void test() {
        SqlSession session = null;
        try {
            logger.info("info：进入selectUser方法");
            session = MybatisUtils.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.selectUserLimit(2));
            System.out.println(mapper.getUser(2));
            System.out.println(mapper.getUsers());
        } finally {
            session.close();
        }
    }
    @Test
    public void add() {
        SqlSession session = null;
        try {
            logger.info("info：进入add方法");
            session = MybatisUtils.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            mapper.add(new User(6, "add", "123456"));
            System.out.println(mapper.getUsers());
        } finally {
            session.close();
        }
    }
    @Test
    public void update() {
        SqlSession session = null;
        try {
            logger.info("info：进入add方法");
            session = MybatisUtils.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getUser(2));
            mapper.update(new User(2, "anno update", "123456"));
            System.out.println(mapper.getUser(2));
        } finally {
            session.close();
        }
    }
    @Test
    public void del() {
        SqlSession session = null;
        try {
            logger.info("info：进入add方法");
            session = MybatisUtils.getSession();
            UserMapper mapper = session.getMapper(UserMapper.class);
            System.out.println(mapper.getUsers());
            mapper.del(6);
            System.out.println(mapper.getUsers());
        } finally {
            session.close();
        }
    }

}