package com.revature.homework1;

public class Question3 {
	/*
	 * Reverse a string without using a temporary variable.  
	 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */
	public static void main(String[] args) {
		
		//starting string
		String str = "string";
		int origLen = str.length();
		
		System.out.println(str);
		
		//Pulls the reverse string out and prints it
		System.out.println(reverseString(str));
		
		str = "This is a string";
		
		System.out.println(str);
		
		//Pulls the reverse string out and prints it
		System.out.println(reverseString(str));
		
	}
	
	public static String reverseString(String str) {
		
		int origLen = str.length();
		//concats the reverse string to the end of the original string
		for (int i = origLen - 1; i >= 0; i--) {

			str += str.charAt(i);

		}

		// Pulls the reverse string out and returns it
		
		return str.substring(origLen, str.length());
	}
}
