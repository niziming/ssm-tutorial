package cn.zm.mapper;

import cn.zm.domain.Student;
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
        SqlSession session = null;
        session = MybatisUtils.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        System.out.println(mapper.getAll());
        System.out.println(mapper.StudentTeacher());
        session.close();
    }
}