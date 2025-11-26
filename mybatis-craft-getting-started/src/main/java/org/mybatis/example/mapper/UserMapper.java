package org.mybatis.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.mybatis.example.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    int save(@Param("user") User user);

    int updatePasswordById(@Param("userId") Long userId, @Param("password") String password);

    User selectById(@Param("userId") Long userId);

}
