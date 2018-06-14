package com.hibernate.convert;

import java.util.Objects;

import javax.persistence.AttributeConverter;

import com.hibernate.entity.enumeration.Gender;

public class GenderConvert implements AttributeConverter<Gender, String> {

    // 在数据从Java到数据库时进行的转换
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return gender.getcValue();
    }

    // 从数据库到类对象封装的时候进行的转换
    @Override
    public Gender convertToEntityAttribute(String value) {
        Objects.requireNonNull(value, "gender value must not be null");
        Gender gender = null;
        if ("男".equals(value)) {
            gender = Gender.MALE;
        }
        if ("女".equals(value)) {
            gender = Gender.FEMALE;
        }
        return gender;
    }



}
