package com.hibernate.other;

import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Doctor;
import com.hibernate.entity.enumeration.Gender;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.QueryExecutor;
import com.hibernate.template.interf.UpdateExecutor;

public class TestQueryCache {

    public static void main(String[] args) {
        HibernateTemplate<List<Doctor>> template = new HibernateTemplate<>();
        List<Doctor> doctors01 = template.query(new QueryExecutor<List<Doctor>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Doctor> execute(Session session) throws HibernateException {
                String hql = "from Doctor where salary > :minsal and salary < :maxsal";
                return session.createQuery(hql).setParameter("minsal", new Double(50))
                        .setParameter("maxsal",  new Double(200)).setCacheable(true).list();
            }
        });
        
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                session.save(new Doctor("LiLei", 123.22, new Date(), Gender.MALE));
            }
        });
        
        List<Doctor> doctors02 = template.query(new QueryExecutor<List<Doctor>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Doctor> execute(Session session) throws HibernateException {
                String hql = "from Doctor where salary > :minsal and salary < :maxsal";
                return session.createQuery(hql).setParameter("minsal", new Double(50))
                        .setParameter("maxsal", new Double(200)).setCacheable(true).list();
            }
        });
    }

}
