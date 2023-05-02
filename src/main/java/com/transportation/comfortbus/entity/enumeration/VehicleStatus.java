package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
public enum VehicleStatus {

    ACTIVE(0),
    TECHNICAL_REVIEW(1),
    INACTIVE(2);

    private final int dbCode;

    VehicleStatus(int dbCode) {
        this.dbCode = dbCode;
    }

    public int getDbCode() {
        return dbCode;
    }

    public static VehicleStatus getByCode(final int dbCode) {
        return Arrays.stream(VehicleStatus.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No Vehicle status found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }


}
