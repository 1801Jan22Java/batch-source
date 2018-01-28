package com.revature.homework1;
import java.util.ArrayList;

public class Question9 {
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 1; i <= 100; i++) {
			nums.add(i);
			if(isPrime(i) && i != 1) {
				System.out.println(i);
			}
		}
		
	}
	
	/*
	 * Helper method to determine whether or not a number is prime. Luckily, with a little knowledge of
	 * prime numbers, we can make this algorithm more efficient. If you list out the numbers of a number
	 * the square root of a number will always be in the middle. We also know that factors appear in pairs,
	 * and that as long as it's not divisible by two, we don't need to worry about the evens. That means if we
	 * can check that it's not divisible by two, and that all the odds up to n's square root are not divisible,
	 * we can determine if n is prime or not.
	 */
	public static boolean isPrime(int n) {
		if(n == 2) {
			return true;
		}
		
		if(n%2 == 0) {
			return false;
		}else{
			for(int i = 3; i*i <= n; i+=2) {
				if(n%i == 0) {
					return false;
				}
			}
		}
		
		return true;
	}
}
