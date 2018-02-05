package com.revature.beans;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private int depId;
	private int salary;
	private String email;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, int depId, int salary, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.depId = depId;
		this.salary = salary;
		this.email = email;
	}

	public Employee(int id, String firstName, String lastName, int depId, int salary, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.depId = depId;
		this.salary = salary;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getDepId() {
		return depId;
	}

	public void setDepId(int depId) {
		this.depId = depId;
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

}
