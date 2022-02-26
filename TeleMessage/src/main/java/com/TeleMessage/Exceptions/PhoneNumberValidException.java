package com.TeleMessage.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (value = HttpStatus.NOT_FOUND)
public class PhoneNumberValidException extends Exception {

	
	/**
	 * Default Serial Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new Resource not found exception.
	 *
	 * @param message the message
	 */
	public PhoneNumberValidException(String message) {
		super(message);
	}
}
