package com.tz.online.dao.test;

import org.testng.annotations.Test;

import com.tz.online.dao.IUserDao;
import com.tz.online.entity.User;
import com.tz.online.util.BeanFactory;



public class UserDaoImplTest {

	private IUserDao userDaoImpl = (IUserDao) BeanFactory.createBeans("userDao");
	
	@Test
	public void testSave() {
		User u = new User("admin","admin","12345678@qq.com","18812345678","天智","烽火路十八号");
		userDaoImpl.save(u);
		User u1 = new User("tom","tom","12234567@qq.com","18345678901","天智","烽火路十八号");
		userDaoImpl.save(u1);
		User u2 = new User("rose","rose","12234567@qq.com","18345678901","天智","烽火路十八号");
		userDaoImpl.save(u2);
	}

	@Test
	public void testFindByName() {
		User u = userDaoImpl.findByName("rose");
		System.out.println(u);
	}

	@Test
	public void testUpdate(){
		User u = userDaoImpl.findByName("lucy");
		u.setUserName("rose");
		userDaoImpl.update(u);
	}
}
