package cn.zm.mapper;

import cn.zm.domain.Student;
import cn.zm.domain.Teacher;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    @Select("select * from teacher")
    List<Teacher> getAll();
}
