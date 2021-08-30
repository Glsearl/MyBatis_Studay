package com.mybatis.config;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 15:37
 * 用于封装执行的SQL语句和结果类型的全限定类名
 */
public class Mapper {
    private String queryString;//需要执行的SQL语句
    private String resultType;//sql语句返回的结果类型，实体类的全限定类名

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public String getResultType() {
        return resultType;
    }

    public void setResultType(String resultType) {
        this.resultType = resultType;
    }
}
