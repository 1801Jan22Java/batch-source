package com.revature.beans;

public class Employee {
	private int employee_id;
	private String employee_fname;
	private String employee_lname;
	private int department_id;
	private double salary;
	private String employee_email;
	
	public Employee() {
		super();
	}
	
	public Employee(int employee_id, String employee_fname, String employee_lname, int department_id, double salary,
			String employee_email) {
		super();
		this.employee_id = employee_id;
		this.employee_fname = employee_fname;
		this.employee_lname = employee_lname;
		this.department_id = department_id;
		this.salary = salary;
		this.employee_email = employee_email;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getEmployee_fname() {
		return employee_fname;
	}

	public void setEmployee_fname(String employee_fname) {
		this.employee_fname = employee_fname;
	}

	public String getEmployee_lname() {
		return employee_lname;
	}

	public void setEmployee_lname(String employee_lname) {
		this.employee_lname = employee_lname;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_fname=" + employee_fname + ", employee_lname="
				+ employee_lname + ", department_id=" + department_id + ", salary=" + salary + ", employee_email="
				+ employee_email + "]";
	}
	
}
