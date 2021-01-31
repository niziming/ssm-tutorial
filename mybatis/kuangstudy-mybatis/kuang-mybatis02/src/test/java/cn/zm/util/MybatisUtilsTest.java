package cn.zm.util;

import cn.zm.mapper.UserDao;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class MybatisUtilsTest {

    @Test
    public void getSessin() {
        SqlSession sessin = null;
        try {
            sessin = MybatisUtils.getSession();
            UserDao userDao = sessin.getMapper(UserDao.class);
            //@Param("username")
            System.out.println(userDao.selectUserByNP("ziming", "123456"));
            //万能map
            HashMap hashMap = new HashMap();
            hashMap.put("username", "ziming");
            hashMap.put("pwd", "123456");
            System.out.println(userDao.selectUserByNP1(hashMap));
        } finally {
            sessin.close();
        }
    }
}