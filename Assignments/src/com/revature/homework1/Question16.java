package com.revature.homework1;

//Write a program to display the number of characters for a string input. 
//The string should be entered as a command line argument using (String [ ] args).
public class Question16 {
	public static void main(String[] args) {
		// Get the first command line argument.
		// Find the length using String's built-in length() method.
		if(args.length==0) {
			System.out.println("0");
		}
		else {
			int strLen = args[0].length();
			
			System.out.println(strLen);
		}

	}
}
