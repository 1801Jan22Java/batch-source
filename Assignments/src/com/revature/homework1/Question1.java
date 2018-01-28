package com.revature.homework1;

public class Question1 {
	
	/*
	 * Bubblesort is most likely the easiest sort method to implement. It is implemented exactly how you think,
	 * iterating repeated over the array bubbling the largest integers to the top.
	 */
	public static void main(String[] args) {
		int[] exampleSet = {1,0,5,6,3,2,3,7,9,8,4};
		
		for(int i = 0; i < exampleSet.length - 1; i++) {
			
			for(int j = i+1; j < exampleSet.length; j++) {
				
				if(exampleSet[i] > exampleSet[j]) {
					
					int swap = exampleSet[i];
					exampleSet[i] = exampleSet[j];
					exampleSet[j] = swap;
				}
			}
		}
		
		for(int i = 0; i < exampleSet.length; i++) {
			System.out.println(exampleSet[i]);
		}
	}
}
