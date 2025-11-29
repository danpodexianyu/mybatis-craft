package org.mybatis.configuration.example.mapper;

import org.mybatis.configuration.example.entity.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

}
