package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.VehicleStatus;
import jakarta.persistence.AttributeConverter;

public class VehicleStatusEntityConverter implements AttributeConverter<VehicleStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final VehicleStatus vehicleStatus) {
        return vehicleStatus.getDbCode();
    }

    @Override
    public VehicleStatus convertToEntityAttribute(final Integer dbCode) {
        return VehicleStatus.getByCode(dbCode);
    }
}
