package com.revature.homework1;

import java.util.*;

class Question7{
	
	public static void main(String[] args){
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		Employee one = new Employee("Jeff","Engineering",27);
		Employee two = new Employee("Bob","HR",33);
		Employee three = new Employee("Dave","Accounting",71);
		Employee four = new Employee("Emily", "Engineering", 29);
		
		employeeList.add(one);
		employeeList.add(two);
		employeeList.add(three);
		employeeList.add(four);
		
		printList(employeeList);
		
		Collections.sort(employeeList, new sortByName() );
		printList(employeeList);
		Collections.sort(employeeList, new sortByDepartment() );
		printList(employeeList);
		Collections.sort(employeeList, new sortByAge() );
		printList(employeeList);
	}
	
	static void printList(ArrayList<Employee> source) {
		for (Employee employee : source) {
			System.out.println(employee.name+" "+employee.department+" "+employee.age);
		}

	}
}

class Employee{
	String name;
	String department;
	int age;
	
	Employee(String n, String d, int a){
		name = n;
		department = d;
		age =a;
	}
}

class sortByName implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return (one.name).compareTo(two.name);
	}
}

class sortByDepartment implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return (one.department).compareTo(two.department);
	}
}

class sortByAge implements Comparator<Employee>{
	public int compare(Employee one, Employee two) {
		return (one.age - two.age);
	}
}