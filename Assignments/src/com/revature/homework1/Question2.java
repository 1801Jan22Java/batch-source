package com.revature.homework1;

/* Created by: Jeffrey Rubi
 * Date: 24 January 2018
 * Write a program to display the first 25 Fibonacci numbers beginning at 0.
 */

public class Question2 {

	public static void main(String[] args) {
		// no input from user embedded code, prints out the 1st 25 Fib. numbers
		System.out.println("The first 25 Fibonacci number are:");
		for(int i = 0; i < 25; i++) {
			System.out.print(fib(i) + " ");
		}
	}
	
	public static long fib(long number) {
		if(number == 0) return 0; // base case 1
		else if(number == 1) return 1; // base case 2
		// Fibonacci numbers are the sum of the 2 previous Fibs.
		else return fib(number - 1) + fib(number - 2); 
	}

}

/***checking
 *  0 1 1 3 5 8 13....
 *  0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 
 */
 