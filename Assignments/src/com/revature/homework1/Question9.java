package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

/**
 * Homework 1. Question 9. Printing primes.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question9 {
	
	/**
	 * Returns true if given number is prime. False otherwise.
	 * 
	 * @param num The number to determine if prime.
	 * @return true if num is prime. false otherwise.
	 */
	private static boolean isPrime(int num) {
		// 1 is defined as not prime. Also since prime numbers are natural numbers,
		// all of {..., -2, -1, 0} cannot be prime.
		if (num < 2) return false;
		
		// If not divisible by anything before, or including, square root,
		// then the number must be prime. Note that this is ineffecient
		// for large numbers.
		for (int i = 2; i <= Math.sqrt(num); i++) {
			// A divisible number is found. Cannot be prime.
			if (num % i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Given a list of integers, prints all prime numbers in list.
	 * 
	 * @param nums A list of integers
	 * @throws IllegalArgumentException if nums is null
	 * @return No return value
	 */
	private static void printPrime(List<Integer> nums) {
		if (nums == null) {
			throw new IllegalArgumentException();
		}
		
		for (int num : nums) {
			if (isPrime(num)) {
				System.out.print(num + " ");
			}
		}
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		List<Integer> hundredList = new ArrayList<Integer>();
		for (int i = 1; i <= 100; i++) {
			hundredList.add(i);
		}
		System.out.print("The prime numbers between 1 and 100 are: ");
		printPrime(hundredList);
		
	}

}
