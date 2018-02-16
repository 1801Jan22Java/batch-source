package com.revature.exceptions;

public class InvalidPasswordException extends Exception{
	
	private static final long serialVersionUID = -4844485922961447765L;

	public InvalidPasswordException(String str) {
		super(str);
	}
}