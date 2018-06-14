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
@Table(name="tbl_wife")
public class Wife implements Serializable{

    private static final long serialVersionUID = 6448677895170902121L;
    
    private Integer id;
    private String name;
    private Husband husband;
    public Wife() {
        super();
    }
    public Wife(String name) {
        super();
        this.name = name;
    }
    public Wife(String name, Husband husband) {
        super();
        this.name = name;
        this.husband = husband;
    }
    public Wife(Integer id, String name, Husband husband) {
        super();
        this.id = id;
        this.name = name;
        this.husband = husband;
    }
    
    @Id
    @GeneratedValue(generator="gen_wife_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_wife_id", sequenceName="sen_wife_id",allocationSize=1)
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

    public Husband getHusband() {
        return husband;
    }
    public void setHusband(Husband husband) {
        this.husband = husband;
    }
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Wife [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
    
}
