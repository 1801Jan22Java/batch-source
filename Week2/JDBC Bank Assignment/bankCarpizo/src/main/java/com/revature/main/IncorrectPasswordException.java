package com.revature.main;

public class IncorrectPasswordException extends Exception
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5183482055734150072L;
	public IncorrectPasswordException(String message)
	{
		super(message);
	}
}
