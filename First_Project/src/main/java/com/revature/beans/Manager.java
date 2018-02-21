package com.revature.beans;

public class Manager {
	private int Manager_Id, Department_Id, Role_Id,Employee_Id;
	
	public Manager() {
		super();
	}

	public Manager(int manager_Id, int department_Id, int role_Id, int employee_Id) {
		super();
		Manager_Id = manager_Id;
		Department_Id = department_Id;
		Role_Id = role_Id;
		Employee_Id = employee_Id;
	}

	public int getManager_Id() {
		return Manager_Id;
	}

	public void setManager_Id(int manager_Id) {
		Manager_Id = manager_Id;
	}

	public int getDepartment_Id() {
		return Department_Id;
	}

	public void setDepartment_Id(int department_Id) {
		Department_Id = department_Id;
	}

	public int getRole_Id() {
		return Role_Id;
	}

	public void setRole_Id(int role_Id) {
		Role_Id = role_Id;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
	}


}
