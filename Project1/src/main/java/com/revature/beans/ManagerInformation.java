package com.revature.beans;

public class ManagerInformation {
	
	private int managerInformationId;
	private String email;
	private String fname;
	private String lname;
	private String address;
	
	public ManagerInformation() {
		super();
	}
	
	public ManagerInformation(int managerInformationId, String email, String fname, String lname, String address) {
		super();
		this.managerInformationId = managerInformationId;
		this.email = email;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
	}

	public int getManagerInformationId() {
		return managerInformationId;
	}

	public void setManagerInformationId(int managerInformationId) {
		this.managerInformationId = managerInformationId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ManagerInformation [managerInformationId=" + managerInformationId + ", email=" + email + ", fname="
				+ fname + ", lname=" + lname + ", address=" + address + "]";
	}

}
