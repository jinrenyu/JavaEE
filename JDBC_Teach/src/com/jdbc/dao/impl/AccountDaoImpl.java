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
            // 定制SQL模板
            String sql = "select * from t_account where username = ? and password =?";
            pst = conn.prepareStatement(sql);
            // 为模板设置参数把变量传递给数据库
            pst.setString(1, username);
            pst.setString(2, password);
            // 执行完整的SQL语句,做查询
            rs = pst.executeQuery();
            // 处理结果集
            if (rs.next()) {
                // 封装数据到账户对象中
                account = new Account();
                // PreparedStatement接口对*的情况可以直接使用列的列索引值
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
            // 禁用JDBC中的自动提交模式
            conn.setAutoCommit(false);
            // 定制转账的SQL模板
            String sql = "update t_account set balance = balance - ? where id = ?";
            // 根据模板产生PreparedStatement对象实例
            pst = conn.prepareStatement(sql);
            // 为模板设置参数
            pst.setDouble(1, money);
            pst.setInt(2, fromAcc.getId());
            // 执行SQL, 传递参数至数据库
            pst.executeUpdate();
            
//            int a = 5/0;
//            System.out.println("哎呀 断电啦!");
            
            // 把转入的钱到转入账户中去
            pst.setDouble(1, -money);
            pst.setInt(2, toAcc.getId());
            pst.executeUpdate();
            // 手动进行提交
//            conn.commit();
        } catch (Exception e) {
            try {
                if (conn != null) {
                    // 发生异常进行回滚
                    conn.rollback();
                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                // Oracle驱动连接关闭时如果存在活动连接将自动对数据进行同步
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
