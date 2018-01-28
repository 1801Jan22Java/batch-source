package com.revature.homework1;

import java.util.*;


public class Employee {

	//Class is used for question7 program to populate and classify
	//employees based on their name, age, and department
	
	String name, department;
	int age;
	
	public Employee(String name, String department, int age)
	{
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//outputs the employees information in clean format
	public String toString()
	{
		return "Name: " + this.name + "\tDepartment: " + this.department + "\tAge: " + this.age;
	}
	
}

//compares the name of two employees and outputs them in ascending order
class SortByName implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.name.compareTo(b.name);
	}
}

//compares the department of two employees and outputs them in ascending order
class SortByDepartment implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.department.compareTo(b.department);
	}
	
}

//compares the age of two employees and outputs them in ascending order
class SortByAge implements Comparator<Employee>
{
	public int compare(Employee a, Employee b)
	{
		return a.age - b.age;
	}
	
}




