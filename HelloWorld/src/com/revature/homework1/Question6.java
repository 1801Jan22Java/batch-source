package com.revature.homework1;

import java.util.Scanner;

public class Question6 {

	
	public static void main(String[] args) {
		// Q6. Write a program to determine if an integer is even without using the modulus operator (%)
		ifNumberEven();
		 
	}
	
	public static void ifNumberEven () {
		
		System.out.println("please input only number. ");
		System.out.println("If a non-digit is entered, the program will be terminated.");
		
		int no = 0;
		
		Scanner sc = new Scanner(System.in);
		do {											// Repeat the program until a non-numeric value is entered. 
			no = sc.nextInt();							// user's input value
			if ( no == (no/2)*2) {
				System.out.println("it's even");
			} else {
				System.out.println("it's odd");
			}
			System.out.println("please input another number below. ");		
		} while (sc.hasNextInt());
		
		System.out.println("program to be terminated.");
				
	}
	 
}