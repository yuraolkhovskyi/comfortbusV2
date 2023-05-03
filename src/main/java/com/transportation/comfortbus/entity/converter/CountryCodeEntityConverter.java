package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.CountryCode;
import com.transportation.comfortbus.entity.enumeration.VehicleType;
import jakarta.persistence.AttributeConverter;

public class CountryCodeEntityConverter implements AttributeConverter<CountryCode, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final CountryCode countryCode) {
        return countryCode.getDbCode();
    }

    @Override
    public CountryCode convertToEntityAttribute(final Integer dbCode) {
        return CountryCode.getByCode(dbCode);
    }
}
