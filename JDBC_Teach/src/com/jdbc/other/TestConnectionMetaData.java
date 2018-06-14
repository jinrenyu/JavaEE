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
            // ��ȡ���ݿ��Ԫ������Ϣ
            DatabaseMetaData dm = conn.getMetaData();
            // ��ȡ�������������󳤶�
            System.out.println(dm.getMaxTableNameLength());
            // ��ȡorder by�Ӿ������Ը����������
            // 0����û�����ƻ�������û�취��ȡ��
            System.out.println(dm.getMaxColumnsInOrderBy());
            // ���ݿ�һ�����ܹ�ͬʱ���ڵ���������������
            // 0����û�����ƻ�������û�취��ȡ��
            System.out.println(dm.getMaxStatements());
            // �ж����ݿ������Ƿ�֧��������������뼶��
            System.out.println(dm.supportsTransactionIsolationLevel(8));
            
            // ��ȡ���ݿ�����汾��46.32.21
            System.out.println(dm.getDatabaseMajorVersion());
            // ��ȡ���ݿ�Ĵ˰汾��
            System.out.println(dm.getDatabaseMinorVersion());
            // ��ȡ���ݿ�Ĳ�Ʒ����
            System.out.println(dm.getDatabaseProductName());
            // ��ȡ���ݿ�İ汾��ϸ��Ϣ
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
