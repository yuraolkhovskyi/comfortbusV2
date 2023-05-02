package com.transportation.comfortbus.entity.converter;

import com.transportation.comfortbus.entity.enumeration.UserRole;
import jakarta.persistence.AttributeConverter;

public class UserRoleEntityConverter implements AttributeConverter<UserRole, Integer> {

    @Override
    public Integer convertToDatabaseColumn(final UserRole userRole) {
        return userRole.getDbCode();
    }

    @Override
    public UserRole convertToEntityAttribute(final Integer dbCode) {
        return UserRole.getByCode(dbCode);
    }
}
