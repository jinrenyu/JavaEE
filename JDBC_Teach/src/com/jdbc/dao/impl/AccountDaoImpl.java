package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Connection.*;

import com.jdbc.dao.AccountDao;
import com.jdbc.entity.Account;
import com.jdbc.util.JdbcUtil;

public class AccountDaoImpl implements AccountDao {

    @Override
    public Account login(String username, String password) {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        Account account = null;
        try {
            conn = JdbcUtil.getConnection();
            // ����SQLģ��
            String sql = "select * from t_account where username = ? and password =?";
            pst = conn.prepareStatement(sql);
            // Ϊģ�����ò����ѱ������ݸ����ݿ�
            pst.setString(1, username);
            pst.setString(2, password);
            // ִ��������SQL���,����ѯ
            rs = pst.executeQuery();
            // ��������
            if (rs.next()) {
                // ��װ���ݵ��˻�������
                account = new Account();
                // PreparedStatement�ӿڶ�*���������ֱ��ʹ���е�������ֵ
                account.setId(rs.getInt(1));
                account.setUsername(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setBalance(rs.getDouble(4));
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
        return account;
    }

    @Override
    public void transfer(Account fromAcc, Account toAcc, Double money) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtil.getConnection();
            conn.setTransactionIsolation(TRANSACTION_READ_COMMITTED);
            // ����JDBC�е��Զ��ύģʽ
            conn.setAutoCommit(false);
            // ����ת�˵�SQLģ��
            String sql = "update t_account set balance = balance - ? where id = ?";
            // ����ģ�����PreparedStatement����ʵ��
            pst = conn.prepareStatement(sql);
            // Ϊģ�����ò���
            pst.setDouble(1, money);
            pst.setInt(2, fromAcc.getId());
            // ִ��SQL, ���ݲ��������ݿ�
            pst.executeUpdate();
            
//            int a = 5/0;
//            System.out.println("��ѽ �ϵ���!");
            
            // ��ת���Ǯ��ת���˻���ȥ
            pst.setDouble(1, -money);
            pst.setInt(2, toAcc.getId());
            pst.executeUpdate();
            // �ֶ������ύ
//            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    // �����쳣���лع�
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Oracle�������ӹر�ʱ������ڻ���ӽ��Զ������ݽ���ͬ��
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
