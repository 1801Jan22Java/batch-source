package com.revature.beans;

public class Employee {
		/*
		EMPLOYEE_ID INT,
		EMP_FIRSTNAME VARCHAR(255),
		EMP_LASTNAME VARCHAR(255),
		DEPARTMENT_ID INT,
		SALARY INT,
		EMP_EMAIL VARCHAR(255),
		 */
	
	private int id;
	private String firstName;
	private String lastName;
	private int dep_id;
	private int salary;
	private String email;
	
	public Employee(int id, String firstName, String lastName, int dep_id, int salary, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dep_id = dep_id;
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

	public int getDep_id() {
		return dep_id;
	}

	public void setDep_id(int dep_id) {
		this.dep_id = dep_id;
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
