package com.revature.homework1;

import java.util.Arrays;

/**
 * Homework 1. Question 1. Bubble sort.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question1 {
	
	/**
	 * Given an array of integers, modifies array by performing bubble sort
	 * on it.
	 * 
	 * @param list Integer array to be sorted
	 * @modifies list
	 * @return No return value
	 */
	private static void bubbleSort(int[] list) {
		// If swapFlag is true, we need to make at least one more pass over list
		boolean swapFlag = true;
		
		while (swapFlag) {
			// Assume list is sorted
			swapFlag = false;
			
			for (int i = 0; i < list.length - 1; i++) {
				
				// If an element is greater than the one that succeeds it ...
				if (list[i] > list[i + 1]) {
					// ... we know that it is not sorted, so we need to make another pass
					swapFlag = true;
					
					// Here, a swap is performed to correct the order
					int temp = list[i + 1];
					list[i + 1] = list[i];
					list[i] = temp;
				}
				// At this point, if swapFlag is still false, then the array is sorted
				// so we can exit the while loop and the entire method
			}
		}
	}
	
	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		int[] list = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
		System.out.println("Before: " + Arrays.toString(list));
		bubbleSort(list);
		System.out.println("After: " + Arrays.toString(list));
	}
	
}
