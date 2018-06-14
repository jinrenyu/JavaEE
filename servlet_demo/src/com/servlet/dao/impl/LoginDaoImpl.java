package com.servlet.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.servlet.dao.LoginDao;
import com.servlet.entity.User;
import com.servlet.util.HibernateTemplate;
import com.servlet.util.IHibernateCallBack;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User getUserByName(String name) {
		return (User) HibernateTemplate.execute(new IHibernateCallBack() {
			
			@Override
			public Object doInHibernate(Session ses) throws HibernateException {
				return ses.createCriteria(User.class).add(
						Restrictions.eq("username", name)).uniqueResult();
			}
		});
	}

}
