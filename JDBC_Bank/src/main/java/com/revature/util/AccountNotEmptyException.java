package com.revature.util;

public class AccountNotEmptyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4472275708588207193L;

	public AccountNotEmptyException() {
	}

	public AccountNotEmptyException(String arg0) {
		super(arg0);
	}

	public AccountNotEmptyException(Throwable arg0) {
		super(arg0);
	}

	public AccountNotEmptyException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public AccountNotEmptyException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
