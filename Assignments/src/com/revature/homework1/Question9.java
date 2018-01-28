package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
// numbers to the console.
// Created by: KP Saini

public class Question9 {

	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>(100);
		
		// store the numbers 1 through 100 in an arraylist, in order
		for (int i = 0; i < 100; i++) {
			intList.add(i, i + 1);
		}
		
		System.out.println("The prime numbers between 1 and 100 are: ");
		boolean isPrime;
		for (int i = 1; i < 100; i++) {				// iterate through the list, skipping index 0 since 1 is not a prime number
			isPrime = true;							// assign boolean variable to true at start of each loop iteration
			for (int j = 1; j < i; j++) {			// divide each number by 2 through (number - 1), note the number 2 (index 1) is skipped
				if (intList.get(i) % intList.get(j) == 0) {	
					isPrime = false;				// assign isPrime to false if condition is true
				}
			}
			if (isPrime) {
				System.out.println(intList.get(i));
			}
		}
		
	}
}
