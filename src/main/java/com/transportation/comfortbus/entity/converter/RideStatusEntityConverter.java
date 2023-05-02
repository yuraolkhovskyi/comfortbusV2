package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.RideStatus;
import jakarta.persistence.AttributeConverter;

public class RideStatusEntityConverter implements AttributeConverter<RideStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final RideStatus rideStatus) {
        return rideStatus.getDbCode();
    }

    @Override
    public RideStatus convertToEntityAttribute(final Integer dbCode) {
        return RideStatus.getByCode(dbCode);
    }
}
