package com.revature.main;

public class OverdraftException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1499622323854094139L;
	public OverdraftException(String message)
	{
		super(message);
	}
}
