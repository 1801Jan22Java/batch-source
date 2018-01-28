package com.revature.homework1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Question7 {

	public static void main(String[] args) {
		// Sort two employees based on their name, department, and age using the Comparator
		// interface
		
		//Sortable collection for our employees
		List<Employee> employees = new ArrayList<Employee>();
		
		//Our employees
		Employee wageEarner1 = new Employee("Williams, Hank", "Opry Dep.", 29);
		Employee wageEarner2 = new Employee("Cash, Johnny", "Highway Dep.", 71);
		
		//Put them in that List
		employees.add(wageEarner1);
		employees.add(wageEarner2);
		
		System.out.println("Unsorted Employees: ");
		listEmployees(employees);
		
		EmployeeCompare comp = new EmployeeCompare();
		employees.sort(comp);
		
		System.out.println("Sorted Employees: ");
		listEmployees(employees);
	}
	
	public static void listEmployees(List<Employee> employees) {
		for(Employee e : employees) {
			System.out.println(e.toString());
		}
	}

}

//Class used to store information about the employees
class Employee{
	
	@Override
	public String toString() {
		return "Employee [name = " + name + ", department = " + department + ", age = " + age + "]";
	}

	private String name;
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

	private String department;
	private int age;
	
	public Employee(String name, String dep, int age) {
		this.name = name;
		this.department = dep;
		this.age = age;
	}
}

//Class used for handling employee sorting
class EmployeeCompare implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		//Sorting by all three seems unhelpfull but this'll do it!
		//Commenting out two of the three sub comparisons will sort only by the remaining
		
		//This variable combines all the sub comparisons into a single value
		int score = 0;
		
		score += o1.getName().compareTo(o2.getName());
		score += o1.getDepartment().compareTo(o2.getDepartment());
		score += Integer.compare(o1.getAge(), o2.getAge());
		
		//System.out.println("Sort Score: " + score);
		
		return score;
	}
	
}