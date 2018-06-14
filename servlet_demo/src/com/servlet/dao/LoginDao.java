package com.servlet.dao;

import com.servlet.entity.User;

public interface LoginDao {

	/**
	 * 根据用户名返回相应的用户对象
	 * @param name 用户名
	 * @return 用户对象
	 */
	User getUserByName(String name);
}
