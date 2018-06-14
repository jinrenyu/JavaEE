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
@Table(name="tbl_course")
public class Course implements Serializable{

    private static final long serialVersionUID = -6979122384838735369L;
    
    private Integer id;
    private String name;
    private String courseNo;
    
    private List<Student> students;

    public Course() {
        super();
    }

    public Course(String name, String courseNo, List<Student> students) {
        super();
        this.name = name;
        this.courseNo = courseNo;
        this.students = students;
    }

    public Course(Integer id, String name, String courseNo,
            List<Student> students) {
        super();
        this.id = id;
        this.name = name;
        this.courseNo = courseNo;
        this.students = students;
    }

    @Id
    @GeneratedValue(generator="gen_course_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_course_id", sequenceName="sen_course_id", allocationSize=1)
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
    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Course [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", courseNo=");
        builder.append(courseNo);
        builder.append(", students=");
        builder.append(students);
        builder.append("]");
        return builder.toString();
    }

}
