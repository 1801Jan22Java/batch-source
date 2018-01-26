package com.revature.homework1;

/**
 * Homework 1. Question 3. Reverse string.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question3 {
	
	/**
	 * Returns the reverse of the given string.
	 * 
	 * @param s String to reverse
	 * @throws IllegalArgumentException if s is null
	 * @return The reverse of s
	 */
	private static String reverseString(String s) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		
		char[] chars = s.toCharArray();
		
		// Start by swapping the first and last characters
		int lowerLim = 0;
		int higherLim = s.length() - 1;
		
		// As long as condition is valid, lowerLim and higherLim should be swapped
		while (lowerLim < higherLim) {
			// Perform the swap using xor operations
			chars[lowerLim] ^= chars[higherLim];
			chars[higherLim] ^= chars[lowerLim];
			chars[lowerLim] ^= chars[higherLim];
			
			// Then swap the next from bottom and next from top and so on
			lowerLim++;
			higherLim--;
		}
		
		return new String(chars);
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		String a = "";
		String b = "a";
		String c = "abc";
		String d = "Hello world!";
		
		String template = "The reverse of ";
		
		System.out.println(template + a + " is " + reverseString(""));
		System.out.println(template + b + " is " + reverseString("a"));
		System.out.println(template + c + " is " + reverseString("abc"));
		System.out.println(template + d + " is " + reverseString("Hello world!"));
	}

}
