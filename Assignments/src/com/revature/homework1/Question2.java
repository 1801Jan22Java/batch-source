package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

// Q2 . Write a program to display the first 25 Fibonacci numbers beginning at 0.
//Created by: KP Saini
public class Question2 {

	public static void main(String[] args) {
		
		// Declare, create, and initialize an ArrayList with the initial values of 0 and 1
		ArrayList<Integer> myList = new ArrayList<>
		(Arrays.asList(new Integer(0), new Integer(1)));
		
		int numberOfFibonacciNumbers = 25;		// Note: This number can be changed 
												// if more or less Fibonacci numbers are desired
		
		// Sum the last two numbers in the list and then insert the sum into the end of the list 
		for (int i = 0; myList.size() <= numberOfFibonacciNumbers - 1; i++) {
			Integer nextNumber = myList.get(i) + myList.get(i+1);
			myList.add(nextNumber);
		}
		
		// Print out the list to the console
		System.out.println("Beginning at 0, the first " + myList.size() 
			+ " Fibonacci numbers are:\n" + myList.toString());	
	}
}
