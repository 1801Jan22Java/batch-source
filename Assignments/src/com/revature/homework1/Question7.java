package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Q7. Sort two employees based on their name, department, 
//and age using the Comparator interface.
public class Question7 {
	public static void main(String[] args) {
		comparisons();

	}

	public static void comparisons() {
		ArrayList<Employee> employeeList = new ArrayList<>();

		// Instantiate 2 employees
		Employee emp1 = new Employee("John", "Accounting", 29);
		Employee emp2 = new Employee("Smith", "Zoologist", 81);
		// More if 2 isn't enough
		// Employee emp3 = new Employee("Jane", "Programmer", 81);
		// Employee emp4 = new Employee("Doe", "Mage", 81);
		// Employee emp5 = new Employee("Sungkwon", "Dog Whisperer", 81);
		// Employee emp6 = new Employee("Kudo", "Ramen Flipper", 81);

		Collections.addAll(employeeList, emp1, emp2);
		// Collections.addAll(employeeList, emp1, emp2, emp3, emp4, emp5, emp6);

		// Initialize comparators
		EmployeeAgeComparator ageCompare = new EmployeeAgeComparator();
		EmployeeDepartmentComparator departmentCompare = new EmployeeDepartmentComparator();
		EmployeeNameComparator nameCompare = new EmployeeNameComparator();

		// Sort using comparators, and print out
		Collections.sort(employeeList, ageCompare);
		System.out.println("Sort by age: ");
		for (Employee e : employeeList) {
			System.out.println("Age: " + e.getAge() + " Department: " + e.getDepartment() + " Name: " + e.getName());
		}

		Collections.sort(employeeList, departmentCompare);
		System.out.println("Sort by department: ");
		for (Employee e : employeeList) {
			System.out.println("Age: " + e.getAge() + " Department: " + e.getDepartment() + " Name: " + e.getName());
		}

		Collections.sort(employeeList, nameCompare);
		System.out.println("Sort by name: ");
		for (Employee e : employeeList) {
			System.out.println("Age: " + e.getAge() + " Department: " + e.getDepartment() + " Name: " + e.getName());
		}
	}
}
