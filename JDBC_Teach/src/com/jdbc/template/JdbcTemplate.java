package com.jdbc.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.template.interf.SQLExecutor;
import com.jdbc.template.interf.SqlQuerier;
import com.jdbc.template.interf.SqlUpdater;
import com.jdbc.util.JdbcUtil;
import com.jdbc.util.SimplateDataSource;

public class JdbcTemplate<T> {

    public final void simplteUpdate(SQLExecutor se) {
        // ������Ԥ��������
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = SimplateDataSource.getInstance().getConnection();
            // ��ģ����������ýӿڵķ���
            pst = se.execute(conn);
            // �����Ľ�β��������
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public final void update(SqlUpdater su) {
        Connection conn = null;
        try {
            conn = SimplateDataSource.getInstance().getConnection();
            conn.setAutoCommit(false);
            su.execute(conn);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public final T query(SqlQuerier<T> se) {
        Connection conn = null;
        T t = null;
        try {
            conn = SimplateDataSource.getInstance().getConnection();
            conn.setAutoCommit(false);
            t = se.execute(conn);
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return t;
    }
}
