package org.example.mybatis.advanced.mapper;

import org.apache.ibatis.session.SqlSession;
import org.example.mybatis.advanced.entity.User;
import org.example.mybatis.advanced.utils.SqlSessionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
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
    void batchDeleteUserByIds() {
        int deletedRows = userMapper.batchDeleteUserByIds(List.of());
        log.info("Deleted Rows: {}", deletedRows);
    }

    @Test
    void save() {
        User user = new User();
        user.setUsername("周十三");
        user.setPassword("zhoushisan741");
        user.setBirthday(LocalDate.of(1994, 3, 28));
        user.setGender("男");
        user.setEmail("zhoushisan@example.com");

        userMapper.save(user);
        log.info("user: {}", user);
    }
}