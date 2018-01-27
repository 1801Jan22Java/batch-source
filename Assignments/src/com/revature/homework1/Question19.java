package com.revature.homework1;

import java.util.ArrayList;

public class Question19 {
	
	public static int evenSum(ArrayList<Integer> intList) {
		int sum = 0;
		for(int i : intList) {
			if(i % 2 ==0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static int oddSum(ArrayList<Integer> intList){
		int sum = 0;
		for(int i : intList) {
			if(i % 2 != 0) {
				sum += i;
			}
		}
		return sum;
	}
	
	public static void removePrime(ArrayList<Integer> intList) {
		for(Integer num : intList) {
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
	}
}
