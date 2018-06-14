package com.servlet.service.impl;

import com.servlet.dao.LoginDao;
import com.servlet.dao.impl.LoginDaoImpl;
import com.servlet.entity.User;
import com.servlet.service.LoginService;
import com.servlet.util.CreateMD5;

public class LoginServiceImpl implements LoginService {
	
	private LoginDao loginDao = new LoginDaoImpl();

	@Override
	public String checkUser(String name, String pwd, String md) {
		User user = loginDao.getUserByName(name);
		// 1. 完成了用户名的验证, 因为密码信息已经在上面获取到了
		if (user == null) {
			return USER_NOT_EXIST;
		} else {
			String tempPwd = user.getPassword();
			// 用户已经存在, 进行密码验证
			// 说明前端发送回来的密码是一个密文
			if (null != md && !"".equals(md)) {
				tempPwd = CreateMD5.getMd5(tempPwd);
			}
			if (null != pwd && pwd.equals(tempPwd)) {
				return LOGIN_SUCCESS;
			} else {
				return PWD_ERROR;
			}
		}
	}

}
