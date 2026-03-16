package com.joel.projectManagement.exception;

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

    @ExceptionHandler(MethodArgumentNotValidException.class) public ResponseEntity<List<PMSError>> handleValidation (MethodArgumentNotValidException methodArgumentNotValidException){
        List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
        List<PMSError> pmsErrors = new ArrayList<>();
        fieldErrors.forEach((fieldError) -> pmsErrors.add(new PMSError(fieldError.getCode(), fieldError.getDefaultMessage())));
        return new ResponseEntity(pmsErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PMSException.class)
    public ResponseEntity<List<PMSError>> handle (PMSException pmsException) {
        return new ResponseEntity(pmsException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
