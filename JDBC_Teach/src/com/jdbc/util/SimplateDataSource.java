package com.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class SimplateDataSource {

    // 单例设计模式[饱汉单例(非线程安全的)/饿汉单例(线程安全的)...]
    // 饿汉单例
    private static final SimplateDataSource ds = new SimplateDataSource();
    private static final String FILEPATH = "db_config.properties";
    private static Properties prop = new Properties();
    private static BasicDataSource bs = null;
    
    static {
        InputStream inStream = Thread.currentThread()
                .getContextClassLoader().getResourceAsStream(FILEPATH);
        try {
            prop.load(inStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        bs = new BasicDataSource();
        // 设置驱动类路径
        bs.setDriverClassName(prop.getProperty("oracleDriver"));
        // 设置URL
        bs.setUrl(prop.getProperty("url"));
        // 设置用户名
        bs.setUsername(prop.getProperty("user"));
        // 设置密码
        bs.setPassword(prop.getProperty("password"));

        // 设置管理连接的策略
        // 设置连接池内的初始连接的数目
        bs.setInitialSize(Integer.parseInt(prop.getProperty("initialSize")));
        // 设置连接池内活动连接的最大数量
        bs.setMaxActive(Integer.parseInt(prop.getProperty("maxActive")));
        // 设置连接池内最大空闲的连接数量
        bs.setMaxIdle(Integer.parseInt(prop.getProperty("maxIdle")));
        // 设置连接的最大等待时长(单位:毫秒)
        bs.setMaxWait(Integer.parseInt(prop.getProperty("maxWait")));
    }
    // 饱汉/懒汉单例
//    private static SimplateDataSource ds = null;
    // 第一步, 把构造方法变成私有的, 防止创建新的实例
    private SimplateDataSource() {}

    // 第二步, 提供一个构建实例的方法, 必须保证所返回的实例是一个对象实例
    public static SimplateDataSource getInstance() {
        return ds;
    }

    public Connection getConnection() throws SQLException {
        return bs == null ? null : bs.getConnection();
    }
}
