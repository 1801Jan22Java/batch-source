package com.revature.homework1;

import java.util.Arrays;

public class Question1 {

	// Q1. Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
	
	public static void main(String[] args) {
		
		int[] intArr = {1,0,5,6,3,2,3,7,9,8,4};
		bubbleSort(intArr);
	}
	
	public static void bubbleSort (int[] intArr) {
		
		// When a bubble sort is executed once, the comparison of the two adjacent numbers is repeated by the number of the whole elements minus one. 
		for (int j = 0 ; j <intArr.length-1 ; j++) {				
			
			int init = 0;		// This means the total number of times that two adjacent numbers have changed when a bubble sort is run.		
			
			for (int i = 0 ; i < intArr.length-1 ; i++) {
				
				if (intArr[i] - intArr[i+1] > 0) {
					int temp = intArr[i];
					intArr[i] = intArr[i+1];
					intArr[i+1] = temp;
					init++;
				};
			}
			
			if (init < 1 ) {	// If no element exchange has taken place, stop a bubble sort.
				break;
			}
		}
		System.out.println("final result: "+ Arrays.toString(intArr));
	}
}
