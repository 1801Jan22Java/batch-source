package com.revature.homework1;

/*
 * Q1. ​Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4
 */
public class Question1 {
	private int arr[] = {1, 0, 5, 6, 3, 2, 3, 7, 9, 8, 4};
	
	public int[] bubbleSort() {
		boolean swapped = true;
		do {
			swapped = true;
			for(int i = 1; i < 11; i++) {
				if(arr[i] < arr[i-1]) {
					swapped = false;
					int temp = arr[i];
					arr[i] = arr[i-1];
					arr[i-1] = temp;
				}
			}
		}while(!swapped);
		return arr;
	}
	
}
