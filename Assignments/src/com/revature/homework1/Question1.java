package com.revature.homework1;

import java.util.Arrays;

public class Question1 {

	public static void main(String[] args) {
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		
		System.out.println("Before sort: " + Arrays.toString(array));
		System.out.println("After sort: " + Arrays.toString(bubbleSort(array)));
		
		int[] array2 = {2,8,1,49,56,1,400,90,10,9,-1};
		
		System.out.println("Before sort: " + Arrays.toString(array2));
		System.out.println("After sort: " + Arrays.toString(bubbleSort(array2)));
		
	}
	
	//The method that bubble sorts a given array
	public static int[] bubbleSort(int[] array) {
		boolean sorting;
		int temp;
		//This while loop will keep going until a pass in which no indices switch. 
		do {

			sorting = false;

			// This iterates over the array and switches indices where applicable.
			for (int i = 0; i < array.length - 1; i++) {

				// Checks to see of the current index value is larger than the next one.
				if (array[i] > array[i + 1]) {
					sorting = true;

					// Switches the indices' values.
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}

			}

		}while (sorting);
		
		return array;
		
	}
	
}
