package com.revature.homework1;

/**
 * Homework 1. Question 5. substring.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question5 {
	
	/**
	 * Returns the substring of given string from the 0th up to given index exclusive
	 * where the first letter is that of the 0th index. In other words, returns
	 * the first idx letters in the given string. If index is larger than size
	 * of string, returns the given string. If index is less than 1, returns an empty
	 * string.
	 * 
	 * @param s String from which substring is to be extracted
	 * @param idx Index of first element to not be included
	 * @throws IllegalArgumentException if s is null
	 * @return String between indexes 0 inclusive and idx exclusive
	 */
	private static String substring(String s, int idx) {
		if (s == null) {
			throw new IllegalArgumentException();
		}
		
		if (idx > s.length()) {
			return s;
		}
		
		String result = "";
		for (int i = 0; i < idx; i++) {
			result += s.charAt(i);
		}
		return result;
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		System.out.println(substring("HelloWorld", -1));
		System.out.println(substring("HelloWorld", 0));
		System.out.println(substring("HelloWorld", 1));
		System.out.println(substring("HelloWorld", 9));
		System.out.println(substring("HelloWorld", 67));
	}
	
}
