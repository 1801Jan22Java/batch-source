package question7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Q7. Sort two employees based on their name, department, and age using the Comparator
// interface.
// Created by: KP Saini
public class Driver {

	public static void main(String[] args) {
		// create a list of Employee objects
		List<Employee> employeeList = new ArrayList<>();
		Employee employee1 = new Employee("Billy Bob", "Toys", 35);
		Employee employee2 = new Employee("Aaron Bogers", "Electronics", 42);
		Employee employee3 = new Employee("Peter Smith", "Men's Clothing", 28);
		Collections.addAll(employeeList, employee1, employee2, employee3);
		
		// natural ordering
		System.out.println("Employee list before sorting: ");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
		
		// invoke sort methods
		sortByName(employeeList);
		
		sortByDepartment(employeeList);
		
		sortByAge(employeeList);
	}
	
	// sort the Employee list by employee name and print it to the console
	public static void sortByName(List<Employee> employeeList) {
		// sort with NameCompare
		Collections.sort(employeeList, new NameCompare());
		System.out.println("\nEmployee list after sorting by name: ");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
	
	// sort the Employee list by department name and print it to the console
	public static void sortByDepartment(List<Employee> employeeList) {
		// sort with Department Compare
		Collections.sort(employeeList, new DepartmentCompare());
		System.out.println("\nEmployee list after sorting by department name: ");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}

	// sort the Employee list by employee age
	public static void sortByAge(List<Employee> employeeList) {
		// sort with AgeCompare
		Collections.sort(employeeList, new AgeCompare());
		System.out.println("\nEmployee list after sorting by employee age: ");
		for (Employee e : employeeList) {
			System.out.println(e);
		}
	}
}
