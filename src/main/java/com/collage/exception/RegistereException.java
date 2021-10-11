package com.collage.exception;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.ALREADY_REPORTED)
public class RegistereException extends SQLException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RegistereException(String message) {
		super(message);
	}
	
}
