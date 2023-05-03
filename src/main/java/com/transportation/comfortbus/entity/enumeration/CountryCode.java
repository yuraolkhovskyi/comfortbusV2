package com.transportation.comfortbus.entity.enumeration;

import com.transportation.comfortbus.exception.SystemException;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

import static com.transportation.comfortbus.exception.ErrorMessageConstants.INTERNAL_SERVER_ERROR_MESSAGE;
import static com.transportation.comfortbus.exception.code.ServiceErrorCode.INTERNAL_SERVER_ERROR;

@Slf4j
@Getter
public enum CountryCode {

    UA(0, "Ukraine"),
    PL(1, "Poland"),
    DE(2, "Germany"),
    FR(3, "France");

    private final int dbCode;
    private final String countryName;

    CountryCode(int dbCode, String countryName) {
        this.dbCode = dbCode;
        this.countryName = countryName;
    }

    public static CountryCode getByCode(final int dbCode) {
        return Arrays.stream(CountryCode.values())
                .filter(role -> role.getDbCode() == dbCode)
                .findFirst()
                .orElseThrow(() -> {
                    log.error("No Ride Status found by db code {}", dbCode);
                    throw new SystemException(INTERNAL_SERVER_ERROR_MESSAGE, INTERNAL_SERVER_ERROR);
                });
    }
}
