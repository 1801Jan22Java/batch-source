package com.revature.homework1;

import java.util.Arrays;

//Bubble sort for following integer array 1,0,5,6,3,2,3,7,9,8,4
public class Question1 {
	
	public static void isSorted(int[] intArray) {
		boolean isSort = false;
		//Using a do-while loop to see if integer array is already sorted
		do {
			isSort = true;
			for(int i : intArray) {
				//Check if following element is larger than the current
				//swap if true
				if(intArray[i] > intArray[i+1]) {
					int temp = intArray[i];
					intArray[i] = intArray[i+1];
					intArray[i+1] = temp;
					isSort = false;
				}
			}
		}
		while(!isSort);
		
		System.out.println(Arrays.toString(intArray));
	}
}
