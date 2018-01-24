package com.revature.homework1;

import java.util.Arrays;

// Sort the following using bubble sort: 1,0,5,6,3,2,3,7,9,8,4
public class Question1 {
	public static void main(String[] args) {
		String strArray = "";
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		System.out.println(Arrays.toString(bubbleSort(arr)));
	}
	
	public static int[] bubbleSort(int[] arr) {
		// First loop to move the sorting window up
		for(int left=0; left<arr.length; left++) {
			
			// Second loop to sort within the varying
			// window sizes and locations
			for(int right=0; right<left; right++) {
				// If left element is less than right,
				// swap array elements
				if(arr[left]<arr[right]) {
					int temp = arr[right];
					arr[right]=arr[left];
					arr[left]=temp;
				}
			}
		}
		return arr;
	}
}
