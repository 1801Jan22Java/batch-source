package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {
	public static ArrayList<Integer> primesUpTo(int number) {
		int arrSize = number;
		// creates an ArrayList of size number and an ArrayList to store its primes
		ArrayList<Integer> numbers = new ArrayList<Integer>(arrSize);
		ArrayList<Integer> primes = new ArrayList<Integer>();
		// for every integer up to size specified
		for (int i = 1; i <= arrSize; i++) {
			// add the number to an arrayList
			numbers.add(i);
			// check for primeness and add the primes to the appropriate ArrayList
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
	}

	// function checks to see if number is prime
	public static boolean isPrime (int number) {
		int check = number;
		// for every possible factor up to the square root 
		// (after the sqrt test is unnecessary)
		for (int i = 2; i <= Math.sqrt(check); i++) {
			// if it divides without a remainder
			if (check % i == 0) {
				// the number is not prime
				return false;
			}
		}
		return true;
	}	
}
