package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tbl_employee")
public class Employee implements Serializable{

    private static final long serialVersionUID = 5282383853661203489L;
    
    private Integer id;
    private String name;
    private Integer age;
    
    private Department dept;

    public Employee() {
        super();
    }

    public Employee(String name, Integer age, Department dept) {
        super();
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    public Employee(Integer id, String name, Integer age, Department dept) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.dept = dept;
    }

    @Id
    @GeneratedValue(generator="gen_emp_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_emp_id", sequenceName="sen_emp_id",allocationSize=1)
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

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Employee [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", dept=");
        builder.append(dept);
        builder.append("]");
        return builder.toString();
    }
    
}
