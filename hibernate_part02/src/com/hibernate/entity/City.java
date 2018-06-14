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
@Table(name="tbl_city")
public class City implements Serializable {

    private static final long serialVersionUID = -6714167953754703009L;
    
    private Integer id;
    private String name;
    private String postNo;
    
    private Province province;

    public City() {
        super();
    }

    public City(String name, String postNo, Province province) {
        super();
        this.name = name;
        this.postNo = postNo;
        this.province = province;
    }

    public City(Integer id, String name, String postNo, Province province) {
        super();
        this.id = id;
        this.name = name;
        this.postNo = postNo;
        this.province = province;
    }

    @Id
    @GeneratedValue(generator="gen_city_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_city_id", sequenceName="sen_city_id", allocationSize=1)
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
    public String getPostNo() {
        return postNo;
    }

    public void setPostNo(String postNo) {
        this.postNo = postNo;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("City [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", postNo=");
        builder.append(postNo);
        builder.append("]");
        return builder.toString();
    }
    
}
