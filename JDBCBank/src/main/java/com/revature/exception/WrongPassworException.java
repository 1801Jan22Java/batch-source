package com.revature.exception;

public class WrongPassworException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1647588021104816317L;

	public WrongPassworException (){
		System.out.println("The password is not right. please try again");
	}
}
