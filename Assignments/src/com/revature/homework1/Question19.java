package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the even numbers up 
 * and display the result. Add all the odd numbers up and display the result. Remove the prime numbers from 
 * the ArrayList and print out the remaining ArrayList.
 */

import java.util.List;
import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {
		
		int sumEven = 0;
		int sumOdd = 0;
		
		List<Integer> myList = new ArrayList<>();
		
		// initialize values in the ArrayList
		for(int i = 0; i < 10; i++) {
			myList.add(i+1);
		}
		// display ArrayList
		System.out.println(myList);
		
		for(int k : myList) {
			// System.out.println(k);
			
			if(k % 2 == 0) {
				sumEven += k;
			} 
			else {
				sumOdd += k;
			}
		} // end for
		
		// display sum of even, and odd numbers
		System.out.println("Sum of all even numbers: " + sumEven);
		System.out.println("Sum of all odd numbers: " + sumOdd);
		// System.out.println(myList.size());
		
		for (int i = 0; i < myList.size(); i++) {
			
			boolean isPrime = true;
						
			if(myList.get(i) == 1) { // 1 is not a prime auto
				isPrime = false;
			}
			
			for(int j = 2; j <= (myList.get(i)) / 2; j++) { // prime numbers are divisible by itself or 1 only.
				if( (myList.get(i)) % j == 0 ) {
					isPrime = false;
					break;
				}
				
			}
			
			if(isPrime) {
				myList.remove(i);
				i = i-1; // every time I remove, start at previous index again because array resize
			}
			
		} // end for
		
		System.out.println(myList);
		
	} // end main()

} // end class
