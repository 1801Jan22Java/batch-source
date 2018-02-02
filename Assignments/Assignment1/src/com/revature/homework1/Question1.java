package com.revature.homework1;

public class Question1 {

	public static void main(String[] args) {
		
		//​Perform a bubble sort on the following integer array: 1,0,5,6,3,2,3,7,9,8,4

		int[] toSort = {1,0,5,6,3,2,3,7,9,8,4};
		
		printArray(toSort);
		
		sortArray(toSort);
		
		printArray(toSort);
	}

	//Print contents of the array to the console
	public static void printArray(int[] intArray) {
		for(int i : intArray){
			System.out.print(i + " ");
		}
		
		System.out.println();
	}
	
	//Sorts array in ascending order
	public static void sortArray(int[] intArray){
		
		//This boolean will be used to determine if the bubble sort is complete
		boolean swapped = true;
		
		//Loop through until array is all sorted
		while(swapped) {
			
			//Reset swaps
			swapped = false;
			
			for(int i = 1; i < intArray.length; i++) {
				//Check if adjacent pairs need to be swapped
				if(intArray[i] < intArray[i - 1]) {
					//Perform a swap
					int tmp = intArray[i];
					intArray[i] = intArray[i - 1];
					intArray[i - 1] = tmp;
					swapped = true;
				}
			}
		}
		
		System.out.println("Array Sorted!");
	}
}
