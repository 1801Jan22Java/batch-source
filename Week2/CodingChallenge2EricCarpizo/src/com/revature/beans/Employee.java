package com.revature.beans;

public class Employee {
	private int id;
	private String firstname;
	private String lastname;
	private Department department;
	private int salary;
	private String email;
	
	public Employee(String firstname, String lastname, Department department, int salary, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.salary = salary;
		this.email = email;
	}
	
	public Employee(int id, String firstname, String lastname, Department department, int salary, String email) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.salary = salary;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", department="
				+ department + ", salary=" + salary + ", email=" + email + "]";
	}
}
