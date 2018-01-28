package com.revature.homework1;

// Q1. Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
// Created by: KP Saini
public class Question1 {

	public static void main(String[] args) {
		int[] intArray = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4");
		bubbleSort(intArray);		// Invoke bubbleSort
	}
	
	// Go through each pair of elements (e.g. compare 0,1 then 1,2 then 2,3...) 
	// and repeat process until there is a pass with no swaps
	public static void bubbleSort(int[] intArray) {
		boolean lastPass = false;	// The algorithm needs one whole pass without any swap to know that it is sorted
		
		while(!lastPass) {
			lastPass = true;		// Assume last pass
			System.out.println("Pass: ");
			for (int i = 0; i < intArray.length - 1; i++) {
				if (intArray[i] > intArray[i + 1]) {
					lastPass = false;					// Change to false if the loop has a swap
					int tempInt = intArray[i];			// Store element to swap
					intArray[i] = intArray[i + 1];
					intArray[i + 1] = tempInt;
				}
				for (int p : intArray) {				// Print the array to the console
					System.out.print(p + " ");
				}
				System.out.println("");
			}
		}
	}
}
