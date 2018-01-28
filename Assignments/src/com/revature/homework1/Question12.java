package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

public class Question12 {

	public static void main(String[] args) {
		// Write a program to store numbers from 1 to 100 in an array. Print out all the even
		//numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		
		//Array to store the numbers
		int[] numbers = new int[100];

		//Add numbers 1 - 100 to the array
		for(int i = 1; i < 101; i++) {
			numbers[i - 1] = i;
		}
		
		System.out.println("Even Numbers:");
		
		//Enhanced for loop to print out even numbers
		for(int i : numbers) {
			if(i % 2 == 0)
				System.out.print(i + " ");
		}
	}

}
