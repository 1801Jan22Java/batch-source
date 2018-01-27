package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 
{
	public static void sortEmployees()
	{
		//Create a list, two employees,
		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee("Eric", "IT", 37);
		Employee e2 = new Employee("Clarissa", "Education", 21);
		//and add the employees to the list.
		Collections.addAll(employees, e1, e2);
		
		System.out.println("---------Sorting Based on First Name---------\n");
		//Sorting by First Name
		System.out.println("Employees before sorting");
		//Randomize the employees
		Collections.shuffle(employees);
		//Print out the current order of employees
		for(Employee employee : employees)
			System.out.println(employee);
		//Sort the employees by alphabetical order
		sortByNameWithComparator(employees);
		System.out.println();
		
		System.out.println("---------Sorting Based on Last Name---------");
		//Sorting by Department
		System.out.println("Employees before sorting");
		Collections.shuffle(employees);
		for(Employee employee : employees)
			System.out.println(employee);
		//Sort the employees by department's alphabetical order
		sortByDepartmentWithComparator(employees);
		System.out.println();
		
		
		System.out.println("---------Sorting Based on Age---------");
		//Sorting by Age
		System.out.println("Employees before sorting");
		Collections.shuffle(employees);
		for(Employee employee : employees)
			System.out.println(employee);
		//Sort the employees by age.
		sortListByAgeWithComparator(employees);
	}

	public static List<Employee> sortByNameWithComparator(List<Employee> l)
	{
		NameCompare nc = new NameCompare();
		//This particular version of the Collections's sort method
		//will use the custom compareTo method to sort the list
		Collections.sort(l, nc);
		System.out.println("\nEmployees after sorting:");
		//print the employees
		for(Employee e : l)
			System.out.println(e);
		return l;
	}

	public static List<Employee> sortByDepartmentWithComparator(List<Employee> l)
	{
		DepartmentCompare dc = new DepartmentCompare();
		Collections.sort(l, dc);
		System.out.println("\nEmployees after sorting:");
		for(Employee e : l)
			System.out.println(e);
		return l;
	}

	public static List<Employee> sortListByAgeWithComparator(List<Employee> l) 
	{
		IntCompare ic = new IntCompare();
		Collections.sort(l, ic);
		System.out.println("\nEmployees after sorting:");
		for(Employee e : l)
			System.out.println(e);
		return l;
	}
}

class Employee
{
	private String name;
	private String department;
	private int age;

	public Employee()
	{
	}

	public Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public String getDepartment()
	{
		return department;
	}

	public Integer getAge() 
	{
		return age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", department=" + department + ", age=" + age + "]";
	}
}

class NameCompare implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2) 
	{
		String name1 = e1.getName();
		String name2 = e2.getName();
		return name1.compareTo(name2);
	}
}

class DepartmentCompare implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2) 
	{
		String d1 = e1.getDepartment();
		String d2 = e2.getDepartment();
		return d1.compareTo(d2);
	}
}

class IntCompare implements Comparator<Employee>
{
	@Override
	public int compare(Employee e1, Employee e2) 
	{
		Integer age1 = e1.getAge();
		Integer age2 = e2.getAge();
		return age1 - age2;
	}
}
