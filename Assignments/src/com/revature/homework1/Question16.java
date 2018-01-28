package com.revature.homework1;

public class Question16 {

	public static void main(String[] args) {
		//Write a program to display the number of characters for a string input. The string should
		//be entered as a command line argument using (String [ ] args).

	//If a command line argument is passed, print its length otherwise indicate no arguments were passed
		if(args.length > 0)
			System.out.println("Entered string \"" + args[0] + "\" contains " + args[0].length() + " characters");
		else
			System.out.println("No command line arguments specified!");

	}

}
