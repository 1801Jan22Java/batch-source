package com.revature.homework1;

import java.util.Scanner;

public class Question16 {

	//Returns the number of characters in a string (including whitespaces)
	public static int stringCount(String str) {
		return str.length();
	}
	
	//Our main
	public static void main(String[] args) {
		
		//Our scanner
		Scanner sc = new Scanner(System.in);
		
		String inputString = "";
		
		//Will prompt the user for string until they type "bye"
		do {
			
			System.out.println("Type anything and hit enter and the String shall be calculated.  Type bye to exit");
			inputString = sc.nextLine();
			//Our string count is printed out
			System.out.println("The String size is " + stringCount(inputString));
			
		//Exit when they type "bye"
		}while (!inputString.equals("bye"));
		
	}	
	
}
