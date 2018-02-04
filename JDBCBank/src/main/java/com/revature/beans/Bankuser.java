package com.revature.beans;

public class Bankuser {
	
	private int bankuserID;
	private String ssn;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	
	public Bankuser() {
		super();
	}
	
	public Bankuser(String ssn, String firstName, String lastName, String address, String email) {
		super();
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}
	public Bankuser(int bankuserID, String ssn, String firstName, String lastName, String address, String email) {
		super();
		this.bankuserID = bankuserID;
		this.ssn = ssn;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
	}

	public int getBankuserID() {
		return bankuserID;
	}

	public void setBankuserID(int bankuserID) {
		this.bankuserID = bankuserID;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Bankuser [bankuserID=" + bankuserID + ", ssn=" + ssn + ", firstName=" + firstName + ", lastName="
				+ lastName + ", address=" + address + ", email=" + email + "]";
	}
	
}
