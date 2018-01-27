package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program to store numbers from 1 to 100 in an array. Print out all the even numbers from the
 * array. Use the enhanced FOR loop for printing out the numbers.
 */

public class Question12 {

	public static void main(String[] args) {

		// int array reference variable to store 1-100
		int[] oneToHundred = new int[100];

		// for loop to assign values to indexes
		for (int i = 0; i < 100; i++) {
			oneToHundred[i] = i + 1;
		} // end for

		// counter for my Display
		int count = 0;

		// 'enhanced FOR loop' to check, then Display even integers
		for (int dream : oneToHundred) {
			if (isEven(dream)) {
				count++;
				if (count % 10 == 0) {
					System.out.println(dream);
				} else {
					System.out.print(dream + " ");
				}
			}
		} // end for

	} // end main()

	// checks if an int is even
	public static boolean isEven(int toCheck) {
		
		// if the integer passed is not divisible by 2 then it's NOT even
		if (toCheck % 2 != 0) {
			return false;
		}
		// assume even
		return true;
		
	} // end isEven()

} // end class
