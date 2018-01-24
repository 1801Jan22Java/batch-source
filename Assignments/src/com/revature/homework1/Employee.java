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
		
		if (!arg0.getName().equals(arg1.getName())) {
			return arg0.getName().compareTo(arg1.getName());
		}
		
		if (!arg0.getDepartment().equals(arg1.getDepartment())) {
			return arg0.getDepartment().compareTo(arg1.getDepartment());
		}
		
		if (arg0.getAge() != arg1.getAge()) {
			if (arg0.getAge() < arg1.getAge()) {
				return -1;
			}
			return 1;
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

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}

}
