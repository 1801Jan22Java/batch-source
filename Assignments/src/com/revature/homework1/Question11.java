package com.revature.homework1;
/*
 * Write a program that would access two float-variables from a class that exists in another package. 
 * Note, you will need to create two packages to demonstrate the solution.
 */
//This statment will allow me access to the static variables three and four that I created in another package
import static com.revature.homework1Q11.HW11Floats.three;
import static com.revature.homework1Q11.HW11Floats.four;

public class Question11 
{
	public static void main(String args[])
	{
		System.out.println("The variables from the other class are "+three+" and"+four);
	}
}
