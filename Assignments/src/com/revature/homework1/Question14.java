package com.revature.homework1;

import java.util.Calendar;

public class Question14 {

	public static void main(String[] args) {
		// Write a program that demonstrates the switch case. Implement the following
		//functionalities in the cases:java
		//Case 1: Find the square root of a number using the Math class method.
		//Case 2: Display today’s date.
		//Case 3: Split the following string and store it in a string array.
		//“I am learning Core Java”

		System.out.println("Case 0:");
		runCase(0);
		
		System.out.println("\nCase 1:");
		runCase(1);
		
		System.out.println("\nCase 2:");
		runCase(2);
		
		

	}

	public static void runCase(int option) {
		
		switch(option)
		{
		
		default:
		case 0:
			int number = 49;
			System.out.println("The square root of " + number + " is: " + Math.sqrt(number));
			break;
			
		case 1:
			System.out.println(Calendar.getInstance().getTime());
			break;
		case 2:
			String str = "I am learning Core Java";
			
			String[] strArray = str.split("a");
			
			for(String s : strArray) {
				System.out.println(s);
			}
			
			break;
		}
	}
}
