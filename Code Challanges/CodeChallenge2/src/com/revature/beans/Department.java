package com.revature.beans;

public class Department {

	public Department(int departmentID, String departmentName) {
		super();
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}

	public Department() {
		departmentName = "Uninitialized";
	}

	private int departmentID;
	private String departmentName;

	public int getDepartmentID() {
		return departmentID;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
