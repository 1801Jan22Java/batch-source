package com.revature.homework1;

import java.util.Scanner;

/**Created by: Jeffrey Rubi
 * Date: 24 January 2018
 * Write a program to determine if an integer is even without using the modulus
 * operator (%)
 */

public class Question6 {

	public static void main(String[] args) {
		
		/* Idea: Substract 2 from n until n < 2. If n is 1 then not even else
		 * (n = 0) it is even.
		 */
		String message = "Your number is even: ";
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter an integer value: ");
		int n = input.nextInt();
		input.close();

		if(n == 0) System.out.println(message + "true");
		else if(n < 0) {
			n = -1 * n;
			System.out.println(message + isEven(n));
		} 
		else System.out.println(message + isEven(n)); 
	}
	
	public static boolean isEven(int n) {
		do {
			n -= 2; 
		} while(n >= 2);
		
		if(n == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
