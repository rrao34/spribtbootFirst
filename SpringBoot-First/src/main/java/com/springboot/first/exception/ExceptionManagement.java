package com.springboot.first.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionManagement extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value=RecordNotFoundException.class)
	public ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			RecordNotFoundException ex, HttpStatus status) {
		return new ResponseEntity<>("Student not found", HttpStatus.NOT_FOUND);
	}
}
