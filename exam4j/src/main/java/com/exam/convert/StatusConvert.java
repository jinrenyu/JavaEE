package com.exam.convert;

import java.util.Objects;

import javax.persistence.AttributeConverter;

import com.exam.entity.enumeration.Status;

public class StatusConvert implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return status.getcValue();
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        Objects.requireNonNull(value, "status value must not be null");
        Status status = null;
        if ("未入住".equals(value)) {
            status = Status.AVAILABLE;
        }
        if ("已入住".equals(value)) {
            status = Status.CHECKIN;
        }
        if ("已退房".equals(value)) {
            status = Status.CHECKOUT;
        }
        return status;
    }

}
