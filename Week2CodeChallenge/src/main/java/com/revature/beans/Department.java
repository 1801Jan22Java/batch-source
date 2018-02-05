package com.revature.beans;

public class Department {
	public Department(int departmentId, String departmentName, double average) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.average = average;
	}
	public Department(String departmentName, double average) {
		super();
		this.departmentName = departmentName;
		this.average = average;
	}
	private int departmentId;
	private String departmentName;
	private double average;
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public double getAverage() {
		return average;
	}
	public void setAverage(double average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return "Department [departmentName=" + departmentName + ", average="
				+ average + "]";
	}
}
