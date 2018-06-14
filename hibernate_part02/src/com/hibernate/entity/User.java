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
@Table(name="tbl_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1911361303150494341L;
    
    private Integer id;
    private String name;
    
    private List<RU> rus;

    public User() {
        super();
    }

    public User(String name, List<RU> rus) {
        super();
        this.name = name;
        this.rus = rus;
    }

    public User(Integer id, String name, List<RU> rus) {
        super();
        this.id = id;
        this.name = name;
        this.rus = rus;
    }

    @Id
    @GeneratedValue(generator="gen_user_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_user_id", sequenceName="sen_user_id", allocationSize=1)
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

    public List<RU> getRus() {
        return rus;
    }

    public void setRus(List<RU> rus) {
        this.rus = rus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("User [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append("]");
        return builder.toString();
    }
    

}
