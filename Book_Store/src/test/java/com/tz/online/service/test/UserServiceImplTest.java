package com.tz.online.service.test;

import java.util.List;

import javax.security.auth.login.LoginException;

import org.testng.annotations.Test;

import com.tz.online.dao.IAddressDao;
import com.tz.online.dao.IUserDao;
import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;

public class UserServiceImplTest {

	private IUserService userService =   (IUserService) BeanFactory.createBeans("userService");
	private IUserDao userDaoImpl = (IUserDao) BeanFactory.createBeans("userDao");
	private IAddressDao addressDao = (IAddressDao) BeanFactory.createBeans("addressDao");
	@Test
	public void testRegister() {
		User u = new User("jack","jack","12234567@qq.com","18345678901","天智","烽火路十八号");
		userService.register(u);
	}

	@Test
	public void testLogin() throws LoginException {
		System.out.println(userService.login("admin", "admin"));
	}

	@Test
	public void testValidate(){
		System.out.println(userService.validate("admin"));
	}
	
	@Test
	public void testAddAddress(){
		User u = userDaoImpl.findByName("tom");
		Address address = new Address("姑苏区","嘉登大厦","123456","tom","12345678903","0",u);
		userService.addAddress(address);
	}
	@Test
	public void testDelAddress(){
		Address a = addressDao.findById(23l);
		userService.delAddress(a);
	}
	
	@Test
	public void testUpdAddress(){
		Address a = addressDao.findById(24l);
		a.setArea("苏州");
		userService.updAddress(a);
	}
	
	@Test
	public void testGetAddressByUserId(){
		List<Address> list = userService.getAddressByUserId(3l);
		for (Address address : list) {
			System.out.println(address);
		}
	}
	
	@Test
	public void testGetAddressById(){
		System.out.println(userService.getAddressById(24l));
	}
	
}
