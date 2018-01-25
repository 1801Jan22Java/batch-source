//Done!
package com.revature.homework1;

import java.util.Comparator;

//Create an Employee class to encapsulate each employee's information
class Employee{
	public Employee(String name, String department, int age) {
		super();
		this.name = name;
		this.department = department;
		this.age = age;
	}
	private String name;
	private String department;
	private int age;		//In years
	
	
	//Getters and Setters 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printInfo() {
		System.out.println("Name: " + this.name);
		System.out.println("Department: " + this.department);
		System.out.println("Age: " + this.age + " years");
	}
}

//Implement Comparator to compare Employee objects
public class Question7 implements Comparator<Employee>{
		
	@Override
	public int compare(Employee emp1, Employee emp2) {
		//If the comparison between emp1's and emp2's names yields something
		//greater than 0, that means emp2 comes before emp1 lexicographically
		if(emp1.getName().compareToIgnoreCase(emp2.getName()) > 0){
			//Print the second employee before the first
			return 2;
		}
		
		else if (emp1.getName().compareToIgnoreCase(emp2.getName()) < 0){
			//Print the first employee's information before the second
			return 1;
		}
		
		
		//Names identical, so move on to their departments
		if(emp1.getDepartment().compareToIgnoreCase(emp2.getDepartment()) > 0){
			//Print the second employee before the first
			return 2;
		}
		
		else if (emp1.getDepartment().compareToIgnoreCase(emp2.getDepartment()) < 0){
			//Print the first employee's information before the second
			return 1;
		}
		
		
		//Departments also identical? Move onto their ages
		//Print the older employee first
		if(emp1.getAge() < emp2.getAge()){
			//Print the second employee before the first
			return 2;
		}
		
		else if (emp1.getAge() > emp2.getAge()){
			//Print the first employee's information before the second
			return 1;
		}
		
		return 0;
	}

	public static void main(String[] args){
		Employee first = new Employee("Sam", "HR", 25);
		Employee second = new Employee("Ralph", "Sales", 24);
		
		Question7 q7 = new Question7();
		//Compare Employees
		int firstEmployee = q7.compare(first, second);
		
		//If compare returns 1, the first employee's info is printed first
		if(firstEmployee == 1) {
			first.printInfo();
			System.out.println();
			second.printInfo();
		}
		//If compare returns 2, the second employee's info is printed first
		else if(firstEmployee == 2) {
			second.printInfo();
			System.out.println();
			first.printInfo();
		}
		//If compare returns 0, they have identical information
		else {
			System.out.println("They're the same person, but here's their info printed twice anyway!");
			first.printInfo();
			System.out.println();
			second.printInfo();
		}
	}
}
	
