package org.example.mybatis.mapper;

import org.example.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

}
