package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

public class Question9 {

	public static void main(String[] args) {
		//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime
		//numbers to the console.
		
		//Array list to store the numbers
		List<Integer> numbers = new ArrayList<Integer>();

		System.out.println("Prime numbers: ");
		
		//Add numbers 1 - 100 to the list
		for(int i = 1; i < 101; i++) {
			numbers.add(i);
			
			if(isPrime(i))
				System.out.print(i + " ");
		}
		
	}
	
	//Check to see if a number is prime or not!
	public static boolean isPrime(int num) {
		
		//Loop through all possible divisors of a number and idmediatly return if a number is found to not be prime
		for(int i = 2; i <= num  / 2; i++) {
			if(num % i == 0)
				return false;
		}
		
		//No divisors found so number must be prime!
		return true;
	}
}
