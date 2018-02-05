package com.revature.beans;

public class Employee {
	public Employee(int employeeId, String empFirstname, String empLastname, String department, String emp_email) {
		super();
		this.employeeId = employeeId;
		this.empFirstname = empFirstname;
		this.empLastname = empLastname;
		this.department = department;
		this.emp_email = emp_email;
	}
	private int employeeId;
	private String empFirstname;
	private String empLastname;
	private String department;
	private String emp_email;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmpFirstname() {
		return empFirstname;
	}
	public void setEmpFirstname(String empFirstname) {
		this.empFirstname = empFirstname;
	}
	public String getEmpLastname() {
		return empLastname;
	}
	public void setEmpLastname(String empLastname) {
		this.empLastname = empLastname;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empFirstname=" + empFirstname + ", empLastname=" + empLastname
				+ ", department=" + department + ", emp_email=" + emp_email + "]";
	}
}
