package com.revature.homework1;

public class Question07Bean {
	public Question07Bean(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	private String name;
	private String department;
	private int age;
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
		return "Name:\"" + name + "\" - Dept:\"" + department + "\" - Age:" + age;
	}
	
}
