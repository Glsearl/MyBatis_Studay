package com.mybatis.session;


/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 12:02
 */
public interface SqlSession {
    /**
     * 根据参数创建一个代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
