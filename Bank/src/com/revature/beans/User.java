package com.revature.beans;


public class User {
	
	private int userID;
	private String firstname;
	private String middlename;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String email;
	private String phone;
	private String ssn;
	
	public User(int userID, String firstname, String middlename, String lastname, String address, String city,
			String state, String email, String phone, String ssn) 
	{
		super();
		this.userID = userID;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
	}

	/**
	 * 
	 * @param firstname
	 * @param middlename
	 * @param lastname
	 * @param address
	 * @param city
	 * @param state
	 * @param email
	 * @param phone
	 * @param ssn
	 */
	public User(String firstname, String middlename, String lastname, String address, String city, String state,
			String email, String phone, String ssn) 
	{
		super();
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.address = address;
		this.city = city;
		this.state = state;
		this.email = email;
		this.phone = phone;
		this.ssn = ssn;
	}

	/**
	 * 
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the middlename
	 */
	public String getMiddlename() {
		return middlename;
	}

	/**
	 * @param middlename the middlename to set
	 */
	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
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
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/* 
	 * 
	 */
	@Override
	public String toString() {
		return "User [userID=" + userID + ", firstname=" + firstname + ", middlename=" + middlename + ", lastname="
				+ lastname + ", address=" + address + ", city=" + city + ", state=" + state + ", email=" + email
				+ ", phone=" + phone + ", ssn=" + ssn + "]";
	}
	
	
	
	
	
}
