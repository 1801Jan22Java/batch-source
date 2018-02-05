package com.revature.beans;
/**
 * Class uses an integer id to store the different account types there are in the bank 
 * @author Nabeela Hassan
 *
 */
public class AccountType{
	
	private int id;
	private String type;
	
	/**
	 * constructor that initializes id and type
	 * @param id
	 * @param type
	 */
	public AccountType(int id, String type) 
	{
		super();
		this.id = id;
		this.type = type;
	}
	
	/**
	 * constructor that initializes type
	 * @param type
	 */
	public AccountType(String type) {
		super();
		this.type = type;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/* 
	 *
	 */
	@Override
	public String toString() {
		return "AccountType [id=" + id + ", type=" + type + "]";
	}
	
	
	

}
