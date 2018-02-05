package com.revature.exceptions;

public class UserTakenException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2320026981645439136L;

	public UserTakenException(String str) {
		super(str);
	}
}
