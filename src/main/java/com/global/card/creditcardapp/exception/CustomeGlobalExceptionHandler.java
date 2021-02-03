package com.global.card.creditcardapp.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

/**
 * This class is  to define handle global exception.
 */

@ControllerAdvice
public class CustomeGlobalExceptionHandler {


    @ExceptionHandler(CardAlreadyExistsException.class)
    protected ResponseEntity<Object> handleCardAlreadyExistsException(
            CardAlreadyExistsException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
                "Card already exist");
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {
        ErrorDetails errorDetails = new ErrorDetails(new Date(), "Validation Failed",
                ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}

