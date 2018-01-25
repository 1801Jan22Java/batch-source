//Done!

package com.revature.homework1;

import java.util.ArrayList;

public class Question19 {
	public static void main(String[] args) {
		ArrayList<Integer> arrInt = new ArrayList<Integer>();
		
		//Add numbers from 1 to 10 to the ArrayList arrInt
		for(int i = 1; i <= 10; i++) {
			arrInt.add(i);
		}
		
		//Add all even numbers up
		int evenSum = 0;
		
		System.out.print("The ArrayList: ");
		//Iterate through the ArrayList
		for(int num : arrInt) {
			System.out.print(num + " ");
			
			//If num is even, add it to evenSum
			if(num % 2 == 0) {
				evenSum += num;
			}
		}
		System.out.println();
		System.out.println("The sum of the even numbers is: " + evenSum);
		
		
		//Add all the odd numbers up
		int oddSum = 0;
		
		//Iterate through the ArrayList again
		for(int num : arrInt) {
			//If num is odd, add it to oddSum
			if(num % 2 != 0) {
				oddSum += num;
			}
		}
		System.out.println("The sum of the odd numbers is: " + oddSum);
		
		
		for(int i = 0; i < arrInt.size(); i++) {
			//If number at index i of arrInt is prime, remove it from arrInt
			if(Question9.isPrime(arrInt.get(i))) {
				arrInt.remove(i);
			}
		}
		
		System.out.print("The composite numbers in the ArrayList are: ");
		for(int num : arrInt) {
			System.out.print(num + " ");
		}
		
	}
	
}
