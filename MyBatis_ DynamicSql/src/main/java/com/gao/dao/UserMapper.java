package com.gao.dao;

import com.gao.domain.QueryVo;
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

    /**
     * 根据id查询有用户信息
     */
    User findUserById(Integer id);

    /**
     * 根据用户名模糊查询用户信息
     * @param name
     * @return
     */
    List<User> findUserByName(String name);

    List<User> findUserByUser(User user);

    List<User>  findByVo(QueryVo vo);
}
