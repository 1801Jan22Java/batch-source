package com.revature.homework1;

public class Question12 {
	
	public static void evenNums() {
		
		int[] numbers = new int[100];
		
		//Add the numbers from 1-100 using a for-loop
		for(int i = 1; i <= 100; i++) {
			numbers[i-1] = i;
		}
		
		//Using modulus, check if each number is divisible by 2
		//print out the number if it is
		for(int num : numbers) {
			if(num % 2 == 0) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}
}
