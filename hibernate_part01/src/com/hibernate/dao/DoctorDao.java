package com.hibernate.dao;

import com.hibernate.entity.Doctor;

public interface DoctorDao {

    void addDoctor(Doctor doctor);
    
    Doctor findDoctorById(int id);
}
