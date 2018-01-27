package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Sort two employees based on their name, department, and age using the Comparator interface.
 * Status: Done
 */
public class Question07 {

	public static void main(String[] args) {
		String name = "";
		String department = "";
		int age = 0;
		Scanner input = new Scanner(System.in);
		// Get user input
		System.out.print("Enter the first employee's name: ");
		name = input.nextLine();
		System.out.print("Enter the first employee's department: ");
		department = input.nextLine();
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter a the first employee's age: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				age = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't an age.");
				input.next();
			}
		}
		System.out.println();
		// Create first bean object
		Question07Bean first = new Question07Bean(name, department, age);
		// Clear Scanner
		input.nextLine();
		// Clear values
		name = "";
		department = "";
		age = 0;
		// Get user input
		System.out.print("Enter the second employee's name: ");
		name = input.nextLine();
		System.out.print("Enter the second employee's department: ");
		department = input.nextLine();
		// Assume the user entered an invalid value
		validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("Enter a the second employee's age: ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				age = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't an age.");
				input.next();
			}
		}
		System.out.println();
		// Create second bean object
		Question07Bean second = new Question07Bean(name, department, age);
		// Create array of beans
		ArrayList<Question07Bean> array = new ArrayList<>(Arrays.asList(first, second));
		// Display original array
		System.out.println("Original array =\t" + array);
		// Sort by name
		SortByName s1 = new SortByName();
		array.sort(s1);
		System.out.println("Sorted by name =\t" + array);
		// Sort by department
		SortByDepartment s2 = new SortByDepartment();
		array.sort(s2);
		System.out.println("Sorted by department =\t" + array);
		// Sort by age
		SortByAge s3 = new SortByAge();
		array.sort(s3);
		System.out.println("Sorted by age =\t\t" + array);
	}
}
// Comparator for sorting beans by name
class SortByName implements Comparator<Question07Bean> {

	@Override
	public int compare(Question07Bean b1, Question07Bean b2) {
		return b1.getName().compareTo(b2.getName());
	}
	
}
// Comparator for sorting beans by department
class SortByDepartment implements Comparator<Question07Bean> {

	@Override
	public int compare(Question07Bean b1, Question07Bean b2) {
		return b1.getDepartment().compareTo(b2.getDepartment());
	}
	
}
// Comparator for sorting beans by age
class SortByAge implements Comparator<Question07Bean> {

	@Override
	public int compare(Question07Bean b1, Question07Bean b2) {
		return b1.getAge() - b2.getAge();
	}
	
}

