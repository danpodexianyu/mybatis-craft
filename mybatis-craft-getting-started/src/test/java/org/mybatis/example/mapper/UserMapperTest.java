package org.mybatis.example.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mybatis.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

class UserMapperTest {

    private static final Logger log = LoggerFactory.getLogger(UserMapperTest.class);

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    private static final String MYBATIS_CONFIG = "mybatis-config.xml";

    /**
     * 每个测试方法执行前初始化
     */
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

    @Test
    void save() {
        User user = new User();
        user.setUsername("林十三");
        user.setPassword("linshisan555");
        user.setBirthday(LocalDate.of(1994, 3, 28));
        user.setGender("男");
        user.setEmail("linshisan@example.com");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.save(user);
    }

    @Test
    void updatePasswordById() {
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.updatePasswordById(12L, "linshisan556");
    }

    @Test
    void selectById() {
        User user = userMapper.selectById(1L);
        log.info("{}", user);
    }
}