package com.tz.online.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.tz.online.dao.IUserDao;
import com.tz.online.entity.User;
import com.tz.online.util.HibernateTemplates;
import com.tz.online.util.ICallBack;

public class UserDaoImpl implements IUserDao {

	@Override
	public void save(User user) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				
				return ses.save(user);
			}
		});

	}

	@Override
	public User findByName(String userName) {
		
		return (User) HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				
				return ses.createQuery("from User where username=:username").setParameter("username", userName).uniqueResult();
			}
		});
	}

	@Override
	public void update(User user) {
		HibernateTemplates.execute(new ICallBack() {
			
			@Override
			public Object execute(Session ses) throws HibernateException {
				ses.update(user);
				return null;
			}
		});
		
	}

}
