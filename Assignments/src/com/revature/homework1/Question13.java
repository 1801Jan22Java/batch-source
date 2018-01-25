package com.revature.homework1;
/*
 Display the triangle on the console as follows using any type of loop.  
 Do NOT use a simple group of print statements to accomplish this.
 
0
1 0
1 0 1
0 1 0 1
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Question13 {
	public static void main(String[] args) {
		printNums();
	}
	
	public static void printNums() {
		
		// Create an ArrayList of alternating 1s and 0s
		ArrayList<String> buildBlocks = new ArrayList<String>(Arrays.asList("0","1","0","1","0","1","0","1","0","1"));
		Iterator it = buildBlocks.iterator();
		
		// amount to printo out per line, incremented to create the "triangle" pattern
		int i = 1;
		
		// Iterate through and print out elements.
		// Use i for elements per row
		while(it.hasNext()) {
			for(int n=0; n<i; n++) {
				System.out.print(it.next()+" ");
			}
			i++;
			System.out.println();
		}
	}
}
