package com.revature.homework1;

public class Question6 {
	//Determine if a given int is even without using the modulus operator
	public static boolean checkEven(int num) {
		boolean isEven = false;
		
		//Since int truncates any decimals, an odd number divided by 2 will always be smaller than actual value.
		//Therefore, when the num is multiplied by 2 again, it can never be equivalent 
		if(num/2 * 2 == num) {
			isEven = true;
		}

		return isEven;
	}
}
