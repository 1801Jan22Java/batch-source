package com.revature.hello;

/*
 * package - a namespace that organizes a set of related classes and interfaces
 * corresponds to a folder structure, base package for Java is java.lang
 */
public class HelloWorld {
	
	/*
	 * Naming conventions 
	 * classes and projects: pascal casing, FirstSecondThird
	 * methods and variables: camel casing, firstSecondThird
	 * package names: all lowercase: lowercase, separated by periods
	 * constants: all caps, FIRST_SECOND_THIRD
	 */
	
	/*
	 * main method
	 * JVM looks for a method with this signature as an entrance point to the program
	 */
	public static void main (String[] args) {
		// static: don't need an instance of HelloWorld to execute the method
		// void: return type, doesn't return anything
		//String[] args: array of strings that specify the execution parameters
		
		//systout+control+space
		System.out.println("Hello World");
		
		//sts does incremental compiling, allowing it to check for errors on the fly
		// everytime a file is saved it, and any dependencies, are compiled
		// compiling: converting .java source files into .class bytecode for execution by the JVM
		
		
	}
}
