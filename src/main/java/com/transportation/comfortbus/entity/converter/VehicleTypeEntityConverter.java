package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.VehicleType;
import jakarta.persistence.AttributeConverter;

public class VehicleTypeEntityConverter implements AttributeConverter<VehicleType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final VehicleType vehicleType) {
        return vehicleType.getDbCode();
    }

    @Override
    public VehicleType convertToEntityAttribute(final Integer dbCode) {
        return VehicleType.getByCode(dbCode);
    }
}
