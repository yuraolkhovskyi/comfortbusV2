package com.transportation.comfortbus.exception.advice;

import com.transportation.comfortbus.exception.SystemException;
import com.transportation.comfortbus.exception.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(value = SystemException.class)
    public Object handleSystemException(final SystemException systemException) {
        log.error("System exception occurred. " + systemException);
        final ErrorDTO errorDTO = new ErrorDTO(systemException);
        return new ResponseEntity<>(errorDTO, HttpStatusCode.valueOf(errorDTO.getHttpStatusCode()));
    }


}
