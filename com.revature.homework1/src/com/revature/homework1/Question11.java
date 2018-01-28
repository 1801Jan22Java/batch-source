package com.revature.homework1;

import com.revature.homework1.pckge2.*;

public class Question11 {

	public static void main(String[] args) {
		// Q11. Write a program that would access two float-variables
		//from a class that exists in another
		//package. Note, you will need to create two packages to demonstrate the solution.

		//Question11p2 is in pckge2 which contains the functions getFirst(Second)Float
		
		System.out.println(Question11p2.getFirstFloat());
		System.out.println(Question11p2.getSecondFloat());
		
	}

}
