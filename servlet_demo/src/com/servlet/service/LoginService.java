package com.servlet.service;

public interface LoginService {
	
	public static final String USER_NOT_EXIST = "101";
	public static final String PWD_ERROR = "102";
	public static final String TOKEN_ERROR = "103";
	public static final String LOGIN_SUCCESS = "200";

	/**
	 * 根据用户名和密码校验用户是否可以正确登录
	 * 若不能, 则给出相应的提示信息
	 * @param name 用户名
	 * @param pwd 密码
	 * @return 提示的信息
	 */
	String checkUser(String name, String pwd, String md);
}
