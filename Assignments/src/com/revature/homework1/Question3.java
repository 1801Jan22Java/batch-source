package com.revature.homework1;

import java.util.Scanner;

// Q3. Reverse a string without using a temporary variable. Do NOT use reverse() in the
// StringBuffer or the StringBuilder APIs.
//Created by: KP Saini

public class Question3 {	
	
	public static void main(String[] args) {		
		System.out.println(reverseAString());		// invoke reverseAString()
	}
	
	public static String reverseAString() {
		Scanner input = new Scanner(System.in);				// create a Scanner object
		
		System.out.println("Enter some text to be reversed and press enter: ");	// prompt the user
		
		String string = input.nextLine();					// create a String

		
		char[] charArray = string.toCharArray();	// create an array of chars from string
		char[] reversedCharArray = new char[charArray.length];	// create another char array
		
		// Store the characters of the String in reverse order 
		for (int i = charArray.length - 1, j = 0; i >= 0; i--, j++) {
			reversedCharArray[j] = charArray[i];
		}
		
		// Create a new String from reversedCharArray and then print it to the console
		String reversedString = new String(reversedCharArray);
		System.out.println("The text in reverse is: ");
		return reversedString;			// return the String object
	}

}
