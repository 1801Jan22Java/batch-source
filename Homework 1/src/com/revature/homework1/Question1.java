//Done!
package com.revature.homework1;

//Bubble Sort!
public class Question1 {
	public static void bubbleSort() {
		
		//The unsorted array
		int[] numbers = {1,0,5,6,3,2,3,7,9,8,4};
		int i;
		
		/*
		 * Use a nested for-loop
		 * Outer loop allows us to iterate through the array n times
		 * Inner loop is for comparing adjacent elements, swapping if necessary
		 */
		for(i = 0; i < numbers.length; i++) {
			for(int j = 0; j < numbers.length-1; j++) {
				if(numbers[j] > numbers[j+1]) {
					int temp = numbers[j];
					numbers[j] = numbers[j+1];
					numbers[j+1] = temp;
				}
			}
		}
		
		//Print the sorted array
		System.out.print("Sorted Array: ");
		for(i = 0; i < numbers.length-1; i++) {
			System.out.print(numbers[i] + " ");
		}
		System.out.println(numbers[numbers.length-1]);
	}
	
	public static void main(String[] args) {
		Question1.bubbleSort();
	}
}
