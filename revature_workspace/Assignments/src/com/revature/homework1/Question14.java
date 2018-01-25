package com.revature.homework1;
/*
 * Q14. Write a program that demonstrates the switch case. Implement the following functionalities 
 * in the cases:java 
Case 1: Find the square root of a number using the Math class method.
Case 2: Display today’s date.
Case 3: Split the following string and store it in a string array.
           	“I am learning Core Java”

Refer to Generics in Notes under 1/25/2018
 * 
 * */



public class Question14 {
	
	public static void switchRun(int num)
	{
		switch(num)
		{
		case 1: System.out.println( Math.sqrt(num)); break;
		case 2: System.out.println(); break;
		case 3: String learning = "I am learning Core Java"; String [] learningArr = learning.split(" "); break;
		default: System.out.println("Invalid choice");
		}
		
	}

}
