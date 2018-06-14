package com.tz.online.service.impl;


import java.util.List;

import javax.security.auth.login.LoginException;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.tz.online.dao.IAddressDao;
import com.tz.online.dao.IUserDao;
import com.tz.online.entity.Address;
import com.tz.online.entity.User;
import com.tz.online.service.IUserService;
import com.tz.online.util.BeanFactory;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.ICallBack;

public class UserServiceImpl implements IUserService {

	IUserDao userDao = (IUserDao) BeanFactory.createBeans("userDao");
	
	IAddressDao addressDao = (IAddressDao) BeanFactory.createBeans("addressDao");
	//完成用户的注册功能
	@Override
	public void register(User user) {
		
		userDao.save(user);

	}

	@Override
	public User login(String userName, String pwd) throws LoginException {
		
		return (User) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				Criteria criteria = ses.createCriteria(User.class,"u");
				if(null != userName && userName.trim().length()>0){
					criteria.add(Restrictions.eq("u.userName", userName));
				}
				if(null != pwd && pwd.trim().length()>0){
					criteria.add(Restrictions.eq("u.passWord", pwd));
				}
				return criteria.uniqueResult();
			}
		});
	}
	
	@Override
	public boolean validate(String name) {
		User u = userDao.findByName(name);
		return (null != u?true:false);
	}

	@Override
	public void addAddress(Address a) {
		addressDao.save(a);
		
	}

	@Override
	public void delAddress(Address a) {
		addressDao.delete(a);
		
	}

	@Override
	public void updAddress(Address a) {
		addressDao.update(a);
		
	}

	@Override
	public List<Address> getAddressByUserId(Long userId) {
		
		return addressDao.findByUserId(userId);
	}

	@Override
	public Address getAddressById(Long id) {
		
		return addressDao.findById(id);
	}

	

}
