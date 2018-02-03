package com.revature.util;

public class OverdraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 698938167784601458L;

	public OverdraftException() {
		
	}

	public OverdraftException(String message) {
		super(message);
	}

	public OverdraftException(Throwable cause) {
		super(cause);
	}

	public OverdraftException(String message, Throwable cause) {
		super(message, cause);
	}

	public OverdraftException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
