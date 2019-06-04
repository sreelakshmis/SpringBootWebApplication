package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MissingRequiredInputException extends RuntimeException {

	private static final long serialVersionUID = 2L;

	public MissingRequiredInputException(String arg0) {
		super(arg0);
	}
}
