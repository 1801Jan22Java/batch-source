package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program to display the number of characters for a string input. The string should be entered as a 
 * command line argument using (String [ ] args).
 */

import java.util.Scanner;

public class Question16 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string input: ");
		String stringOWord = input.nextLine(); // this will count including spaces
		System.out.println("Number of characters in your string is: " + stringOWord.length());
		input.close();
		
	} // end main()

} // end class
