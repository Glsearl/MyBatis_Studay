package com.mybatis.session;

import com.mybatis.config.Configuration;
import com.mybatis.utils.XMLConfigBuilder;
import java.io.InputStream;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 12:01
 */
public class SqlSessionFactoryBuilder {
    public SqlSessionFactory build(InputStream config) {
        Configuration configuration= XMLConfigBuilder.loadConfiguration(config);
        return new DefaultSqlSessionFactory(configuration);
    }
}
