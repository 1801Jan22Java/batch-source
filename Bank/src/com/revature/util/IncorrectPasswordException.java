package com.revature.util;

public class IncorrectPasswordException extends Exception {

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -1653785124170202380L;

	public IncorrectPasswordException()
	{
		super("The password entered was incorrect");
	}
}
