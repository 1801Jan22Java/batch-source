package com.revature.homework1;

/**Created by: Jeffrey Rubi
 * Date: 25 January 2018
 * Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the 
 * console.
 */

import java.util.List;
import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		
		// my display counter
		int count = 0;
		// Create an ArrayList to store values 1-100
		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Prime numbers from 1-100 stored in an ArrayList: ");
		
		for (int i = 0; i < 100; i++) {
			numbers.add(i + 1);
			
			boolean isPrime = true;
			
			if(i+1 == 1) { // 1 is not a prime auto
				isPrime = false;
			}
			
			for(int j = 2; j <= (i+1) / 2; j++) { // prime numbers are divisible by itself or 1 only.
				if( (i+1) % j == 0 ) {
					isPrime = false;
					break;
				}
			}
			
			if(isPrime) {
				// display 10 primes per line
				count++;
				if (count % 10 == 0) {
					System.out.println(numbers.get(i));
				} else {
					System.out.print(numbers.get(i) + " ");
				}
			}
		} // end for

	} // end main()

} // end class
