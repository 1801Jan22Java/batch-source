package com.revature.beans;

public class Users {

	//Constructors
	public Users() {}
	
	public Users(int userID, String userAccount, String userFName, String userLName, String userPassword,
			int userType) {
		super();
		this.userID = userID;
		this.userAccount = userAccount;
		this.userFName = userFName;
		this.userLName = userLName;
		this.userPassword = userPassword;
		this.userType = userType;
	}
	
	//Variables
	private int userID;
	private String userAccount;
	private String userFName;
	private String userLName;
	private String userPassword;
	private int userType;
	public int getUserID() {
		return userID;
	}

	//Getters and Setters
	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	//toString
	@Override
	public String toString() {
		
		/*return "Users [userID=" + userID + ", userAccount=" + userAccount + ", userFName=" + userFName + ", userLName="
				+ userLName + ", userPassword=" + userPassword + ", userType=" + userType + "]";*/
		
		String userT;
		if (userType == 1)
			userT = "Super User Bob Dole, the best, better than the rest, yes your almighty lord";
		else
			userT = "Customer";
		
		return String.format("%s Account: %s         Password: %s        User ID: %d       Name on Account: %s %s", userT, userAccount, userPassword, userID, userFName, userLName);
		
	
	}
	
	
	
}
