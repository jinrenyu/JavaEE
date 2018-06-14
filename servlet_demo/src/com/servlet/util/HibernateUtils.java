package com.servlet.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {
	
	static Configuration cfg = null;
	static SessionFactory sf = null;
	
	static {
		cfg = new Configuration();
		cfg.configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		sf = cfg.buildSessionFactory(sr);
	}
	
	public static SessionFactory getSessionFactory() {
		return sf == null ? null : sf;
	}
	
	//返回一个与本地线程绑定的session
	public static Session getSessionObject() {
		return sf.getCurrentSession();
	}
	
	public static void main(String[] args) {
		
	}

}
