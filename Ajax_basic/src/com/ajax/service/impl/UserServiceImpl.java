package com.ajax.service.impl;

import com.ajax.dao.UserDao;
import com.ajax.dao.impl.UserDaoImpl;
import com.ajax.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public String checkName(String uName) {
		return userDao.getUserByName(uName) == null ? "success" : "failure";
	}

}
