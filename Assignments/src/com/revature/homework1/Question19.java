package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Calvin Milliron
 * Assignment: Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * 		Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
 * 		Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 * Status: Done
 */
public class Question19 {

	public static void main(String[] args) {
		Integer evenSum = 0;
		Integer oddSum = 0;
		boolean isPrime = true;
		ArrayList<Integer> removals = new ArrayList<>();
		// Define original array and display it
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		System.out.println("The original list of numbers is " + numbers);
		// Step through each number, if the number is divisible by two without a remainder, then add it to the evenSum, otherwise add it to oddSum
		for(Integer x : numbers) {
			if (x % 2 == 0) {
				evenSum += x;
			} else {
				oddSum += x;
			}
		}
		// Display the sums of the even numbers and the odd numbers
		System.out.println("The sum of all the even numbers is " + evenSum + ".");
		System.out.println("The sum of all the odd numbers is " + oddSum + ".");
		// Starts with the first element and works up to the last element in the array
		for(int i = 0; i < numbers.size() - 1; i++) {
			isPrime = true;
			// Check the remainder after dividing the current number by every number up to the current number
			// Starts with 2 and works up to the numeric equivalent of the element that exists at index i
			for (int j = 2; j < numbers.get(i); j++) {
				// If dividing the current number by another number results in no remainder, it is not prime
				if (numbers.get(i) % j == 0) { 
					isPrime = false;
				}
			}
			// If there were no remainders found when the current number was divided by every other number, it is prime
			// If the number is prime add it to a temporary array
			if (isPrime == true) {
				removals.add(numbers.get(i));
			}
		}
		// Use temporary array to remove prime numbers from original array
		for(Integer x : removals) {
			numbers.remove(x);
		}
		System.out.println("The result list after removing all prime numbers is " + numbers);
	}

}
