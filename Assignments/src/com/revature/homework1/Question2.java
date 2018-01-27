package com.revature.homework1;

public class Question2 {

	public static void main(String[] args) {
		// Write a program to display the first 25 Fibonacci numbers beginning at 0
		
		//System.out.println("0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368");
		
		getTheNumbers();

	}

	//Calculate the numbers
	private static void getTheNumbers() {
		int[] theNumbers = new int[25];
		
		//Seed the start of the sequence
		theNumbers[0] = 0;
		theNumbers[1] = 1;
		theNumbers[2] = 1;
		
		//Calculate the numbers
		for(int i = 3; i < 25; i++) {
			theNumbers[i] = theNumbers[i- 1] + theNumbers[i - 2];
		}
		
		//Print out the calculated numbers
		for(int i : theNumbers) {
			System.out.print(i + ", ");
		}
	}
	
}
