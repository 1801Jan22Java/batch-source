package com.revature.homework1;

import java.util.*;

public class Question7 {
	
	public static void main(String[] args) {
		
		ArrayList<Employee> arr = new ArrayList<Employee>();
		arr.add(new Employee("Frank",23,"ENG"));
		arr.add(new Employee("Frank",24,"ENG"));
		arr.add(new Employee("Frank",23,"HR"));
		arr.add(new Employee("Jack",18,"HR"));
		arr.add(new Employee("Albert",55,"CEO"));
		
		System.out.println("Sorting Employees");
		
		Collections.sort(arr,new EmployeeComparator());
		
		for(Employee e:arr) {
			System.out.println("Name: " + e.name + "\nDepartment: " + e.department + "\nAge: " + e.age + "\n");
		}
		
		
	}

}
