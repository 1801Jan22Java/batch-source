package com.revature.homework1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Homework 1. Question 19. Arraylist demo.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question19 {

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		
		System.out.println("Here is the ArrayList: " + list.toString());
		
		int evenSum = 0;
		int oddSum = 0;
		
		// Add the evens to evenSum. Likewise for odds.
		for (int i : list) {
			if (i % 2 == 0) {
				evenSum += i;
			} else {
				oddSum += i;
			}
		}
		
		System.out.println("The sum of all even numbers is " + evenSum);
		System.out.println("The sum of all odd numbers is " + oddSum);
		
		// Using a set to activate its O(1) finding time
		// Not a big enough set to worry about speed
		Set<Integer> primes = new HashSet<Integer>();
		primes.add(2);
		primes.add(3);
		primes.add(5);
		primes.add(7);
		
		Iterator<Integer> itr = list.iterator();
		
		while (itr.hasNext()) {
			int x = itr.next();
			// Since x is prime, remove from list
			if (primes.contains(x)) {
				itr.remove();
			}
		}
		
		System.out.println("Here is the ArrayList without primes: " + list);
		
	}

}
