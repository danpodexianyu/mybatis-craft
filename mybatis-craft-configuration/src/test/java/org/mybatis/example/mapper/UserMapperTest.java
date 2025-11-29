package org.mybatis.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.configuration.example.entity.User;
import org.mybatis.configuration.example.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.List;

class UserMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    @BeforeEach
    void setUp() throws Exception {
        // 加载Mybatis配置
        try (InputStream inputStream = Resources.getResourceAsStream(MYBATIS_CONFIG)) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        // 打开SqlSession, 默认自动提交
        sqlSession = sqlSessionFactory.openSession(true);
        // 获取UserMapper代理对象
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    void selectAll() {
        List<User> users = userMapper.selectAll();
        users.forEach(user -> log.info("{}", user));
    }
}