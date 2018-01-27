package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question7 
{
	public static void sortEmployees()
	{
		List<Employee> employees = new ArrayList<Employee>();
		Employee e1 = new Employee("Eric", "IT", 37);
		Employee e2 = new Employee("Clarissa", "Education", 21);
		Collections.addAll(employees, e1, e2);
		
		//Sorting by First Name
		System.out.println("Employees before sorting");
		Collections.shuffle(employees);
		for(Employee employee : employees)
			System.out.println(employee);
		System.out.println("Sorting Based on First Name");
		sortByNameWithComparator(employees);
		System.out.println();
		
		
		//Sorting by Department
		System.out.println("Employees before sorting");
		Collections.shuffle(employees);
		for(Employee employee : employees)
			System.out.println(employee);
		System.out.println("Sorting Based on Last Name");
		sortByDepartmentWithComparator(employees);
		System.out.println();
		
		
		//Sorting by Age
		System.out.println("Employees before sorting");
		Collections.shuffle(employees);
		for(Employee employee : employees)
			System.out.println(employee);
		System.out.println("Sorting Based on Age");
		sortListByAgeWithComparator(employees);
	}

	public static List<Employee> sortByNameWithComparator(List<Employee> l)
	{
		NameCompare nc = new NameCompare();
		Collections.sort(l, nc);
		System.out.println("Employees after sortByNameWithComparator: ");
		for(Employee e : l)
			System.out.println(e);
		return l;
	}

	public static List<Employee> sortByDepartmentWithComparator(List<Employee> l)
	{
		DepartmentCompare dc = new DepartmentCompare();
		Collections.sort(l, dc);
		System.out.println("Employees after sortByDepartmentWithComparator: ");
		for(Employee e : l)
			System.out.println(e);
		return l;
	}

	public static List<Employee> sortListByAgeWithComparator(List<Employee> l) 
	{
		IntCompare ic = new IntCompare();
		Collections.sort(l, ic);
		System.out.println("Employees after sortListByAgeWithComparator: ");
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
