package com.revature.homework1;

import java.util.ArrayList;
import java.util.List;

// Q19 . Create an ArrayList and insert integers 1 through 10. Display the ArrayList. Add all the
// even numbers up and display the result. Add all the odd numbers up and display the result.
// Remove the prime numbers from the ArrayList and print out the remaining ArrayList.
// Created by: KP Saini

public class Question19 {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>(10);		// create an ArrayList of size 10

		System.out.println("The integers in the arraylist are: ");
		for (int i = 0; i < 10; i++) {					// store the numbers 1 through 10
			myList.add(i, i+1);
			System.out.println(myList.get(i));			// print the numbers to the console
		}

		Integer sumOfEvenNumbers = 0;
		Integer sumOfOddNumbers = 0;
		for (Integer number : myList) {
			if (number % 2 == 0) {
				sumOfEvenNumbers += number;				// add the even numbers
			}
			if (!(number % 2 == 0)) {
				sumOfOddNumbers += number;				// add the odd numbers
			}
		}
		// display the result to the console
		System.out.println("\nThe sum of the even numbers is: " + sumOfEvenNumbers);
		System.out.println("The sum of the odd numbers is: " + sumOfOddNumbers);
		
		// iterate through the list backwards and remove the prime numbers
		for (int i = 9; i >= 0; i--) {
			if (myList.get(i) == 2 || myList.get(i) == 3 || myList.get(i) == 5 || 
					myList.get(i) == 7) {
				myList.remove(i);
			}
		}

		// print the new list to the console
		System.out.println("\nThe list after removing the prime numbers is: ");
		for (Integer number : myList) {
			System.out.println(number);
		}
	}
}
