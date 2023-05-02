package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@Getter
public enum RideStatus {

    ACTIVE(0),
    IN_RIDE(1),
    CANCELLED(2),
    FINISHED(3);

    private final int dbCode;

    RideStatus(int dbCode) {
        this.dbCode = dbCode;
    }

    public static RideStatus getByCode(final int dbCode) {
        return Arrays.stream(RideStatus.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No Ride Status found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }
}
