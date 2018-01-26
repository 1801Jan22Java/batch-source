package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Sort two employees based on their name, department, and age using the Comparator interface.
 */
public class Question7 
{
	public static void main(String[] args) 
	{
		Employee e1 = new Employee("Bob Jones", "IT", 32);
		Employee e2 = new Employee("Bob Jones", "Human Resoureces", 22);
		List <Employee> employees = new ArrayList();
		Collections.addAll(employees,e1, e2);
		EmployeeCompare ec = new EmployeeCompare();
		Collections.sort(employees, ec);
		System.out.println(employees.toString());
	}
}
