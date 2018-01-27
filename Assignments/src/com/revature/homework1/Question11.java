package com.revature.homework1;

/**
 * Created by: Jeffrey Rubi Date: 26 January 2018 
 * Write a program that would access two float-variables from a class that exists in another package. Note, 
 * you will need to create two packages to demonstrate the solution.
 */

import com.revature.question11config.*;

public class Question11 {

	public static void main(String[] args) {

		// instantiate class that exist in another package
		Question11OtherClass readOtherPackage = new Question11OtherClass();

		// Display the float variables from the class that exist from another package
		System.out.println(readOtherPackage.toString());

	} // end main()

} // end class
