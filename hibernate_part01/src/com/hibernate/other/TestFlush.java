package com.hibernate.other;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.entity.Doctor;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.UpdateExecutor;

public class TestFlush {

    public static void main(String[] args) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        template.update(new UpdateExecutor() {

            @Override
            public void execute(Session session) throws HibernateException {
                Doctor doctor = (Doctor) session.get(Doctor.class, 5);
//                session.evict(doctor);
                doctor.setName("Chris");
                Doctor doctor2 = new Doctor();
                doctor2.setName("Ray");
                session.save(doctor2);
                doctor2.setSalary(123.32);
                session.clear();
//                doctor.setId(4);
                // 该方法的作用是刷新缓存与数据库进行同步
//                session.flush();
//                doctor.setName("Tom");
//                session.update(doctor);
//                session.save(doctor);
            }
        });
    }
}
