package com.revature.homework1;

/**
 * @author Calvin Milliron
 * Assignment: Reverse a string without using a temporary variable.  
 * 		Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
 * Status: Done
 */
import java.util.Scanner;
public class Question03 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String str = new String();
		// Get input from the user
		System.out.print("What you would like reversed: ");
		str = input.nextLine();
		// Save the length of the user input
		int length = str.length();
		// Add each letter in sequence from the end of the original string onto the end of the string
		for (int i = length-1; i >= 0; i--) {
			str = str + str.charAt(i);
		}
		// Remove the first half of the string containing the original content
		str = str.substring(length);
		// Print the result
		System.out.println("The reverse is: \"" + str + "\"");
		
	}

}
