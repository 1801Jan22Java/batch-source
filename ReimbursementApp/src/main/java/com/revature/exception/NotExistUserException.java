package com.revature.exception;

public class NotExistUserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3216815177640705621L;

	public NotExistUserException() {
		System.out.println("The username does not exist. please try again");
	}
}
