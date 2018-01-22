package com.revature.hello;
/*
 * package - a namespace that organizes a set of related classes and interfaces.
 * Corresponds to a folder structure
 * Base package for Java is java.lang
 */
public class HelloWorld {
	
	/*
	 * Naming conventions:
	 * Classes and projects: Pascal casing, capitalize the first letter of every word. FirstSecondThird
	 * Methods and variables: camel casing, firstSecondThird
	 * Package names: lowercase, separated by periods, e.g. com.revature.[other stuff]
	 * Constants: all caps, delimited by underscores. FIRST_SECOND_THIRD
	 */
	
	/*
	 * Main method - the driver. Our starting point.
	 * JVM looks for a method with this signature as an entrance point to the program.
	 */
	
	public static void main(String[] args)
	{
		//static: don't need an instance of the class to run a static method.
		//void: return type; doesn't return anything
		//String[] args: an array of strings as arguments to be utilized inside the method
		
		//sysout+ctrl+space
		System.out.println("Hello World!");
		
		//STS (eclipse) does incremental compiling
		//Every time a file is saved, it and any of its dependencies are compiled.
		//Compiling: converting .java source files into .class bytecode for execution by the JVM
	}
}
