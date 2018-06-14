package com.exam.vo;

public class Option {
    /*
     * ������ѡ���չʾ�ı�
     */
    private String label;
    /*
     * ������ѡ���ֵ
     */
    private String value;
    /*
     * ��ֵ���͵�������ֵ
     */
    private Integer intValue;

    public Option() {
        super();
    }

    public Option(String label, String value) {
        super();
        this.label = label;
        this.value = value;
    }

    public Option(String label, Integer intValue) {
        super();
        this.label = label;
        this.intValue = intValue;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public void setIntValue(Integer intValue) {
        this.intValue = intValue;
    }
    
}
