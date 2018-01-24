package com.revature.homework1;

import java.util.ArrayList;
import java.util.Arrays;

public class Question9 {
	public static void main(String[] args) {
		printPrimes();
	}
	
	public static void printPrimes() {
		ArrayList<Integer> hundred = new ArrayList<Integer>(100);
		ArrayList<Integer> primes = new ArrayList<Integer>(100);

		for(Integer i=1;i<=100;i++) {
			hundred.add(i);
		}
		
		for(Integer div : hundred) {
			if(checkPrime(div)) {
				primes.add(div);
			}
		}
		
		System.out.println(primes);
	}
	
	// Prime number checker
	private static boolean checkPrime(Integer n) {
		// Primes start at 2
		Integer start = 2;
		
		if(n==2) {
			return true;
		}
		
		// Save on processing by going until half of n
		// Ideally should be square root of n
		while(start<=n/2) {
			if(n%start==0) {
				return false;
			}
			start++;
		}
		
		return true;
	}
}
