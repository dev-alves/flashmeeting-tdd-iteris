package com.tdd.domain.exceptions.handlers;

import com.tdd.domain.exceptions.BirthDateException;
import com.tdd.domain.exceptions.ItemNotFoundException;
import com.tdd.domain.exceptions.OrderNotFoundException;
import com.tdd.domain.exceptions.PersonNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class CustomHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BirthDateException.class)
    public final ResponseEntity<StandartError> handleBirthDateException(BirthDateException ex, WebRequest request){
        StandartError err = new StandartError(HttpStatus.FORBIDDEN.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }
    @ExceptionHandler(ItemNotFoundException.class)
    public final ResponseEntity<StandartError> handleItemNotFound(ItemNotFoundException ex, WebRequest request){
        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public final ResponseEntity<StandartError> handleBirthDateException(OrderNotFoundException ex, WebRequest request){
        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
    @ExceptionHandler(PersonNotFoundException.class)
    public final ResponseEntity<StandartError> handleBirthDateException(PersonNotFoundException ex, WebRequest request){
        StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(),ex.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
