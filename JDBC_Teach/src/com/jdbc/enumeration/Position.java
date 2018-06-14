package com.jdbc.enumeration;

public enum Position {

    PG("组织后卫"), SG("得分后卫"), SF("小前锋"), PF("大前锋"), C("中锋");

    private final String cValue;

    private Position(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }

}
