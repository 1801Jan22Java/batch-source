package com.revature.homework1;

public class Question1 {
	// bubbleSort function to be called by driver class
	public static int[] bubbleSort(int[] intArray) {
		int[] array = intArray;
		// temp int to store a value during position swap
		int temp = 0;
		// determines the number of iterations of bubbleSort based on size of array
		for (int i = array.length; i > 0; i--) {
			// runs through ever shorter subArray and checks each element
			for (int j = 0; j < (i - 1); j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}
