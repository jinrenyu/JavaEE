package com.jdbc.maintest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "jsd1612";
        String password = "jsd1612";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            // ��һ��, ע������(����1)
            Class.forName("oracle.jdbc.driver.OracleDriver");
            // ����2
//            Driver driver = new OracleDriver();
//            DriverManager.registerDriver(driver);
            // �ڶ���, ��ȡ���Ӷ���������
            conn = DriverManager.getConnection(url, user, password);
            // ������, ��ȡ����������ִ�о����SQL���
            st = conn.createStatement();
            // ���Ĳ�, ��дSQL��䲢ִ�д��뵽ResultSet��
            String sql = "select first_name fname, title, salary from s_emp";
//            String sql = "select * from s_emp";
            rs = st.executeQuery(sql);
            // ���岽, ��ResultSet���д���
            System.out.printf("%13s %20s %13s\n", "first_name", "title", "salary");
            while (rs.next()) {
                String fName = rs.getString(1);
                String title = rs.getString(2);
                double salary = rs.getDouble(3);
//                String fName = rs.getString("first_name");
//                String title = rs.getString("title");
//                double salary = rs.getDouble("salary");
                System.out.printf("%13s %20s %13.2f\n", fName, title, salary);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ������, �����ͷ���Դ
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
