package com.revature.homework1;

/**
 * @author Calvin Milliron
 * Assignment: Write a program to display the number of characters for a string input. 
 * 		The string should be entered as a command line argument using (String [ ] args).
 * Status: Done
 */
public class Question16 {

	public static void main(String[] args) {
		int count = 0;
		// Step through all strings separated by spaces stored in the array
		for(String x : args) {
			// Step through every character of each string
			for(int i = 0; i < x.length(); i++) {
				count++;
			}
			// Count spaces between arguments, will result in extra count at end of loop
			count++;
		}
		// Remove extra count, then display
		System.out.println(count - 1 + " total characters were entered as arguments to this program including spaces.");
	}

}
