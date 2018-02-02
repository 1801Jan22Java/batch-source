package com.revature.homework1;

public class Question13 {

	public static void main(String[] args) {
		// Display the triangle on the console as follows using any type of loop. Do NOT use a simple
		//group of print statements to accomplish this.
		// 0
		// 1 0
		// 1 0 1
		// 0 1 0 1

		//Specify height of the triangle
		int triangleHeight = 4;
		
		//Boolean for alternating the zeros and ones
		boolean isZero = true;

		//First loop is for the height of the triangle
		for(int i = 1; i < triangleHeight + 1; i++) {
			
			//This is for the width of triangle
			for(int j = 0; j < i; j++) {
				System.out.print((isZero ? 0 : 1) + " ");
				isZero = !isZero;
			}
			
			//After width go to the next line
			System.out.print("\n");
		}
		
	}

}
