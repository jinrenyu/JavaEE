package com.hibernate.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student implements Serializable {

    private static final long serialVersionUID = -2005812841024253872L;
    
    private Integer id;
    private String name;
    private Integer age;
    
    private List<Course> courses;

    public Student() {
        super();
    }

    public Student(String name, Integer age, List<Course> courses) {
        super();
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public Student(Integer id, String name, Integer age, List<Course> courses) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    @Id
    @GeneratedValue(generator="gen_student_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_student_id", sequenceName="sen_student_id", allocationSize=1)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Student [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", courses=");
        builder.append(courses);
        builder.append("]");
        return builder.toString();
    }

    public void remove(Course tc) {
        if (courses != null && courses.contains(tc)) {
            // 让Student对象get不到Course对象
            courses.remove(tc);
            // 让Course对象也get不到Student对象
            tc.getStudents().remove(this);
        }
    }
    
    public void add(Course tc) {
        if (courses != null && courses.contains(tc)) {
            // 让Student对象get不到Course对象
            courses.add(tc);
            // 让Course对象也get不到Student对象
            tc.getStudents().add(this);
        }
    }

}
