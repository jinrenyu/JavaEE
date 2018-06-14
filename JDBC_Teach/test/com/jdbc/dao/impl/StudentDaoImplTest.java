package com.jdbc.dao.impl;

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

public class StudentDaoImplTest {

    private StudentDao studentDao;
    
    @Before
    public void setUp() throws Exception {
        studentDao = new StudentDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        studentDao = null;
    }

    @Test
    public void testFindStudentById() {
        System.out.println(studentDao.findStudentById(1));
    }

    @Test
    public void testFindAllStudents() {
        List<Student> students = studentDao.findAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Test
    public void testDeleteStudentById() {
        studentDao.deleteStudentById(3);
    }

    @Test
    public void testUpdateStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("Lucy");
        student.setAge(23);
        student.setBirthday(DateUtil.setTime(1994, 4, 23));
        student.setGender(Gender.FEMALE);
        studentDao.updateStudent(student);
    }

    @Test
    public void testAddStudent() {
        studentDao.addStudent(new Student("Ray", 34, 
                DateUtil.setTime(1986, 3, 4), Gender.MALE));
    }

    @Test
    public void testAddStudents() {
        List<Student> students = new ArrayList<Student>();
        for(int i = 0; i < 10000; i++) {
            students.add(new Student("Test" + i, new Integer(23) , new Date(), Gender.MALE));
        }
        studentDao.addStudents(students);
    }

}
