package com.revature.beans;

import java.util.List;

/**
 * @author Eric
 *
 */
public class Employee 
{
	
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private int managerId;
	private int isManager;
	private List<Request> requests;
	
	public Employee(int id, String firstname, String lastname, String email, String password, int managerId,
			int isManager, List<Request> requests) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.managerId = managerId;
		this.isManager = isManager;
		this.requests = requests;
	}

	public Employee(String firstname, String lastname, String email, String password, int managerId,
			int isManager, List<Request> requests) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.managerId = managerId;
		this.isManager = isManager;
		this.requests = requests;
	}

	public Employee() {}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	
	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", managerId=" + managerId + ", isManager=" + isManager + ", requests="
				+ requests.toString() + "]";
	}
}
