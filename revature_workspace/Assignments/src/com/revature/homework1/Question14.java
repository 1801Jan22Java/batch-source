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

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class Question14 {
	
	public int validateInput(String input)
	{
		char [] inputArr=input.toCharArray();
		int inputInt=0;
		for(char a:inputArr)
		{
			inputInt+= Character.getNumericValue(a);
		}
		if(inputInt<=0 || inputInt>= 4)
		{
			inputInt=0;
		}
		return inputInt;
	}
	
	private Double getSquareRoot(int num)
	{
		double square = (double)num;
		double result = Math.sqrt(square);
		return result;
	}
	public void switchRun(int input)
	{
		
		switch((Integer)input)
		{
		case 1: Scanner sc = new Scanner(System.in); 
				System.out.println("Please enter an integer:   "); 
				Integer a = sc.nextInt();
				while(!(a instanceof Integer) )
					{System.out.println("Please enter an integer:  "); 
						a=sc.nextInt();
						}
				System.out.println( getSquareRoot(a));
		case 2: Date date = new Date(); System.out.println(date); break;
		case 3: String learning = "I am learning Core Java"; String [] learningArr = learning.split(" "); 
		for(int i =0;i<learningArr.length;i++)
		{
			System.out.println(learningArr[i]);
		}
		break;
		default: System.out.println("Invalid choice");
		}
		
	}
}
