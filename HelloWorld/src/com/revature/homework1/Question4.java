package com.revature.homework1;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		
		//Write a program to compute N factorial
		factorial();
		
	}
	
	public static void factorial() {
		
		System.out.println("---please input the N below ---");
		Scanner sc = new Scanner(System.in);
		
		int sum = 1;					// initialize the total sum number
		if (sc.hasNextInt()) {
			int n = sc.nextInt();		// user's input number
			int i = 1;
			while (i <= n) {			// The numbers between 1 to n will be multiplied 
				sum *= i;
				i++;
			}
			System.out.println("total sum is = "+sum);
		} else {
			System.out.println("opps! please input only number.");
		}
	}
}
