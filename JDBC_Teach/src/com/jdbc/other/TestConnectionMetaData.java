package com.jdbc.other;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import com.jdbc.util.JdbcUtil;

public class TestConnectionMetaData {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = JdbcUtil.getConnection();
            // 获取数据库的元数据信息
            DatabaseMetaData dm = conn.getMetaData();
            // 获取表明名允许的最大长度
            System.out.println(dm.getMaxTableNameLength());
            // 获取order by子句后面可以跟的最大列数
            // 0代表没有限制或者驱动没办法获取到
            System.out.println(dm.getMaxColumnsInOrderBy());
            // 数据库一次性能够同时存在的语句对象的最大数量
            // 0代表没有限制或者驱动没办法获取到
            System.out.println(dm.getMaxStatements());
            // 判断数据库驱动是否支持所给的事物隔离级别
            System.out.println(dm.supportsTransactionIsolationLevel(8));
            
            // 获取数据库的主版本号46.32.21
            System.out.println(dm.getDatabaseMajorVersion());
            // 获取数据库的此版本号
            System.out.println(dm.getDatabaseMinorVersion());
            // 获取数据库的产品名称
            System.out.println(dm.getDatabaseProductName());
            // 获取数据库的版本详细信息
            System.out.println(dm.getDatabaseProductVersion());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(null, null, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
