package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Display the triangle on the console as follows using any type of loop. Do NOT
 * use a simple group of print statements to accomplish this. 
 * 0 
 * 1 0 
 * 1 0 1
 * 0 1 0 1
 */

public class Question13 {

	public static void main(String[] args) {

		boolean check = true;

		for (int i = 0; i < 4; i++) {

			for (int j = 0; j < i + 1; j++) {

				if (check) {
					System.out.print("0 ");
					check = false;
				} else {
					System.out.print("1 ");
					check = true;
				}

			} // end in-for

			System.out.println();

		} // end out-for
	} // end main

} // end class
