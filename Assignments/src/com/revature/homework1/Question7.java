package com.revature.homework1;

import java.util.Comparator;

/**
 * This class represents an employee.
 * 
 * @author Ahmed Awwad
 *
 */
class Employee {
	
	private String name;
	private String department;
	private int age;
	
	public Employee() {
		this("John Doe", "Widgets", 42);
	}
	
	public Employee(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	/**
	 * @return Name of employee
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return Department of employee
	 */
	public String getDepartment() {
		return department;
	}
	
	/**
	 * @return Age of employee
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * @return
	 */
	public String toString() {
		return this.name + ":" + this.department + ":" + this.age;
	}
	
}

/**
 * Class for sorting employees
 * 
 * @author Ahmed Awwad
 *
 */
class EmployeeSort implements Comparator<Employee> {
	
	/**
	 * Compares the given employees based on the lexical name of their departments,
	 * then based on their ages, and finally based on their names.
	 * 
	 * @param o1 First employee to be compared
	 * @param o2 Second employee to be compared
	 * @return Comparison value between o1 and o2
	 */
	public int compare(Employee o1, Employee o2) {
		
		int a = o1.getDepartment().compareTo(o2.getDepartment());
		if (a != 0) {
			return a;
		}
		
		
		int b = ((Integer) o1.getAge()).compareTo(o2.getAge());
		if (b != 0) {
			return b;
		}
		
		return o1.getName().compareTo(o2.getName());
	}
	
}

/**
 * Homework 1. Question 7. Sorting employees.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question7 {
	
	/**
	 * Compares the two given employees and displays a verdict about their ordering
	 * 
	 * @param o1 First employee
	 * @param o2 Second employee
	 * @throws IllegalArgumentException if o1 is null or o2 is null
	 */
	private static void compareEmployees(Employee o1, Employee o2) {
		if (o1 == null || o2 == null) {
			throw new IllegalArgumentException();
		}
		
		EmployeeSort s = new EmployeeSort();
		
		int i = s.compare(o1, o2);
		
		System.out.println("For employees " + o1.getName() + " and " + o2.getName() + "...");
		
		if (i == 0) {
			System.out.println("Both employees are the same!");
		} else if (i > 0) {
			System.out.println("Here is their order: [" + o2.toString() + ", " + 
					o1.toString() + "]");
		} else {
			System.out.println("Here is their order: [" + o1.toString() + ", " + 
					o2.toString() + "]");
		}
		
		System.out.println();
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		Employee e1 = new Employee();
		Employee e2 = new Employee("Alice Jenkins", "Zoology", 33);
		Employee e3 = new Employee("Becky Robertson", "Widgets", 28);
		Employee e4 = new Employee("Crispin Freeman", "Widgets", 42);
		Employee e5 = new Employee();
		
		compareEmployees(e1, e2);
		compareEmployees(e1, e3);
		compareEmployees(e1, e4);
		compareEmployees(e1, e5);
	}

}
