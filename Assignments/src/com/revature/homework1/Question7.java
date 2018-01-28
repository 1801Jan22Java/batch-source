package com.revature.homework1;

import java.util.Comparator;

public class Question7 {

	// a class to represent an employee
	public static class Employee {
		// data fields
		String name;
		String department;
		int age;

		// Constructor
		public Employee(String name, String department, int age) {
			super();
			this.name = name;
			this.department = department;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
		}
		
	}

	// used to compare employees based upon name using default String comparison
	static class SortByName implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.name.compareTo(b.name);
		}
	}

	// used to compare employees by department using default String comparison
	static class SortByDepartment implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.department.compareTo(b.department);
		}
	}
	
	// used to compare employees based on age in ascending order
	static class SortByAge implements Comparator<Employee> {
		@Override
		public int compare(Employee a, Employee b) {
			return a.age - b.age;
		}
	}
}
