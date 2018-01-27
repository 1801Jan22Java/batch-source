package com.revature.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//James Whitten

//This class compares and sorts Employees
public class Question7 implements Comparator<Employee> {

	//Using overridden comparator interface method for sorting by name, department, and age of employees
	@Override
	public int compare(Employee emp1, Employee emp2) {
		
		//If the names are equal then we must compare by department 
		if (emp1.getEmpName().equals(emp2.getEmpName()))
		{
			//If the name of the department are also equal then we must compare by age
			if (emp1.getEmpDep().equals(emp2.getEmpDep()))
			{
				//Sorts by age (this has lowest precedence)
				return emp1.getEmpAge() - emp2.getEmpAge();
			}
			else
			{
				//Sorts by department (this has less precedence than name but higher precedence than age)
				return emp1.getEmpDep().compareTo(emp2.getEmpDep());
			}
		}
		else
		{
			//Sorts by name (this has highest precedence)
			return emp1.getEmpName().compareTo(emp2.getEmpName());
		}
		
		

	}

	
		//Our main
		public static void main(String[] args)
		{
			
			//Test cases
			ArrayList<Employee> empList = new ArrayList<Employee>();
			empList.add(new Employee("John", "HR", 42));
			empList.add(new Employee("Christina", "Sales", 33));
			empList.add(new Employee("John", "HR", 33));
			empList.add(new Employee("Mary", "HR", 36));
			empList.add(new Employee("Ted", "Accounting", 42));
			
			//The unsorted Collection
			System.out.println("Unsorted Employees Collection: ");
			for (int i = 0; i < empList.size(); i++)
			{
				empList.get(i).printEmp();
			}
			
			//Now sort the Collection
			Collections.sort(empList, new Question7());
			
			//The sorted Collection
			System.out.println("Sorted Employees Collection: ");
			for (int i = 0; i < empList.size(); i++)
			{
				empList.get(i).printEmp();
			}
			
			
		}
	
	
}
