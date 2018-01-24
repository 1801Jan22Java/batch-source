package com.revature.homework1;

import java.util.Arrays;

public class Question1 {

	public static void main(String[] args) {
		
		int[] array = {1,0,5,6,3,2,3,7,9,8,4};
		boolean sorting = true;
		int temp;
		
		//This while loop will keep going until a pass in which no indices switch. 
		while (sorting) {
			
			sorting = false;
			
			//This iterates over the array and switches indices where applicable.
			for (int i = 0; i < array.length - 1; i++) {
				
				//Checks to see of the current index value is larger than the next one.
				if (array[i] > array[i + 1]) {
					sorting = true;
					
					//Switches the indices' values.
					temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
				
			}
			
		}
		
		System.out.println(Arrays.toString(array));
		
	}
	
}
