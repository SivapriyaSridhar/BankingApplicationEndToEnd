package com.bankingManagementSystem.endToEnd.exception;

import com.bankingManagementSystem.endToEnd.entity.ErrorDetail;
import com.bankingManagementSystem.endToEnd.model.ErrorResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandler {
  public static final long FAILED = -1;

  @ExceptionHandler(value = NoSuchElementException.class)
  public ResponseEntity<ErrorDetail> handler(NoSuchElementException ex) {
    ErrorDetail error = new ErrorDetail();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ErrorResponseBody> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex) {
    List<String> details = new ArrayList<>();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      details.add(error.getDefaultMessage());
    }
    ErrorResponseBody error = new ErrorResponseBody();
    error.setStatus(HttpStatus.NOT_FOUND.value());
    error.setMessage(details.toString());
    return new ResponseEntity<ErrorResponseBody>(error, HttpStatus.BAD_REQUEST);
  }
}
