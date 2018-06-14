package com.servlet.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface IHibernateCallBack {
	public Object doInHibernate(Session ses) throws HibernateException;
}
