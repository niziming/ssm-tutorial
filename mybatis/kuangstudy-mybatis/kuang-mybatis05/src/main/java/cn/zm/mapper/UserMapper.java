package cn.zm.mapper;

import cn.zm.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
    @Select("select * from user limit 1")
    List<User> selectUserLimit(@Param("num") Integer num);
    @Select("select * from user where id = #{id}")
    List<User> getUser(@Param("id") Integer id);
    @Insert("insert into user(id,name,pwd) values (#{id}, #{name}, #{pwd})")
    void add(User user);
    @Insert("update user set name=#{name},pwd=#{pwd} where id=#{id}")
    void update(User user);
    @Delete("delete from user where id=#{id}")
    void del(@Param("id") Integer id);
}
