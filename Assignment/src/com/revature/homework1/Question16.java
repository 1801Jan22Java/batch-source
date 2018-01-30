package com.revature.homework1;

import java.util.Arrays;

public class Question16 {

	/*
	 * Q16. Write a program to display the number of characters for a string input. 
	 * The string should be entered as a command line argument using (String [ ] args).
	 */
	public static void main(String[] args) {

		int length = Arrays.toString(args).length();
		if (length > 0) {
			System.out.println("the number of characters : "+ length);
		} else {
			System.out.println();
			System.out.println("the number of characters : 0  ");
		}
		
	}
	
	 
}
