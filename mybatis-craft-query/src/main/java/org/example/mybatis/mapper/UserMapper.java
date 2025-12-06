package org.example.mybatis.mapper;

import org.example.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    /**
     * 查询案例（一）
     * <p>
     * 字面量传参
     *
     * @param username 用户名
     * @return 用户
     */
    User selectByUsername(String username);

}
