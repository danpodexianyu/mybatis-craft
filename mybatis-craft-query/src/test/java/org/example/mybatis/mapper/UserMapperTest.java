package org.example.mybatis.mapper;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.entity.User;
import org.example.mybatis.utils.SqlSessionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

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

    @Test
    void selectByUsername() {
        User user = userMapper.selectByUsername("张三");
        log.info("{}", user);
    }

    @Test
    void selectByMap() {
        User user = userMapper.selectByMap(Map.of("username", "张三", "password", "zhangsan123"));
        log.info("{}", user);
    }

    @Test
    void selectByMultiParams() {
        User user = userMapper.selectByMultiParams("张三", "zhangsan123");
        log.info("{}", user);
    }

    @Test
    void count() {
        int count = userMapper.count();
        log.info("the number of users: {}", count);
    }

    @Test
    void fuzzyQuery() {
        User user = userMapper.fuzzyQuery("张三");
        log.info("Fuzzy Query Result: {}", user);
    }

    @Test
    void batchDeleteUserByIds() {
        int count = userMapper.batchDeleteUserByIds(List.of());
        log.info("deleted rows: {}", count);
    }
}