package com.gao.dao;

import com.gao.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:18
 */
public interface UserMapper {
    /**
     *查询所有用户信息
     * 使用注解的方式实现
     * @return
     */
    @Select("select * from user ")
    List<User> finAll();
}
