package com.revature.homework1;

import java.util.*;


public class Question7 {

	public static void main(String[] args) {
		
		//Q7. Sort two employees based on their name, department, and age using the Comparator
		//interface.
		
		//Employee class is used in this program to create employees
		//and classify their name, department and age
		
		//Creates an array list and populate it with two employees 
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee("Chris", "sales", 25));
		emp.add(new Employee("Sam", "hr", 32));
		
		//print out the employees in an unsorted order
		System.out.println("Unsorted employees: ");
		for(int i=0; i<emp.size(); i++)
		{
			System.out.println(emp.get(i));
		}

		//function that sorts the employees by first name
		Collections.sort(emp, new SortByName());
		
		System.out.println("\nSorted by Name: ");
		for(int i=0; i<emp.size();i++)
		{
			System.out.println(emp.get(i));
		}
		
		//function that sorts the employees by their department
		Collections.sort(emp, new SortByDepartment());
		
		System.out.println("\nSorted by Department: ");
		for(int i=0; i<emp.size();i++)
		{
			System.out.println(emp.get(i));
		}
		
		//function that sorts the employees by their age
		Collections.sort(emp, new SortByAge());
		
		System.out.println("\nSorted by Age: ");
		for(int i=0; i<emp.size();i++)
		{
			System.out.println(emp.get(i));
		}
		
	}

	
	
}
