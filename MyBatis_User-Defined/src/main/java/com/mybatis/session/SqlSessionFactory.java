package com.mybatis.session;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 12:02
 */
public interface SqlSessionFactory {
    /**
     * 用户打开session
     * @return
     */
    SqlSession openSession();
}
