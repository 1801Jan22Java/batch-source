package com.revature.beans;

public class Department2 {

	/*
	 * DEPARTMENT_ID, DEPARTMENT_NAME
	 */
	
	int d_id;
	String name;
	public int getD_id() {
		return d_id;
	}
	public void setD_id(int d_id) {
		this.d_id = d_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department2(String name) {
		super();
		this.name = name;
	}
	public Department2(int d_id, String name) {
		super();
		this.d_id = d_id;
		this.name = name;
	}
	
}
