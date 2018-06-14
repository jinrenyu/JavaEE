package com.hibernate.dao.impl;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.hibernate.dao.DoctorDao;
import com.hibernate.entity.Doctor;
import com.hibernate.entity.enumeration.Gender;

public class DoctorDaoImplTest {

    private DoctorDao doctorDao;
    
    @Before
    public void setUp() throws Exception {
        doctorDao = new DoctorDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        doctorDao = null;
    }

    @Test
    public void testAddDoctor() {
        doctorDao.addDoctor(new Doctor("Tom", 100.00, new Date(), Gender.MALE));
    }

    @Test
    public void testFindDoctorById() {
        System.out.println(doctorDao.findDoctorById(3));
    }

}
