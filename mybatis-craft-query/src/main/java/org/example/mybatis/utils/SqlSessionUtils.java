package org.example.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;

/**
 * SqlSession 工具类
 *
 * @author xianyu
 * @since 2025-12-04
 */
public class SqlSessionUtils {

    private static final Logger log = LoggerFactory.getLogger(SqlSessionUtils.class);

    /**
     * 加载mybatis配置文件并获取SqlSession, 默认自动提交事务
     *
     * @return SqlSession
     */
    public static SqlSession getSqlSession() {
        SqlSession sqlSession = null;
        try (InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (Exception e) {
            log.error("Failed to load mybatis configuration and obtain SqlSession.", e);
        }
        return sqlSession;
    }

}
