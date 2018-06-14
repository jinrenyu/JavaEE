package com.hibernate.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.hibernate.dao.DoctorDao;
import com.hibernate.entity.Doctor;
import com.hibernate.template.HibernateTemplate;
import com.hibernate.template.interf.QueryExecutor;
import com.hibernate.template.interf.UpdateExecutor;

public class DoctorDaoImpl implements DoctorDao {

    @Override
    public void addDoctor(Doctor doctor) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        template.update(new UpdateExecutor() {
            
            @Override
            public void execute(Session session) throws HibernateException {
                session.save(doctor);
            }
        });
    }

    @Override
    public Doctor findDoctorById(int id) {
        HibernateTemplate<Doctor> template = new HibernateTemplate<>();
        return template.query(new QueryExecutor<Doctor>() {
            
            @Override
            public Doctor execute(Session session) throws HibernateException {
                return (Doctor) session.get(Doctor.class, id);
            }
        });
    }

}
