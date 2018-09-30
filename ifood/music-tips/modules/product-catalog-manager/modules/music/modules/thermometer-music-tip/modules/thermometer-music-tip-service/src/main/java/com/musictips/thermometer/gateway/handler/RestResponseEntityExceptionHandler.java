package com.musictips.thermometer.gateway.handler;

import com.musictips.thermometer.gateway.model.ErrorResponseModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.concurrent.atomic.AtomicReference;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        AtomicReference<Integer> errorIndex = new AtomicReference<>(0);
        ErrorResponseModel errorResponseModel = ErrorResponseModel.builder().build();
        ex.getAllErrors().stream().forEach(error -> {
            errorIndex.getAndSet(errorIndex.get() + 1);
            errorResponseModel.getMessages().put(errorIndex.get().toString(), error.getDefaultMessage());
        });

        return handleExceptionInternal(ex, errorResponseModel, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
