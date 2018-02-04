package com.revature.exceptions;

public class WrongUsernameOrPasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5431679845685048721L;

	@Override
	public String getMessage() {
		return "Incorrect Username or Password.";
	}
	
}
