package com.mybatis.session;

import com.mybatis.config.Configuration;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 16:21
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    /**
     * 用于创建一个新的操作数据库对象
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(configuration);
    }
}
