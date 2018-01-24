package com.revature.homework1;

/* Created by: Jeffrey Rubi
 * Date: 23 January 2018
 * Reverse a string without using a temporary variable.  Do NOT use reverse() 
 * in the StringBuffer or the StringBuilder APIs.
 */

public class Question3 {

	public static void main(String[] args) {
		// set the String
		String word = "Hello World";
		// Print by iterating through the string from the last index to the 0th index
		for(int i = word.length() - 1; i >= 0; i--) {
			System.out.print(word.charAt(i));
		} // end for
	} // end main()

} // end class
