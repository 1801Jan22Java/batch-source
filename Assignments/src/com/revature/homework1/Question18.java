package com.revature.homework1;

import java.util.Scanner;

/*
 * Author: Calvin Milliron
 * Assignment: Write a program having a concrete ;subclass that inherits three abstract methods from a superclass.  
 * 		Provide the following three implementations in the subclass corresponding to the abstract methods in the superclass:
 * 		1. 	Check for uppercase characters in a string, and return ‘true’ or ‘false’ depending if any are found.
 * 		2. 	Convert all of the lower case characters to uppercase in the input string, and return the result.
 * 		3. 	Convert the input string to integer and add 10, output the result to the console.
 * 		Create an appropriate class having a main method to test the above setup.
 * Status: Done
 */
public class Question18  extends Question18Super{

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = new String();
		// Create object from subtype
		Question18 q18 = new Question18();
		// Get user input
		System.out.print("What would you like to say? ");
		str = input.nextLine();
		// Check to see if there are upper case characters
		System.out.print("1. There are ");
		if (!q18.containsUpper(str)) {
			System.out.print("no ");
		}
		System.out.println("upper case characters in that string.");
		// Display the string in all caps
		System.out.println("2. If your caps lock was stuck you would have said \"" + q18.toUpper(str) + "\"");
		// If the string did not contain letters, the integer value plus ten is displayed even if truncated from a decimal
		try {
			System.out.println("3. The integer that represents what you said plus 10 is: " + q18.convertToInt(str));
		// Otherwise an error message appears
		} catch (NumberFormatException e) {
			System.out.println("3. Sorry, you did not enter a number.");
		}

	}
	
	public boolean containsUpper(String str) {
		boolean containsUpper = false;
		// Step through every character and check if it is upper case
		for(int i = 0; i < str.length();  i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				containsUpper = true;
			}
		}
		return containsUpper;
	}
	public String toUpper(String str) {
		// Shortcut = return str.toUpperCase();
		String strUpper = new String();
		// Step through every character and convert it to upper case
		for(int i = 0; i < str.length();  i++) {
			strUpper = strUpper + Character.toUpperCase(str.charAt(i));
		}
		return strUpper;
	}
	public int convertToInt(String str) throws NumberFormatException {
		int result = 0;
		// If the string can be parsed to an integer, save result
		try {
			result = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			// If the string can be parsed to a double, truncate and save result
			try {
				double doubleResult = Double.parseDouble(str);
				result = (int)doubleResult;
			} finally {
				
			}
		}
		// If the string can be parsed to a number, add 10 and return result
		return result + 10;
	}
}
