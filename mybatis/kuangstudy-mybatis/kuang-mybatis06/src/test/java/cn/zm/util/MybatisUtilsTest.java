package cn.zm.util;

import cn.zm.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MybatisUtilsTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MybatisUtilsTest.class);
    @Test
    public void test() {
        SqlSession session = null;
        try {
            logger.info("info：进入selectUser方法");
            session = MybatisUtils.getSession();
            StudentMapper mapper = session.getMapper(StudentMapper.class);
            mapper.getAll();
        } finally {
            session.close();
        }
    }
}