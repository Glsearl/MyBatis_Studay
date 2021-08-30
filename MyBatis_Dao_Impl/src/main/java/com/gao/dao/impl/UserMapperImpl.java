package com.gao.dao.impl;

import com.gao.dao.UserMapper;
import com.gao.domain.QueryVo;
import com.gao.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/17 17:17
 */
public class UserMapperImpl implements UserMapper {
    private SqlSessionFactory factory;

    public UserMapperImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> finAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.gao.dao.UserMapper.finAll");
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        SqlSession session = factory.openSession();
        session.insert("com.gao.dao.UserMapper.saveUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void updateUser(User user) {
        SqlSession session = factory.openSession();
        session.update("com.gao.dao.UserMapper.updateUser",user);
        session.commit();
        session.close();
    }

    @Override
    public void deleteUserById(Integer id) {
        SqlSession session = factory.openSession();
        session.update("com.gao.dao.UserMapper.deleteUserById",id);
        session.commit();
        session.close();

    }

    @Override
    public User findUserById(Integer id) {
        SqlSession session = factory.openSession();
        User user = session.selectOne("com.gao.dao.UserMapper.findUserById", id);
        session.close();
        return user;
    }

    @Override
    public List<User> findUserByName(String name) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.gao.dao.UserMapper.findUserByName", name);
        session.close();
        return users;
    }

    @Override
    public int count() {
        SqlSession session = factory.openSession();
        int i=session.selectOne("com.gao.dao.UserMapper.count");
        session.close();
        return i;
    }

    @Override
    public List<User> findByVo(QueryVo vo) {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.gao.dao.UserMapper.findByVo", vo);
        session.close();
        return users;
    }
}
