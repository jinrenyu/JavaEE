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
		// 1. ������û�������֤, ��Ϊ������Ϣ�Ѿ��������ȡ����
		if (user == null) {
			return USER_NOT_EXIST;
		} else {
			String tempPwd = user.getPassword();
			// �û��Ѿ�����, ����������֤
			// ˵��ǰ�˷��ͻ�����������һ������
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
