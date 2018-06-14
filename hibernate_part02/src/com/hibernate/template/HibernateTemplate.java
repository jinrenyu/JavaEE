package com.hibernate.template;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernate.template.interf.QueryExecutor;
import com.hibernate.template.interf.UpdateExecutor;
import com.hibernate.util.HibernateUtil;

public class HibernateTemplate<T> {

    public final void update(UpdateExecutor executor) {
        Session ses = null;
        Transaction tx = null;
        try {
            ses = HibernateUtil.getSession();
            tx = ses.beginTransaction();
            executor.execute(ses);
            tx.commit();
        } catch(HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            HibernateUtil.close(ses);
        }
    }
    
    public final T query(QueryExecutor<T> executor) {
        Session ses = null;
        Transaction tx = null;
        T t = null;
        try {
            ses = HibernateUtil.getSession();
            tx = ses.beginTransaction();
            t = executor.execute(ses);
            tx.commit();
        } catch(HibernateException hex) {
            if (tx != null) {
                tx.rollback();
            }
            hex.printStackTrace();
        } finally {
            HibernateUtil.close(ses);
        }
        return t;
    }
    
}
