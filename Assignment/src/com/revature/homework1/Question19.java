package com.revature.homework1;

import java.util.ArrayList;
import java.util.Iterator;

public class Question19 {

	/*
	 * Q19. Create an ArrayList and insert integers 1 through 10. Display the ArrayList. 
	 * Add all the even numbers up and display the result. Add all the odd numbers up and display the result. 
	 * Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
	 */
	public static void main(String[] args) {
		
		int init = 10;										// size of ArrayList				
		ArrayList<Integer> arr = createNumberArr(init);
		System.out.println(arr.toString());
		addEvenNumber(arr);
		addOddNumber(arr);
		filterPrimeNumber(init, arr);
	
	}
	
	public static ArrayList<Integer> createNumberArr (int size) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int i = 0;
		while (i <size) {
			i++;
			arr.add(i);
		}

		return arr;
	}

	public static void addEvenNumber (ArrayList<Integer> arr) {
		int sum = 0;
		for(int no : arr) {
			if ( no%2 == 0) {
				sum += no;
			}
		}
		System.out.println("The total of even numbers : " + sum);
	}
		
	public static void addOddNumber (ArrayList<Integer> arr) {
		int sum = 0;
		for(int no : arr) {
			if ( no%2 != 0) {
				sum += no;
			}
		}
		System.out.println("The total of odd numbers : " + sum);
	}
	
	public static void filterPrimeNumber (int size, ArrayList<Integer> arr) {
		
		// use Iterator to avoid concurrentModification Error (nexted for Loop can cause)
		Iterator<Integer> iter = arr.iterator();
		
		while (iter.hasNext()) {		// loop while arr has any element
			
			int no = iter.next();
			boolean ifPrime = true;		// assume the number(i++) is prime
			
			for (int j = 2 ; j < no ; j ++) {	//1 is not included in the dividing number
				
				// If a number is divided by a smaller number and the rest is 0, it means it is not a prime number.
				if (no % j == 0 ) {  
					iter.remove();
					ifPrime = false;
					break;				// doesn't need to loop more once it's removed
				} 
			} 
		}
		 
		System.out.println(arr.toString());
	}
}
