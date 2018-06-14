package com.tz.online.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface ICallBack {
	public Object execute(Session ses) throws HibernateException;
}
