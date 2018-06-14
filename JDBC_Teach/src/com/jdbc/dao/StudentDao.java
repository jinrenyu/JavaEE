package com.jdbc.dao;

import java.util.List;

import com.jdbc.entity.Student;

public interface StudentDao {

    /**
     * 根据id获取数据库中对应的记录并返回学生对象
     * @param id 所要查找的学生记录的ID
     * @return 学生对象
     */
    Student findStudentById(int id);
    /**
     * 获取所有的学生记录并返回
     * @return 学生列表对象
     */
    List<Student> findAllStudents();
    /**
     * 根据传入的ID值删除数据库中对应记录
     * @param id 要删除记录的ID
     */
    void deleteStudentById(int id);
    /**
     * 更新数据库中的学生记录
     * @param student 所要进行更新的学生对象
     */
    void updateStudent(Student student);
    /**
     * 添加学生对象到数据库中
     * @param student 要添加的学生记录
     */
    void addStudent(Student student);
    /**
     * 批量添加学生记录
     * @param students 要添加的学生列表对象
     */
    void addStudents(List<Student> students);
}
