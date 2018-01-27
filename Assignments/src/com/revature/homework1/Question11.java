package com.revature.homework1;

import com.assignment.hw1.FloatStore;

//Write a program that would access two float-variables from a class 
//that exists in another package. Note, you will need to create two packages
//to demonstrate the solution.
public class Question11 {

	public static void main(String[] args) {
		System.out.println("From com.assignment.hw1.FloatStore:");
		System.out.println("First number: " + FloatStore.copyThis);
		System.out.println("Second number: " + FloatStore.takeThis);
	}
}
