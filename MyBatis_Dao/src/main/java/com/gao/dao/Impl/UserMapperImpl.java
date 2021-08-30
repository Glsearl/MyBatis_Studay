package com.gao.dao.Impl;

import com.gao.dao.UserMapper;
import com.gao.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/10 17:21
 * UserMapper实现类
 */
public class UserMapperImpl implements UserMapper {
    private SqlSessionFactory factory;
    public UserMapperImpl(SqlSessionFactory factory) {
        this.factory=factory;
    }

    @Override
    public List<User> finAll() {
        SqlSession session = factory.openSession();
        List<User> users = session.selectList("com.gao.dao.UserMapper.finAll");
        session.close();
        return users;
    }
}
