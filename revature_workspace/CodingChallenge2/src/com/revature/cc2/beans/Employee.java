package com.revature.cc2.beans;

public class Employee {
	private String firstName;
	private String lastName;
	private float salary;
	private String email;
	
	public Employee(){}
	public Employee(String fname, String lname, float sal, String eml)
	{
		firstName=fname;
		lastName= lname;
		salary=sal;
		email=eml;
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
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
