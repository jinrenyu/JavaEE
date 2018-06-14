package com.ajax.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ajax.dao.UserDao;
import com.ajax.entity.User;
import com.ajax.template.JdbcTemplate;
import com.ajax.template.interf.SqlQuerier;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserByName(String name) {
		JdbcTemplate<User> template = new JdbcTemplate<>();
		return template.query(new SqlQuerier<User>() {
			
			@Override
			public User execute(Connection con) throws SQLException {
				// ��дsql��ģ�����
				String sql = "select * from ajax_user where uname = ?";
				// ����Ԥ����������
				PreparedStatement pst = null;
				ResultSet rs = null;
				User user = null;
				try {
					pst = con.prepareStatement(sql);
					// Ԥ���������Ҫ����ģ��Ĳ���
					pst.setString(1, name);
					rs = pst.executeQuery();
					// ����ܹ���ѯ����¼, ���װһ��User����
					if (rs.next()) {
						user = new User();
						user.setId(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setPassword(rs.getString(3));
					}
				} finally {
					// �ر����ͽ�����ͷ����ӵ���Դ
					if (pst != null) {
						pst.close();
					}
					if (rs != null) {
						rs.close();
					}
				}
				return user;
			}
		});
	}

}
