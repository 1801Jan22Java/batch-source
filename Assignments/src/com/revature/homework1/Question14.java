package com.revature.homework1;

import java.util.Arrays;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

//Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java 
//Case 1: Find the square root of a number using the Math class method.
//Case 2: Display today’s date.
//Case 3: Split the following string and store it in a string array.
//               “I am learning Core Java”
public class Question14 {
	public static void main(String[] args) {
		switchCase(1);
		switchCase(2);
		switchCase(3);
	}

	public static void switchCase(int option) {
		switch (option) {
		case 1:
			// Find the square root of a hard coded number.
			// The better option would be to overload switchCase(int option, int input),
			// but this would take out the option for the specific assignment.
			System.out.println("The square root of 100 is: " + Math.sqrt(100));
			break;
		case 2:
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			break;
		case 3:
			String str = new String("I am learning Core Java");
			String[] splitStr = str.split("\\s");
			System.out.println(Arrays.toString(splitStr));
			break;
		}
	}
}
