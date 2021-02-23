package cn.zm.mapper;

import cn.zm.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    List<Student> getAll();

    List<Student> getStu();
    List<Student> getStudents();
    List<Student> getStudents2();
}
