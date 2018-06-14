package com.tz.online.dao.test;



import java.util.List;

import org.testng.annotations.Test;

import com.tz.online.dao.IAddressDao;
import com.tz.online.dao.IUserDao;
import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.util.BeanFactory;



public class AddressDaoImplTest {

	private IAddressDao addressDao = (IAddressDao) BeanFactory.createBeans("addressDao");
	private IUserDao userDaoImpl = (IUserDao) BeanFactory.createBeans("userDao");
	
	@Test
	public void testSave() {
		User u = userDaoImpl.findByName("tom");
		Address address = new Address("中国","烽火路十八号","123456","tom","12345678903","0",u);
		
		addressDao.save(address);
		
	
	}

	@Test
	public void testFindByUserId() {
		List<Address> list = addressDao.findByUserId(3l);
		for (Address address : list) {
			System.out.println(address);
		}
		
		
	}

	@Test
	public void testDelete() {
		Address a = addressDao.findById(22l);
		addressDao.delete(a);
	}

	@Test
	public void testFindById() {
		
		System.out.println(addressDao.findById(22l));
	}

	@Test
	public void testUpdate() {
		Address a = addressDao.findById(22l);
		a.setArea("姑苏区");
		addressDao.update(a);
	}

}
