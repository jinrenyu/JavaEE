package com.exam.entity.enumeration;

public enum Status {

    AVAILABLE("未入住"), CHECKIN("已入住"), CHECKOUT("已退房");
    
    private final String cValue;

    private Status(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }
    
}
