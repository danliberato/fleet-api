package com.example.fleetapi.domain.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DriverAlreadyExistsException.class)
    @ResponseStatus(value = HttpStatus.CONFLICT)
    protected ResponseEntity<Issue> exceptionLogError(final DomainException ex) {
        return ResponseEntity.badRequest().body(ex.getIssue());
    }


}
