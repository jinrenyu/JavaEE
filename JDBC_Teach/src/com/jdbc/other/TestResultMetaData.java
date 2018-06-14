package com.jdbc.other;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.jdbc.util.JdbcUtil;

public class TestResultMetaData {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from s_emp";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            // 获取结果集的元数据描述接口
            ResultSetMetaData rm = rs.getMetaData();
            // 获取结果集拥有的列数
            System.out.println("列数:" + rm.getColumnCount());
            // 获取索引列对应的列的名称
            System.out.println(rm.getColumnName(1));
            // 获取索引列对应的列的展示名称
            System.out.println(rm.getColumnLabel(1));
            int colCount = rm.getColumnCount();
            // 对我的结果集进行行的遍历
            while(rs.next()) {
                // 在不知道有多少列以及每个列对应的列名情况下对列进行横向遍历
                for (int i = 1; i < colCount; i++) {
                    String colLabel = rm.getColumnLabel(i);
                    String colValue = rs.getString(colLabel);
                    if (i > 1) {
                        System.out.print(",");
                    }
                    System.out.println(colLabel + "=" + colValue);
                }
                // 为每条数据中间添加一个空行
                System.out.println();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(rs, pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
