package com.tz.online.util;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * hibernate工具类
 * @author teacher
 * @version 1.0
 */
public class HibernateTemplates {
	
	public static Object execute(ICallBack cb){
		Session ses = null;
		Transaction tx = null;
		Object obj = null;
		try {
			ses = HibernateUtil.getSession();
			tx = ses.beginTransaction();
			
			obj = cb.execute(ses);
			
			tx.commit();
		} catch (HibernateException e) {
		
			if(null!=tx){
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
		
			if(null!=ses){
				ses.close();
			}
		}
		return obj;
	}
}
