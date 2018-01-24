package com.revature.homework1;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the array. 
 * Use the enhanced FOR loop for printing out the numbers.
 */

public class Question12 {

	public static void main(String[] args) {
		
		int[] array = new int[100];
		
		//Fills the array with numbers from 1 to 100 
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		
		//checks all numbers in the array and if they are even, prints them out
		for (int i : array) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}

	}

}
