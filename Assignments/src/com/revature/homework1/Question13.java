package com.revature.homework1;

public class Question13 {
	
	public static void printTriangle() {
		// By following the pattern
		// 1
		// 2 3
		// 4 5 6, etc
		// The 0 are going to be printed in the odd positions
		
		int counter = 0;
		for(int i = 0; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				if(counter % 2 == 0) {
					System.out.print("0");
				} else {
					System.out.print("1");
				}
				counter++;
			}
			System.out.println();
		}
	}
}
