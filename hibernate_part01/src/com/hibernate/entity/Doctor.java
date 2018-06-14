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

// ��ʾ������һ��ʵ����, ��ҪHibernate�����е�ע����н����Լ�ӳ�����Ӧ�ı��
@Entity
// ��ʾ�����Ӧ���ݿ��еı������
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

    // ��ʾ�ó�Ա��Ӧ���е�������
    @Id
    // ��ʾʹ���Զ�����ֵ�����ɸ��е�ֵ
    @GeneratedValue(generator="gen_doctor_id", strategy=GenerationType.AUTO)
    // ʹ�����еķ�ʽ���ɶԶ�Ӧ��idֵ, ���Զ������е�����Ϊseq_doctor_id, ��3��ʼÿ������2
    @SequenceGenerator(name="gen_doctor_id", sequenceName="seq_doctor_id", initialValue=3, allocationSize=2)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // ��ʾ�ó�Ա��Ӧ���е�һ����ͨ��, Ĭ�������ͳ�Ա����ͬ
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
    // Temporal������ֵ,�ֱ�ΪDATE/TIME/TIMESTAMP�ֱ��Ӧ�����е���������
    @Temporal(TemporalType.DATE)
    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Column
    // Enumerated������ֵString/Ordinal,String��ʾ������������ʱʹ��ö�����Ӧ��
    // �ַ�����ֵ���в���(��Gender.MALE -> MALE), 
    // Ordinal��ʾö������ö��ʵ��������λ��(Ĭ��ֵ, ���д�0��ʼ)
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
