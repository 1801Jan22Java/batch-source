package com.revature.homework1;

public class Question6 {
	public static void main(String[] args) {
		System.out.println(IsEven(25640));
		System.out.println(IsEven(479));
	}
	
	
	/*
	 * Returns true if an integer is even, false otherwise
	 * Parameters:
	 * 	num; integer; an integer value.
	 * Return:
	 * 	boolean; a boolean value indicating true if even, false otherwise.
	 */
	public static boolean IsEven(int num) {
		/*
		 * Here, we will take advantage of int division. When dividing an int, Java will automatically give
		 * you a floor for the odd number. When dividing an odd number, 3 for example, float division would give
		 * us 1.5. Not true with int division. It would give you 1. Therefore, the evaluation 3/2*2 == 3 would 
		 * evaluate to false.
		 */
		if(num/2*2==num) {
			return true;
		}else {
			return false;
		}
	}
}
