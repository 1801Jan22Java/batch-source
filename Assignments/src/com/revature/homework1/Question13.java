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
		ArrayList<String> buildBlocks = new ArrayList<String>(Arrays.asList("0","1","0","1","0","1","0","1","0","1"));
		Iterator it = buildBlocks.iterator();
		
		int i = 1;
		while(it.hasNext()) {
			for(int n=0; n<i; n++) {
				System.out.print(it.next()+" ");
			}
			i++;
			System.out.println();
		}
	}
}
