package com.revature.homework1;

import java.util.Comparator;

public class Employee {
	private int age;
	private String name;
	private String department;
	
	Employee(){
		super();
	}
	
	Employee(String name, int age,String department){
		super();
		this.name = name;
		this.age = age;
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	@Override
	public String toString() {
		return "Employee [age=" + age + ", name=" + name + ", department=" + department + "]";
	}
	
	

}

class SortByName implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return arg0.getName().compareTo(arg1.getName());
	}
	
	
}
class SortByAge implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return arg0.getAge() - arg1.getAge();
	}
	
	
}
class SortBydepartment implements Comparator<Employee>{

	@Override
	public int compare(Employee arg0, Employee arg1) {
		// TODO Auto-generated method stub
		return arg0.getDepartment().compareTo(arg1.getDepartment());
	}
	
	
}
