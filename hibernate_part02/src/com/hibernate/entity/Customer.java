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
@Table(name="tbl_customer")
public class Customer implements Serializable {

    private static final long serialVersionUID = 2877728464256738672L;
    
    private Integer Id;
    private String name;
    private Integer age;
    
    private List<Order> orders;

    public Customer() {
        super();
    }

    public Customer(String name, Integer age, List<Order> orders) {
        super();
        this.name = name;
        this.age = age;
        this.orders = orders;
    }

    public Customer(Integer id, String name, Integer age, List<Order> orders) {
        super();
        Id = id;
        this.name = name;
        this.age = age;
        this.orders = orders;
    }
    @Id
    @GeneratedValue(generator="gen_customer_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_customer_id", sequenceName="sen_customer_id",allocationSize=1)
    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Customer [Id=");
        builder.append(Id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", age=");
        builder.append(age);
        builder.append(", orders=");
        builder.append(orders);
        builder.append("]");
        return builder.toString();
    }

}
