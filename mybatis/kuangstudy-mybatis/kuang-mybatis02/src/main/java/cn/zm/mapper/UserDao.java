package cn.zm.mapper;

import cn.zm.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectUser();

    User selectUserByid(Integer id);

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
}
