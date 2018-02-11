package com.revature.project1.beans;

import java.io.File;

public class Receipt {
	private float charge;
	private String description;
	private File file;
	private Employee employee;

	
	public Receipt(float charge,String description,File file,Employee employee) 
	{
		this.charge=charge;
		this.description=description;
		this.file=file;
		this.employee=employee;
	}


	public float getCharge() {
		return charge;
	}


	public void setCharge(float charge) {
		this.charge = charge;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public File getFile() {
		return file;
	}


	public void setFile(File file) {
		this.file = file;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
