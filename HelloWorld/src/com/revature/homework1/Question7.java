package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 {

	// Q7. Sort two employees based on their name, department, and age using the Comparator interface.
	public static void main(String[] args) {
		
		Employee e1 = new Employee("Kitty", "Dell", 10);
		Employee e2 = new Employee("Jerry", "Samsung", 4);
		/*
		 *  Extra instances for test
		Employee e3 = new Employee("Aerry", "Apple", 7);
		Employee e4 = new Employee("Cerry", "Dyson", 11);
		Employee e5 = new Employee("Ferry", "HP", 3);
		Employee e6 = new Employee("Gerry", "LG", 9);
		*/
		
		List<Employee> e = new ArrayList<Employee>();
		Collections.addAll(e, e1, e2);
		System.out.println(e.toString());
		
		EmployeeAgeComparator eAge = new EmployeeAgeComparator();
		EmployeeDeptComparator aDept = new EmployeeDeptComparator();
		EmployeeNameComparator aName = new EmployeeNameComparator();
		
		Collections.sort(e, eAge);
		System.out.println("After sort by age");
		for (Employee each : e) {
			System.out.println(each.toString());
		}
		
		Collections.sort(e, aDept);
		System.out.println("After sort by department");
		for (Employee each : e) {
			System.out.println(each.toString());
		}
		
		Collections.sort(e, aName);
		System.out.println("After sort by Name");
		for (Employee each : e) {
			System.out.println(each.toString());
		}
	}
	
}

class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

class EmployeeDeptComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}

class EmployeeAgeComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee o1, Employee o2) {
		return o1.getAge() - o2.getAge();
	}
}

class Employee {
	
	private String name;
	private String department;
	private int age;
	
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

