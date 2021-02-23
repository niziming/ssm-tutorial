package cn.zm.mapper;

import cn.zm.util.MybatisUtils;
import cn.zm.util.MybatisUtilsTest;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentMapperTest {
    //注意导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MybatisUtilsTest.class);

    @Test
    public void getAll() {
        SqlSession session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        //查询注解的
        System.out.println(mapper.getAll());
        //查询xml
        //System.out.println(mapper.getStu());
        //联表查询
        //System.out.println(mapper.getStudents());
        System.out.println(mapper.getStudents2());
        session.close();
    }
}