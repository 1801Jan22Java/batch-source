package com.revature.homework1;
import com.revature.question11.Question11Support;
/*
 * Author: Calvin Milliron
 * Assignment: Write a program that would access two float-variables from a class that exists in another package. 
 * 		Note, you will need to create two packages to demonstrate the solution.
 * Status: Done
 */
public class Question11 {

	public static void main(String[] args) {
		System.out.println("The first value stored in the com.revature.question11 package is " + com.revature.question11.Question11Support.value1);
		System.out.println("The second value stored imported from the com.ravature.question11 package is " + Question11Support.value2);
	}

}
