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
            // ��ȡ�������Ԫ���������ӿ�
            ResultSetMetaData rm = rs.getMetaData();
            // ��ȡ�����ӵ�е�����
            System.out.println("����:" + rm.getColumnCount());
            // ��ȡ�����ж�Ӧ���е�����
            System.out.println(rm.getColumnName(1));
            // ��ȡ�����ж�Ӧ���е�չʾ����
            System.out.println(rm.getColumnLabel(1));
            int colCount = rm.getColumnCount();
            // ���ҵĽ���������еı���
            while(rs.next()) {
                // �ڲ�֪���ж������Լ�ÿ���ж�Ӧ����������¶��н��к������
                for (int i = 1; i < colCount; i++) {
                    String colLabel = rm.getColumnLabel(i);
                    String colValue = rs.getString(colLabel);
                    if (i > 1) {
                        System.out.print(",");
                    }
                    System.out.println(colLabel + "=" + colValue);
                }
                // Ϊÿ�������м����һ������
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
