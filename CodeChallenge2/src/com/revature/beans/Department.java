package com.revature.beans;

public class Department {
	private int department_Id;
	private String department_Name;
	
	public Department() {
		super();
	}
	
	public Department(int department_Id, String department_Name) {
		this.department_Id = department_Id;
		this.department_Name = department_Name;
	}

	public int getDepartment_Id() {
		return department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		this.department_Id = department_Id;
	}

	public String getDepartment_Name() {
		return department_Name;
	}

	public void setDepartment_Name(String department_Name) {
		this.department_Name = department_Name;
	}
	
	

}
