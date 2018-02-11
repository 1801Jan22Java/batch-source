package com.revature.project1.beans;

public class Employee {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private int isManager;
	private int managerID;
	
	public Employee() 
	{}
	public Employee(String firstName, String lastName, String userName,String password, int isManager, int managerID)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.isManager=isManager;
		this.managerID=managerID;
	}
	public Employee(String firstName, String lastName, String userName,String password)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.isManager=1;
		
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsManager() {
		return isManager;
	}
	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}
	public int getManagerID() {
		return managerID;
	}
	public void setManagerID(int managerID) {
		this.managerID = managerID;
	}
	public Employee getManager() {
		return null
	}
}
