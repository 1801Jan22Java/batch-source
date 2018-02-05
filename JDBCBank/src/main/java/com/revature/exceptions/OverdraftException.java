package com.revature.exceptions;

public class OverdraftException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2745236804089000969L;

	public OverdraftException(String str) {
		super(str);
	}
	
}
