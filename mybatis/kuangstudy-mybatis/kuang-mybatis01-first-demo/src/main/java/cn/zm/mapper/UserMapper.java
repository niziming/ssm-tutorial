package cn.zm.mapper;

import cn.zm.domain.User;

import java.util.List;

//6、编写Mapper接口类
public interface UserMapper {
    List<User> selectUser();
}
