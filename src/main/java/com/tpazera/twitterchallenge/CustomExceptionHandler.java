package com.tpazera.twitterchallenge;

import java.util.Date;

import javax.management.BadAttributeValueExpException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(BadAttributeValueExpException.class)
  public final ResponseEntity<ErrorDetails> handleUserNotFoundException(BadAttributeValueExpException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.toString(),
        request.getDescription(false));
    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
  }
}