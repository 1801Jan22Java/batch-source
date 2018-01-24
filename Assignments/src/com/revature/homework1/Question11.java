package com.revature.homework1;
import com.revature.OtherPackage.*;
/*
 * Write a program that would access two float-variables from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate the solution.
 */

public class Question11 {
	public static void main(String[] args) {
		
		float float1 = 32.68f;
		float float2 = 45.46f;
		
		//Sends the floats to a class that exists on another package
		ClassInAnotherPackage packageClass = new ClassInAnotherPackage(float1, float2);
		
		//Returns and prints out the floats
		System.out.println("First float is " + packageClass.getFloat1() + "\n" +
							"Second float is " + packageClass.getFloat2());
		
		//Static Float from another package
		System.out.println("Static float from another package is " + ClassInAnotherPackage.STATIC_FLOAT);
	}
}
