package com.example.fleetapi.domain.exceptions;


import com.example.fleetapi.domain.exceptions.driver.DriverAlreadyExistsException;
import com.example.fleetapi.domain.exceptions.driver.DriverInRouteException;
import com.example.fleetapi.domain.exceptions.driver.DriverNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DriverAlreadyExistsException.class)
    protected ResponseEntity<Issue> DriverAlreadyExists(final DomainException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getIssue());
    }

    @ExceptionHandler(DriverInRouteException.class)
    protected ResponseEntity<Issue> DriverInRoute(final DomainException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getIssue());
    }

    @ExceptionHandler(DriverNotFoundException.class)
    protected ResponseEntity<Issue> DriverNotFound(final DomainException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getIssue());
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    protected ResponseEntity<Issue> InvalidDateFormat(final DomainException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getIssue());
    }


}
