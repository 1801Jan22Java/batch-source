package com.revature.exceptions;

public class OverdraftException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7168679456912742268L;

	@Override
	public String getMessage() {
		return "Not enough money in account to withdraw given amount";
	}

}
