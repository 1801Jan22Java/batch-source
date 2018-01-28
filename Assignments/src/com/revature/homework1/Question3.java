package com.revature.homework1;

public class Question3 {
	public static void main(String[] args) {
		/*
		 * A little bit of a misleading question given the nature of strings in Java; since
		 * they're immutable, anytime you create a new string will create a new string in 
		 * memory. While you could manipulate substrings to reverse it, you would be creating
		 * many strings in memory to accomplish this. So I interpreted the question as creating 
		 * a char array and walking backwards through the string adding chars to the array as I
		 * go. String.copyValueOf will give us the string representation of the new reversed string.
		 */
		String reverseIt = "Reverse Me!";
		char[] reversedIt = new char[reverseIt.length()];
		
		for(int i = 0; i < reverseIt.length(); i++ ) {
			reversedIt[i] = reverseIt.charAt(reverseIt.length() - 1 - i);
		}
		
		System.out.println(String.copyValueOf(reversedIt));
	}
}
