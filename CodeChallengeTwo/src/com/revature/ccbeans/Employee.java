package com.revature.ccbeans;

public class Employee {
	private int    employeeID;
	private String firstName;
	private String lastName;
	private int    salary;
	private String email;
	private int    deptID;
	
	public Employee() {
		super();
	}
	
	public Employee(int empID, String first, String last, int sal, String email, int deptID) {
		this.employeeID = empID;
		this.firstName  = first;
		this.lastName   = last;
		this.salary     = sal;
		this.email      = email;
		this.deptID		= deptID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}
}
