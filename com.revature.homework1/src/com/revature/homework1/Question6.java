package com.revature.homework1;

import java.util.Scanner;


public class Question6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int theInput;
		
		System.out.println("Enter a number to determine if its even: ");
		
		theInput = sc.nextInt();
		
		//call to function which checks if a number is even
		theChecker(theInput);
		
		sc.close();

	}

	public static void theChecker(int checked)
	{
		//if the number divided by two is equal to itself after being multiplied by 2
		//then it will be even
		int quotient = checked/2;
		if(quotient*2 == checked)
		{
			System.out.println("This number is even");
		}
		else
			System.out.println("This number is odd");
		
	
	}
	
}
