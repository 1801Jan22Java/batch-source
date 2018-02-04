package com.revature.util;

public class LoginNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5415246660943752902L;
	
	private String message;
	
	public LoginNotValidException() {
		super();
		this.message = "Invaid password or username.";
	}

	public LoginNotValidException(String message) {
		super();
		this.message = message;
	}



	public String getMessage() {
		return message;
	}
	
	

}
