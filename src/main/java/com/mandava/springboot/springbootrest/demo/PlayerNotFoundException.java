package com.mandava.springboot.springbootrest.demo;

public class PlayerNotFoundException extends RuntimeException {

	public PlayerNotFoundException() {
		super();
	}

	public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PlayerNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PlayerNotFoundException(String message) {
		super(message);
	}

}
