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
@Table(name="tbl_province")
public class Province implements Serializable {

    private static final long serialVersionUID = 9143647114879297598L;
    
    private Integer Id;
    private String name;
    private String area;
    
    private List<City> cities;

    public Province() {
        super();
    }

    public Province(String name, String area, List<City> cities) {
        super();
        this.name = name;
        this.area = area;
        this.cities = cities;
    }

    public Province(Integer id, String name, String area, List<City> cities) {
        super();
        Id = id;
        this.name = name;
        this.area = area;
        this.cities = cities;
    }

    @Id
    @GeneratedValue(generator="gen_province_id", strategy=GenerationType.AUTO)
    @SequenceGenerator(name="gen_province_id", sequenceName="sen_province_id", allocationSize=1)
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
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
    
    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Province [Id=");
        builder.append(Id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", area=");
        builder.append(area);
        builder.append("]");
        return builder.toString();
    }
    

}
