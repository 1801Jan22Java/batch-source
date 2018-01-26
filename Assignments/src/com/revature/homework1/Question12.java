package com.revature.homework1;

/*
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even
numbers from the array. Use the enhanced FOR loop for printing out the numbers.
 */
public class Question12 {
	
	private Integer[] numbers;
	
	public Question12() {
		numbers = new Integer[100];
	}
	
	public void doThing() {
		for(int i = 0; i < 100; i++) {
			numbers[i] = i+1;
		}
		for(Integer j: numbers) {
			if(numbers[j] % 2 == 0) 
				System.out.print(numbers[j] + ", ");
			
			if(numbers[j] % 8 == 0)
				System.out.println(); // for cleaning up the output
		}
	}
	
}
