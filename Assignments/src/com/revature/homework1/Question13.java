package com.revature.homework1;

/*
 * Author: Calvin Milliron
 * Assignment: Display the triangle on the console as follows using any type of loop.  
 * 		Do NOT use a simple group of print statements to accomplish this.
 *   	0
 *   	1 0
 *   	1 0 1
 *   	0 1 0 1
 * Status: Done
 */
public class Question13 {

	public static void main(String[] args) {
		int count = 0;
		// Create for loop for number of rows
		for(int i = 1; i <= 4; i++) {
			// Create for loop for number of columns that match row number
			for(int j = 0; j < i; j++) {
				// Print remainder of number divided by 2, which will be 0 for evens, and 1 for odds
				System.out.print(count % 2 + " ");
				count++;
			}
			System.out.println();
		}
	}

}
