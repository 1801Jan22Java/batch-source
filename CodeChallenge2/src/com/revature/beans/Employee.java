package com.revature.beans;

public class Employee {
	
	private String f_Name,l_Name,email;
	private int salary,department_id,employee_id;
	
	public Employee() {
		super();
	}
	
	public Employee(int employee_id,String f_Name,String l_name,int department_id,int salary,String email) {
		this.f_Name = f_Name;
		this.employee_id = employee_id;
		this.l_Name = l_Name;
		this.department_id = department_id;
		this.salary = salary;
		this.email = email;
	}
	
	public String getF_Name() {
		return f_Name;
	}
	public void setF_Name(String f_Name) {
		this.f_Name = f_Name;
	}
	public String getL_Name() {
		return l_Name;
	}
	public void setL_Name(String l_Name) {
		this.l_Name = l_Name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	@Override
	public String toString() {
		return "Employee [f_Name=" + f_Name + ", l_Name=" + l_Name + ", email=" + email + ", salary=" + salary
				+ ", department_id=" + department_id + ", employee_id=" + employee_id + "]";
	}
	
 
	
}
