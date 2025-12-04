package org.mybatis.example.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.configuration.example.entity.User;
import org.mybatis.configuration.example.mapper.UserMapper;
import org.mybatis.configuration.example.utils.SqlSessionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

class UserMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    private final SqlSession sqlSession = SqlSessionUtils.getSqlSession();
    private UserMapper userMapper;

    @BeforeEach
    void setUp() {
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    void selectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(user -> log.info("{}", user));
    }
}