package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
public enum UserRole {

    CLIENT(0),
    DRIVER(1),
    ADMIN(2);

    private final int dbCode;

    UserRole(int dbCode) {
        this.dbCode = dbCode;
    }

    public int getDbCode() {
        return dbCode;
    }

    public static UserRole getByCode(final int dbCode) {
        return Arrays.stream(UserRole.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No User Role found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }
}
