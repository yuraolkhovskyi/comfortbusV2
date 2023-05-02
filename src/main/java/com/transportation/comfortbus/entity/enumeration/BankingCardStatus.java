package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@Getter
public enum BankingCardStatus {

    ACTIVE(0),
    BLOCKED(1),
    EXPIRED(2);

    private final int dbCode;

    BankingCardStatus(int dbCode) {
        this.dbCode = dbCode;
    }

    public static BankingCardStatus getByCode(final int dbCode) {
        return Arrays.stream(BankingCardStatus.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No Ride Status found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }

}
