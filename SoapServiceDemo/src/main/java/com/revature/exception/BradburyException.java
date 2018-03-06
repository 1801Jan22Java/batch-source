package com.revature.exception;

public class BradburyException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -986522341637997027L;
	
	private String message = "subversive texts";
	
	public BradburyException(){
		super();
	}
	
	public BradburyException(String message){
		super(message);
	}
	
	

}
