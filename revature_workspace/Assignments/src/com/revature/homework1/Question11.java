package com.revature.homework1;
/*
 * Q11. Write a program that would access two float-variables 
 * from a class that exists in another package. Note, you will 
 * need to create two packages to demonstrate the solution.
 * */

import static homework1a.Question11.*;


public class Question11 {

	public void accessVariables()
	{
	
		System.out.println(homework1a.Question11.aStatic);
		System.out.println(homework1a.Question11.bStatic);
	//	System.out.println(homework1a.Question11.cNotStatic);  // cNotStatic is not static, and can't be accessed directly
		homework1a.Question11 q11=new homework1a.Question11();
		System.out.println(q11.getNotStatic());  // cNonStatic must be accessed through getter method
	}
}
