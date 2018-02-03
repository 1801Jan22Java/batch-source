package com.revature.beans;

public final class SuperUser extends AbstractUser {
	public SuperUser() {
		super();
		verified = false;
	}
	
	static boolean verified;
	
	public boolean rootLogin(String username, String password) {
		return SuperUserCredentials.verifyRoot(username, password);
	}
	
	public void rootLogout() {
		verified = false;
	}
}
