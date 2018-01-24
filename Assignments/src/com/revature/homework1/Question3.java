package com.revature.homework1;

public class Question3 {
	public static void main(String[] args) {
		System.out.println(reverse("this is an input"));
	}
	
	public static String reverse(String input) {
		// An output variable
		String output="";	
		
		// Start at the end of the string by beginning 
		// from the total length of the input.
		// Subtract from this value to get the index.
		for(int i=input.length()-1; i>=0; i--) {
			
			// Get the character at index
			// Convert to String using the Character static method toString()
			// Concatenate to output
			output=output.concat(Character.toString(input.charAt(i)));
		}
		
		return output;
	}
}
