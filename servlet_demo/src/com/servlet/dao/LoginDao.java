package com.servlet.dao;

import com.servlet.entity.User;

public interface LoginDao {

	/**
	 * �����û���������Ӧ���û�����
	 * @param name �û���
	 * @return �û�����
	 */
	User getUserByName(String name);
}
