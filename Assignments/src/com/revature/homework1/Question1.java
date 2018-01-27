package com.revature.homework1;

import java.util.Arrays;

public class Question1 {
	
	public static int[] bubbleSortArray(int[] bubbleArray) {
		
		boolean sorted = false;
		
		while (sorted == false) {
			sorted = true;
			int placeholder;
			for(int i =1; i< bubbleArray.length ; i++) {
				placeholder =  0;
				if(bubbleArray[i-1] > bubbleArray[i]) {
					placeholder = bubbleArray[i-1];
					bubbleArray[i-1] = bubbleArray[i];
					bubbleArray[i] = placeholder;
					sorted = false;
					
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
		
		for( int i = 0 ; i < testArray.length; i++) {
			System.out.println(testArray[i] );
			
			
			
		}
		

		System.out.println("fin") ;
		
			
			

				
				
			}

	

	
	
	

}
