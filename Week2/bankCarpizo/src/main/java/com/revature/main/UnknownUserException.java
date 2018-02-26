package com.revature.main;

public class UnknownUserException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2198102944623551559L;
	public UnknownUserException(String message)
	{
		super(message);
	}
}
