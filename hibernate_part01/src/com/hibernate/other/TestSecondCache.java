package com.hibernate.other;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Doctor;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.QueryExecutor;

public class TestSecondCache {

    public static void main(String[] args) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        HibernateTemplate<List<Doctor>> template02 = new HibernateTemplate<>();
        
        List doctors01 = template02.query(new QueryExecutor<List<Doctor>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Doctor> execute(Session session) throws HibernateException {
                return session.createQuery("from Doctor").list();
            }
        });
        
        List doctors = template02.query(new QueryExecutor<List<Doctor>>() {
            
            @SuppressWarnings("unchecked")
            @Override
            public List<Doctor> execute(Session session) throws HibernateException {
                return session.createQuery("from Doctor where dname = ?").setParameter(0, "Ray").list();
            }
        });
//        
//        Doctor doctor01 = template.query(new QueryExecutor<Doctor>() {
//            
//            @Override
//            public Doctor execute(Session session) throws HibernateException {
//                return (Doctor) session.get(Doctor.class, 3);
//            }
//        });
        
        
//        Doctor doctor02 = template.query(new QueryExecutor<Doctor>() {
//
//            @Override
//            public Doctor execute(Session session) throws HibernateException {
//                return (Doctor) session.get(Doctor.class, 3);
//            }
//        });
        
//        System.out.println(doctor01 == doctor02);
    }
}
