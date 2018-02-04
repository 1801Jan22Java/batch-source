package com.revature.beans;


public class User {
	
	private int userID;
	private String address;
	private String city;
	private String state;
	private String email;
	private int phone;
	private int ssn;
	
	/**
	 * 
	 * @param userID
	 * @param address
	 * @param city
	 * @param state
	 * @param email
	 * @param phone
	 * @param ssn
	 */
	public User(int userID, String address, String city, String state, String email, int phone, int ssn) 
	{
		super();
		this.userID = userID;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
	}

	/**
	 * 
	 * @param address
	 * @param city
	 * @param state
	 * @param email
	 * @param phone
	 * @param ssn
	 */
	public User(String address, String city, String state, String email, int phone, int ssn) {
		super();
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
	}
	
	
	/**
	 * no args constructor
	 */
	public User() 
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}


	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}


	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}


	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}


	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}


	/**
	 * @return the ssn
	 */
	public int getSsn() {
		return ssn;
	}


	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	
}
