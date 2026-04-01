package com.joel.propertyManagement.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class PMSExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<List<PMSError>> handleValidation (MethodArgumentNotValidException methodArgumentNotValidException){
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        List<PMSError> pmsErrors = new ArrayList<>();
        fieldErrors.forEach((fieldError) -> {
            logger.error("Inside field validation: {} - {}", fieldError.getField(), fieldError.getDefaultMessage());
            pmsErrors.add(new PMSError(fieldError.getCode(), fieldError.getDefaultMessage()));
        });
        return new ResponseEntity(pmsErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PMSException.class)
    public ResponseEntity<List<PMSError>> handle (PMSException pmsException) {
        pmsException.getErrors().forEach(error -> {
            logger.error("PMS exception: {} - {}", error.getCode(), error.getMessage());
        });
        return new ResponseEntity(pmsException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
