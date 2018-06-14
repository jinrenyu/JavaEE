package com.ajax.service;

public interface UserService {

	/**
	 * 校验给定的用户名, 如果用户名不存在, 则返回"success"
	 * 如果用户名存在, 则返回"failure"
	 * @param uName 待校验的用户名
	 * @return 提示信息, "success"/"failure"
	 */
	String checkName(String uName);
}
