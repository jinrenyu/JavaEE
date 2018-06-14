package com.jdbc.dao.impl;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.jdbc.dao.StudentDao;
import com.jdbc.entity.Student;
import com.jdbc.enumeration.Gender;
import com.jdbc.util.DateUtil;

public class StudentDaoPreParedImplTest {
    
    private StudentDao studentDao;

    @Before
    public void setUp() throws Exception {
        studentDao = new StudentDaoPreParedImpl();
    }

    @After
    public void tearDown() throws Exception {
        studentDao = null;
    }

    @Test
    public void testFindStudentById() {
        fail("Not yet implemented");
    }

    @Test
    public void testFindAllStudents() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteStudentById() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateStudent() {
        fail("Not yet implemented");
    }

    @Test
    public void testAddStudent() {
        studentDao.addStudent(new Student("Ray", 34, 
                DateUtil.setTime(1986, 3, 4), Gender.MALE));
    }

    @Test
    public void testAddStudents() {
        List<Student> students = new ArrayList<Student>();
        for(int i = 0; i < 100000; i++) {
            students.add(new Student("Test" + i, new Integer(23) , new Date(), Gender.MALE));
        }
        studentDao.addStudents(students);
    }

}
