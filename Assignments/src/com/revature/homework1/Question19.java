package com.revature.homework1;
/*
Create an ArrayList and insert integers 1 through 10. 
Display the ArrayList. Add all the even numbers up
and display the result. Add all the odd numbers up 
and display the result. Remove the prime numbers from 
the ArrayList and print out the remaining ArrayList.
*/

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
		// Insert 1-10 into an ArrayList
		ArrayList<Integer> deca = insert1_10();

		// Add all Even numbers and display the results
		addEvens(deca);

		// Add all Odds and display the results
		addOdds(deca);

		// Remove primes, print remaining ArrayList
		for (int n = 1; n < 10; n++) {
			// Use the prime checker from Question 9
			if (Question9.checkPrime(n)) {
				deca.remove(new Integer(n));
			}
		}
		System.out.println("Array without primes: " + deca.toString());

	}

	public static ArrayList<Integer> insert1_10() {
		ArrayList<Integer> deca = new ArrayList<Integer>(10);
		for (int i = 1; i <= 10; i++) {
			deca.add(i);
		}

		System.out.println("Array of 1-10: " + deca.toString());

		return deca;
	}

	public static void addEvens(ArrayList<Integer> intArr) {
		// Create a placeholder var for the result
		Integer n = new Integer(0);

		// Loop through checking for evenness
		for (Integer num : intArr) {
			if (num % 2 == 0) {
				n += num;
			}
		}
		System.out.println("Sum of evens: " + n);
	}

	// Virtually the same code as addEvens, except with
	// a different name and a change to the if-condition
	public static void addOdds(ArrayList<Integer> intArr) {
		Integer n = new Integer(0);
		for (Integer num : intArr) {
			if (num % 2 != 0) {
				n += num;
			}
		}
		System.out.println("Sum of odds: " + n);
	}

}
