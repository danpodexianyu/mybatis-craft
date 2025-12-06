package org.example.mybatis.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.entity.User;

import java.util.List;
import java.util.Map;

/**
 * User Mapper
 *
 * @author xianyu
 * @since 2025-12-06
 */
public interface UserMapper {

    List<User> selectAll();

    /**
     * Mybatis获取参数方式（一）- 使用字面量传参
     *
     * @param username 用户名
     * @return 用户
     */
    User selectByUsername(String username);

    /**
     * Mybatis获取参数的方式（二）- 将所有的参数通过Map进行封装
     *
     * @param params 封装所有参数的Map集合
     * @return 用户
     */
    User selectByMap(Map<String, String> params);

    /**
     * Mybatis获取参数的方式（三）- 使用Mybatis提供的注解对参数进行命名 @Param
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户
     */
    User selectByMultiParams(@Param("username") String username, @Param("password") String password);

    int count();

    User fuzzyQuery(String username);

    /**
     * 根据多个用户ID批量删除用户信息
     *
     * @param ids 用户ID集合
     * @return 影响的行数
     */
    int batchDeleteUserByIds(@Param("ids") List<Long> ids);

}
