package cn.zm.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//4、编写MyBatis工具类
public class MybatisUtils {
    //静态属性
    private static SqlSessionFactory sqlSessionFactory;

    //初始化
    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream is = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static SqlSession getSession () {
        return sqlSessionFactory.openSession();
    }

}
