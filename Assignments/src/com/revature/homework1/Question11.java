package com.revature.homework1;

/*
 * Write a program that would access two float-variables from a class that exists in another
package. Note, you will need to create two packages to demonstrate the solution.

 */
public class Question11 {
	public void getFloats(com.revature.dummyPackage.FloatArithmatic floats) {
		System.out.println("Float values are" + floats.getF1() + " , " + floats.getF2());
	}
}
