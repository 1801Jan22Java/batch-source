package com.revature.exceptions;

public class BalanceNotEmptyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8261371544298341945L;

	public BalanceNotEmptyException(String str) {
		super(str);
	}

}
