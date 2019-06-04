package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), request.getDescription(false),
				new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public final ResponseEntity<Object> handlePostNotFoundException(PostNotFoundException ex, WebRequest request)
			throws Exception {
		ExceptionDetails exceptionDetails = new ExceptionDetails(ex.getMessage(), request.getDescription(false),
				new Date());

		return new ResponseEntity<Object>(exceptionDetails, HttpStatus.NOT_FOUND);
	}

}
