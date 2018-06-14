package com.jdbc.entity;

import java.util.Date;

import com.jdbc.enumeration.Position;
import com.jdbc.util.DateUtil;

public class Player {

    private Integer id;
    private String name;
    private Double salary;
    private Date joinDate;
    private Position position;

    private BasketballTeam team;

    public Player() {
        super();
    }
    
    public Player(Integer id, String name, Double salary, Date joinDate,
            Position position, BasketballTeam team) {
        super();
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
        this.position = position;
        this.team = team;
    }

    public Player(String name, Double salary, Date joinDate, Position position,
            BasketballTeam team) {
        super();
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
        this.position = position;
        this.team = team;
    }
    
    public Player(String name, Double salary, Date joinDate, Position position) {
        super();
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public BasketballTeam getTeam() {
        return team;
    }

    public void setTeam(BasketballTeam team) {
        this.team = team;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Player [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", salary=");
        builder.append(salary);
        builder.append(", joinDate=");
        builder.append(DateUtil.formatDate(joinDate, "yyyy-MM-dd"));
        builder.append(", position=");
        builder.append(position);
        builder.append("]");
        return builder.toString();
    }

}
