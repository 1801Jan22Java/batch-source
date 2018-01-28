package com.revature.homework1;

// Q16. Write a program to display the number of characters for a string input. The string should
// be entered as a command line argument using (String [ ] args).
// Created by: KP Saini

// See screenshot titled: Question16_Screenshot.PNG
public class Question16 {

	public static void main(String[] args) {
		// display the number of characters in each String argument entered from the 
		// command line
		for (int i = 0; i < args.length; i++) {
			System.out.println("The String in args[" + i + "] contains " 
					+ args[i].length() + " characters.");
		}		
	}
}
