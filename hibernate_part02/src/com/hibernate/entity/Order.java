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
@Table(name="tbl_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 9010576204745680185L;

    private Integer Id;
    private String ordNo;
    private Double price;
    
    public Order() {
        super();
    }
    
    public Order(String ordNo, Double price) {
        super();
        this.ordNo = ordNo;
        this.price = price;
    }
    
    public Order(Integer id, String ordNo, Double price) {
        super();
        Id = id;
        this.ordNo = ordNo;
        this.price = price;
    }
    
    @Id
    @Column(name="oid")
    @GeneratedValue(generator="gen_order_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_order_id", sequenceName="sen_order_id",allocationSize=1)
    public Integer getId() {
        return Id;
    }
    
    public void setId(Integer id) {
        Id = id;
    }
    
    @Column
    public String getOrdNo() {
        return ordNo;
    }
    public void setOrdNo(String ordNo) {
        this.ordNo = ordNo;
    }
    
    @Column
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Order [Id=");
        builder.append(Id);
        builder.append(", ordNo=");
        builder.append(ordNo);
        builder.append(", price=");
        builder.append(price);
        builder.append("]");
        return builder.toString();
    }
    
}
