package com.exam.entity.enumeration;

public enum Status {

    AVAILABLE("δ��ס"), CHECKIN("����ס"), CHECKOUT("���˷�");
    
    private final String cValue;

    private Status(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }
    
}
