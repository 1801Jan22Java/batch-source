package com.revature.util;

public class InvalidAccountIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3324557974145563088L;

	public InvalidAccountIdException() {

	}

	public InvalidAccountIdException(String message) {
		super(message);

	}

	public InvalidAccountIdException(Throwable cause) {
		super(cause);

	}

	public InvalidAccountIdException(String message, Throwable cause) {
		super(message, cause);

	}

	public InvalidAccountIdException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

}
