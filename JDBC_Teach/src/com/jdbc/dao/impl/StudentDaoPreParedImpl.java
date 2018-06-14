package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.jdbc.dao.StudentDao;
import com.jdbc.entity.Student;
import com.jdbc.template.JdbcTemplate;
import com.jdbc.template.interf.SQLExecutor;
import com.jdbc.util.JdbcUtil;

public class StudentDaoPreParedImpl implements StudentDao {

    @Override
    public Student findStudentById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void deleteStudentById(int id) {
        JdbcTemplate<Student> template = new JdbcTemplate<>();
        template.simplteUpdate(new SQLExecutor() {
            
            @Override
            public PreparedStatement execute(Connection conn) {
                String sql = "delete t_student where id = ?";
                PreparedStatement pst = null;
                try {
                    pst = conn.prepareStatement(sql);
                    pst.setInt(1, id);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return pst;
            }
        });
    }

    @Override
    public void updateStudent(Student student) {

    }

    @Override
    public void addStudent(Student student) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtil.getConnection();
            String sql = "insert into t_student values(seq_student_id.nextval,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            if (student != null) {
                String name = student.getName();
                int age = student.getAge();
                // �˴�Date��������java.util.Date
                Date birth = student.getBirthday();
                // ���Ա���д���,��ö����ת�������ݿ��Ӧ��ֵ
                String gender = student.getGender().getcValue();
                
                pst.setString(1, name);
                pst.setInt(2, age);
                // ����ģ����������ͱ�������java.sql.Date
                // ��ɴ�java.util.Date -> java.sql.Date��ת��
                pst.setDate(3, new java.sql.Date(birth.getTime()));
                pst.setString(4, gender);

                int num = pst.executeUpdate();
                System.out.println("�����[" + num + "]������");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addStudents(List<Student> students) {
        Connection conn = null;
        PreparedStatement pst = null;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            String sql = "insert into t_student values(seq_student_id.nextval,?,?,?,?)";
            pst = conn.prepareStatement(sql);
            if (students != null && students.size() > 0) {
                int count = 0;
                for (Student student : students) {
                    String name = student.getName();
                    int age = student.getAge();
                    // �˴�Date��������java.util.Date
                    Date birth = student.getBirthday();
                    // ���Ա���д���,��ö����ת�������ݿ��Ӧ��ֵ
                    String gender = student.getGender().getcValue();
                    
                    pst.setString(1, name);
                    pst.setInt(2, age);
                    // ����ģ����������ͱ�������java.sql.Date
                    // ��ɴ�java.util.Date -> java.sql.Date��ת��
                    pst.setDate(3, new java.sql.Date(birth.getTime()));
                    pst.setString(4, gender);
                    pst.addBatch();
                    if (++count % 100 == 0) {
                        pst.executeBatch();
                        // ���ģ���е�Ҫ���ݵĲ���
                        pst.clearParameters();
                    }
//                    int num = pst.executeUpdate();
//                    System.out.println("�����[" + num + "]������");
                }
                // ��ֹ��100����ģ�����������Sql����ִ��
                pst.executeBatch();
                conn.commit();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(pst, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
