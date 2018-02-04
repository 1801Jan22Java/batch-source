package com.revature.exceptions;

public class NegativeAmountException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1319942250518374418L;

	
	@Override
	public String getMessage() {
		return "Amount cannot be negtive or zero";
	}
	
}
