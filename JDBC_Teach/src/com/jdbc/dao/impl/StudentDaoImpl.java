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
            // 加载驱动
            Class.forName(classPath);
            // 获取连接
            conn = DriverManager.getConnection(url, user, password);
            // 获取了语句对象
            st = conn.createStatement();
            // 定制业务所需的SQL语句
            String sql = "select * from t_student where id = " + id;
            // 执行SQL语句,并返回ResultSet
            rs = st.executeQuery(sql);
            // 处理获取到的结果对象
            if (rs.next()) {
                // 依次从结果集中取出数据
                int sid = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // 从rs.getDate取出的日期数值类型为java.sql.Date
                // 它是java.util.Date的子类,根据java多态不需要做转换
                Date birthday = rs.getDate("birth");
                String gender = rs.getString("gender");
                
                // 把获取到的数值全部封装到学生对象的实例中
                student = new Student();
                student.setId(sid);
                student.setName(name);
                student.setAge(age);
                student.setBirthday(birthday);
                // 对枚举类型进行转换, 首先将中文转换成对应的英文MALE或者FEMALE,再利用工具类
                // Enum.valueOf完成字符串到枚举类型的转换,进行数值的封装
                student.setGender(Enum.valueOf(Gender.class, 
                        gender.equals("男") ? "MALE" : "FEMALE"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 第六步, 依次释放资源
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
        // 作为最后结果返回的容器
        List<Student> students = null;
        try {
//            conn = JdbcUtil.getConnection();
            conn = SimplateDataSource.getInstance().getConnection();
            st = conn.createStatement();
            // 定制SQL语句
            String sql = "select * from t_student";
            // 执行SQL
            rs = st.executeQuery(sql);
            // 处理结果
            students = new ArrayList<Student>();
            while (rs.next()) {
                // 依次从结果集中取出数据
                int sid = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // 从rs.getDate取出的日期数值类型为java.sql.Date
                // 它是java.util.Date的子类,根据java多态不需要做转换
                Date birthday = rs.getDate("birth");
                String gender = rs.getString("gender");
                
                // 把获取到的数值全部封装到学生对象的实例中, 完成对一个学生对象的封装
                Student student = new Student();
                student.setId(sid);
                student.setName(name);
                student.setAge(age);
                student.setBirthday(birthday);
                // 对枚举类型进行转换, 首先将中文转换成对应的英文MALE或者FEMALE,再利用工具类
                // Enum.valueOf完成字符串到枚举类型的转换,进行数值的封装
                student.setGender(Enum.valueOf(Gender.class, 
                        gender.equals("男") ? "MALE" : "FEMALE"));
                // 把封装好的学生对象添加到的学生列表中
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
            System.out.println("删除了[" + num + "]条数据");
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
            // id值一定不为空
            int sid = student.getId();
            // 保证SQL语句符合SQL的语法
            String sql = "update t_student set id = " + sid;
            // 拼接时逗号位置必须在前
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
            // 拼接最后的限定语句
            sql += " where id = " + sid;
            int num = st.executeUpdate(sql);
            System.out.println("更新了[" + num + "]条数据");
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
                // 把日期类型转换成特定的字符串格式, 为SQL语句中做转换进行铺垫
                String birth = DateUtil.formatDate(
                        student.getBirthday(), "yyyy-MM-dd");
                // 对性别进行处理,把枚举型转换成数据库对应的值
                String gender = student.getGender().getcValue();
                // 定制添加的SQL语句
                String sql = "insert into t_student values(seq_student_id.nextval, '" + name + "', " 
                        + age + ", to_date('" + birth + "', 'yyyy-mm-dd'), "
                        + "'" + gender + "')";
                int num = st.executeUpdate(sql);
                System.out.println("添加了[" + num + "]条数据");
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
                    // 把日期类型转换成特定的字符串格式, 为SQL语句中做转换进行铺垫
                    String birth = DateUtil.formatDate(
                            student.getBirthday(), "yyyy-MM-dd");
                    // 对性别进行处理,把枚举型转换成数据库对应的值
                    String gender = student.getGender().getcValue();
                    // 定制添加的SQL语句
                    String sql = "insert into t_student values(seq_student_id.nextval, '" + name + "', " 
                            + age + ", to_date('" + birth + "', 'yyyy-mm-dd'), "
                            + "'" + gender + "')";
                    st.addBatch(sql);
                    if (++count % 100 == 0) {
                        st.executeBatch();
                        // 清空内存中的sql语句
                        st.clearBatch();
                    }
//                    int num = st.executeUpdate(sql);
//                    System.out.println("添加了[" + num + "]条数据");
                }
                // 防止对100进行模运算的余数条Sql不被执行
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
