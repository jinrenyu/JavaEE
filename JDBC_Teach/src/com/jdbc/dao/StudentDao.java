package com.jdbc.dao;

import java.util.List;

import com.jdbc.entity.Student;

public interface StudentDao {

    /**
     * ����id��ȡ���ݿ��ж�Ӧ�ļ�¼������ѧ������
     * @param id ��Ҫ���ҵ�ѧ����¼��ID
     * @return ѧ������
     */
    Student findStudentById(int id);
    /**
     * ��ȡ���е�ѧ����¼������
     * @return ѧ���б����
     */
    List<Student> findAllStudents();
    /**
     * ���ݴ����IDֵɾ�����ݿ��ж�Ӧ��¼
     * @param id Ҫɾ����¼��ID
     */
    void deleteStudentById(int id);
    /**
     * �������ݿ��е�ѧ����¼
     * @param student ��Ҫ���и��µ�ѧ������
     */
    void updateStudent(Student student);
    /**
     * ���ѧ���������ݿ���
     * @param student Ҫ��ӵ�ѧ����¼
     */
    void addStudent(Student student);
    /**
     * �������ѧ����¼
     * @param students Ҫ��ӵ�ѧ���б����
     */
    void addStudents(List<Student> students);
}
