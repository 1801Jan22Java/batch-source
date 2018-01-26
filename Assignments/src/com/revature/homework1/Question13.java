package com.revature.homework1;

/**
 * Homework 1. Question 13. Pyramid drawing.
 * 
 * @author Ahmed Awwad
 *
 */
public class Question13 {
	
	/**
	 * Draws a pyramid of 0's and 1's for given height. Draws nothing
	 * if given height is less than 1
	 * 
	 * @param height The vertical height of the leftmost column
	 * @return No return value
	 */
	private static void drawTriangle(int height) {
		// Counter to keep track of 0's and 1's
		int counter = 0;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				// If the counter is even, print 0, else 1
				if (counter % 2 == 0) {
					System.out.print("0 ");
				} else {
					System.out.print("1 ");
				}
				// By incrementing the counter each time something is printed,
				// can keep alternating 0's and 1's
				counter++;
			}
			// Start a new row with next iteration
			System.out.println();
		}
	}

	/**
	 * @param args A string array containing command line arguments.
	 * @return No return value
	 */
	public static void main(String[] args) {
		
		drawTriangle(4);
		
	}

}
