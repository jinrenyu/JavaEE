package com.jdbc.entity;

import java.io.Serializable;

public class Account implements Serializable {

    private static final long serialVersionUID = 419324415298433325L;
    
    private Integer id;
    private String username;
    private String password;
    private Double balance;
    
    public Account() {
        super();
    }
    
    public Account(String username, String password, Double balance) {
        super();
        this.username = username;
        this.password = password;
        this.balance = balance;
    }
    
    public Account(Integer id, String username, String password, Double balance) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Account [id=");
        builder.append(id);
        builder.append(", username=");
        builder.append(username);
        builder.append(", password=");
        builder.append(password);
        builder.append(", balance=");
        builder.append(balance);
        builder.append("]");
        return builder.toString();
    }
}
