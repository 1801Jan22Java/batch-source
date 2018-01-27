package com.revature.homework1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.List;


/*
 * Q7. Sort two employees based on their name, department, 
 * and age using the Comparator interface.
 * */
public class Question7 {

	public List<Employee> sortEmployeeFirstName(List <Employee> empList)
	{

		FirstNameCompare fnc= new FirstNameCompare();
		
		Collections.sort(empList,fnc);
		return empList;
	}
	
	public List<Employee> sortEmployeeLastName(List <Employee> empList)
	{

		LastNameCompare lnc= new LastNameCompare();
		
		Collections.sort(empList,lnc);
		return empList;
	}
	public List<Employee> sortAge(List <Employee> empList)
	{

		AgeCompare ac= new AgeCompare();
		
		Collections.sort(empList,ac);
		return empList;
	}
	
	public List<Employee> sortDepartment(List <Employee> empList)
	{

		DepartmentCompare dc= new DepartmentCompare();
		
		Collections.sort(empList,dc);
		
		return empList;
	}




}
class AgeCompare implements Comparator<Employee>
{
	
	public int compare(Employee e1,Employee e2)
	{
		Integer age1=e1.getAge();
		return age1.compareTo(new Integer(e2.getAge()));
	}
}
class FirstNameCompare implements Comparator<Employee>{
	
	
	public int compare(Employee e1, Employee e2)
	{
		String name1 = e1.getFirstName();
		return name1.compareTo(new String(e2.getFirstName()));
	}
}
class LastNameCompare implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2)
	{
		String name1 = e1.getLastName();
		return name1.compareTo(new String(e2.getLastName()));
	}

}
class DepartmentCompare implements Comparator<Employee>{
	
	public int compare(Employee e1, Employee e2)
	{
		String department1 = e1.getDepartment();
		return department1.compareTo(new String(e2.getDepartment()));
	}
}

class Employee 
{
	private String firstName;
	private String lastName;
	private String department;
	private int age;
	Employee (String firstName, String lastName, String department, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.department=department;
		this.age = age;
	}

	public int getAge()
	{
		return age;
	}
	public String getFirstName()
	{
		return firstName;
	}


	public String getLastName(){
		return lastName;
	}

	public String getDepartment()
	{
		return department;
	}
	public String toString(){
		return "Employee: First name:"+ this.getFirstName()+ " Last name: " +this.getLastName()+ " Department: "
	+this.getDepartment()+ " Age:" + this.getAge();
	}

}