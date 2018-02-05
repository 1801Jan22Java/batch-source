package com.revature.exception;

public class NotEnoughBalanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7334703087796426356L;

	public NotEnoughBalanceException() {
		System.out.println("balance is not enough to withdraw. please try again.");
	}
}
