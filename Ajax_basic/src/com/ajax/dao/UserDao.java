package com.ajax.dao;

import com.ajax.entity.User;

public interface UserDao {

	/**
	 * ���ݸ������û������ط�װ�õ�User����
	 * @param name �û���
	 * @return ��Ӧ���û�����
	 */
	User getUserByName(String name);

}
