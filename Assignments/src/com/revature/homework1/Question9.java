package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {
	
	public static void primeNumbers() {
		//Add all the numbers from 1-100 to an ArrayList
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			numbers.add(i);
		}
		//Check if each value is divisible by 2 up to half of the value
		//If it is divisible, it is not prime
		//Only need to go up to half the value because the other half would have been a factor with previous half.
		for(Integer num : numbers) {
			boolean isPrime = true;
			for(int i = 2; i < num / 2; i++) {
				if(num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}
}
