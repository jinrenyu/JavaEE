package com.tz.online.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.tz.online.entity.Address;
import com.tz.online.entity.User;

public interface IUserService {


	//验证用户是否合法
	public User login(String userName ,String pwd)throws LoginException;
	//完成用户的注册功能
	public void register(User user);
	//验证用户名是否合法,如果可用,则返回TRUE,否则,返回false;
	public boolean validate(String name);
	//添加地址
	public void addAddress(Address a);
	//删除地址
	public void delAddress(Address a);
	//更新指定的地址信息
	public void updAddress(Address a);
	//根据用户查询此用户的所有地址
	public List<Address> getAddressByUserId(Long userId);
	//根据id查询地址
	public Address getAddressById(Long id);
	
}
