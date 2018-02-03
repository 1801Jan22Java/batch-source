package com.revature.beans;

public final class SuperUserCredentials{

	private static final String username = "root";
	private static final String password = "I_AM_ROOT!";
	
	public static boolean verifyRoot(String username, String password) {
		return (SuperUserCredentials.username.equals(username) 
				&& SuperUserCredentials.password.equals(password));
	}

}
