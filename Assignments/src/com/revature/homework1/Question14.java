package com.revature.homework1;

import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program that demonstrates the switch case. Implement the following functionalities in the 
 * cases:java 
 * Case 1: Find the square root of a number using the Math class method.
 * Case 2: Display today's date.
 * Case 3: Split the following string and store it in a string array.
 *         "I am learning Core Java"
 */

public class Question14 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter: \n1 to find sqrt of a number\n2 to Display today's date\n"
				+ "3 to split \"I am learning Core Java\"");
		int java = input.nextInt();
		
		switch(java) {
			case 1:
				System.out.println("Enter the number you want to find the Sqrt of: ");
				double number = input.nextDouble();
				findSqrt(number);
				input.close();
				break;
			case 2: displayDate(); break;
			case 3: splitString(); break;
			default: System.out.println("Wrong choice, choose 1 or 2 or 3 only"); break;
		}
		
	} // end main()
	
	public static void findSqrt(double number) {
		System.out.println("Sqrt of your number is: " + Math.sqrt(number));
	} // end findSqrt()
	
	public static void displayDate() {
		LocalDateTime currDateTime = LocalDateTime.now();
		LocalDate date = currDateTime.toLocalDate();
		System.out.println("Today's date is: " + date);
	} // end displayDate()
	
	public static void splitString() {
		String str = "I am learning Core Java";
		String[] words = str.split("[ ]");
		for(String m : words) {
			System.out.println(m);
		}
	} // end splitString()

} // end class
