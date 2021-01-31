package cn.zm.util;

import cn.zm.mapper.UserMapper;
import cn.zm.domain.User;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MybatisUtilsTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MybatisUtilsTest.class);
    @Test
    public void getSessin() {
        SqlSession sessin = null;
        try {
            logger.info("info：进入selectUser方法");
            int currentPage = 1;  //第几页
            int pageSize = 2;  //每页显示几个
            Map<String,Integer> map = new HashMap<String,Integer>();
            map.put("currentPage",(currentPage-1)*pageSize);
            map.put("pageSize",pageSize);
            sessin = MybatisUtils.getSession();
            UserMapper userMapper = sessin.getMapper(UserMapper.class);
            //List<User> arr = userMapper.selectUserByPage((1-1)*3, 3);
            List<User> arr = userMapper.selectUserByPage(map);
            System.out.println(arr);
        } finally {
            sessin.close();
        }
    }

    @Test
    public void testUserByRowBounds() {
        SqlSession session = MybatisUtils.getSession();

        int currentPage = 2;  //第几页
        int pageSize = 2;  //每页显示几个
        RowBounds rowBounds = new RowBounds((currentPage-1)*pageSize,pageSize);

        //通过session.**方法进行传递rowBounds，[此种方式现在已经不推荐使用了]
        List<User> users = session.selectList("cn.zm.dao.UserMapper.getUserByRowBounds", null, rowBounds);

        for (User user: users){
            System.out.println(user);
        }
        session.close();
    }
}