package com.revature.homework1;

/*
 * Write a program to display the number of characters for a string input. 
 * The string should be entered as a command line argument using (String [ ] args).
 */


public class Question16 {
	//Needs arguments or does nothing
	public static void main(String[] args) {
		
		for (String str : args) {
			
			//Also counts the spaces in the arguments as a character
			System.out.println("\"" + str + "\"" + " has " + str.length() + " charcters.");
			
		}

	}

}
