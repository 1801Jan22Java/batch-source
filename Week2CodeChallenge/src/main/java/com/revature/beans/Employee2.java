package com.revature.beans;

public class Employee2 {
	
	/*
	 * EMPLOYEE_ID, EMP_FIRSTNAME, EMP_LASTNAME, DEPARTMENT_ID, SALARY, EMP_EMAIL
	 * 
	 */
	
	int E_id;
	String fname;
	String lname;
	int department_id;
	int salary;
	String email;
	public int getE_id() {
		return E_id;
	}
	public void setE_id(int e_id) {
		E_id = e_id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee2(int e_id, String fname, String lname, int department_id, int salary, String email) {
		super();
		E_id = e_id;
		this.fname = fname;
		this.lname = lname;
		this.department_id = department_id;
		this.salary = salary;
		this.email = email;
	}
	public Employee2(String fname, String lname, int department_id, int salary, String email) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.department_id = department_id;
		this.salary = salary;
		this.email = email;
	}
	
}
