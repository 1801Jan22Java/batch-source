package com.revature.ccbeans;

public class Department {
	private int deptID;
	private String deptName;
	
	public Department() {
		super();
	}
	
	public Department(int deptID, String deptName) {
		this.deptID   = deptID;
		this.deptName = deptName;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
}
