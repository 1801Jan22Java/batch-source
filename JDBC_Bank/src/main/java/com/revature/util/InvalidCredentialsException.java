package com.revature.util;

public class InvalidCredentialsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4389541543679968648L;

	public InvalidCredentialsException() {
	}

	public InvalidCredentialsException(String arg0) {
		super(arg0);
	}

	public InvalidCredentialsException(Throwable arg0) {
		super(arg0);
	}

	public InvalidCredentialsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public InvalidCredentialsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
