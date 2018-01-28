package question11package1;

import question11package2.Question11;

//Q11. Write a program that would access two float-variables from a class that exists in another
//package. Note, you will need to create two packages to demonstrate the solution.
// Created by: KP Saini

public class Driver {

	public static void main(String[] args) {
		
		// construct a Question11 object
		Question11 question11 = new Question11();
		// print the values of the default float variables to the console
		System.out.println("The variable float1 has a value of " + question11.getFloat1()
				+ "\nThe variable float2 has a value of " + question11.getFloat2());
	}
}
