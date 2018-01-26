package com.revature.homework1;

/**Created by: Jeffrey Rubi
 * Date: 25 January 2018
 * Sort two employees based on their name, department, and age using the Comparator interface.
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Question7 {

	public static void main(String[] args) {
		// instantiate a List to store employees
		List<Employee> employees = new ArrayList<Employee>();
		// instantiate Employees
		Employee e1 = new Employee("Raymond", "Engineering", 22);
		Employee e2 = new Employee("Charlie", "Biology", 33);
		// store the Employees in the ArrayList
		Collections.addAll(employees, e1, e2);
		// Display list before sorting
		System.out.println("List of employees BEFORE sort by name: ");
		for (Employee n : employees) {
			System.out.println(n.getName() + " " + n.getDepartment() + " " + n.getAge());
		}
		
		// Call method that sorts by name, department, age.
		sortEmployeeName(employees);
		sortEmployeeDept(employees);
		sortEmployeeAge(employees);

	} // end main()
	
	public static List<Employee> sortEmployeeName(List<Employee> employees) {
		EmployeeNameComparator ice = new EmployeeNameComparator();
		Collections.sort(employees, ice);
		System.out.println("List of employees AFTER sort by NAME: ");
		for (Employee e : employees) {
			System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getAge());
		}
		return employees;
	} // end sortEmployeeName()

	public static List<Employee> sortEmployeeDept(List<Employee> employees) {
		EmployeeDeptComparator water = new EmployeeDeptComparator();
		Collections.sort(employees, water);
		System.out.println("List of employees AFTER sort by DEPARTMENT: ");
		for (Employee e : employees) {
			System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getAge());
		}
		return employees;
	} // end sortEmployeeDept()

	public static List<Employee> sortEmployeeAge(List<Employee> employees) {
		EmployeeAgeComparator steam = new EmployeeAgeComparator();
		Collections.sort(employees, steam);
		System.out.println("List of employees AFTER sort by AGE: ");
		for (Employee e : employees) {
			System.out.println(e.getName() + " " + e.getDepartment() + " " + e.getAge());
		}
		return employees;
	} // end sortEmployeeAge()

}
