package com.revature.homework1;
/*
 * Q11. Write a program that would access two float-variables 
 * from a class that exists in another package. Note, you will 
 * need to create two packages to demonstrate the solution.
 * */

import static com.revature.homework1a.Question11.*;


public class Question11 {

	/*
	 * Tries to access variables from Class Question11a in another package (homework1a)
	 * @param none
	 * @return none
	 * */
	public void accessVariables()
	{
	
		System.out.println(com.revature.homework1a.Question11.aStatic);
		System.out.println(com.revature.homework1a.Question11.bStatic);
	//	System.out.println(homework1a.Question11.cNotStatic);  // cNotStatic is not static, and can't be accessed directly
		com.revature.homework1a.Question11 q11=new com.revature.homework1a.Question11();
		System.out.println(q11.getNotStatic());  // cNonStatic must be accessed through getter method
	}
}
