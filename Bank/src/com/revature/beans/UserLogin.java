package com.revature.beans;

public class UserLogin {
	
	int userID;
	String username;
	String password;
	/**
	 * Creates a UserLogin with a user id, username and password
	 * @param userID
	 * @param username
	 * @param password
	 */
	public UserLogin(int userID, String username, String password) 
	{
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
	}

	/**
	 * Creates a UserLogin with a username and password
	 * @param username 
	 * @param password
	 */
	public UserLogin(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * no args constructor
	 */
	public UserLogin() 
	{
		super();
		
	}

	/**
	 * @return the userID
	 */
	public int getUserID() 
	{
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) 
	{
		this.userID = userID;
	}

	/**
	 * @return the username
	 */
	public String getUsername() 
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) 
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() 
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) 
	{
		this.password = password;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserLogin [userID=" + userID + ", username=" + username + ", password=" + password + "]";
	}
	
}
