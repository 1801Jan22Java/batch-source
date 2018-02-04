package com.revature.beans;
/**
 * Class uses an integer id to store the different account types there are in the bank 
 * @author Nabeela Hassan
 *
 */
public class AccountType{
	
	private int id;
	/**
	 * constructor that initializes id
	 * @param id
	 */
	public AccountType(int id) {
		super();
		this.id = id;
	}
	
	/**
	 * no args constructor
	 */
	public AccountType() {
		super();
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	

}
