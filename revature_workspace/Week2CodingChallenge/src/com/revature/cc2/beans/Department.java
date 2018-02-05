package com.revature.cc2.beans;

public class Department {
	private String deptName;
	
	public Department(){}
	public Department (String name)
	{
		deptName=name;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
