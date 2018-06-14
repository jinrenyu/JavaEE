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
				// 书写sql的模板语句
				String sql = "select * from ajax_user where uname = ?";
				// 创建预编译语句对象
				PreparedStatement pst = null;
				ResultSet rs = null;
				User user = null;
				try {
					pst = con.prepareStatement(sql);
					// 预编译语句需要设置模板的参数
					pst.setString(1, name);
					rs = pst.executeQuery();
					// 如果能够查询到记录, 则封装一个User对象
					if (rs.next()) {
						user = new User();
						user.setId(rs.getInt(1));
						user.setUsername(rs.getString(2));
						user.setPassword(rs.getString(3));
					}
				} finally {
					// 关闭语句和结果集释放连接的资源
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
