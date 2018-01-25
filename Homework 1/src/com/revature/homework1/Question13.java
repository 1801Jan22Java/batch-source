//Done!

package com.revature.homework1;

public class Question13 {
	public static void main(String[] args) {
		int bit = 0;	//The pattern starts with a 0
		
		//Each successive line is one bit longer than the previous, 
		//so we start with 1 and increment as we go
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= i; j++) {
				
				//If we reach the end of a line (line 2 has length 2),
				//print the bit and move to the next line.
				if(j == i) {
					System.out.println(bit);
				}
				//Otherwise, print the bit and a space to follow
				else {
					System.out.print(bit + " ");
				}
				
				//If the printed bit was a 0, set the bit to print 1 next time
				if(bit == 0) {
					bit = 1;
				}
				//And vice versa
				else {
					bit = 0;
				}
			}
		}
	}
}
