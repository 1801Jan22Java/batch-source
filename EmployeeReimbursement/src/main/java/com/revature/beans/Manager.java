package com.revature.beans;

public class Manager extends Employee{
	
	private int managerID;

	
	public Manager() {}
	
	public Manager(int id, String firstName, String lastName, String email, String password, int managerID) {
		super(id, firstName, lastName, email, password);
		this.managerID = managerID;
	}
	
	
	public int getManagerID() {
		return managerID;
	}

	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	
	
}
