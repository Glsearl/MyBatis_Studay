package com.mybatis.session;

import com.mybatis.config.Configuration;
import com.mybatis.config.Mapper;
import com.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 16:22
 */
public class DefaultSqlSession implements SqlSession{
    private Configuration configuration;
    private Connection connection;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        connection = DataSourceUtil.getConnection(configuration);
    }

    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        return(T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),new Class[]{daoInterfaceClass},new MapperProxy(configuration.getMappers(),this.connection));
    }

    @Override
    public void close() {
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
