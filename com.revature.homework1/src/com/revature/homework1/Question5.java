package com.revature.homework1;

import java.util.Scanner;

public class Question5 {

	public static void main(String[] args) {
		
		//Q5. Write a substring method that accepts a string str and an integer idx and returns the
		//substring contained between 0 and idx-1 inclusive. Do NOT use any of the existing substring
		//methods in the String, StringBuilder, or StringBuffer APIs.
		Scanner sc = new Scanner(System.in);
		String theInput;
		int theAmount;
		
		//gets input from user and stores it into a string and int
		System.out.println("Enter a sentence: ");
		theInput = sc.nextLine();
		System.out.println("Enter the number of characters you want to display from that sentence: ");
		theAmount = sc.nextInt();
		//calls to function to display substring of entered string
		subStringMethod(theInput, theAmount);
			
		sc.close();
	}

	public static String subStringMethod(String str, Integer idx)
	{	
		//convert string to character array and prints out the substring
		char[] ch = str.toCharArray();
		for(int i = 0; i < idx; i++)
		{
			System.out.print(ch[i]);
		}
		
		return str;
	}
	
}
