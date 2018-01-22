package com.revature.hello;
/*
 * Packages are essentially folders or namespaces
 * that organize a set of related classes and 
 * interfaces.
 * Corresponds to a folder structure.
 * Base package for Java is java.lang
 * */

public class HelloWorld {
	
	/*
	 * Naming conventions:
	 *  Classes and projects
	 *  Classes should be named thusly:
	 *  Pascal case: FirstSecondThird
	 *  Methods and variables: 
	 *  Camel case: firstSecondThird.
	 *  Package names: lowerscase, separated by periods
	 *  e.g. com.revature.otherstuff
	 *  
	 *  Constants: All caps and underscores.
	 *   Ex. FIRST_SECOND_THIRD
	 * */

	/*
	 * JVM looks for method with this signature 
	 * as the entrance point of the program
	 * */
	public static void main(String [] args)
	{
		//static method - we don't need an instance of HelloWorld to execute.
		// void - no return value
		// String[] args: Can pass in array of strings as arguments
		
		System.out.println("Zdravstvuite mir!");
		
	}
}
