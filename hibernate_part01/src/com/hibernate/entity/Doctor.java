package com.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.hibernate.entity.enumeration.Gender;
import com.hibernate.util.DateUtil;

// 标示该类是一个实体类, 需要Hibernate对其中的注解进行解析以及映射出对应的表格
@Entity
// 标示该类对应数据库中的表的名字
@Table(name="tbl_doctor")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE, region="sampleCache1")
public class Doctor implements Serializable {

    private static final long serialVersionUID = 8471698641935657503L;
    
    private Integer id;
    
    private String name;
    
    private Double salary;
    
    private Date birth;
    
    private Gender gender;

    public Doctor() {
        super();
    }

    public Doctor(String name, Double salary, Date birth, Gender gender) {
        super();
        this.name = name;
        this.salary = salary;
        this.birth = birth;
        this.gender = gender;
    }

    public Doctor(Integer id, String name, Double salary, Date birth, Gender gender) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.birth = birth;
        this.gender = gender;
    }

    // 标示该成员对应表中的主键列
    @Id
    // 标示使用自动生成值来生成该列的值
    @GeneratedValue(generator="gen_doctor_id", strategy=GenerationType.AUTO)
    // 使用序列的方式生成对对应的id值, 并自定义序列的名称为seq_doctor_id, 从3开始每次增加2
    @SequenceGenerator(name="gen_doctor_id", sequenceName="seq_doctor_id", initialValue=3, allocationSize=2)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // 标示该成员对应表中的一个普通列, 默认列名和成员名相同
    @Column(name="dName", nullable=false, length=30)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(columnDefinition="number(10, 2) constraint doctor_sal_ck check(salary > 0)")
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Column
    // Temporal有三个值,分别为DATE/TIME/TIMESTAMP分别对应生成列的数据类型
    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Column
    // Enumerated有两个值String/Ordinal,String表示插入数据数据时使用枚举类对应的
    // 字符串的值进行插入(如Gender.MALE -> MALE), 
    // Ordinal表示枚举类中枚举实例的索引位置(默认值, 序列从0开始)
    @Enumerated(EnumType.STRING)
//    @Convert(converter=GenderConvert.class)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Doctor [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", salary=");
        builder.append(salary);
        builder.append(", birth=");
        builder.append(DateUtil.formatDate(birth, "yyyy-MM-dd"));
        builder.append(", gender=");
        builder.append(gender.getcValue());
        builder.append("]");
        return builder.toString();
    }

}
