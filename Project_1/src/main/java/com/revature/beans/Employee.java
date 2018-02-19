package com.revature.beans;

import java.util.List;

public class Employee {

	private int id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private EmployeeTitle title;
	private String email;
	private List<ReimbursementRequest> requests;

	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String userName,
			String password, EmployeeTitle title, String email,
			List<ReimbursementRequest> requests) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.title = title;
		this.email = email;
		this.requests = requests;
	}

	public Employee(int id, String firstName, String lastName, String userName,
			String password, EmployeeTitle title, String email,
			List<ReimbursementRequest> requests) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.title = title;
		this.email = email;
		this.requests = requests;
	}

	public int getId() {
		return id;
	}

	public Employee setId(int id) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public String getFirstName() {
		return firstName;
	}

	public Employee setFirstName(String firstName) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public String getLastName() {
		return lastName;
	}

	public Employee setLastName(String lastName) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public String getUserName() {
		return userName;
	}

	public Employee setUserName(String userName) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public String getPassword() {
		return password;
	}

	public Employee setPassword(String password) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public EmployeeTitle getTitle() {
		return title;
	}

	public Employee setTitle(EmployeeTitle title) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public String getEmail() {
		return email;
	}

	public Employee setEmail(String email) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

	public List<ReimbursementRequest> getRequests() {
		return requests;
	}

	public Employee setRequests(List<ReimbursementRequest> requests) {
		return new Employee(id, firstName, lastName, userName, password, title,
				email, requests);
	}

}
