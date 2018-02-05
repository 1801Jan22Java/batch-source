package com.revature.beans;

public class Department {

	public Department(int depID, String depName) {
		super();
		this.depID = depID;
		this.depName = depName;
	}
	
	private int depID;
	private String depName;
	
	public int getDepID() {
		return depID;
	}
	public void setDepID(int depID) {
		this.depID = depID;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	
}
