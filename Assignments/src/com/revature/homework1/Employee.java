package com.revature.homework1;

import java.util.Comparator;

public class Employee implements Comparator<Employee> {

	private String name;
	private String department;
	private int age;
	
	
	public Employee(){
		
	}
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	@Override
	public int compare(Employee arg0, Employee arg1) {
		if (arg0 == null || arg1 == null) {
			throw new NullPointerException();
		}
		if (!(arg0 instanceof Employee && arg1 instanceof Employee)) {
			throw new ClassCastException();
		}
		return 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
