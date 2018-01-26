package com.revature.homework1;

/**
 * Homework 1. Question 16. Counting chars.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question16 {

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		if (args.length != 0) {
			// Print first argument only
			System.out.println(args[0].length());
		} else {
			System.out.println("Usage: Question16 string");
			System.out.print("  If string is more than one word, use parentheses ");
			System.out.println("around entire string.");
		}
	}

}
