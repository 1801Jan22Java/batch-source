package com.revature.homework1;

import java.util.ArrayList;

public class Question9 {

	public static void main(String[] args) {
		
		ArrayList<Integer> intArray = new ArrayList<Integer>();
		System.out.println("prime numbers:");
		for(int i=1; i<100; i++) {
			if(isPrime(i)) {
				System.out.println(i+" ");
			}
			intArray.add(i);
			
		}
	}
	
	public static boolean isPrime(int n) {
		for(int i=2; i<n; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
