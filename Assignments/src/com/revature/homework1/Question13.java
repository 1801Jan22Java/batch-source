package com.revature.homework1;

/*
 * Display the triangle on the console as follows using any type of loop.  
 * Do NOT use a simple group of print statements to accomplish this.
    0
    1 0
    1 0 1
    0 1 0 1

 */

public class Question13 {

	public static void main(String[] args) {
		
		int numRows = 4;//number of rows in the triangle to print
		//change this for different results
		
		int limit = 1;//used to determine how many numbers to put in a row
		int next = 0;//the next number in the pattern
		
		//number of rows
		for (int i = 0; i < numRows; i++) {
			//number of columns
			for (int j = 0;j < limit; j++) {
				System.out.print(" " + next );
				if (next == 0) {
					next++;
				}else {
					next--;
				}
			}
			limit++;
			System.out.println();
		}

	}

}
