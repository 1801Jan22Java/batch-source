package com.revature.homework1;

//Write a program to store numbers from 1 to 100 in an array. 
//Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
public class Question12 {
	public static void main(String[] args) {
		printEvens();
	}

	public static void printEvens() {
		int[] hundred = new int[100];
		for (int i = 1; i <= 100; i++) {
			hundred[i - 1] = i;
		}

		for (int i : hundred) {
			if (i % 2 == 0) {
				System.out.print(i + " ");
			}
		}

	}
}
