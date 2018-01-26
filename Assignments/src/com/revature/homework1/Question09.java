package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author: Calvin Milliron
 * Assignment: Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
 * Status: Done
 */
public class Question09 {

	public static void main(String[] args) {
		// Build array of numbers from 1 to 100
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i = 1; i <= 100; i++) { numbers.add(i); }
		int count = 0;
		boolean isPrime = true;
		System.out.println("Prime numbers found are: ");
		// Step through each number in array
		for(Integer x : numbers) {
			isPrime = true;
			// Check the remainder after dividing the current number by every number up to the current number
			for (int i = 2; i < x; i++) {
				// If dividing the current number by another number results in no remainder, it is not prime
				if (x % i == 0) { 
					isPrime = false;
				}
			}
			// If there were no remainders found when the current number was divided by every other number, it is prime
			if (isPrime == true) {
				// Only show 10 in a row
				if (count % 10 == 0 && count > 0) { System.out.println(", "); }
				else if (count > 0) { System.out.print(",\t"); }
				System.out.print(x);
				count++;
			}
		}
		
	}

}
