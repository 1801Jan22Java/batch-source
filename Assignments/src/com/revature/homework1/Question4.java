package com.revature.homework1;

/* Created by: Jeffrey Rubi
 * Date: 24 January 2018
 * Write a program to compute N factorial.
 */

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		/* Assuming user will follow the prompt, NOT expecting negative integer,long,
		 * float, double. No checks for special characters. 
		 */
		System.out.print("Enter only positive integer: ");
		int n = input.nextInt();
		input.close();
		
		System.out.println("factorial of " + n + " is: " + factorial(n));
	}
	
	public static long factorial(long n) {
		if(n == 0) return 1; // base case
		else return n * factorial(n - 1); // recursive calls here
	}

}
