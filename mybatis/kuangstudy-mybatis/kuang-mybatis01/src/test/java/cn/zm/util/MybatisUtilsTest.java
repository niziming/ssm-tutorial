package cn.zm.util;

import cn.zm.mapper.UserMapper;
import cn.zm.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MybatisUtilsTest {

    @Test
    public void getSessin() {
        SqlSession sessin = MybatisUtils.getSession();
        UserMapper userMapper = sessin.getMapper(UserMapper.class);
        //List<User> users = userMapper.selectUser();
        //System.out.println(users);
        //System.out.println(userMapper.selectUserByid(1));
        //System.out.println(userMapper.selectUserByNP("ziming", "123456"));
        //HashMap<String, String> userParam = new HashMap<>();
        //userParam.put("username", "ziming");
        //userParam.put("pwd", "123456");
        //System.out.println(userMapper.selectUserByNP1(userParam));

        //新增
        //System.out.println(userMapper.addUser(new User(4, "xueqing", "xueqing")));
        //sessin.commit();
        //System.out.println(userMapper.selectUser());
        //新增map
        //System.out.println(userMapper.selectUser());
        //HashMap<String, Object> mapUser = new HashMap<>();
        //mapUser.put("userid", 5);
        //mapUser.put("username", "map");
        //mapUser.put("passwd", "add");
        //userMapper.addUser1(mapUser);
        //sessin.commit();
        //System.out.println(userMapper.selectUser());

        //更新
        //System.out.println(userMapper.selectUser());
        //int i = userMapper.updateUser(new User(3, "update", "user"));
        //System.out.println(i);
        //sessin.commit();
        //System.out.println(userMapper.selectUser());

        //删除
        //System.out.println(userMapper.selectUser());
        //userMapper.deleteById(4);
        //sessin.commit();
        //System.out.println(userMapper.selectUser());

        //模糊查询
        System.out.println(userMapper.selectUser());
        List<User> z = userMapper.searchUser("z");
        sessin.commit();
        System.out.println(z);
        sessin.close();
    }
}