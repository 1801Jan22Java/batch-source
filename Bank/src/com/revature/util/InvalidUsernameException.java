package com.revature.util;

public class InvalidUsernameException extends Exception{

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = 4427561735094628251L;

	public InvalidUsernameException()
	{
		super("The username you are trying to create already exists");
	}
}
