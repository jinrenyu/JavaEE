package com.servlet.service;

public interface LoginService {
	
	public static final String USER_NOT_EXIST = "101";
	public static final String PWD_ERROR = "102";
	public static final String TOKEN_ERROR = "103";
	public static final String LOGIN_SUCCESS = "200";

	/**
	 * �����û���������У���û��Ƿ������ȷ��¼
	 * ������, �������Ӧ����ʾ��Ϣ
	 * @param name �û���
	 * @param pwd ����
	 * @return ��ʾ����Ϣ
	 */
	String checkUser(String name, String pwd, String md);
}
