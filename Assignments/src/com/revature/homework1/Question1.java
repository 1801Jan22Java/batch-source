package com.revature.homework1;

import java.util.Arrays;

public class Question1 {
	
	public static int[] bubbleSortArray(int[] bubbleArray) {
		
		boolean sorted = false;
		
		while (sorted == false) {
			sorted = true;
			int placeholder;
			// uses placeholder to keep the number of the larger number and sets the number in front of the i-1 element to it
			for(int i =1; i< bubbleArray.length ; i++) {
				placeholder =  0;
				if(bubbleArray[i-1] > bubbleArray[i]) {
					placeholder = bubbleArray[i-1];
					bubbleArray[i-1] = bubbleArray[i];
					bubbleArray[i] = placeholder;
					sorted = false; // sorted is set equal to false to so that the for loop can run to check the array again
					
				}
				
			}
			
		}
		return bubbleArray;
		
		
	}
	
	
	
	public static void main(String[] args) {
		int[] testArray = new int[11];
		testArray[0] = 1;
		testArray[1] = 0;
		testArray[2] = 5;
		testArray[3] = 6;
		testArray[4] = 3;
		testArray[5] = 2;
		testArray[6] = 3;
		testArray[7] = 7;
		testArray[8] = 9;
		testArray[9] = 8;
		testArray[10] = 4;
		
		
		bubbleSortArray(testArray);
		
		// print elements of the sorted array
		for( int i = 0 ; i < testArray.length; i++) {
			System.out.println(testArray[i] );

		}
		
			
			

				
				
			}

	

	
	
	

}
