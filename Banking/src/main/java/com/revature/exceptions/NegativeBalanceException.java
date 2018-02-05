package com.revature.exceptions;

public class NegativeBalanceException extends Exception{
	public NegativeBalanceException(String str) {
		super(str);
	}
}