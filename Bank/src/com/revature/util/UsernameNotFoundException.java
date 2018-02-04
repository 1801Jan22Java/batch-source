package com.revature.util;

public class UsernameNotFoundException extends Exception{

	/**
	 * generated serial id
	 */
	private static final long serialVersionUID = -7596215354008730285L;
	
	public UsernameNotFoundException()
	{
		super("The username entered does not match any records");
	}

}
