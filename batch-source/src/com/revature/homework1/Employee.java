package com.revature.homework1;
//James Whitten

//An Employee class utilized for Question 7
public class Employee {

	//Employee Constructors, Fields and Getters/Setters
	
	public Employee() {}
	
	public Employee(String empName, String empDep, int empAge) {
		super();
		this.empName = empName;
		this.empDep = empDep;
		this.empAge = empAge;
	}
	
	private String empName;
	private String empDep;
	private int empAge;
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDep() {
		return empDep;
	}
	public void setEmpDep(String empDep) {
		this.empDep = empDep;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	//Prints out Employee information
	public void printEmp()
	{
		System.out.println(empName + " " + empDep + " " + empAge);
	}
	
	
	
	
}
