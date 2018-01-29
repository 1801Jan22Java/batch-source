package com.revature.homework1;

import java.util.Arrays;

/**
 * @author Calvin Milliron
 * Assignment: Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
 * Status: Done
 */
public class Question01 {
	public static void main(String[] args) {
		int[] list = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println("Original array:\t" + Arrays.toString(list));
		// Iterate through each place in the array
		for (int i = 0; i < list.length; i++) {
			// Iterate through each remaining place in the array
			for (int j = i; j < list.length - 1 - i; j++) {
				// If place A is greater than place B, switch places
				if (list[j] > list[j + 1]) {
					// Save value of place A
					int temp= list[j];
					// Copy value of place B into place A
					list[j] = list[j + 1];
					// Copy saved value of place A into place B
					list[j + 1] = temp;
				}
			}
		}
		// Display formatted result
		System.out.println("Sorted array:\t" + Arrays.toString(list));
	}
}
