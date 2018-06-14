package com.jdbc.other;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jdbc.util.JdbcUtil;

public class TestParameterMetaData {

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "select * from s_emp where salary > ? and salary < ?";
            pst = conn.prepareStatement(sql);
            pst.setDouble(1, 1000);
            pst.setDouble(2, 2000);
            ParameterMetaData pm = pst.getParameterMetaData();
            System.out.println(pm.getParameterTypeName(1));
            // 输出参数的数量
            System.out.println(pm.getParameterCount());
            // 对应java.sql.Types类的常量的实际值
            System.out.println(pm.getParameterType(1));
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
