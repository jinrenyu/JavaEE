package com.hibernate.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="ru_role_user")
public class RU implements Serializable{

    private static final long serialVersionUID = -2306645277051574117L;
    
    private Role role;
    private User user;
    
    public RU() {
        super();
    }

    public RU(Role role, User user) {
        super();
        this.role = role;
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("RU [role=");
        builder.append(role);
        builder.append(", user=");
        builder.append(user);
        builder.append("]");
        return builder.toString();
    }

}
