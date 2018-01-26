package com.revature.homework1;

/*
 * Author: Calvin Milliron
 * Assignment: Write a program to display the first 25 Fibonacci numbers beginning at 0.
 * Status: Done
 */
public class Question02 {
	public static void main(String[] args)
		{
		// Define how many numbers to calculate
		int total = 25;
		
		// Start with F0, and F1
		int x = 0;
	    int y = 1;
	    // Print F0
	    System.out.println("F0 = " + x);
	    for (int i = 1; i <= total; i++) {
	    	// Print F1 and on
	        System.out.println("F" + i + " = " + y);
	        // Add last number and next number
	        int temp = x + y;
	        // Update last number and next number
	        x = y;
	        y = temp;
	    }
	}
}
