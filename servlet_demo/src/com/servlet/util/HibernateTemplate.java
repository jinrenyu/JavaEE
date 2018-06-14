package com.servlet.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTemplate {
	
	public static Object execute(IHibernateCallBack hcb){
		Session ses = null;
		Transaction tx = null;
		Object obj = null;
		try {
			ses = HibernateUtils.getSessionObject();
			tx = ses.beginTransaction();
			
			obj = hcb.doInHibernate(ses);
			
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			if(null!=tx){
				tx.rollback();
			}
			e.printStackTrace();
		}finally{
			//因为这里的Session是跟线程绑定的  也就是不需要关闭Session
		}
		return obj;
	}
}
