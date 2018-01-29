package com.revature.homework1;

import java.util.Scanner;

/**
 * @author Calvin Milliron
 * Assignment: Write a substring method that accepts a string str and an integer idx and returns the substring contained between 0 and idx-1 inclusive.  
 * 		Do NOT use any of the existing substring methods in the String, StringBuilder, or StringBuffer APIs.
 * Status: Done... Negative indexes result in an empty string
 */
public class Question05 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = new String();
		int idx = 0;
		System.out.print("Please enter something to be shortened: ");
		str = input.nextLine();
		// Assume the user entered an invalid value
		boolean validInput = false;
		// Loop until the user enters a valid value
		while (!validInput) {
			// Ask user for a value
			System.out.print("What index would you like to read up to? ");
			// If user entered a valid value, store it, otherwise print error message and clear Scanner
			if (input.hasNextInt()) {
				idx = input.nextInt();
				validInput = true;
			} else {
				System.out.println("Sorry, that wasn't an index.");
				input.next();
			}
		}
		// Print result
		System.out.println("The result is: \"" + subString(str, idx) + "\"");
	}
	
	public static String subString(String str, int idx) {
		// If the index provided is larger than the length of the string, return the original string
		if (idx > str.length()) { return str; }
		// If the index provided is smaller than the length of the string, create a sub string
		String subStr = new String("");
		// Copy each character in sequence from original string to new string up to index provided
		for (int i = 0; i < idx; i++) {
			subStr = subStr + str.charAt(i);
		}
		// Return new sub string
		return subStr;
	}

}
