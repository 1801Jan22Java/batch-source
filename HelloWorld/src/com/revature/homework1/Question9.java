package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {

	// Q9. Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
	public static void main(String[] args) {
		
		checkIfPrime();
	}
	
	public static void checkIfPrime() {
		
		int i = 1;	// set the initial number for using 'while' 
		
		ArrayList<Integer> primeNo = new ArrayList<Integer>();
		
		while ( i < 100) {
			i++;			// iterate from 1 to 100
			int givenNo = i;
			boolean ifPrime = true;		// assume the number(i++) is prime
			
			for (int j = 2 ; j < givenNo ; j ++) {	//1 is not included in the dividing number
				
				// If a number is divided by a smaller number and the rest is 0, it means it is not a prime number.
				if (givenNo % j == 0 ) {  
					ifPrime = false;
					break;
				} 
			} 
			if (ifPrime) {		// if it's prime (prime is true), add the number 
				primeNo.add(givenNo);
			}
		}
		
		System.out.println("prime numbers from 1 to 100 are : " + primeNo.toString());
	}
}
