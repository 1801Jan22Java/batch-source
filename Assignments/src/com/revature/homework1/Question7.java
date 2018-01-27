package com.revature.homework1;

import java.util.Comparator;

public class Question7 implements Comparator<Employee>{

	@Override
	public int compare(Employee e1, Employee e2) {
		
		int compareName = e1.getName().compareTo(e2.getName());
		int compareDepartment = e1.getDepartment().compareTo(e2.getDepartment());
		int compareAge = e1.getAge().compareTo(e2.getAge());
		
		// Use an if-else block to compare each field
		// If names are the same, compare department and 
		// if departments are the same return age otherwise return department
		
		if(compareName == 0) {
			return ((compareDepartment == 0) ? compareAge : compareDepartment);
		} else {
			return compareName;
		}
		
	}
	
}

class Employee {
	
	private String name;
	private String department;
	private Integer age;
	
	public Employee() {
		super();
	}
	
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
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
	public Integer getAge() {
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
