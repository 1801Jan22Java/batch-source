package com.revature.homework1;

import java.util.*;
/*
 * Do Bubble sort on the integer array [1,0,5,6,3,2,3,7,9,8,4]
 */

public class Question1 {
	
	private static int [] arr = {1,0,5,6,3,2,3,7,9,8,4};
	
	public static void bubbleSort() {
		
		// want to iterate over the list arr.length - 1 times because you are comparing adjacent 
		// indicies and you dont want an index out of range error
		for (int i = arr.length - 1; i > 0; i --) {
			
			// check the index @ j is less than index @ j + 1, if not then swap
			for (int j = 0; j < i; j++) {
				
				if (arr[j] >= arr[j + 1]) {
					
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j+1] = temp;
					
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println("before: " + Arrays.toString(arr));
		bubbleSort();
		System.out.println("after: " + Arrays.toString(arr));
	}
	
}