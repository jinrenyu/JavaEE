package com.jdbc.enumeration;

public enum Gender {
    MALE("ÄÐ"), FEMALE("Å®");

    private final String cValue;

    private Gender(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }
}
