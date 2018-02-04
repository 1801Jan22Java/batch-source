package com.revature.util;

public class InvalidTransactionIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3779743859405845882L;

	public InvalidTransactionIdException() {

	}

	public InvalidTransactionIdException(String arg0) {
		super(arg0);

	}

	public InvalidTransactionIdException(Throwable arg0) {
		super(arg0);

	}

	public InvalidTransactionIdException(String arg0, Throwable arg1) {
		super(arg0, arg1);

	}

	public InvalidTransactionIdException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);

	}

}
