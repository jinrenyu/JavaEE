package com.tz.online.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {

    private static SessionFactory sf = null;
    
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
    
    public static Session getSession() {
        return sf == null ? null : sf.openSession();
    }
    
    public static void close(Session ses) {
        try {
            if (ses != null) {
                ses.close();
            }
        } catch (HibernateException hex) {
            hex.printStackTrace();
        }
    }
}
