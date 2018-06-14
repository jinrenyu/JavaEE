package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jdbc.dao.StudentDao;
import com.jdbc.entity.Student;
import com.jdbc.enumeration.Gender;
import com.jdbc.util.DateUtil;
import com.jdbc.util.JdbcUtil;
import com.jdbc.util.SimplateDataSource;

public class StudentDaoImpl implements StudentDao {

    @Override
    public Student findStudentById(int id) {
        String user = "jsd1612";
        String password = "jsd1612";
        String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
        String classPath = "oracle.jdbc.driver.OracleDriver";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Student student = null;
        try {
            // ��������
            Class.forName(classPath);
            // ��ȡ����
            conn = DriverManager.getConnection(url, user, password);
            // ��ȡ��������
            st = conn.createStatement();
            // ����ҵ�������SQL���
            String sql = "select * from t_student where id = " + id;
            // ִ��SQL���,������ResultSet
            rs = st.executeQuery(sql);
            // �����ȡ���Ľ������
            if (rs.next()) {
                // ���δӽ������ȡ������
                int sid = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // ��rs.getDateȡ����������ֵ����Ϊjava.sql.Date
                // ����java.util.Date������,����java��̬����Ҫ��ת��
                Date birthday = rs.getDate("birth");
                String gender = rs.getString("gender");
                
                // �ѻ�ȡ������ֵȫ����װ��ѧ�������ʵ����
                student = new Student();
                student.setId(sid);
                student.setName(name);
                student.setAge(age);
                student.setBirthday(birthday);
                // ��ö�����ͽ���ת��, ���Ƚ�����ת���ɶ�Ӧ��Ӣ��MALE����FEMALE,�����ù�����
                // Enum.valueOf����ַ�����ö�����͵�ת��,������ֵ�ķ�װ
                student.setGender(Enum.valueOf(Gender.class, 
                        gender.equals("��") ? "MALE" : "FEMALE"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // ������, �����ͷ���Դ
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        // ��Ϊ��������ص�����
        List<Student> students = null;
        try {
//            conn = JdbcUtil.getConnection();
            conn = SimplateDataSource.getInstance().getConnection();
            st = conn.createStatement();
            // ����SQL���
            String sql = "select * from t_student";
            // ִ��SQL
            rs = st.executeQuery(sql);
            // ������
            students = new ArrayList<Student>();
            while (rs.next()) {
                // ���δӽ������ȡ������
                int sid = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // ��rs.getDateȡ����������ֵ����Ϊjava.sql.Date
                // ����java.util.Date������,����java��̬����Ҫ��ת��
                Date birthday = rs.getDate("birth");
                String gender = rs.getString("gender");
                
                // �ѻ�ȡ������ֵȫ����װ��ѧ�������ʵ����, ��ɶ�һ��ѧ������ķ�װ
                Student student = new Student();
                student.setId(sid);
                student.setName(name);
                student.setAge(age);
                student.setBirthday(birthday);
                // ��ö�����ͽ���ת��, ���Ƚ�����ת���ɶ�Ӧ��Ӣ��MALE����FEMALE,�����ù�����
                // Enum.valueOf����ַ�����ö�����͵�ת��,������ֵ�ķ�װ
                student.setGender(Enum.valueOf(Gender.class, 
                        gender.equals("��") ? "MALE" : "FEMALE"));
                // �ѷ�װ�õ�ѧ��������ӵ���ѧ���б���
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(rs, st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

    @Override
    public void deleteStudentById(int id) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.createStatement();
            String sql = "delete t_student where id = " + id;
            int num = st.executeUpdate(sql);
            System.out.println("ɾ����[" + num + "]������");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateStudent(Student student) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.createStatement();
            // idֵһ����Ϊ��
            int sid = student.getId();
            // ��֤SQL������SQL���﷨
            String sql = "update t_student set id = " + sid;
            // ƴ��ʱ����λ�ñ�����ǰ
            if (student.getName() != null) {
                sql += ", name = '" + student.getName() + "'";
            }
            if (student.getAge() != null) {
                sql += ", age = " + student.getAge();
            }
            if (student.getBirthday() != null) {
                sql += ", birth = to_date('" + DateUtil
                        .formatDate(student.getBirthday(), "yyyy-MM-dd") + "', 'yyyy-mm-dd')";
            }
            if (student.getGender() != null) {
                sql += ", gender = '" + student.getGender().getcValue() + "'";
            }
            // ƴ�������޶����
            sql += " where id = " + sid;
            int num = st.executeUpdate(sql);
            System.out.println("������[" + num + "]������");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addStudent(Student student) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcUtil.getConnection();
            st = conn.createStatement();
            if (student != null) {
                String name = student.getName();
                int age = student.getAge();
                // ����������ת�����ض����ַ�����ʽ, ΪSQL�������ת�������̵�
                String birth = DateUtil.formatDate(
                        student.getBirthday(), "yyyy-MM-dd");
                // ���Ա���д���,��ö����ת�������ݿ��Ӧ��ֵ
                String gender = student.getGender().getcValue();
                // ������ӵ�SQL���
                String sql = "insert into t_student values(seq_student_id.nextval, '" + name + "', " 
                        + age + ", to_date('" + birth + "', 'yyyy-mm-dd'), "
                        + "'" + gender + "')";
                int num = st.executeUpdate(sql);
                System.out.println("�����[" + num + "]������");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.close(st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addStudents(List<Student> students) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = JdbcUtil.getConnection();
            conn.setAutoCommit(false);
            st = conn.createStatement();
            if (students != null && students.size() > 0) {
                int count = 0;
                for (Student student : students) {
                    String name = student.getName();
                    int age = student.getAge();
                    // ����������ת�����ض����ַ�����ʽ, ΪSQL�������ת�������̵�
                    String birth = DateUtil.formatDate(
                            student.getBirthday(), "yyyy-MM-dd");
                    // ���Ա���д���,��ö����ת�������ݿ��Ӧ��ֵ
                    String gender = student.getGender().getcValue();
                    // ������ӵ�SQL���
                    String sql = "insert into t_student values(seq_student_id.nextval, '" + name + "', " 
                            + age + ", to_date('" + birth + "', 'yyyy-mm-dd'), "
                            + "'" + gender + "')";
                    st.addBatch(sql);
                    if (++count % 100 == 0) {
                        st.executeBatch();
                        // ����ڴ��е�sql���
                        st.clearBatch();
                    }
//                    int num = st.executeUpdate(sql);
//                    System.out.println("�����[" + num + "]������");
                }
                // ��ֹ��100����ģ�����������Sql����ִ��
                st.executeBatch();
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
                JdbcUtil.close(st, conn);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
