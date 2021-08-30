package com.mybatis.session;

import com.mybatis.config.Mapper;
import com.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.Map;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 17:12
 */
public class MapperProxy implements InvocationHandler {
    private Map<String,Mapper> mappers;
    private  Connection connection;

    public MapperProxy(Map<String, Mapper> mappers, Connection connection) {
        this.connection=connection;
        this.mappers=mappers;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className + "." + methodName;
        Mapper mapper = mappers.get(key);
        if (mapper != null) {
            return new Executor().selectList(mapper, connection);
        } else {
            throw  new IllegalArgumentException("传入的参数有误");
        }
    }
}
