package com.revature.hello;
/*
 * package is a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure
 * base package for Java is java.lang
 */

public class HelloWorld {

	/*
	 * Naming conventions:
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: lowercase, separated by periods, com.revature.[other stuff]
	 * constants: CAPS, separated by underscore, FIRST_SECOND_THIRD
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	
	public static void main(String[] args) {
		//static don't need and instance of HelloWorld to execute the method
		//void: return type, doesn't return anything
		//String [] args: array of string parameters to pass to main()
		
		System.out.println("Hello World!");
		
		//STS (Eclipse really) does incremental compiling
		//every time a file is saved, it and any of its dependencies are compiled
		//compiling: converting .java source files into .class bytecode for execution by the JVM
	}
}
