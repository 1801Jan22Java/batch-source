package com.revature.homework1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Question14 {

	public static void main(String[] args) {
		// Write a program that demonstrates the switch case. Implement the following
		//functionalities in the cases:java
		//Case 1: Find the square root of a number using the Math class method.
		//Case 2: Display today’s date.
		//Case 3: Split the following string and store it in a string array.
		//“I am learning Core Java”
		Scanner sc = new Scanner(System.in);
		int java;
		
		//Creates menu for user on console
		System.out.println("Choose from the following menu options: ");
		System.out.println("Enter 1 for Sqaure Root");
		System.out.println("Enter 2 for today's date");
		System.out.println("Enter 3 for splitting an array");
		
		java = sc.nextInt();
		
		//switch case to determine which operation the user wants
		switch(java)
		{
		//gets square root of the number being entered by the user
		case 1:
		{
			double x;
			System.out.println("Enter a number to find the square root: ");
			x = sc.nextDouble();
			x = Math.sqrt(x);
			System.out.println("Square root of " + x + " is: " + x);				
		}
		//output the current date to the console
		case 2:
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			try {
	            
	            System.out.println("Today: " + dateFormat.format(calendar.getTime()));
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }		
		}	
		//convert string to string array and outputs the array to the console
		case 3:
		{
			String str = "I am learning Core Java.";
			String[] words = str.split("\\s");
			System.out.println("The following string is now an array: ");
			for(String w: words)
			{
				System.out.println(w);
			}
		}
		}
		sc.close();
		
	}

}
