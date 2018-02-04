package com.revature.util;

public class AccountOverdraftException extends Exception {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -7629936883598111861L;
	
	public AccountOverdraftException()
	{
		super("There are not enough funds in this account to make that withdrawal");
	}
}
