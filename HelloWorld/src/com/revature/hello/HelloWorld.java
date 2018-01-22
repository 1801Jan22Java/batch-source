package com.revature.hello;

/*
 * package is a namespace that organizes a set of files
 * Corresponds to a folder structure
 * Base package for java is java.lang
*/

/*
 * NAMING CONVENTIONS
 * Classes and projects: pascalCasing
 * Methods and variables: CamelCase
 * package name:  All lowercase
 * Constants: ALL_CAPS_AND_UNDERSCORES
 */

/*
 * main method
 * JVM looks for a method with this signature as an entrance point to the program
 * Main is static so you don't need an instance of the class
 * args is an array of strings that are ttaken in as parameters
 */

/*
 * STS does incremental compiling (and eclipse) so every time file is saved it and dependencies are compiled
 * Compiling changes the code into bytecode that can be run by the JVM
 */

public class HelloWorld {

	public static void main(String[] args)
	{
		System.out.println("Hello World!");
	}
}
