package com.jvirriel.testrestful.backend.configuration.exception;

import com.jvirriel.testrestful.backend.configuration.logger.LoggerProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    private final LoggerProducer producer;

    @Autowired
    public RestResponseEntityExceptionHandler(LoggerProducer producer) {
        this.producer = producer;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class, IllegalStateException.class})
    protected ResponseEntity<?> handleIllegalArgumentException(RuntimeException runtimeException, WebRequest request) {
        producer.log(runtimeException);

        return getResponseEntity("Error del Sistema.", SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception exception, WebRequest request) {
        producer.log(exception);

        return getResponseEntity("Error interno del servidor.", INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<?> getResponseEntity(String errorMessage, HttpStatus httpStatus) {
        return new ResponseEntity<>(CustomErrorType.get(errorMessage), httpStatus);
    }
}