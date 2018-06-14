package com.ajax.dao;

import com.ajax.entity.User;

public interface UserDao {

	/**
	 * 根据给定的用户名返回封装好的User对象
	 * @param name 用户名
	 * @return 对应的用户对象
	 */
	User getUserByName(String name);

}
