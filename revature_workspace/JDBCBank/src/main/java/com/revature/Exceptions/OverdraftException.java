package com.revature.Exceptions;

public class OverdraftException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2726202474664985363L;

	public OverdraftException(String message){
		super(message);
	}

}
