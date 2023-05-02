package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.PaymentType;
import jakarta.persistence.AttributeConverter;

public class PaymentTypeEntityConverter implements AttributeConverter<PaymentType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final PaymentType userRole) {
        return userRole.getDbCode();
    }

    @Override
    public PaymentType convertToEntityAttribute(final Integer dbCode) {
        return PaymentType.getByCode(dbCode);
    }
}
