package com.revature.homework1;

public class Question3 {
	/*
	 * Reverse a string without using a temporary variable.  
	 * Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
	 */
	public static void main(String[] args) {
		
		//starting string
		String str = "string";
		
		System.out.println("string");
		
		//Prints the reverse of the string
		for (int i = str.length() - 1; i >= 0 ; i--) {
			
			System.out.print(str.charAt(i)); 
			
		}
		
		System.out.println();
		
	}
}
