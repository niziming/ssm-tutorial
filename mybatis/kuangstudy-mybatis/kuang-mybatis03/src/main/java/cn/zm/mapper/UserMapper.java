package cn.zm.mapper;

import cn.zm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> selectUser();

    User selectUserById(@Param("id") Integer id);

    User selectUserByNP(
            @Param("username") String username,
            @Param("pwd") String pwd
    );

    User selectUserByNP1(Map map);

    int addUser(User user);
    int addUser1(Map<String, Object> user);

    int updateUser(User user);
    void deleteById(Integer id);

    List<User> searchUser(@Param("keyword") String keyword);

    List<User> selectUserLimit(@Param("num") Integer num);
    List<User> selectUserByPage(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);
    List<User> selectUserByPage(Map map);

    //选择全部用户RowBounds实现分页
    List<User> getUserByRowBounds();
}
