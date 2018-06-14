package com.hibernate.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hibernate.util.DateUtil;

public class Worker implements Serializable {

    private static final long serialVersionUID = 6606836589404185697L;
    
    private Integer id;
    
    private String name;
    
    private Integer age;
    
    private BigDecimal salary;
    
    private Date birth;

    public Worker() {
        super();
    }

    public Worker(String name, Integer age, BigDecimal salary, Date birth) {
        super();
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.birth = birth;
    }

    public Worker(Integer id, String name, Integer age, BigDecimal salary, Date birth) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.birth = birth;
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

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Worker [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", salary=");
        builder.append(salary);
        builder.append(", birth=");
        builder.append(DateUtil.formatDate(birth, "yyyy-MM-dd"));
        builder.append("]");
        return builder.toString();
    }

}
