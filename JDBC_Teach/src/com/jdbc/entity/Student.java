package com.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

import com.jdbc.enumeration.Gender;
import com.jdbc.util.DateUtil;

public class Student implements Serializable {

    private static final long serialVersionUID = 1986061318155219584L;
    /*
     * 学生ID
     */
    private Integer id;
    /*
     * 学生姓名
     */
    private String name;
    /*
     * 学生年龄
     */
    private Integer age;
    /*
     * 学生的出生日期
     */
    private Date birthday;
    /*
     * 学生的性别
     */
    private Gender gender;
    
    public Student() {
        super();
    }

    public Student(String name, Integer age, Date birthday, Gender gender) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Student(Integer id, String name, Integer age, Date birthday, Gender gender) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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
        builder.append(", birthday=");
        builder.append(DateUtil.formatDate(birthday, "yyyy-MM-dd"));
        builder.append(", gender=");
        builder.append(gender.getcValue());
        builder.append("]");
        return builder.toString();
    }

}
