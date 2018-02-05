package com.revature.beans;

public class Department {

	/*
	DEPARTMENT_ID INT,
	DEPARTMENT_NAME VARCHAR(255),
	*/
	
	private int id;
	private String name;
	
	public Department(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
