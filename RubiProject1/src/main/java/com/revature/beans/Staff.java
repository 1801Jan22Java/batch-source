package com.revature.beans;

public class Staff {
	
	private int employeeId;
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	private String username;
	private int isManager;
	private String strManager;
	private int reportsTo;
	
	public Staff() {
		super();
	}

	public Staff(int id, String lastName, String firstName, String email, String username,
			int isManager, int reportsTo) {
		super();
		this.employeeId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.username = username;
		this.isManager = isManager;
		this.reportsTo = reportsTo;
	}
	
	public Staff(int id, String lastName, String firstName, String email, String password, String username,
			int isManager, int reportsTo) {
		super();
		this.employeeId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
		this.username = username;
		this.isManager = isManager;
		this.reportsTo = reportsTo;
	}
	
	public Staff(int id, String lastName, String firstName, String email, String username, String strManager, int reportsTo) {
		super();
		this.employeeId = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.username = username;
		this.setStrManager(strManager);
		this.reportsTo = reportsTo;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int id) {
		this.employeeId = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	public int getReportsTo() {
		return reportsTo;
	}

	public void setReportsTo(int reportsTo) {
		this.reportsTo = reportsTo;
	}

	public String getStrManager() {
		return strManager;
	}

	public void setStrManager(String strManager) {
		this.strManager = strManager;
	}

	@Override
	public String toString() {
		return "Staff [id=" + employeeId + ", lastName=" + lastName + ", firstName=" + firstName + ", email=" + email
				+ ", password=" + password + ", username=" + username + ", isManager=" + isManager + ", reportsTo="
				+ reportsTo + "]";
	}
	
}
