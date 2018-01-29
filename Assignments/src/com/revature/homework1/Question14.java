package com.revature.homework1;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Homework 1. Question 14. Switch.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question14 {
	
	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String slogan = "I am learning Core Java";
		
		System.out.println("Type 1, 2, or 3 to perform an operation:");
		System.out.println("1 -> Find the square root of 57.34");
		System.out.println("2 -> Find out today's date in \"year-month-day\" format");
		System.out.println("3 -> Split and store \"" + slogan + "\" into an array");
		
		int choice = -1;
		String template = "Please type 1, 2, or 3!";
		
		try {
			choice = sc.nextInt();
			System.out.println();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println(template);
			sc.close();
			return;
		}
		
		switch(choice) {
			case 1:
				System.out.println("The square root of 57.34 is " + Math.sqrt(57.34));
				break;
			case 2:
				System.out.println("Today's date is " + LocalDate.now().toString());
				break;
			case 3:
				// Splitting on whitespace
				String[] words = slogan.split(" ");
				System.out.print("Here it is: ");
				System.out.println(Arrays.toString(words));
				break;
			default:
				System.out.println(template);
				sc.close();
				return;
		}
		
		System.out.println();
		System.out.println("Thank you, and have a nice day!");
		
		sc.close();
		
	}

}
