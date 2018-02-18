package com.revature.project1.beans;

public class Employee {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private int isManager;
	private Employee manager;
	private int employeeID;
	
	public Employee() 
	{}
	public Employee(String firstName, String lastName, String userName,String password,String email, int isManager, Employee manager)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.email=email;
		this.isManager=isManager;
		this.manager=manager;
	}
	public Employee(String firstName, String lastName, String userName,String password,String email, int isManager, Employee manager, int empID)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.email=email;
		this.isManager=isManager;
		this.manager=manager;
		this.employeeID=empID;
	}
	public Employee(String firstName, String lastName, String userName,String password,String email)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.userName=userName;
		this.password=password;
		this.email=email;
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
	public Employee getManagerID() {
		return manager;
	}
	public void setManagerID(Employee manager) {
		this.manager = manager;
	}
	public Employee getManager() {
		return manager;
	}
	public void setEmail(String email) 
	{
		this.email=email;
	}
	public String getEmail() 
	{
		return this.email;
	}
	@Override
	public String toString() {
		return "Employee name=" + firstName + " " + lastName 
				+ ", userName=" + userName + ", password="
				+ password + ", email=" + email + "\n isManager=" 
				+ isManager + ", managerID=" + manager;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	
}
