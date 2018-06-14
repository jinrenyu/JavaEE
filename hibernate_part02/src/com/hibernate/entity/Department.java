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
@Table(name="tbl_department")
public class Department implements Serializable {

    private static final long serialVersionUID = 7272511209272949882L;

    private Integer id;
    private String name;
    private String deptNo;

    public Department() {
        super();
    }
    public Department(String name, String deptNo) {
        super();
        this.name = name;
        this.deptNo = deptNo;
    }
    public Department(Integer id, String name, String deptNo) {
        super();
        this.id = id;
        this.name = name;
        this.deptNo = deptNo;
    }
    @Id
    @GeneratedValue(generator="gen_dept_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_dept_id", sequenceName="sen_dept_id",allocationSize=1)
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
    public String getDeptNo() {
        return deptNo;
    }
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Department [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", deptNo=");
        builder.append(deptNo);
        builder.append("]");
        return builder.toString();
    }
    
}
