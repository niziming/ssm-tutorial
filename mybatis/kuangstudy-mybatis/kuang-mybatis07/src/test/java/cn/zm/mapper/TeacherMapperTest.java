package cn.zm.mapper;

import cn.zm.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TeacherMapperTest {
    @Test
    public void getAll() {
        SqlSession session = null;
        try {
            session = MybatisUtils.getSession();
            TeacherMapper mapper = session.getMapper(TeacherMapper.class);
            System.out.println(mapper.getAll());
            System.out.println(mapper.getTeacher(1));
            //System.out.println(mapper.getTeacher2(1));
        } finally {
            session.close();
        }
    }
}