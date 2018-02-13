package com.revature.beans;

public class Manager {
	
	private int managerId;
	private String username;
	private String password;
	private int managerInformationId;
	
	public Manager() {
		super();
	}

	public Manager(int managerId, String username, String password, int managerInformationId) {
		super();
		this.managerId = managerId;
		this.username = username;
		this.password = password;
		this.managerInformationId = managerInformationId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getManagerInformationId() {
		return managerInformationId;
	}

	public void setManagerInformationId(int managerInformationId) {
		this.managerInformationId = managerInformationId;
	}

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", username=" + username + ", password=" + password
				+ ", managerInformationId=" + managerInformationId + "]";
	}


}
