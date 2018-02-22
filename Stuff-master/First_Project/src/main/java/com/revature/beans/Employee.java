package com.revature.beans;

public class Employee {
	private int Employee_Id, Department_Id,Role_Id;
	private String First_Name, Last_Name, E_Mail, Username, Password;

	public Employee() {
		super();
	}

	public Employee(int employee_Id, int department_Id, int role_Id, String first_Name, String last_Name, String e_Mail,
			String username, String password) {
		super();
		Employee_Id = employee_Id;
		Department_Id = department_Id;
		Role_Id = role_Id;
		First_Name = first_Name;
		Last_Name = last_Name;
		E_Mail = e_Mail;
		Username = username;
		Password = password;
	}

	public int getEmployee_Id() {
		return Employee_Id;
	}

	public void setEmployee_Id(int employee_Id) {
		Employee_Id = employee_Id;
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

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getE_Mail() {
		return E_Mail;
	}

	public void setE_Mail(String e_Mail) {
		E_Mail = e_Mail;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Employee [Employee_Id=" + Employee_Id + ", Department_Id=" + Department_Id + ", Role_Id=" + Role_Id
				+ ", First_Name=" + First_Name + ", Last_Name=" + Last_Name + ", E_Mail=" + E_Mail + ", Username="
				+ Username + ", Password=" + Password + "]";
	}
	
	

}
