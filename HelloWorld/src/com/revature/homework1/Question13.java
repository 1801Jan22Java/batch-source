package com.revature.homework1;

public class Question13 {

	/*
	 * Q13. Display the triangle on the console as follows using any type of loop.  Do NOT use a simple group of print statements to accomplish this.
	 	    0
		    1 0
		    1 0 1
		    0 1 0 1

	 */
	public static void main(String[] args) {
		triangle(4);		
	}
	
	public static void triangle(int lineNo) {
		
		boolean ifZero = true;
		int i = 0 ;				// init number for using infinite while loop
		
		while ( i < lineNo) {
			
			i++;
			StringBuilder sb = new StringBuilder("");
			
			// 1st line has 1 element, 2nd line has 2 elements... so each i line will have 'i' number of elements
			int j = 0;				
			while (j < i) {		// 'i' number line will have a 'j' number of elements
				if(ifZero) {
					sb.append("0 ");
					ifZero = false;
				} else {
					sb.append("1 ");
					ifZero = true;
				}
				j++;
			}
			System.out.println(sb.toString());
		}
		
	}
}
