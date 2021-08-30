package com.mybatis.io;

import java.io.InputStream;

/**
 * @author gaols
 * @version 1.0
 * @date 2021/8/11 11:59
 */
public class Resources {
    /**
     * 根据传入的路径获取字节流对象
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
    return  Resources.class.getClassLoader().getResourceAsStream(filePath);

    }
}
