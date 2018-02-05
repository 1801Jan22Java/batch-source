package com.revature.exception;

public class NotExistAccountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5121017129493783882L;

	public NotExistAccountException() {
		System.out.println("The account does not exist.");
	}
}
