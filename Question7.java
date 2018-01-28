package com.revature.homework1;

import java.util.Comparator;

public class Question7 {

	private String name;
	private int age;
	private String department;
	
	public Question7(String name, int age, String department) {
		super();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
}

class EmployeeName implements Comparator<Question7>{

	@Override
	public int compare(Question7 e1 , Question7 e2) {
		// TODO Auto-generated method stub
		return e1.getName().compareTo(e2.getName());
	}
	
	
	
}

class EmployeeDepartment implements Comparator<Question7>{

	@Override
	public int compare(Question7 e1 , Question7 e2) {
		// TODO Auto-generated method stub
		return e1.getDepartment().compareTo(e2.getDepartment());
	}
	
	
	
}

class EmployeeAge implements Comparator<Question7>{

	@Override
	public int compare(Question7 e1 , Question7 e2) {
		// TODO Auto-generated method stub
		return e1.getAge() + e2.getAge();
	}
	
	
	
}
