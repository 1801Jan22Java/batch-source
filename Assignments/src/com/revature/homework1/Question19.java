package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Author: Calvin Milliron
 * Assignment: Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
 * 		Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
 * 		Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
 */
public class Question19 {

	public static void main(String[] args) {
		Integer evenSum = 0;
		Integer oddSum = 0;
		boolean isPrime = true;
		ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
		ArrayList<Integer> removals = new ArrayList<>();
		System.out.println("The original list of numbers is " + numbers);
		for(Integer x : numbers) {
			if (x % 2 == 0) {
				evenSum += x;
			} else {
				oddSum += x;
			}
			
			
			
			
		}
		System.out.println("The sum of all the even numbers is " + evenSum + ".");
		System.out.println("The sum of all the odd numbers is " + oddSum + ".");
		
		for(int i = numbers.size() - 1; i > 0; i--) {
			isPrime = true;
			// Check the remainder after dividing the current number by every number up to the current number
			for (int j = 2; j < i; j++) {
				// If dividing the current number by another number results in no remainder, it is not prime
				if (numbers.get(i) % j == 0) { 
					isPrime = false;
				}
			}
			// If there were no remainders found when the current number was divided by every other number, it is prime
			if (isPrime == true) {
				//numbers.remove(numbers.indexOf((Integer)i));
				//System.out.println("object " + i + " = index " + numbers.indexOf(i));
				System.out.println(i + " is prime");
				
			}
		}
//		for(Integer x : removals) {
//			numbers.remove(x);
//		}
		//System.out.println(removals);
		System.out.println(numbers);
		
		
		
				
	}

}
