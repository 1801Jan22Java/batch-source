package com.revature.homework1;

// Q13. Display the triangle on the console as follows using any type of loop. Do NOT use a simple
// group of print statements to accomplish this.
//	0
//	1 0
//	1 0 1
//	0 1 0 1
//Created by: KP Saini

public class Question13 {

	public static void main(String[] args) {
	
		// create an outer loop to represent the rows
		for (int i = 0, k = 0; i < 4; i++) {	// create a k variable to be added to each j index
			// create an inner loop to represent the columns
			for (int j = 0; j < i + 1; j++) {
				if ((j + k) % 2 == 0) {			// print a 0 if j + k is even
					System.out.print("0 ");
				}
				else {
					System.out.print("1 ");		// print a 1 if j + k is odd
				}
			}
			if (i % 2 == 0) {
				k += 1;							// increment k by 1 if i is even
			} else {
				k += 2;							// increment k by 2 if i is odd
			}
			System.out.println();
		}
	}
}
