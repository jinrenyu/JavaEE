package com.hibernate.entity.enumeration;

public enum Gender {
    MALE("��"), FEMALE("Ů");

    private final String cValue;

    private Gender(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }
}
