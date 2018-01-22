package com.revature.hello;
/*
 * Package - a namespace that organizes a set of related classes and interfaces
 * It corresponds to folder structure
 * The base package for java is java.lang
 */

public class HelloWorld {
	
	/*
	 * Naming conventions:
	 * Classes + projects: Pascal casing, FirstSecondThird
	 * Methods + variables: Camel casing, firstSecondThird
	 * Package names: All lowercase, separated by periods, com.revature.[other stuff]
	 * Constants: All caps, FIRST_SECOND_THIRD
	 */

	/*
	 * mMin method
	 * JVM looks for method with this signature as an entrance point to the program
	 */
	public static void main(String[] args) {
		// static: Do not need instance of HelloWorld to execute method
		// void: Return type, does not return anything
		// String[] args: Array of string parameters passed to main
		
		// sysout+ctrl+space
		System.out.println("Hello World!");
		
		// STS (eclipse really) does incremental compiling
		// Every time a file is saved, any of its dependencies are compiled
		// Compiling: Converting .java source files into .class bytecode for execution by JVM
	}

}
