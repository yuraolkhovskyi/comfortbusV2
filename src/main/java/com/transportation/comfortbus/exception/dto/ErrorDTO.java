package com.transportation.comfortbus.exception.dto;

import com.transportation.comfortbus.exception.SystemException;
import com.transportation.comfortbus.exception.code.ErrorCode;
import lombok.Data;

@Data
public class ErrorDTO {

    private ErrorCode errorCode;
    private int httpStatusCode;
    private String message;

    public ErrorDTO(final SystemException systemException) {
        final ErrorCode errorObject = systemException.getErrorCode();
        this.errorCode = errorObject;
        this.httpStatusCode = errorObject.getHttpStatusCode();
        this.message = systemException.getMessage();
    }

}
