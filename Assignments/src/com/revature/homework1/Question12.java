package com.revature.homework1;

// Q12. Write a program to store numbers from 1 to 100 in an array. Print out all the even
// numbers from the array. Use the enhanced FOR loop for printing out the numbers.
// Created by: KP Saini

public class Question12 {

	public static void main(String[] args) {
		
		// declare and create an array of size 100
		int[] myArray = new int[100];
		
		// store the values 1 through 100 in the array
		for (int i = 0; i < myArray.length; i++) {
			myArray[i] = i + 1;
		}
		
		System.out.println("The even numbers between 1 and 100 are: ");
		
		// print all even numbers to the console with an enhanced for loop
		for (int number : myArray) {
			if (number % 2 == 0) {
				System.out.println(number);
			}
		}
	}
}
