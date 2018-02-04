package com.revature.beans;
/**
 * 
 * @author Nabeela Hassan
 *
 */
public class UserBankAccount {

	private int userID;
	private int accountID;
	
	/**
	 * Creates a UserBankAccount with a user id and an account id
	 * @param userID
	 * @param accountID
	 */
	public UserBankAccount(int userID, int accountID) 
	{
		super();
		this.userID = userID;
		this.accountID = accountID;
	}

	/**
	 * no args constructor
	 */
	public UserBankAccount() 
	{
		super();
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the accountID
	 */
	public int getAccountID() {
		return accountID;
	}

	/**
	 * @param accountID the accountID to set
	 */
	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}
	
	
	
}
