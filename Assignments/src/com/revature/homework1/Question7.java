package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Question7 {
	
	/*
	 * The following methods create new comparators for age, name, and department. I went ahead and used three
	 * employees to demonstrate that each comparison actually works.
	 */
	public static void main(String[] args) {
		Employee a = new Employee("John", 24, "Information Technologies");
		Employee b = new Employee("Doe", 34, "Human Resources");
		Employee c = new Employee("Zoey", 27, "Executive");
		
		ArrayList<Employee> employees = new ArrayList<Employee>();
		employees.add(a);
		employees.add(b);
		employees.add(c);
		
		System.out.println("By Name");
		Collections.sort(employees, new sortByName());
		for(Employee e:employees) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		System.out.println("By Department");
		Collections.sort(employees, new sortByDepartment());
		for(Employee e:employees) {
			System.out.println(e.toString());
		}
		System.out.println();
		
		System.out.println("By Age");
		Collections.sort(employees, new sortByAge());
		for(Employee e:employees) {
			System.out.println(e.toString());
		}
	}
	
}

class Employee {
	String name, department;
	int age;
		
	public Employee(String name, int age, String department) {
		this.name = name;
		this.age = age;
		this.department = department;
	}
		
	@Override
	public String toString() {
		return "Name: " + this.name + " Age: " + this.age + " Department: " + this.department; 
	}

}
	
class sortByName implements Comparator<Employee>{
	public int compare(Employee a, Employee b) {
		return a.name.compareTo(b.name);
	}
}
	
class sortByDepartment implements Comparator<Employee>{
	public int compare(Employee a, Employee b) {
		return a.department.compareTo(b.department);
	}
}
	
class sortByAge implements Comparator<Employee>{
	public int compare(Employee a, Employee b) {
		return a.age - b.age;
	}
}	
