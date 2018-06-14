package com.exam.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * 本类用来获取HIbernate中的Session对象以及关闭Session
 * @author Chris
 *
 * 2017年3月6日下午1:51:37
 */
public class HibernateUtil {

    private static SessionFactory sf;
    
    static {
        try {
            Configuration cfg = new Configuration().configure();
            ServiceRegistry sr = new StandardServiceRegistryBuilder()
                    .applySettings(cfg.getProperties()).build();
            sf = cfg.buildSessionFactory(sr);
        } catch(HibernateException hex) {
            hex.printStackTrace();
        }
    }
    
    /**
     * 根据初始化完成的会话工厂对象返回一个会话对象
     * @return 会话对象实例Session
     */
    public static Session getSession() {
        return sf == null ? null : sf.openSession();
    }
    
    /**
     * 关闭传入的会话对象
     * @param ses 需要关闭的会话对象实例
     */
    public static void close(Session ses) {
        try {
            if (ses != null) {
                ses.close();
            }
        } catch(HibernateException hex) {
            hex.printStackTrace();
        }
    }
    
}
