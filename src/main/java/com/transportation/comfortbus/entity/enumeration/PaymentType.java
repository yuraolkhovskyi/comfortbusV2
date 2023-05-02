package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@Getter
public enum PaymentType {

    IN_CASH(0),
    CREDIT_CARD(1);

    private final int dbCode;

    PaymentType(int dbCode) {
        this.dbCode = dbCode;
    }

    public static PaymentType getByCode(final int dbCode) {
        return Arrays.stream(PaymentType.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No Ride Status found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }

}
