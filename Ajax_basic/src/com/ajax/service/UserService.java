package com.ajax.service;

public interface UserService {

	/**
	 * У��������û���, ����û���������, �򷵻�"success"
	 * ����û�������, �򷵻�"failure"
	 * @param uName ��У����û���
	 * @return ��ʾ��Ϣ, "success"/"failure"
	 */
	String checkName(String uName);
}
