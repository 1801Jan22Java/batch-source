package com.revature.homework1;

import java.util.ArrayList;

public class Question19 {

	public static void main(String[] args) {

		ArrayList<Integer> intArr = new ArrayList<>();

		int even = 0;

		int odd = 0;

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				even += i;
			} else {
				odd += i;
			}
			intArr.add(i);
		}
		
		//array list
		System.out.println("the ArrayList: "+intArr.toString());	
		//even sum
		System.out.println("sum of evens: "+even);
		//odd sum
		System.out.println("sum of odds: "+odd);
		
		//remove primes
		for(int i=0; i<intArr.size(); i++) {
			if(isPrime(intArr.get(i))){
				intArr.remove(i);
			}
		}
		
		System.out.println("primeless ArrayList: "+intArr.toString());
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
