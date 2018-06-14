package com.hibernate.convert;

import java.util.Objects;

import javax.persistence.AttributeConverter;

import com.hibernate.entity.enumeration.Gender;

public class GenderConvert implements AttributeConverter<Gender, String> {

    // �����ݴ�Java�����ݿ�ʱ���е�ת��
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.getcValue();
    }

    // �����ݿ⵽������װ��ʱ����е�ת��
    @Override
    public Gender convertToEntityAttribute(String value) {
        Objects.requireNonNull(value, "gender value must not be null");
        Gender gender = null;
        if ("��".equals(value)) {
            gender = Gender.MALE;
        }
        if ("Ů".equals(value)) {
            gender = Gender.FEMALE;
        }
        return gender;
    }



}
