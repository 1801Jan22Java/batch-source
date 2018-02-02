package com.revature.homework1;
import java.util.*;
public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee("Jonathan River", "Sales", 29));
		list.add(new Employee("Anna Smith", "Finance", 36));
		
		System.out.print("Employees: ");
		
		for(Employee e: list)   // printing the list of names
		{
	         System.out.print(e.name + ", ");
		}
		System.out.println();
		
		System.out.print("Employees sorted by age: ");
		Collections.sort(list, new AgeComparator());		// sort by age
		
		for(Employee e: list)   // printing the list of names
		{
	         System.out.print(e.name + ", ");
		}

		System.out.println();
		
		System.out.print("Employees sorted by name: ");
		Collections.sort(list, new NameComparator());		// sort by name
		
		for(Employee e: list)   // printing the list of names
		{
	         System.out.print(e.name + ", ");
		}
		
		System.out.println();
		
		System.out.print("Employees sorted by department: ");
		Collections.sort(list, new DepartmentComparator());		// sort by name
		
		for(Employee e: list)   // printing the list of names
		{
	         System.out.print(e.name + ", ");
		}
	}

}
