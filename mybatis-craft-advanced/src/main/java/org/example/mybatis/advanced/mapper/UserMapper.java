package org.example.mybatis.advanced.mapper;

import org.apache.ibatis.annotations.Param;
import org.example.mybatis.advanced.entity.User;

import java.util.List;

/**
 * User Mapper
 *
 * @author xianyu
 * @since 2025-12-06
 */
public interface UserMapper {

    /**
     * 根据多个用户ID批量删除用户信息
     *
     * @param ids 用户ID集合
     * @return 影响的行数
     */
    int batchDeleteUserByIds(@Param("ids") List<Long> ids);

    /**
     * 添加用户, 返回自增主键
     *
     * @param user 添加的用户信息
     * @return 影响的行数
     */
    int save(User user);

}
