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
     *保存用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUserById(Integer id);

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

    /**
     * 统计user表中的总条数
     * @return
     */
    int count();

    List<User>  findByVo(QueryVo vo);
}
