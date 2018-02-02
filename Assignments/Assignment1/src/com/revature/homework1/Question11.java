package com.revature.homework1;

import com.revature.homework1util.Question11Util;

public class Question11 {

	public static void main(String[] args) {
		// Write a program that would access two float-variables from a class that exists in another
		//package. Note, you will need to create two packages to demonstrate the solution.

		//Create an instance of the other class which exists in another package
		Question11Util otherClass = new Question11Util();
		
		//User getters to access the private floats
		System.out.println("First float = " + otherClass.getSecretFloat1());
		System.out.println("First float = " + otherClass.getSecretFloat2());

	}

}
