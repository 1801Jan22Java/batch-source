package com.revature.beans;

public class Employee {
	private double salary;

	private int employee_id;
	private String firstname;
	private String lastname;
	private int department_id;
	private String email;
	
	

	public Employee(double salary, int employee_id, String firstname, String lastname, int department_id,
			String email) {
		super();
		this.salary = salary;
		this.employee_id = employee_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department_id = department_id;
		this.email = email;
	}

	public Employee() {
		super();
	}
	
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
