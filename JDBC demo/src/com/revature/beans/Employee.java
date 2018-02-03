package com.revature.beans;

public class Employee {
	
	public int id;
	public String fname;
	public String lname;
	
	public Employee(int id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}
	
	public String toString() {
		return id + " " + fname + " " + lname;
	}
	
}
