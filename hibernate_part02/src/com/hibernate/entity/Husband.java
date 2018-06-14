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
@Table(name="tbl_husband")
public class Husband implements Serializable {

    private static final long serialVersionUID = -6620223782335407449L;

    private Integer id;
    private String name;
    private Integer age;
    private Wife wife;

    public Husband() {
        super();
    }
    
    public Husband(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
    }

    public Husband(String name, Integer age, Wife wife) {
        super();
        this.name = name;
        this.age = age;
        this.wife = wife;
    }
    
    
    public Husband(Integer id, String name, Integer age, Wife wife) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
        this.wife = wife;
    }

    @Id
    @GeneratedValue(generator="gen_husband_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_husband_id", sequenceName="sen_husband_id", allocationSize=1)
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

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Husband [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append("]");
        return builder.toString();
    }
    
}
