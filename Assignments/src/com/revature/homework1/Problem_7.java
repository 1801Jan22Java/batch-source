package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;

public class Problem_7 {
	public static void comparing() {
		ArrayList<Employee> workers = new ArrayList<>();
		workers.add(new Employee("Bill", 22, "Accounting"));
		workers.add(new Employee("Ted", 23, "Accounting"));
		workers.add(new Employee("Riley", 24, "Accounting"));
		workers.add(new Employee("Furgson", 25, "Finance"));
		workers.add(new Employee("Mitch", 26, "Finance"));
		workers.add(new Employee("Stephanie", 27, "Finance"));
		workers.add(new Employee("Steven", 28, "Marketing"));
		workers.add(new Employee("Susan", 29, "Marketing"));
		workers.add(new Employee("Shawna", 32, "Marketing"));
		workers.add(new Employee("Shawn", 42, "Being Rich"));

		Collections.sort(workers, new SortByName());

		System.out.println("Sorted by name");

		for (Employee m : workers) {
			System.out.println(m.toString());
		}

		Collections.sort(workers, new SortByAge());

		System.out.println("Sorted by Age");

		for (Employee m : workers) {
			System.out.println(m.toString());
		}
		
		Collections.sort(workers, new SortBydepartment());

		System.out.println("Sorted by department");

		for (Employee m : workers) {
			System.out.println(m.toString());
		}

	}

	public static void main(String[] args) {
		comparing();
	}

}
