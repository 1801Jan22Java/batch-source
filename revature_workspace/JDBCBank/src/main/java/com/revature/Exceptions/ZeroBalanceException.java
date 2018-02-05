package com.revature.Exceptions;

public class ZeroBalanceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5469482582822393585L;

	public ZeroBalanceException(String message){
		super(message);
}
}
