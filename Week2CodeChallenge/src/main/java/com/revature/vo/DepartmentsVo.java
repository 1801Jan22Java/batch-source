package com.revature.vo;

public class DepartmentsVo {

	public int department_id;
	public String department_name;
	public int avg_salary;
	
	
	public DepartmentsVo() {
		super();
	}
	
	public DepartmentsVo(int department_id, String department_name, int avg_salary) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
		this.avg_salary = avg_salary;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public int getAvg_salary() {
		return avg_salary;
	}
	public void setAvg_salary(int avg_salary) {
		this.avg_salary = avg_salary;
	}
	@Override
	public String toString() {
		return "DepartmentsVo [department_id=" + department_id + ", department_name=" + department_name
				+ ", avg_salary=" + avg_salary + "]";
	}
	
}
