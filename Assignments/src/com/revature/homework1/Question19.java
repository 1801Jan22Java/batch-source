package com.revature.homework1;

import java.util.ArrayList;

public class Question19 {
	public static void funWithArrayList() {
		// creates an ArrayList and populates with integers 1 to 10
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println("Original Array: " + list.toString());
		// for each integer in array, check if even and, if even, add to ongoing sum
		int evenSum = 0;
		for (int j : list) {
			if (Question6.isEven(j) == "even") {
				evenSum += j;
			}
		}
		System.out.println("Sum of Evens  : " + evenSum);
		// for each integer in array, check if odd and, if odd, add to ongoing sum
		int oddSum = 0;
		for (int k : list) {
			if (Question6.isEven(k) == "odd") {
				oddSum += k;
			}
		}
		System.out.println("Sum of Odds   : " + oddSum);
		// for every index in array, checks if contents are prime and, if so, removes
		for (int l = (list.size() - 1); l >= 0; l--) {
			if (Question9.isPrime(list.get(l))) {
				list.remove(l);
			}
		}
		System.out.println("Without Primes: " + list.toString() + "\n");
	}
}
