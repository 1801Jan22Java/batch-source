package com.revature.util;

public class UserNameExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3129498241007695884L;

	private String message = "Username already exists. \n Please choose a different username.";

	public UserNameExistsException(String message) {
		this.message = message;
	}

	public UserNameExistsException() {
		super();
	}

	public String getMessage() {
		return message;
	}

	public UserNameExistsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserNameExistsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserNameExistsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
