package com.jdbc.enumeration;

public enum Position {

    PG("��֯����"), SG("�÷ֺ���"), SF("Сǰ��"), PF("��ǰ��"), C("�з�");

    private final String cValue;

    private Position(String cValue) {
        this.cValue = cValue;
    }

    public String getcValue() {
        return cValue;
    }

}
