package com.tz.online.dao;

import com.tz.online.entity.User;

public interface IUserDao {

	//保存用户对象
	public void save(User user);
	//根据用户名查询用户
	public User findByName(String userName);
	// 更新用户
	public void update(User user);
}
