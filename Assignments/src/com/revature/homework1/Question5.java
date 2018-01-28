package com.revature.homework1;

public class Question5 {

	// Q5. Write a substring method that accepts a string str and an integer idx and returns the
	// substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing substring
	// methods in the String, StringBuilder, or StringBuffer APIs.
	// Created by: KP Saini
	
	public static void main(String[] args) {
		
		// console demo
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 1) as arguments: " 
				+ toSubstring("Example", 1));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 2) as arguments: " 
				+ toSubstring("Example", 2));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 3) as arguments: " 
				+ toSubstring("Example", 3));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 4) as arguments: " 
				+ toSubstring("Example", 4));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 5) as arguments: " 
				+ toSubstring("Example", 5));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 6) as arguments: " 
				+ toSubstring("Example", 6));
		
		System.out.println("Result for passing in (" +  "\"Example\"" + ", 7) as arguments: " 
				+ toSubstring("Example", 7));
		
	}
	
	// TODO: Error handling for if int is above the number of string elements
		private static String toSubstring(String str, int idx) {
			// Return "" if the passed in String is null or if idx value is not valid
			if (str == null || str.length() == 0 || idx <= 0 || idx > str.length()) {
				System.out.println("Input is not valid!");
				return "";
			}
			
			char[] charArray = stringToCharArray(str);	 // Invoke stringToCharArray(String s)
			
			char[] newCharArray = new char[idx];		 // Create an array of size idx
			
			for (int i = 0; i < idx; i++) {				 // Copy the elements up to idx
				newCharArray[i] = charArray[i];			
			}
			
			String substring = new String(newCharArray); // Create a new String object from the char Array
			return substring;							 // Return the string
		}		
		
		// method that has the same functionality as the String toCharArray method
		private static char[] stringToCharArray(String string) {
			// return null if null is passed in as a string type
			if (string == null) {
				return null;
			}
			
			char[] charArray = new char[string.length()];
			for (int i = 0; i < charArray.length; i++) {
				charArray[i] = string.charAt(i);
			}
			return charArray;
		}
}
