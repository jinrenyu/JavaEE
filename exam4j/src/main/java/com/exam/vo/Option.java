package com.exam.vo;

public class Option {
    /*
     * 下拉框选项的展示文本
     */
    private String label;
    /*
     * 下拉框选项的值
     */
    private String value;
    /*
     * 数值类型的下拉框值
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
