//Done!

package com.revature.homework1;

import java.util.ArrayList;

public class Question12 {
	public static void main(String[] args) {
		
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int max = 100;	//The max of the range
		System.out.println("Even numbers from 1 through " + max + ": ");
		
		//Add all numbers from 1 to max (100) to the numbers ArrayList.
		for(int i = 1; i <= max; i++) {
			numbers.add(i);
		}
		
		//Use the method from Question6 to check whether each number in the ArrayList
		//is even. Print all that return true.
		for (int check : numbers) {
			if(Question6.isEven(check)) {
				System.out.print(check + " ");
			}
		}
	}
}
