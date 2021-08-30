package com.gao.dao;

import com.gao.domain.User;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/3 22:18
 */
public interface UserMapper {
    /**
     *查询所有用户信息
     * @return
     */
    List<User> finAll();
}
